(ns books.views.welcome
  (:require [books.views.common :as common])
  (:use [noir.core :only [defpage]]
        books.models.db
        noir.fetch.remotes
        hiccup.form))

(defpage "/" []
         (common/layout
          [:h1 "Books"]
          [:div
           (label {} "title" "Title: ")
           (text-field {:id "title"} "title")
           [:br]
           (label {} "review" "Review: ")
           (text-area  {:id "review"} "review")
           [:br]
           [:button {:class "submit"} "Submit"]]))

(defremote add-book-to-db [book]
  (add-book book))
