(ns linearp.core
  (:import [com.quantego.clp CLP CLPExpression CLPVariable]))

(defn add-var
  ([lp v] {v (-> lp .addVariable .free)})
  ([lp v lower] {v (-> lp .addVariable (.lb (float lower)))})
  ([lp v lower upper] {v (-> lp .addVariable (.lb (float lower)) (.ub (float upper)))}))

(defn add-vars [lp vars]
  (let [all-vars (reduce
                  (fn [res [x lower upper]]
                    (merge res 
                           (cond
                             (and (nil? lower) (nil? upper)) (add-var lp x)
                             (nil? upper) (add-var lp x lower)
                             :else (add-var lp x lower upper)))) {} vars)]
    all-vars))

(defn add-constraint [model constraint all-vars & {:keys [objective?] :or {objective? false}}]
  (loop [o constraint final (.createExpression model)]
    (if (empty? o)
      (if objective?
        (.asObjective final)
        final)
      (recur (rest o)
             (let [[a b] (first o)]
               (condp = a
                 '<= (.leq final (float b))
                 '>= (.geq final (float b))
                 '== (.eq final (float b))
                 'not= (.neg final (float b))
                 (.add final a (get all-vars b))))))))

(defmacro add-constraints [model constraints all-vars]
  `(loop [c# ~constraints final# ~model]
     (if (empty? c#)
       ~model
       (recur (rest c#) (add-constraint ~model (first c#) ~all-vars)))))

(defn solve [vars objective constraints & {:keys [solve-as verbose] :or {solve-as :min verbose false}}]
  (let [lp (CLP.)
        all-vars (add-vars lp vars)
        _ (add-constraint lp objective all-vars :objective? true)
        _ (add-constraints lp constraints all-vars)
        res (condp = solve-as
              :min (.minimize lp)
              :max (.maximize lp)
              (throw (ex-info "solve-as method is wrong." {})))
        reduce-fn (fn [res [k v]]
                    (assoc-in res [:decision-vars k] (.getSolution lp v)))]
    (if verbose
      (.printModel lp))
    (reduce reduce-fn {:objective-value (.getObjectiveValue lp) :status (.toString res)} all-vars)))
