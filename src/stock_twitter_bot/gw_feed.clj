(ns stock-twitter-bot.gw-feed
  (:require [feedparser-clj.core :as atom-parser]
            [environ.core :refer [env]])
  (:gen-class))

(def gw-url (:gw-url env))
(def fin-link-pattern #"^http[s]?:\/\/globenewswire.com\/news-release\/.+\/fi\/.+$")

(defn after?
  [d1 d2]
  (> (compare d1 d2) 0))

(defn latter-entry
  [e1 e2]
  (if (after? (:updated-date e1) (:updated-date e2)) e1 e2))

(defn link-matches-language?
  [link language-pattern]
  (some? (re-matches language-pattern link)))

(defn is-finnish-link?
  [link]
  (link-matches-language? link fin-link-pattern))

(defn convert-entry-for-twitter
  [entry]
  {:title (:title entry)
    :link (:link entry)})

(defn convert-entries-for-twitter
  [entries]
  (map convert-entry-for-twitter (reverse entries)))

(defn parse-feed
  [url]
  (atom-parser/parse-feed url))

(defn get-entries-with-fin-link
  [parsed-feed]
  (filter #(is-finnish-link? (:link %)) (:entries parsed-feed)))

(defn get-finnish-news
  []
  (get-entries-with-fin-link
    (parse-feed
      gw-url)))

(defn get-finnish-news-after
  [date-time]
  (filter
    #(after? (:updated-date %) date-time)
    (get-finnish-news)))

(defn get-latest-entry
  [col]
  (reduce latter-entry col))
