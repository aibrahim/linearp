(defproject linearp "0.1.0-SNAPSHOT"
  :description "simple linear programming solver based on clp-java lib."
  :url "https://github.com/aibrahim/linearp"
  :license {:name "Eclipse Public License"
            :url "https://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.quantego/clp-java "1.16.10"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

