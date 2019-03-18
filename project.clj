(defproject linearp "0.1.0-SNAPSHOT"
  :description "simple linear programming solver based on clp-java lib."
  :url "https://github.com/aibrahim/linearp"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.quantego/clp-java "1.16.10"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

