(ns chatty-bird.core
  (:gen-class)
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful]
        [clojure-csv.core :as csv]
        [clojure.string :only (join)])
  (:import [twitter.callbacks.protocols SyncSingleCallback]))

(require '[environ.core :refer [env]])


(def my-creds (make-oauth-creds (env :consumer-key)
                                (env :consumer-secret)
                                (env :access-token)
                                (env :access-token-secret)))
(declare read-csv random-select post-tweet)


(defn -main
  "Read a CSV and post a line from it to twitter every few hours"
  [& args]
  (println "Tweet tweet!")
  (def base-wait-time (Integer/parseInt (env :wait-time)))
  (def post-randomly (nth args 1 nil))

  (println "Pausing for" base-wait-time)
  (def tweets (read-csv (join ["/data/" (first args)])))
  (println "post-randomly is: " post-randomly)

  ;; Loop and sleep
  (while true
    ;; Select tweet
    (if (= post-randomly nil)
      (doseq [tweet tweets]
        (println "Posting in order")
        (post-tweet tweet)
        )
      (
        (println "Posting in random order!")
        (post-tweet (rand-nth tweets))
       )
      )
    )
  )

(defn post-tweet [tweet]
  (def msg (first tweet))
  (try
    (statuses-update :oauth-creds my-creds
                     :params {:status msg})
    ;; sleep for 6 hours plus some random number over 5 minutes
    (def wait-time (+ base-wait-time (* (* (rand) 10) 300000)))
    (println "Sleeping for " (/ (/ wait-time 1000) 60) " minutes")
    (Thread/sleep wait-time)

    (catch Exception excp
      (println "   ****Exception seen:" (.getMessage excp))
      (Thread/sleep 90000)
      )
    )
  )

(defn read-csv [filename]
  (println "Looking at " filename)
  (csv/parse-csv (slurp filename))
)


(defn random-select [data freq] ())
