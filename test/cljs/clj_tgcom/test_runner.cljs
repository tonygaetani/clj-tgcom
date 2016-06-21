(ns clj-tgcom.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [clj-tgcom.core-test]))

(enable-console-print!)

(doo-tests 'clj-tgcom.core-test)
