
INPUT

```
fun main() {

    val image1 = File("photo-1.jpg", "Image")
    val image2 = File("photo-2.jpg", "Image")
    val image3 = File("photo-3.jpg", "Image")
    val imageFolder = Folder("Images")
    imageFolder.add(image1, image2, image3)

    val audio1 = File("song-1.mp3", "Audio")
    val audio2 = File("halo-2.wav", "Audio")
    val audio3 = File("pho3.ogg", "Audio")

    val audioFolder = Folder("Songs")
    audioFolder.add(audio1, audio2, audio3)

    val medias = Folder("Media")
    medias.add(audioFolder, imageFolder)

    val probe = Probe(medias)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2
    plotter.plot()
}
```

OUTPUT

```
┕─Media
   ┝─Songs
   │  ┝─song-1.mp3
   │  ┝─halo-2.wav
   │  ┕─pho3.ogg
   ┕─Images
      ┝─photo-1.jpg
      ┝─photo-2.jpg
      ┕─photo-3.jpg

```