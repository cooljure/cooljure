(ns cooljure.core)

(defn truthy?
  "Returns true if argument is logical true (neither nil nor false);
  otherwise returns false."
  [arg]
  (if arg true false) )

(defn falsey?
  "Returns true if argument is logical false (either nil or false);
  otherwise returns false. Synonymous with clojure.core/not."
  [arg]
  (if arg false true) )

(defn any?
  "Returns true if (pred x) is logical true for any x in coll; otherwise returns false.
   Like clojure.core/some, but returns only true or false."
  [pred coll]
  (truthy? (some pred coll)) )

(defn not-empty?
  "Returns false if coll contains no items; otherwise returns true.
  Same as (truthy? (seq coll))."
  [coll]
  (truthy? (seq coll)) )

(defn conjv 
  "Appends to a collection, always returning a vector."
  ; From Stuart Sierra post 2014-2-10
  [coll item]
  (conj (vec coll) item) )

