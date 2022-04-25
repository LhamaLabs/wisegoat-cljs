(ns app.pages.answer)

(defn get-advice []
  (-> (js/fetch "https://api.adviceslip.com/advice")
      (.then #(do (when-not (.-ok %)
                    (throw (js/Error. "Could not fetch the data")))
                  (.json %)))
      (.then #((-> js/document
                   (.querySelector "h1")
                   (.-textContent)
                   (set! (aget % "slip" "advice")))))
      (.catch #(prn [:error %]))))

(defn answer []
  (get-advice)
  [:<>
   [:div.layout
    [:div.wisegoat-advice
     [:h1.answer "Thinking..."]
     [:button {:class "ask-for-advice"} [:a.link-advice {:on-click get-advice} "Another"]]]
    [:img {:src "https://raw.githubusercontent.com/geovannabrgs/wisegoat/master/assets/bodezinho.png"}]]
   [:div.container-home  [:a.home-link {:href "/"} "Home"]]])

; (js/console.log "%cJSON" "color: white; font-size: 2em;background-color:orange;padding 10px" r)
; (.addEventListener js/window "beforeunload" (fn [e] (js/console.log "a")))