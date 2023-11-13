(ns clojure-example.config.db
  (:require 
    [dotenv :refer [env app-env]]
    [clojure.java.jdbc :as jdbc]
    [clojure.string :as str])
  (:gen-class))

(def -db
  {:subprotocol "mysql"
   :subname (env :DB_CONNECTION)
   :user (env :DB_USER)
   :password (env :DB_PASS)}
  )

(defn concat-fields
  "Concat field names for SQL"
  [fields]
  (clojure.string/join ", " (map name fields)))

(defn concat-update-fields
  "Concat field names for SQL"
  [record]
  (clojure.string/join ", " (for [pair record]
                              (str (name (key pair)) " = ?"))))

(defn insert
  "Insert a new todo into a table"
  [table record]
  (first (jdbc/insert! -db table record)))

(defn select
  "Select records from a table"
  [table fields]
  (jdbc/query -db [(str "SELECT " (concat-fields fields)  " FROM " (name table))] ))
(defn select-by-id
  "Select records from a table"
  [table fields id]
  (jdbc/query -db [(str "SELECT " (concat-fields fields)  " FROM " (name table) " WHERE id = ?") id] ))

(defn delete
  "Delete record by ID from a table"
  [table id]
  (jdbc/execute! -db [(str "DELETE FROM " (name table) " WHERE id = ?") id]))

(defn get-values
  "Get values from record"
  [record]
  (vals record))

(defn update
  "Update record by ID from a table"
  [table, record, id]
  (jdbc/update! -db table record ["id = ?" id]))