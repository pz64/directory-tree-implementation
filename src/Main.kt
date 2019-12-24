fun main() {

    val image2 = File("photo-2.jpg", "Image")
    val image1 = File("photo-1.jpg", "Image")
    val image3 = File("photo-3.jpg", "Image")
    val imageFolder = Folder("Images")
    imageFolder.add(image3, image1, image2)

    val audio1 = File("song-1.mp3", "Audio")
    val audio2 = File("halo-2.wav", "Audio")
    val audio3 = File("pho3.ogg", "Audio")

    val audioFolder = Folder("Songs")
    audioFolder.add(audio1, audio2, audio3)

    val medias = Folder("Media")
    medias.add(audioFolder, imageFolder)

    println("Before sorting")
    val probe = Probe(medias)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2
    plotter.plot()


    println("\nAfter sorting")
    /**
     * Sort all folders from [medias] to all children
     */
    Utils.sortRecursive(medias) {it.name}

    val probe2 = Probe(medias)
    val plotter2 = Plotter(probe2)
    plotter2.tabWidth = 2
    plotter2.plot()
}