/**
 * This class plots the linear directory structure returned by the [Probe] class.
 * @constructor probe
 * @see Probe
 */
class Plotter(private val probe: Probe) {

    var tabWidth = 2

    /**
     * this property generates the string with spaces depending on [tabWidth]
     */
    private val tab: String
        get() {
            var width = ""
            for (i in 0.until(tabWidth))
                width += " "
            return width
        }


    fun plot() {

        /**
         * Reads the linear structure from  [Probe] class and draw the structure.
         */
        val refs = probe.probe()
        draw(refs)
    }

    private fun draw(refs: ArrayList<CountRef>) {
        for (ref in refs) {

            /**
             * Print vertical lines
             */
            val lineOrGapRecogPattern = ref.structPattern.substring(0 until ref.structPattern.lastIndex)
            for (i in lineOrGapRecogPattern) {
                when (i) {
                    '0' -> {
                        print(Lines.LINE.value + tab)
                    }
                    '1' -> print(Lines.GAP.value + tab)
                }

            }

            /**
             * print T or Elbow
             */
            val teeOrElbowRecogPattern = ref.structPattern[ref.structPattern.lastIndex]
            if (teeOrElbowRecogPattern == '0') {
                print(Lines.TEE.value)
            } else {
                print(Lines.ELBOW.value)
            }

            /**
             * prints the name of the [Struct]
             */
            println(ref.structRef.name)
        }
    }

    enum class Lines(val value: String) {
        LINE("│"),
        TEE("┝─"),
        ELBOW("┕─"),
        GAP(" ")
    }
}