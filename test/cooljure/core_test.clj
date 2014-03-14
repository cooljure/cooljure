(ns cooljure.core-test
  (:require [clojure.test  :refer :all]
            [cooljure.core :refer :all] ))

(deftest tst-truthy-falsey
  (testing "truthy items"
    (let [truthy-items [ 0 1 2.3 "abc" \a :any-key [] (list) {} #{} #"regex.*" 
                         true :true  "true"  [true]
                              :false "false" [false] 
                              :nil   "nil"   [nil]   ]]
      (doseq [item truthy-items]
        (is (= true  (truthy? item)))
        (is (= false (falsey? item))) )))

  (testing "falsey items"
    (let [falsey-items [ false nil ]]
      (doseq [item falsey-items]
        (is (= true  (falsey? item)))
        (is (= false (truthy? item))) ))) )

(deftest tst-any?
  (is (= true   (any? identity [1])))
  (is (= true   (any? identity [1 nil])))
  (is (= true   (any? identity [nil 1])))
  (is (= true   (any? identity [true]))) 

  (is (= false  (any? identity [false]))) 
  (is (= false  (any? identity [nil]))) 

  (is (= true   (any? even? '(1 2 3 4)) ))
  (is (= false  (any? even? '(1 3 5 7)) ))

  (is (= false  (any? true? [false false false]) ))
  (is (= true   (any? true? [false true false]) )) 
  (is (= true   (any? true? [true true true]) )) 

  (is (= true   (any? #(= 5 %) [1 2 3 4 5]) )) 
  (is (= false  (any? #(= 5 %) [6 7 8 9 10]) ))

  (is (= true   (any? #(when (even? %) %) '(1 2 3 4)) ))
  (is (= true   (any? {2 "two" 3 "three"} [nil 3 2]) ))

  (is (= true   (any? #{2}   (range 0 10)) ))
  (is (= false  (any? #{200} (range 0 10)) )) )

(deftest tst-not-empty?
  (is (= false (not-empty? '())))
  (is (= true  (not-empty? '(1))))
  (is (= false (not-empty? "")))
  (is (= true  (not-empty? "abc")))
  (is (= true  (every? not-empty? ["1" [1] '(1) {:1 1} #{1}]) ))
  (is (= true  (every?     empty? [""  [ ] '( ) {    } #{ }]) ))
  )

(deftest tst-conjv
  (is (=       (conjv  [1 2 3] 4)  [1 2 3 4] ))
  (is (=       (conjv '(1 2 3) 4)  [1 2 3 4] ))
  (is (vector? (conjv '(1 2 3) 4))) )

