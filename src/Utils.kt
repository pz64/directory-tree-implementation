object Utils {


    fun group(struct: Struct): Folder {
        val files: ArrayList<File> = linearize(struct)
        files.sortBy { it.type }
        val result = Folder("Grouped")
        var type = files.map{it.type}.toSet()
        for (i in type) {
            val groupContent = files.filter { it.type == i }
            val groupFolder = Folder(i)
            groupContent.forEach { groupFolder.add(it) }
            result.add(groupFolder)
        }
        return result
    }

    fun linearize(struct: Struct): ArrayList<File> {
        var structs = arrayListOf<File>()
        getAllFiles(struct, structs)
        return structs
    }

    private fun getAllFiles(struct: Struct, structs: ArrayList<in File>) {
        when (struct) {
            is Folder -> {
                for (i in struct.subStructs)
                    getAllFiles(i, structs)
            }
            is File -> {
                structs.add(struct)
            }
        }
    }
}