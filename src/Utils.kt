/***
 * Utilities functions for sorting, grouping
 */
object Utils {

    /***
     * return unix style path for [struct] input
     */
    fun path(struct: Struct): String {
        var current: Struct? = struct
        val pathBuilder: StringBuilder = StringBuilder("/" + current?.name)
        while (current?.parent != null) {
            current = current.parent
            pathBuilder.insert(0, "/" + current?.name)
        }
        return pathBuilder.toString()
    }

    /**
     * Function to sort folder structure in place
     * @param struct - root folder to start sorting
     * @param selector - specify the property to sort @see [MutableList.sortBy]
     */
    fun <R : Comparable<R>> sortRecursive(struct: Folder, selector: (Struct) -> R?) {

        sort(struct, selector)

        for (i in struct.subStructs)
            if (i is Folder)
                sortRecursive(i, selector)
    }

    /**
     * sort single folder in place
     */
    inline fun <R : Comparable<R>> sort(struct: Folder, crossinline selector: (Struct) -> R?) {
        struct.subStructs.sortBy {
            selector(it)
        }
    }

    /**
     * This function linearize and group every files under current struct.
     * @return grouped folder
     */
    fun group(struct: Folder) {
        val files: ArrayList<File> = linearize(struct)
        files.sortBy { it.type }

        val grouped = Folder("Groups")

        val type = files.map { it.type }.toSet()

        for (i in type) {

            val groupContent = files.filter { it.type == i }

            val groupFolder = Folder(i)

            groupFolder.add(*groupContent.toTypedArray())

            grouped.add(groupFolder)
        }
        struct.removeAll()
        struct.add(grouped)

    }

    /**
     * linearize remove all sub folders and return every files as array
     */
    fun linearize(struct: Struct): ArrayList<File> {
        var structs = arrayListOf<File>()
        getAllFiles(struct, structs)
        return structs
    }


    private fun getAllFiles(struct: Struct, out: ArrayList<in File>) {
        when (struct) {
            is Folder -> {
                for (i in struct.subStructs)
                    getAllFiles(i, out)
            }
            is File -> {
                out.add(struct)
            }
        }
    }
}