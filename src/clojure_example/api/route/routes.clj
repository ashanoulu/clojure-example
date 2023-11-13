(ns clojure-example.api.route.routes
	(:require
		[compojure.core :refer :all]
		[clojure-example.api.handler.api :as api])
	(:gen-class))

(defn echo-route 
	"Echo back the request"
  [req]
	{:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (str "GET '/' " req))})

(defn get-all-todo-list-route
	"Echo all list"
  [req]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/get-all-todo-list))})

(defn get-todo-by-id-route
	"Echo all list"
  [id]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/get-todo-by-id ((id :params) :id)))})

(defn add-todo-item-route
	"Endpoint for add a todo item"
	[req]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/add-todo-item (req :params)))})

(defn update-todo-item-route
	"Endpoint for update a todo item"
	[req]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/update-todo-item (req :params) ((req :params) :id)))})
(defn delete-todo-item-route
	"Echo delete item"
  [id]
	{:status 201
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/delete-todo-item ((id :params) :id)))})