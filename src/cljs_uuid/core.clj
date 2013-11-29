(ns cljs-uuid.core)

(defn make-v4 
  "make a version 4 (random UUID as per http://www.ietf.org/rfc/rfc4122.txt"
  []
  (java.util.UUID/randomUUID))

(def make-random make-v4)

(defn make-random-string
    "Returns a UUID as as String. Common method between CLJ and CLJS for generating UUID strings"
    []
    (str (make-random)))

