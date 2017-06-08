(ns stock-twitter-bot.core
  (:require [stock-twitter-bot.gw-feed :as gw]
            [stock-twitter-bot.twitter :as twitter]
            [clojure.tools.logging :as log])
  (:gen-class))

(org.apache.log4j.BasicConfigurator/configure)

(defonce last-updated (atom (new java.util.Date)))

(def tweet-interval 60000)

(defn tweet-news-entry
  [entry]
  (twitter/post (:title entry) (:link entry)))

(defn tweet-untweeted-news
  []
  (let [news (gw/get-finnish-news-after @last-updated)]
    (dorun
      (map tweet-news-entry
        (gw/convert-entries-for-twitter news)))
    (reset! last-updated (:updated-date (first news)))))

(defn app-loop
  []
  (while true
    (do
      (try
        (tweet-untweeted-news)
        (catch Exception ex
          (log/error ex "Error occurred")))
      (Thread/sleep tweet-interval))))

(defn -main
  [& args]
  (app-loop))
