(ns clj-tgcom.core
  (:require-macros [cljs.core.async.macros :refer [go-loop]])
  (:require [clj-tgcom.pages :as pages]
            [reagent.core :as reagent :refer [atom]]
            [cljs.core.async :refer [chan]]))

(enable-console-print!)

(defonce events (chan))
(defonce state (atom {:page (pages/index events)}))

(defn initialize-event-handling []
  (go-loop []
    (let [event (<! events)]
      (condp = (:type event)
        :page-change (swap! state #(assoc % :page ((pages/get-page (:value event)) events)))
        nil))
    (recur)))

(defn app []
  (:page @state))

(initialize-event-handling)
(reagent/render [app] (js/document.getElementById "app"))
