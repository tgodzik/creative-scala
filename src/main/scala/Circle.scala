import doodle.image.*
// Colors and other useful stuff
import doodle.core.*

object Circle extends Drawable:
  def image() = Image.circle(10).fillColor(Color.red)
