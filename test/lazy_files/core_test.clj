(ns lazy-files.core-test
  (:require [midje.sweet :refer :all]
            [lazy-files.core :refer :all]))


(facts "About `lazy-read"
       (let [file "dev-resources/lazy_read.txt"]
         (lazy-read file) => ["hello" "you"]))

(facts "About `lazy-write"
       (let [file "dev-resources/lazy_write.txt"]
         (do
           (lazy-write file ["hello" "you"])
           (slurp file))) => "hello\nyou\n")
