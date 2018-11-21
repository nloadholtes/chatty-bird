(ns chatty-bird.core
  (:gen-class)
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful]
        [clojure-csv.core :as csv]
        [clojure.string :as str])
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
  (def tweets (read-csv (first args)))

  ;; Loop and sleep
  (while true
    ;; Select tweet
    (def msg (rand-nth tweets))
    (println "Posting:" msg " \n")
    (statuses-update :oauth-creds my-creds
                     :params {:status msg})
    ;; sleep for 6 hours plus some random number over 5 minutes
    (Thread/sleep (+ 21600000 (* (* (rand) 10) 300000)))
   )
 )


(defn read-csv [filename]
  (println "Looking at " filename)
  (csv/parse-csv (slurp filename))

)



(defn random-select [data freq] ())
