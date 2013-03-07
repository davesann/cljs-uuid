# cljs-uuid

Micro clojure and clojurescript portability lib for uuid creation

* can generate version4 (random uuid), as per http://www.ietf.org/rfc/rfc4122.txt
* can read and print uuid literals as per http://dev.clojure.org/jira/browse/CLJ-914 (but no cljs reader capability)
* can read and print plain uuid strings '8-4-4-4-12'

## usage

* clojars [cljs-uuid "0.0.1"]
* clojars [cljs-uuid "0.0.2"] : includes equivalent API in clojure for portability
* clojars [cljs-uuid "0.0.3"] : 
 - added make-random to use in place of make-v4 (deprecated).
 - added cljs parsing of #\<UUID ...\> issue #1
* clojars [cljs-uuid "0.0.4"] : 
 - updated similar to https://github.com/davesann/cljs-uuid/issues/2
 - uses cljs.core.UUID
 - removed no longer relevant print methods
 - only relevant fn is now make-random

As of version 0.0.2 you can use the lib in clojure as well as cljs.
In clj, underneath, java.util.UUID is used.

see: https://github.com/davesann/cljs-uuid/blob/master/test/main.cljs

```clojure
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
```

## TODO

consider use of 'window.crypto.getRandomValues' when available


## License

Copyright (C) 2012 Dave Sann

Distributed under the Eclipse Public License, the same as Clojure.
