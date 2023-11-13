(ns clojure-example.config.migration
  (:require [clojure.java.jdbc :as jdbc]
            [ragtime.jdbc :as ragtime]
            [clojure-example.config.db :as db]))

(def migration-config
  {:database-url "your-database-url"
   :migrations   (sql/load-resources "your/migrations/folder")})

(defn run-migrations!
  "Run database migrations"
  []
  (jdbc/with-connection (jdbc/db-connection db/-db)
                        (ragtime.core/migrate migration-config)))

