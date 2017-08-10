package ios

import com.vaadin.ui.{HorizontalLayout, RichTextArea, TextField}

package zoe {

  import scala.language.implicitConversions


  class VRichTextArea(field: RichTextArea) {

  }

  object opos {
    implicit def VRichTextAreaWrapper(field: RichTextArea) = new VRichTextArea(field)
  }
}

object Test {

  import org.vaadin.addons.rinne._

  import scala.language.implicitConversions

  //val a = new TextField()
  //a.value2
  val b = new RichTextArea()
  b.width = 200.222.px

  val c = new HorizontalLayout()
  c.components += new TextField
  


}
