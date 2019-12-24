fun main() {

    val f1 = File("test.txt", "Text")
    val f2 = File("Audio.mp3", "Audio")
    val dir1 = Folder("dir1")
    dir1.add(f1, f2)
    val f3 = File("test-2.txt", "Text")
    val f4 = File("vid-4.mp4", "Video")
    val dir2 = Folder("dir2")
    dir2.add(f3, dir1, f4)
    val f5 = File("vid-2.mp4", "Video")
    val f6 = File("vid-1.mp4", "Video")
    val dir3 = Folder("dir3")
    dir3.add(f5, f6, dir2)
    val f7 = File("xxxz.bzip2", "Compressed")
    val f8 = File("tex.zip", "Compressed")

    val dir4 = Folder("dir4")
    dir4.add(dir3, f7)

    val rootFolder = Folder("Root Folder")
    rootFolder.add(dir4, f8)

    val probe = Probe(rootFolder)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2

    plotter.plot()

    println("\nunix Paths")
    Utils.linearize(rootFolder).forEach {
        println(Utils.path(it))
    }
}