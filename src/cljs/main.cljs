(ns books.cljs.main
  (:require [enfocus.core :as ef]
            [fetch.remotes :as remotes])
  (:require-macros [enfocus.macros :as em]
                   [fetch.macros :as fm]))

(defn get-book-title []
  (em/from (em/select ["#title"]) (em/get-prop :value)))

(defn get-book-review []
  (em/from (em/select ["#review"]) (em/get-prop :value)))

(defn get-book-data []
  {:title (get-book-title)
   :review (get-book-review)})

(defn push-book []
  (fm/remote (add-book-to-db (get-book-data))))

(em/defaction setup []
  [".submit"] (em/listen :click push-book))

(set! (.-onload js/window) setup)
