(ns cooljure.core-test
  (:require [clojure.test  :refer :all]
            [cooljure.core :refer :all] ))

(deftest test-truthy-falsey
  (testing "truthy items"
    (let [truthy-items [ 0 1 2.3 "abc" \a :any-key true {} [] (list) ]]
      (doseq [item truthy-items]
        (is (= true  (truthy? item)))
        (is (= false (falsey? item))) )))
  (testing "falsey items"
    (let [falsey-items [ false nil ]]
      (doseq [item falsey-items]
        (is (= true  (falsey? item)))
        (is (= false (truthy? item))) ))))

(deftest test-any
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
  (is (= false  (any? #{200} (range 0 10)) ))

  )
   


  
