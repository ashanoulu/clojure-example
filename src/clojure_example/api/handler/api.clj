(ns clojure-example.api.handler.api
  (:require 
    [compojure.core :refer :all]
    [clojure.tools.logging :as log]
    [clojure-example.config.db :as db])
  (:gen-class))

(defn get-all-todo-list
  "Retrieve a list of records from todo list"
  []
  (log/info (str "get all todo items"))
  (db/select :todolist [:id :name :description :date]))

(defn get-todo-by-id
  "Retrieve a Todo item"
  [id]
  (log/info (str "get Todo item by ID, id: " id))
  (db/select-by-id :todolist [:id :name :description :date] id))

(defn add-todo-item
  "Add a record to todolist"
  [{ name :name description :description date :date :as record }]
  (log/info (str "Save new Todo item record: " record))
  (db/insert :todolist record))

(defn update-todo-item
  "Update ToDo item"
  [{ name :name description :description :as record } id]
  (log/info (str "Update Todo item by ID, record: " record))
  (db/update :todolist record id))

(defn delete-todo-item
  "Delete todo item"
  [id]
  (log/info (str "Delete Todo item by ID, id: " id))
  (db/delete :todolist id))