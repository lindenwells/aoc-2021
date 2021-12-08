(ns one_a
  (:require [clojure.java.io :refer [reader]]
            [clojure.edn :refer [read-string]]))

(comment (with-open [rdr (reader "/home/linden/Downloads/1a_input")]
           (doseq [line (line-seq rdr)]
             (println line))))


(defn get-data [path]
  (read-string (str "[" (slurp path) "]")))

(defn count-increasing [data]
  (->> data
       (partition 2 1)
       (filter (fn [[a b]] (< a b)))
       count))

(let [data (get-data "/home/linden/Downloads/1a_input")]
  (count-increasing data))

(->> (read-string "42069")
     type)