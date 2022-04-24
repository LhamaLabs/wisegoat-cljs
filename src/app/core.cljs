(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [reagent.core :as r]
            [app.home :refer [home]]
            [app.answer :refer [answer]]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [spec-tools.data-spec :as ds]
            [fipp.edn :as fedn]))

(defonce match (r/atom nil))

(defn current-page []
  [:div
   [:ul
    [:li [:a {:href (rfe/href ::home)} "Home"]]
    [:li [:a {:href (rfe/href ::answer)} "Answer"]]]
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])

(def routes
  [["/"
    {:name ::home
     :view home}]

   ["/answer"
    {:name ::answer
     :view answer}]])

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [m] (reset! match m))
    ;; set to false to enable HistoryAPI
   {:use-fragment true})
  (r/render [current-page] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
