(ns clj-tgcom.pages
  (:require [clj-tgcom.content :as content]))

(defn wrap-page [events page]
  [:div
   (content/header events)
   (page)
   (content/footer events)])

(defn index [events]
  (wrap-page events content/index))

(defn about [events]
  (wrap-page events content/about))

(defn weather [events]
  (wrap-page events content/weather))

(defn get-page [name]
  (condp = name
    "index" index
    "about" about
    "weather" weather
    nil))
