(ns one_a
  (:require [clojure.edn :refer [read-string]]))

(defn get-data [path]
  (read-string (str "[" (slurp path) "]")))

(defn count-increasing [data]
  (->> data
       (partition 2 1)
       (filter (fn [[a b]] (< a b)))
       count))

(def solve-1 count-increasing)

(defn solve-2 [data]
  (->> data
       (partition 3 1)
       (map (partial apply +))
       count-increasing))

(let [data (get-data "/home/linden/Downloads/1a_input")]
  [(solve-1 data)
   (solve-2 data)])