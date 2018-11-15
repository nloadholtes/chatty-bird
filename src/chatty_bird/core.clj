(ns chatty-bird.core
  (:gen-class)
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful])
  (:import [twitter.callbacks.protocols SyncSingleCallback]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
