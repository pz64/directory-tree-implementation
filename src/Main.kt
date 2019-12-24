fun main() {

    val f1 = File("test.txt", "Text")
    val f2 = File("Audio.mp3", "Audio")
    val f3 = File("test-2.txt", "Text")
    val f4 = File("vid-4.mp4", "Video")
    val f5 = File("vid-2.mp4", "Video")
    val f6 = File("vid-1.mp4", "Video")
    val f7 = File("xxxz.bzip2", "Compressed")
    val f8 = File("tex.zip", "Compressed")

    val rootFolder = Folder("Root Folder")
    rootFolder.add(f1, f2, f3, f4, f5, f6, f7, f8)

    val probe = Probe(rootFolder)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2

    println("Before Grouping")
    plotter.plot()

    println("\nAfter Grouping\n")
    Utils.group(rootFolder)
    val probe2 = Probe(rootFolder)
    val plotter2 = Plotter(probe2)
    plotter2.plot()
}