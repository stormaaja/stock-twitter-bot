(ns stock-twitter-bot.twitter
  (:use [twitter.oauth]
        [twitter.api.restful]
        [environ.core :refer [env]]))

(def max-text-length 100)

(def credentials (make-oauth-creds (:app-consumer-key env)
                                (:app-consumer-secret env)
                                (:user-access-token env)
                                (:user-access-token-secret env)))

(defn truncate
  [str max-len]
  (subs str 0 (min max-len (count str))))

(defn post
  [text link]
  (statuses-update :oauth-creds credentials
                 :params {:status (str (truncate text) " " link)}))
