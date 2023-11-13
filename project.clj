(defproject clojure_example "0.1.0-SNAPSHOT"
  :description "An example project demonstrating how to build a REST API in Clojure with CRUD operations"
  :url "https://ashanchameera.dev"
  :license {:name "MIT"
    :url ""}
  :dependencies [
    [org.clojure/clojure "1.10.0"]
    [org.clojure/tools.logging "0.4.0"]
    [org.clojure/data.json "0.2.6"]
    ;[dev.weavejester/ragtime "0.9.3"]
    [org.clojure/java.jdbc "0.7.10"]
    ;[org.postgresql/postgresql "42.1.4"]
    [mysql/mysql-connector-java "8.0.28"]
    [ring/ring-defaults "0.3.2"]
    [ring/ring-devel "1.6.3"]
    [ring/ring-json "0.5.0"]
    [compojure "1.6.1"]
    [http-kit "2.3.0"]
    [lynxeyes/dotenv "1.0.2"]]
  ;:plugins [[ragtime/ragtime.lein "0.3.9"]]
  ;:ragtime {:database-url (env :DB_URL)
  ;          :migrations   "db"}
  :main ^:skip-aot clojure-example.core
  :target-path "target/%s"
   )