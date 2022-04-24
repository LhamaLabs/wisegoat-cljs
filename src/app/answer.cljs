(ns app.answer)

(defn get-advice []
  (-> (js/fetch "https://api.adviceslip.com/advice")
      (.then (fn [r]
               (when-not (.-ok r)
                 (throw (js/Error. "Could not fetch /data")))
               (.json r)))
      (.then (fn [r] (do
                       (-> js/document
                           (.querySelector "h1")
                           (.-textContent)
                           (set! (aget r "slip" "advice")))
                       (js/console.log "%cJSON" "color: white; background-color:orange;padding 10px"))))
      (.catch (fn [e]
                (prn [:error e])))))

(defn answer []
  (get-advice)
  [:h1 ""])