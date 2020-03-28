import java.io.File

/**
 * This class Probes through the Filesystem path and create a [Struct] object.
 */
class FileRecurser(private val folder: String ) {

    val struct = PFolder("Root")

    init {
        val file = File(folder)
        if (!file.exists()) {
            println("File doesn't exist")
        } else {
            recurse(file, struct)
        }
    }

    private fun recurse(file: File, struct: PFolder) {

        when {
            file.isFile -> {
                val pfile = PFile(file.name)
                struct.add(pfile)
            }

            file.isDirectory -> {
                val pFolder = PFolder(file.name)
                struct.add(pFolder)
                for (i in file.listFiles()) {
                    recurse(i, pFolder)
                }
            }
        }
    }
}