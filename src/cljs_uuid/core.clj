(ns cljs-uuid.core)

; duplicating the api in clojure

(defn make-v4 
  "make a version 4 (random UUID as per http://www.ietf.org/rfc/rfc4122.txt"
  []
  (java.util.UUID/randomUUID))

(defn read-str 
  "read a raw (8-4-4-4-12) uuid string"
  [uuid-str]
  (java.util.UUID/fromString uuid-str))


(def uuid-pr-str-re  #"#uuid\s+\"(.{36})\"")
(def uuid-pr-str-re2 #"#<UUID\s+(.{36})>")

(defn read-pr-str 
  "read in #uuid \"... \"
   or <#UUID \"...\">
  "
  [uuid-pr-str]
  (loop [regexs [uuid-pr-str-re uuid-pr-str-re2]]
    (if-not regexs
      (throw (Exception. (str "Error Reading UUID: " uuid-pr-str)))
      (let [[re & others] regexs]
        (if-let [[_ uuid-str] (re-matches re uuid-pr-str)]
          (read-str uuid-str)
          (recur others))))))


