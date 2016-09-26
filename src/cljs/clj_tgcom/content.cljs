(ns clj-tgcom.content
  (:require [cljs.core.async :refer [put!]]))

(defn page-change [events page]
  (fn _ [] (put! events {:type :page-change
                         :value page})))

(defn header [events]
  [:span
   [:a {:class "header page" :href "#" :on-click (page-change events "index")} "index"] " "
   [:a {:class "header page" :href "#" :on-click (page-change events "about")} "about"]
   [:hr]
   [:a {:class "header link" :href "http://hiking.tonygaetani.com" :target "_blank"} "hiking"] " "
   [:a {:class "header link" :href "https://ceruleancity.github.io" :target "_blank"} "music"] " "
   [:a {:class "header link" :href "https://linkedin.com/in/tonygaetani" :target "_blank"} "linkedin"] " "
   [:a {:class "header link" :href "https://github.com/tonygaetani" :target "_blank"} "github"] " "
   [:a {:class "header link" :href "https://stackoverflow.com/users/664594/tonyg" :target "_blank"} "stackoverflow"] " "
   [:hr]])

(defn footer [events]
  [:span
   [:hr]
   [:a {:class "footer page" :href "#" :on-click (page-change events "weather")} "weather"] [:br]
   [:p {:class "footer pgp"} "PGP: 984C EC21 2057 94EF D296  AD3F 436F D09B AD04 F349 " [:a {:class "footer page" :href "https://keybase.io/tonygaetani/key.asc" :target "_blank"} "(public key)"]]
   [:p {:class "footer generated-by"} "Fork me on " [:a {:href "https://github.com/tonygaetani/clj-tgcom" :target "_blank"} "github"] "!"]])

(defn index []
  [:div {:class "me"}
   [:h1 "Tony Gaetani"]
   [:p "Software Engineer | Chicago, IL"]])

(defn about []
  [:span
   [:h2 {:class "me"} "Tony Gaetani"]
   [:p {:class "address"}
    "Hyde Park" [:br]
    "Chicago, IL" [:br]
    "USA"]
   [:h3 {:class "experience"} "Professional Experience"]
   [:p {:class "job"}
    "Consultant" [:br]
    "6 River Systems, Waltham, MA" [:br]
    "Sept 2016 - Current" [:br]
    "Full Stack development"]
   [:p {:class "job"}
    "Back-end Software Engineer" [:br]
    "Conceptboard, Stuttgart, Germany" [:br]
    "Oct 2014 - Jun 2016" [:br]
    "DevOps" [:br]
    "Java and Clojure development"]
   [:p {:class "job"}
    "Software Engineer" [:br]
    "Mimio, Cambridge, MA" [:br]
    "Nov 2010 - Jun 2014" [:br]
    "Cross-platform C++ development" [:br]]
   [:h3 {:class "education"} "Education"]
   [:p {:class "school"}
    "B.S. Software Engineering" [:br]
    "Champlain College, Burlington, VT" [:br]
    "Sept 2006 - May 2010"]])

(defn weather []
  [:span
   [:div
    [:div
     [:iframe {:src "https://freesecure.timeanddate.com/clock/i4mcy8jh/n64/fn13/tt0/th2/ta1"
               :height "18"}]]
    [:div {:class "weather"}
     [:iframe {:src "https://forecast.io/embed/#lat=41.8791&lon=87.6298&name=Chicago&units=us"
               :id "forcast_embed"
               :type "text/html"
               :height "245"
               :width "100%"}]]
    [:div
     [:iframe {:src "https://free.timeanddate.com/clock/i4mcy8jh/n43/fn13/tt0/th2/ta1"
               :height "18"}]]
    [:div {:class "weather"}
     [:iframe {:src "https://forecast.io/embed/#lat=42.3583&lon=-71.0603&name=Boston&units=us"
               :id "forcast_embed"
               :type "text/html"
               :height "245"
               :width "100%"}]]
    [:div
     [:iframe {:src "https://free.timeanddate.com/clock/i4mcy0p7/n2020/tlde3/fn13/tt0/th1/ta1"
               :height "18"}]]
    [:div {:class "weather"}
     [:iframe {:src "https://forecast.io/embed/#lat=48.5200&lon=9.0556&name=Tübingen&units=ca"
               :id "forcast_embed"
               :type "text/html"
               :height "245"
               :width "100%"}]]]])
