(ns cljs-uuid.core)

(defn make-v4 
  "make a version 4 (random UUID as per http://www.ietf.org/rfc/rfc4122.txt"
  []
  (java.util.UUID/randomUUID))

(def make-random make-v4)

