(ns two
  (:require clojure.edn :refer [read-string]))

(defn get-commands [path]
  (read-string (str "[" (slurp path) "]")))

(defn process-command [[x y] command]
  (let [commands {'up (fn [[x y] d] [x (- y d)])
                   'down (fn [[x y] d] [x (+ y d)])
                   'forward (fn [[x y] d] [(+ x d) y])}]
    (commands command)))

(defn solve [commands]
  (->> commands
       (reduce process-command [0 0])))

(->> (get-commands "/home/linden/Downloads/aoc-inputs/2")
     (solve))
  
(process-command "up 5")