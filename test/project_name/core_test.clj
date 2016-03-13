(ns project-name.core_test
  (:require [clojure.test :refer :all]
            [kerodon.core :refer :all]
            [kerodon.test :refer :all]
            [project-name.core :refer [create-handler all-routes]]))

(def handler (create-handler all-routes))

(deftest smoke-test
  (testing "FIXME: Write an actual test!"
    (-> (session handler)
        (visit "/")
        (has (status? 200) "page exists")
        (has (text? "Hello World"))
        ))

  (testing "FIXME: Write an actual test!"
    (-> (session handler)
        (visit "/Bob?bad-nickname=CoolCat")
        (has (status? 200) "page exists")
        (has (text? "Hello Bob"))
        ))

  (testing "FIXME: Write an actual test!"
    (-> (session handler)
        (visit "/Bob?nickname=CoolCat")
        (has (status? 200) "page exists")
        (has (text? "Hello Bob... or should I say \"CoolCat\" :p"))
        )) 
  )
