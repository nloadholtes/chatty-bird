(ns chatty-bird.core
  (:gen-class)
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful])
  (:import [twitter.callbacks.protocols SyncSingleCallback]))


(def my-creds (make-oauth-creds (System/getenv "CONSUMER_KEY")
                                (System/getenv "CONSUMER_SECRET")
                                (System/getenv "ACCESS_TOKEN")
                                (System/getenv "ACCESS_TOKEN_SECRET")))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println my-creds))


