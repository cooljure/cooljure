(ns cooljure.core)

(defn truthy?
  "Returns true if arg is logical true (neither nil nor false);
  otherwise returns false."
  [arg]
  (if arg true false) )

(defn falsey?
  "Returns true if arg is logical false (either nil or false);
  otherwise returns false. Equivalent to (not (truthy? arg))."
  [arg]
  (if arg false true) )  ; Synonymous with clojure.core/not.

(defn any?
  "Returns true if (pred x) is logical true for any x in coll; otherwise returns false.
   Like clojure.core/some, but returns only true or false."
  [pred coll]
  (truthy? (some pred coll)) )

(defn not-empty?
  "Returns false if coll contains no items; otherwise returns true.
  Equivalent to (not (empty? coll))."
  [coll]
  (truthy? (seq coll)) )

(defn conjv 
  "Appends item to collection, always returning a vector."
  ; From Stuart Sierra post 2014-2-10
  [coll item]
  (conj (vec coll) item) )

