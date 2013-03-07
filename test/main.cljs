(ns test.main
  (:require
    [cljs-uuid.core :as uuid]
    [cljs.reader :as reader]))

(defn log [msg x]
  (do (js/console.log (pr-str {:msg msg :data x}))
    x ))

(log "Starting Test" nil)

(let [id1 (uuid/make-random)
      id2 (uuid/make-random)
      id1-str    (str id1)
      id2-str    (str id2)
      id1-pr-str (pr-str id1)
      id1-reread (reader/read-string id1-str)
      ]
  (log "id1 str"    id1-str)
  (log "id1 pr-str" id1-pr-str)
  (log "id2 str"    id2-str)
  (log "(= id1 id1)" (= id1 id1))
  (log "(not= id1 id2)" (not= id1 id2))
  
  (log "(reader/read-string id1-str)" id1-reread)
  (log "(= id1 id1-reread)" (= id1 id1-reread))
  
  (js/console.log id1)
  (js/console.log id1-reread)
  )
