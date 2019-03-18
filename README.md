# linearp

[![Build Status](https://travis-ci.org/aibrahim/linearp.svg?branch=master)](https://clojars.org/linearp)

linearp is simple linear programming solver in clojure based on clp-java lib

## Examples
example of blending problem which mentioned here https://pythonhosted.org/PuLP/CaseStudies/a_blending_problem.html

in your repl 
```
(use 'linearp.core)
```

howto define simple decision variables?
variables could be free without any lower and upper limits and should be declared as:
```
(def vars 
  '((x1) 
    (x2 0.0 100.0)))
```

or could be with only lower limit as:
```
(def vars
  '((x1 90.0))
```

or could be with both lower and upper limits as:
```
(def vars
   '((x1 0.0 100.0)
    (x2 0.0 100.0)
    (x3 0.0 100.0)
    (x4 0.0 100.0)
    (x5 0.0 100.0)
    (x6 0.0 100.0)))
```

howto define objective function?
```
(def objective '((0.013 x1) (0.008 x2) (0.010 x3) (0.002 x4) (0.005 x5) (0.001 x6)))
```

howto define constraints?
```
(def constraints 
  '(((1.0 x1) (1.0 x2) (1.0 x3) (1.0 x4) (1.0 x5) (1.0 x6) (== 100.0))
    ((0.100 x1) (0.200 x2) (0.150 x3) (0.000 x4) (0.040 x5) (0.0 x6) (>= 8.0))
    ((0.080 x1) (0.100 x2) (0.110 x3) (0.010 x4) (0.010 x5) (0.0 x6) (>= 6.0))
    ((0.001 x1) (0.005 x2) (0.003 x3) (0.100 x4) (0.150 x5) (0.0 x6) (<= 2.0))
    ((0.002 x1) (0.005 x2) (0.007 x3) (0.002 x4) (0.008 x5) (0.0 x6) (<= 0.4))))
```

howto solve the problem?
as minimization (the default)
```
 (solve vars objective constraints)
```
as maximization
```
(solve vars objective constraints :solve-as :max)
```

## License 
Copyright © 2019 Abdullah Ibrahim

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

Have fun :)

