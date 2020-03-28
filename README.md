
Language: Kotlin

Print Directory tree structure on inputting folder path  

example: 
```kotlin
fun main() {

    val r = FileRecurser("C:\\Users\\x\\Documents\\Projects\\external-libs\\glad")


    val probe = Probe(r)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2

    plotter.plot()

    println("\nunix Paths")
    Utils.linearize(r.struct).forEach {
        println(Utils.path(it))
    }
}
```

output
```
╰─Root
   ╰─glad
      ├─include
      │  ├─glad
      │  │  ╰─glad.h
      │  ╰─KHR
      │     ╰─khrplatform.h
      ╰─src
         ╰─glad.c

unix Paths
/Root/glad/include/glad/glad.h
/Root/glad/include/KHR/khrplatform.h
/Root/glad/src/glad.c

```

