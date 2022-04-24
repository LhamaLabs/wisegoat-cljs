(ns app.answer)

(defn get-advice []
  (-> (js/fetch "https://api.adviceslip.com/advice")
      (.then (fn [r]
               (when-not (.-ok r)
                 (throw (js/Error. "Could not fetch /data")))
               (.json r)))
      (.then (fn [r] (do
                       (js/console.log "%cJSON" "color: white; font-size: 2em;background-color:orange;padding 10px" r)
                       (-> js/document
                           (.querySelector "h1")
                           (.-textContent)
                           (set! (aget r "slip" "advice"))))))
      (.catch (fn [e]
                (prn [:error e])))))

(defn answer []
  ; (.addEventListener js/window "beforeunload" (fn [e] (js/console.log "a")))
  (get-advice)
  [:<>
   [:div.layout
    [:div.wisegoat-advice
     [:h1.answer "Thinking..."]
     [:button {:class "ask-for-advice"} [:a.link-advice {:href "/"} "Another"]]]
    [:img {:src "https://raw.githubusercontent.com/geovannabrgs/wisegoat/master/assets/bodezinho.png"}]]])