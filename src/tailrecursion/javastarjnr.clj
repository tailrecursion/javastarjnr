(ns tailrecursion.javastarjnr
  (:require [tailrecursion.javastar :refer [compile-java]])
  (:import jnr.ffi.LibraryLoader))

(def interface
  (compile-java "LibC"
                "public interface LibC {
                   int puts(String s);
                 }"))

(def libc
  (.load (LibraryLoader/create interface) "c"))

(defn -main [& args]
  (let [ret (.puts libc "Hello, World")]
    (println "Return value: " ret)))
