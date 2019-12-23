import kotlin.concurrent.fixedRateTimer

fun main() {

    val image1 = File("photo-1.jpg", "Image")
    val image2 = File("photo-2.jpg", "Image")
    val image3 = File("photo-3.jpg", "Image")
    val imageFolder = Folder("Images")
    imageFolder.add(image1, image2, image3)

    val audio1 = File("song-1.mp3", "Audio")
    val audio2 = File("halo-2.wav", "Audio")
    val audio3 = File("pho3.ogg", "Audio")

    val zzz = Folder("zzz")
    val zzzz = Folder("zzzz")
    zzz.add(zzzz)
    val audio4 = File("phoo3.ogg", "Audio")
    zzzz.add(audio4)


    val audioFolder = Folder("Songs")
    audioFolder.add(audio1, audio2, audio3, zzz)

    val medias = Folder("Media")
    medias.add(audioFolder, imageFolder)

    val d1 = File("doc.pdf", "Document")
    val d2 = File("pxd.doc", "Document")

    val resume = File("resume.pdf", "Document")
    val oF = Folder("Others")
    oF.add(resume)

    val docFolder = Folder("Documents")
    docFolder.add(oF, d1, d2)

    val r1 = File("Img1.jpg", "Image")
    val r2 = File("res.pdf", "Document")
    val r3 = File("song.mp4", "Video")
    val r4 = File("Song.mp3", "Audio")
    val r5 = File("Imgr.gif", "Image")
    val r6 = File("Imx.tiff", "Image")
    val r7 = File("Songs2.ogg", "Audio")
    val rFolder = Folder("Random")
    rFolder.add(r1, r2, r3, r4, r5, r6, r7)

    val z = Folder("z")
    val zz = Folder("zz")
    val zzzx = Folder("zzz")
    val zzzzx = Folder("zzzz")
    val fx = File("xxxx.txt", "Document")
    val zzzzz = Folder("zzzzz")
    zz.add(fx)
    z.add(zz)
    zz.add(zzzx)
    zzzx.add(zzzzx)
    zzzzx.add(zzzzz)

    val rootFolder = Folder("Root")
   rootFolder.add(medias, rFolder, z, docFolder)


    val probe = Probe(rootFolder)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2
    plotter.plot()
}

/***

OUTPUT
''''''

╰─Root
    ├─Media
    │  ├─Songs
    │  │  ├─song-1.mp3
    │  │  ├─halo-2.wav
    │  │  ├─pho3.ogg
    │  │  ╰─zzz
    │  │     ╰─zzzz
    │  │        ╰─phoo3.ogg
    │  ╰─Images
    │     ├─photo-1.jpg
    │     ├─photo-2.jpg
    │     ╰─photo-3.jpg
    ├─Random
    │  ├─Img1.jpg
    │  ├─res.pdf
    │  ├─song.mp4
    │  ├─Song.mp3
    │  ├─Imgr.gif
    │  ├─Imx.tiff
    │  ╰─Songs2.ogg
    ├─z
    │  ╰─zz
    │     ├─xxxx.txt
    │     ╰─zzz
    │        ╰─zzzz
    │           ╰─zzzzz
    ╰─Documents
        ├─Others
        │  ╰─resume.pdf
        ├─doc.pdf
        ╰─pxd.doc

 */