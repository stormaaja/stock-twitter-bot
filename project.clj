(defproject stock-twitter-bot "0.1.0"
  :description "Stock Twitter Bot - Osakeuutisbotti"
  :url "https://github.com/stormaaja/stock-twitter-bot"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                [adamwynne/feedparser-clj "0.5.2"]
                [twitter-api "1.8.0"]
                [org.clojure/tools.logging "0.4.0"]
                [org.slf4j/slf4j-log4j12 "1.7.25"]
                [environ "1.1.0"]]
  :main ^:skip-aot stock-twitter-bot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
