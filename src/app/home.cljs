(ns app.home
  (:require [app.answer :refer [answer]]
            [reitit.frontend.easy :as rfe]))

(defn home []
  [:<>
   [:div.layout
    [:div.wisegoat-advice
     [:h5 "Wise"]
     [:h1.title "Goat"]
     [:button {:class "ask-for-advice"} [:a.link-advice {:href "/#/answer"} "Ask for Advice"]]]
    [:img {:src "https://raw.githubusercontent.com/geovannabrgs/wisegoat/master/assets/bodezinho.png"}]]])