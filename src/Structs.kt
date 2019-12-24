/**
 * Common protocol for [Folder] and [File]
 */
interface Struct {
    var name: String
    var parent: Struct?
}


class Folder(override var name: String) : Struct {

    override var parent: Struct? = null

    val subStructs: MutableList<Struct> = arrayListOf()

    fun add(struct: Struct) {
        struct.parent = this
        subStructs.add(struct)
    }

    fun add(vararg structs: Struct) {
        for (i in structs) {
            add(i)
        }
    }

    fun remove(struct: Struct) {
        struct.parent = null
        subStructs.remove(struct)
    }

    fun removeAll() {
        for (i in subStructs)
           i.parent = null
        subStructs.clear()
    }
}

class File(override var name: String, var type: String = "Uncategorised") : Struct {
    override var parent: Struct? = null
}
