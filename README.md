
Language: Kotlin


**Sorting Example**

```kotlin
import kotlin.concurrent.fixedRateTimer

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

    /**
     * Sort all folders from [medias] to all children
     */
    Utils.sortRecursive(medias) {it.name}

    val probe = Probe(medias)
    val plotter = Plotter(probe)
    plotter.tabWidth = 2
    plotter.plot()
}
```

**output**

```
╰─Media
   ├─Images
   │  ├─photo-1.jpg
   │  ├─photo-2.jpg
   │  ╰─photo-3.jpg
   ╰─Songs
      ├─halo-2.wav
      ├─pho3.ogg
      ╰─song-1.mp3

```

**Grouping Example**

```kotlin
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
```
**output**

```
Before Grouping
╰─Root Folder
   ├─test.txt
   ├─Audio.mp3
   ├─test-2.txt
   ├─vid-4.mp4
   ├─vid-2.mp4
   ├─vid-1.mp4
   ├─xxxz.bzip2
   ╰─tex.zip

After Grouping

╰─Root Folder
   ╰─Groups
      ├─Audio
      │  ╰─Audio.mp3
      ├─Compressed
      │  ├─xxxz.bzip2
      │  ╰─tex.zip
      ├─Text
      │  ├─test.txt
      │  ╰─test-2.txt
      ╰─Video
         ├─vid-4.mp4
         ├─vid-2.mp4
         ╰─vid-1.mp4


```
