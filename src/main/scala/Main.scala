import doodle.core.*
import doodle.effect.Writer.Png
import doodle.image.*
import doodle.image.syntax.*
import doodle.java2d.*

import scala.annotation.tailrec

extension [A](list: List[A])
  def repeat(times: Int) =
    require(times > 0)
    @tailrec
    def loop(times: Int, acc: List[A]): List[A] = 
       if times == 0 then acc
       else loop(times - 1, acc ++ list)
    loop(times, list)


@main
def main(): Unit =
  val allImages: List[Drawable] = List(
    Circle,
    Square
  )

  val fullImage =
    allImages.repeat(10).zipWithIndex
      .groupBy { case (_, index) => index / 10 }
      .map { case (_, group) =>
        group.foldLeft(Image.empty) { case (pre, (drawable, index)) =>
          pre.beside(drawable.image())
        }
      }
      .foldLeft(Image.empty) { case (pre, img) =>
        pre.below(img)
      }

  fullImage.write[Png]("mosaic.png")
end main
