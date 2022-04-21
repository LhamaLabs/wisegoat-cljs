(ns app.home
  (:require [app.answer :refer [answer]]))

;; [:div.layout
;;  [:div.wisegoat-advice
;;   [:div.wisegoat-advice
;;    [:h5.wise "Wise"]
;;   [:h1.goat "Goat"]
;;   [:input {:type "button"} [:a "Ask for Advice"]]]]
;;  [:div.img-bode
;;   [:img {:src "public/img/bodezinho.png"}]]]

(defn home []
  [:<>
   [:div.layout
    [:div.wisegoat-advice
     [:h5 "Wise"]
     [:h1 "Goat"]
     [:button {:class "ask-for-advice"} [:a.link-advice {:href "#"} "Ask for Advice"]]]
    [:img {:src "https://raw.githubusercontent.com/geovannabrgs/wisegoat/master/assets/bodezinho.png"}]]])