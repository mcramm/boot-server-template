(set-env!
  :source-paths #{"src/" "test/"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [http-kit "2.1.19"]
                  [ring "1.4.0"]
                  [compojure "1.5.0"]
                  [environ "1.0.2"]
                  [boot-environ "1.0.2"]
                  [adzerk/boot-test "1.1.1" :scope "test"]
                  [kerodon "0.7.0" :scope "test"]])

(require '[environ.boot :refer [environ]])
(require '[adzerk.boot-test :refer :all])

(task-options!
  pom {:project 'project-name
       :version "1.0.0-SNAPSHOT"}
  aot {:namespace '#{project-name.core}}
  jar {:main 'project-name.core})


(deftask run-clj []
  (with-pre-wrap fileset
    (require '[project-name.core :refer [dev-main]])
    ((resolve 'dev-main))
    fileset))

(deftask dev []
  (comp
    (watch :verbose true)
    (run-clj)
    (repl :server true)))

(deftask watch-test []
  (comp
    (watch)
    (test)))

(deftask run []
  (comp
    (watch :verbose true)
    (run-clj)))

(deftask build-clj []
  (comp (aot) (pom) (uber) (jar)))

(deftask build []
  (comp (build-clj)))
