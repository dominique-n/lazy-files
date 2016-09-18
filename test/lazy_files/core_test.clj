(ns lazy-files.core-test
  (:require [midje.sweet :refer :all]
            [lazy-files.core :refer :all]))


(facts "About `lazy-read"
       (let [file "dev-resources/lazy_read.txt"]
         (lazy-read file) => ["hello" "you"]))

(let [file "dev-resources/lazy_write.txt"]
  (against-background
    [(after :checks (clojure.java.io/delete-file file))]

    (facts "About `lazy-write"
           (do
             (lazy-write file ["hello" "you"])
             (doall (lazy-read file))) => ["hello" "you"])))
