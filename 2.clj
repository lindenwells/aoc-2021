(ns two
  (:require clojure.edn :refer [read-string])
  (:require clojure.string :as [string]))

(defn get-commands [path]
  (read-string (str "[" (slurp path) "]")))

(defn simple-nav-step
  [acc direction n]
  (cond
    (= direction "forward") (update acc :health #(+ % n))
    (= direction "up") (update acc :depth #(- % n))
    (= direction "down") (update acc :depth #(+ % n))))

(defn simple-parse
  [line]
  (let [[direction sn] (clojure.string/split line #" ")
        n (Integer/parseInt sn)]
    [direction n]))

(simple-nav-step {:health 420 :depth 69} "up" 5)

(type (get-commands "/home/linden/Downloads/aoc-inputs/2"))

(reduce simple-nav-step {:health 0 :depth 0} ))

(defn solve [commands]
  (->> commands
       (reduce process-command [0 0])))

(->> (get-commands "/home/linden/Downloads/aoc-inputs/2")
     (solve))
  
(process-command "up 5")


"jelo"