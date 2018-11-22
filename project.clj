(defproject chatty-bird "1.0.0"
  :description "Post to twitter automatically from a CSV file."
  :url "https://giuthub.com/nloadholtes/chatty-bird"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [twitter-api "1.8.0"]
                 [clojure-csv/clojure-csv "2.0.1"]
                 [environ "1.1.0"]]
  :main ^:skip-aot chatty-bird.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
