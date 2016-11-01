package challenge272intermediate

import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.Color

object Challenge272int {
  def main(args: Array[String]) {
    val image: BufferedImage = ImageIO.read(new File("C:\\Users\\Administrator\\Pictures\\harambe.jpg"))
    val harambe = ImageWrapper(image)
    println(image)
    println(harambe.zippedDim)
    println(harambe.getPixelAt(100, 150).getPixelGrayScale)
  }

  case class PixelColor(red: Int, green: Int, blue: Int){
    val getPixelGrayScale: Int = (red + green + blue)/3
  }
  case class ImageWrapper(bufferedImage: BufferedImage) {

    val width = Range(0, bufferedImage.getWidth)
    val testWidth = Range(0, 2)
    val height = Range(0, bufferedImage.getHeight)
    val testHeight = Range(0, 2)
    val zippedDim = testHeight.map { y => testWidth.map { x => (x, y, getPixelAt(x, y).getPixelGrayScale)}.toList}.flatten.toList
//
//    def toBufferedImage(data: List[(Int, Int, Int)]): BufferedImage = {
//      val newBufferedImage = new BufferedImage(testWidth.last, testHeight.last, BufferedImage.TYPE_INT_RGB)
//      val result = data.foldLeft(newBufferedImage){ case (img, (x, y, color)) =>
//        img.setRGB(x, y, color)
//        img
//      }
//    }

    def getPixelAt(x: Int, y: Int): PixelColor = {
      val pixelData: Int = bufferedImage.getRGB(x, y)
      val pixelColor = new Color(pixelData)
      PixelColor(pixelColor.getRed, pixelColor.getGreen, pixelColor.getBlue)
    }

    def getPixelToRight(x: Int, y: Int): PixelColor = {
      getPixelAt(x + 1, y)
    }

    def getPixelToLeft(x: Int, y: Int): PixelColor = {
      getPixelAt(x - 1, y)
    }

    def getPixelBelow(x: Int, y: Int): PixelColor = {
      getPixelAt(x, y + 1)
    }

    def getPixelAbove(x: Int, y: Int): PixelColor = {
      getPixelAt(x, y - 1)
    }
  }

//  case class ImageDitherer(imagewrapper: ImageWrapper) {
//    def dither: ImageWrapper = {
//      val alteredPixel = if (imagewrapper.getPixelAt(0, 0).getPixelGrayScale <= 127) {
//        val blackPixel = new Color(0, 0, 0)
//        val blackError = 127 - (imagewrapper.getPixelAt(x, y).getPixelGrayScale)
//        val carryBlackErrorRight = imagewrapper.getPixelToRight(x + 1, y).getPixelGrayScale + blackError
//      }
//      else {
//        val whitePixel = new Color(255,255,255)
//        val whiteError = 255 - (imagewrapper.getPixelAt(x, y).getPixelGrayScale)
//        val carryWhiteErrorRight = imagewrapper.getPixelToRight(x + 1, y).getPixelGrayScale + whiteError
//      }
//      alteredPixel
//    }
//  }

}

//Pseudocode:
//
//> Take image input
//> Get an array of x * y pixels, and their colors in range (0 - 256). Make each pixel have an x and y coordinate.
//> Make function - If pixel < 128, make black, if pixel > 128, make white. Pass in first pixel.
//> Carry error forward (i.e. if pixel < 128, 128 - pixel color = error) in another function that adds it to the forward pixel (x + 1, pixel color + error), and the pixel below (y + 1, pixel error + color).
//> Pass remaining pixels left to right into the error function.
//> Take new altered array of colors, and render image