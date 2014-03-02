(ns cooljure.log
  (:require
    [clojure.string  :as str]
  ))

(def ^:const log-keys
  "Logging severity levels in order from lowest to highest priority."
  [:trace :debug :message :warning :error :fatal :never] )

(def ^:const key->level
  "Maps log level keyword to an integer severity index"
  (zipmap log-keys (range (count log-keys))) )

(def min-level
  "The lowest severity level of log message to report."
  (atom (:message key->level)) )

(defn set-min-level
  "Sets the minimum level for log messages to be reported."
  [level-key]
  (reset! min-level (level-key key->level)) )

(defn write-to-log
  "Write log msg to console for debugging."
  [level-key & msgs]
  (when (<= @min-level (level-key key->level) )
    (apply println msgs ) ))

; Convenience functions
(defn fatal  [& msgs] (apply write-to-log  :fatal    msgs ))
(defn error  [& msgs] (apply write-to-log  :error    msgs ))
(defn warn   [& msgs] (apply write-to-log  :warning  msgs ))
(defn msg    [& msgs] (apply write-to-log  :message  msgs ))
(defn dbg    [& msgs] (apply write-to-log  :debug    msgs ))
(defn trace  [& msgs] (apply write-to-log  :trace    msgs ))


(defn spy 
  "Prints label and arg to logging stream, then returns arg unaltered.  Useful for spying
  on contents of thread-last (->>) stream."
  [label arg]
  (do (msg label arg) arg) )

