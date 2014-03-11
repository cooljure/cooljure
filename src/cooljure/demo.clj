(ns cooljure.demo
  (:require
    [clojure.string          :as str]
    [cooljure.core           :as cool]
    [cooljure.log            :as log]
  ))

(defn demo1 []
  (let [
        xx [:a nil :c nil :e]
        yy (concat xx [:f nil :g] )
        zz ["a" nil "c" nil "e"]
        kk [\a nil \c nil \e]
        aa [1 nil   3 nil   5]
        bb [1 false 3 false 5]
       ]
    (log/msg)
    (log/msg "xx:" xx)
    (log/msg "(str xx)" (str xx) )
    (log/msg "(apply str xx)" (apply str xx) )
    (log/msg "(str/join xx)" (str/join xx) )
    (log/msg) 
    (log/msg "yy:" yy)
    (log/msg (str " yy: " yy ))
    (log/msg "(apply str yy)" (apply str yy) )
    (log/msg "(str/join yy)" (str/join yy) )
    (log/msg) 
    (log/msg "zz:" zz)
    (log/msg "(str zz)" (str zz) )
    (log/msg "(apply str zz )" (apply str zz ))
    (log/msg "(str/join zz)" (str/join zz) )
    (log/msg)
    (log/msg "kk:" kk)
    (log/msg "(str kk)" (str kk) )
    (log/msg "(apply str kk)" (apply str kk) )
    (log/msg "(str/join kk)" (str/join kk) )
    (log/msg "(apply str (interpose \\space kk) )" (apply str (interpose \space kk) ) )
    (log/msg) 
    (log/msg "aa:" aa)
    (log/msg "(str aa)" (str aa) )
    (log/msg "(apply str aa )" (apply str aa ))
    (log/msg "(str/join aa)" (str/join aa) )
    (log/msg) 
    (log/msg "bb:" bb)
    (log/msg "(str bb)" (str bb) )
    (log/msg "(apply str bb )" (apply str bb ))
    (log/msg "(str/join bb)" (str/join bb) )
  )
)

(defn -main 
  []
  (log/msg "main ")
  (demo1)
)

