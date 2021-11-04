import doodle.image.*
// Colors and other useful stuff
import doodle.core.*

object Square extends Drawable:
  def image() = Image.square(10).fillColor(Color.magenta)
