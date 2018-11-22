(defproject chatty-bird "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [twitter-api "1.8.0"]
                 [clojure-csv/clojure-csv "2.0.1"]
                 [environ "1.1.0"]]
  :main ^:skip-aot chatty-bird.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
