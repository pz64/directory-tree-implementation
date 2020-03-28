fun main() {

    val r = FileRecurser("C:\\Users\\71000430\\Documents\\Projects\\external-libs\\glad")


    val probe = Probe(r)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2

    plotter.plot()

    println("\nunix Paths")
    Utils.linearize(r.struct).forEach {
        println(Utils.path(it))
    }
}