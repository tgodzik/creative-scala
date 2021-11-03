import doodle.image._
import doodle.core._
import doodle.image.syntax._
import doodle.java2d._
import doodle.effect.Writer.Png

@main
def main(): Unit =
  val allImages: List[Drawable] = List(
    Circle,
    Square
  )

  val fulImage =
    allImages.zipWithIndex.groupBy { case (_, index) => index / 10 }.map {
      case (_, group) =>
        group.foldLeft(Image.empty) { case (pre, (drawable, index)) =>
          pre.beside(drawable.image())
        }
    }.foldLeft(Image.empty){ case (pre, img) =>
          pre.below(img)
        }

  fulImage.write[Png]("mosaic.png")
