(ns clojure-example.core
  (:require 
    [dotenv :refer [env app-env]]
    [compojure.core :refer :all]
    [org.httpkit.server :as server]
    [ring.middleware.json :as js]
    [ring.middleware.defaults :refer :all]
    [clojure-example.api.route.routes :as routes])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] routes/echo-route)
  (GET "/todo-list" [] routes/get-all-todo-list-route)
  (GET "/todo-list/:id" [] routes/get-todo-by-id-route)
  (POST "/todo-list" [] routes/add-todo-item-route)
  (PUT "/todo-list/:id" [] routes/update-todo-item-route)
  (DELETE "/todo-list/:id" [] routes/delete-todo-item-route))

(defn -main
  "Run Clojure App"
  [& args]
    (let [port (Integer/parseInt (env :PORT))]
    (server/run-server (js/wrap-json-params (js/wrap-json-response (wrap-defaults #'app-routes api-defaults))) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
