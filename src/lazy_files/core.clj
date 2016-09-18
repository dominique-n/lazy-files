(ns lazy-files.core)

(defn lazy-read [file]
  (letfn  [(helper  [rdr]
             (lazy-seq
               (if-let  [line  (.readLine rdr)]
                 (cons line  (helper rdr))
                 (do  (.close rdr) nil))))]
    (helper  (clojure.java.io/reader file))))

(defn lazy-write
  ([file xs] (lazy-write file false xs))
  ([file append xs]
   (with-open [w  (clojure.java.io/writer file :append append)]
     (doseq [x xs] (.write w (str x ""))))))
