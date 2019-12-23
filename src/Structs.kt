/**
 * Common protocol for [Folder] and [File]
 */
interface Struct {
    var name: String
}


class Folder(override var name: String) : Struct {

    val subStructs: MutableList<Struct> = arrayListOf()

    fun add(struct: Struct) = subStructs.add(struct)
    fun add(vararg structs: Struct) = subStructs.addAll(structs)

    fun remove(struct: Struct) = subStructs.remove(struct)
}

class File(override var name: String, type: String = "Uncategorised") : Struct {}
