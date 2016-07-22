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
   [:a {:class "header link" :href "https://tonygaetani.com/music" :target "_blank"} "music"] " "
   [:a {:class "header link" :href "https://de.linkedin.com/pub/tony-gaetani/93/b6b/970" :target "_blank"} "linkedin"] " "
   [:a {:class "header link" :href "https://github.com/tonygaetani" :target "_blank"} "github"] " "
   [:a {:class "header link" :href "https://stackoverflow.com/users/664594/tonyg" :target "_blank"} "stackoverflow"] " "
   [:hr]])

(defn footer [events]
  [:span
   [:hr]
   [:a {:class "footer page" :href "#" :on-click (page-change events "weather")} "weather"] [:br]
   [:p {:class "footer pgp"} "PGP fingerprint 984C EC21 2057 94EF D296  AD3F 436F D09B AD04 F349"]
   [:p {:class "footer generated-by"} "This page was created using "
    [:a {:href "https://github.com/clojure/clojurescript"} "clojurescript"]]])

(defn index []
  [:div {:class "me"}
   [:h1 "Tony Gaetani"]
   [:p "Software Engineer | Tübingen, Germany"]])

(defn about []
  [:span
   [:h2 {:class "me"} "Tony Gaetani"]
   [:p {:class "address"}
    "Schleifmühleweg 32" [:br]
    "72070 Tübingen" [:br]
    "Germany"]
   [:h3 {:class "experience"} "Professional Experience"]
   [:p {:class "job"}
    "Back-end Software Engineer" [:br]
    "Conceptboard, Stuttgart, Germany" [:br]
    "Oct 2014 - Jun 2016" [:br]
    "Development Operations" [:br]
    "Java and Clojure development"]
   [:p {:class "job"}
    "Software Engineer" [:br]
    "Mimio, Cambridge, MA" [:br]
    "Nov 2010 - Jun 2014" [:br]
    "Cross-platform C++ Development" [:br]]
   [:h3 {:class "education"} "Education"]
   [:p {:class "school"}
    "B.S. Software Engineering" [:br]
    "Champlain College, Burlington, VT" [:br]
    "Sept 2006 - May 2010"]])

(defn weather []
  [:span
   [:div
    [:div
     [:iframe {:src "https://free.timeanddate.com/clock/i4mcy0p7/n2020/tlde3/fn13/tt0/th1/ta1"
               :height "18"}]]
    [:div
     [:iframe {:src "https://forecast.io/embed/#lat=48.5200&lon=9.0556&name=Tübingen&units=uk"
               :id "forcast_embed"
               :type "text/html"
               :height "245"
               :width "50%"}]]
    [:div
     [:iframe {:src "https://free.timeanddate.com/clock/i4mcy8jh/n43/fn13/tt0/th2/ta1"
               :height "18"}]]
    [:div
     [:iframe {:src "https://forecast.io/embed/#lat=42.3583&lon=-71.0603&name=Boston&units=us"
               :id "forcast_embed"
               :type "text/html"
               :height "245"
               :width "50%"}]]]])
