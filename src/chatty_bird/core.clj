(ns chatty-bird.core
  (:gen-class)
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful]
        [clojure-csv.core])
  (:import [twitter.callbacks.protocols SyncSingleCallback]))


(def my-creds (make-oauth-creds (System/getenv "CONSUMER_KEY")
                                (System/getenv "CONSUMER_SECRET")
                                (System/getenv "ACCESS_TOKEN")
                                (System/getenv "ACCESS_TOKEN_SECRET")))

(declare read-csv random-select)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println my-creds)
  (println (System/getenv "CONSUMER_KEY"))
  (read-csv "something-awesome.csv"))


(defn read-csv [filename]
  (println "Looking at " filename)
  (println "args: " *command-line-args*))

(defn random-select [data freq] ())
