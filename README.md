# linearp

simple linear programming solver in clojure based on clp-java lib

## Examples
example of blending problem which mentioned here https://pythonhosted.org/PuLP/CaseStudies/a_blending_problem.html

in your repl (use 'linearp.core)

howto define simple decision variables?
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
```
 (solve vars objective constraints)
```

Have fun :)

