(ns stock-twitter-bot.gw-feed-test
  (:require [clojure.test :refer :all]
            [stock-twitter-bot.gw-feed :refer :all]))

(deftest test-after
  (testing "Testing after"
    (let [t1 (java.time.LocalDateTime/now)
          t2 (.minusDays t1 2)
          t3 (.plusSeconds t1 1)]
      (is (after? t1 t2))
      (is (not (after? t2 t1)))
      (is (after? t3 t1))
      (is (not (after? t1 t3))))))
