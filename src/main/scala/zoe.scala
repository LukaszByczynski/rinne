package ios

import com.vaadin.ui.{AbstractField, RichTextArea, TextField}

package zoe {

  import org.vaadin.addons.rinne.v8.VClientConnector

  import scala.language.implicitConversions


  class VRichTextArea(field: RichTextArea) {

  }

  object opos {
    implicit def VRichTextAreaWrapper(field: RichTextArea) = new VRichTextArea(field)
  }
}

object Test {

  import scala.language.implicitConversions

  import org.vaadin.addons.rinne.v8._
  import ios.zoe.opos._

  //val a = new TextField()
  //a.value2
  val b = new RichTextArea()
  b.value
  b.valueChangeListeners += {
    println()
  }

  b.valueChangeListeners += {
    println("opoka")
  }

  b.value

  b.id 
  b.ui.push()




}
