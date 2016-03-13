(ns project-name.core
  (:require [org.httpkit.server :refer [run-server]]
            [ring.middleware.reload :as reload]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [api]])
  (:gen-class))

(defonce web-server (atom nil))

(defroutes all-routes
  (GET "/" [] "Hello World")
  (GET "/:name" [name] (fn [{:keys [params]}]
                         (if (:nickname params)
                           (format "Hello %s... or should I say \"%s\" :p" name (:nickname params))
                           (format "Hello %s" name)))))

(defn create-handler [routes]
  (api routes))

(defn start-web-server! [handler]
  (reset! web-server (run-server handler {:port 3000})))

(defn dev-main []
  (when-not @web-server
    (start-web-server! (reload/wrap-reload (create-handler #'all-routes)))))

(defn -main [& args]
  (start-web-server! (create-handler all-routes)))
