/**
 * This class Probes through the directory structure and create a linear array of data for the [Plotter]
 * class to Plot.
 */
class Probe(private val struct: Struct) {

    constructor(fileRecurser: FileRecurser): this(fileRecurser.struct)

    private val countRefs = arrayListOf<CountRef>()

    fun probe(): ArrayList<CountRef> {
        recurse(struct, 0, "1")
        return countRefs
    }

    /**
     * a recursive function that finds the
     * @param level - holds the depth of the directory structure.
     * @param structPattern -s a string with 0s and 1s.
     *
     * this function feeds the [countRefs] for [Plotter] class to plot.
     */
    private fun recurse(struct: Struct, level: Int, structPattern: String) {
        when (struct) {
            is PFolder -> {
                countRefs.add(CountRef(struct, level, structPattern))

                struct.subStructs.forEachIndexed { i, sub ->
                    if (i == struct.subStructs.lastIndex)
                        recurse(sub, level + 1, structPattern + "1")
                    else
                        recurse(sub, level + 1, structPattern + "0")
                }
            }
            is PFile -> {
                countRefs.add(CountRef(struct, level, structPattern))
            }
        }
    }
}

/**
 * this class hold the reference of tree, level and pattern for the [Plotter] to plot the structure
 * @param structRef holds the reference of [PFolder] or [PFile] object.
 * @param level holds the depth of the directory structure.
 * @param structPattern is a string with 0s and 1s.
 * 0 indicats a particular element is the last sibling of a tree so [Lines.GAP] or [Lines.ELBOW] are drawn
 * 1 indicates the sibling is not last element so [Lines.LINE] or [Lines.TEE] are drawn
 */
class CountRef(val structRef: Struct, val level: Int, val structPattern: String)