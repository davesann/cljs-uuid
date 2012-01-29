(ns main
  (:require
    [cljs-uuid.core :as uuid])
  )

(defn log [msg x]
  (do (.log js/console (pr-str {:msg msg :data x}))
    x ))

(let [id1 (uuid/make-v4)
      id2 (uuid/make-v4)
      id1-str    (str id1)
      id2-str    (str id2)
      id1-pr-str (pr-str id1)
      ]
  (log "id1 str"    id1-str)
  (log "id1 pr-str" id1-pr-str)
  (log "id2 str"    id2-str)
  (log "(= id1 id1)" (= id1 id1))
  (log "(= id1 id2)" (= id1 id2))
  (log "(uuid/read-str id1-str)"              (uuid/read-str    id1-str))
  (log "(= id1 (uuid/read-str    id1-str))"   (= id1 (uuid/read-str    id1-str)))
  (log "(= id1 (uuid/read-pr-str id1-pr-str)" (= id1 (uuid/read-pr-str id1-pr-str)))
  )
