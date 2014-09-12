package org.vaadin.addons

import com.vaadin.ui._
import org.vaadin.addons.rinne.MeasureExtent
import org.vaadin.addons.rinne.mixins._

import scala.language.implicitConversions
import scala.reflect.{ClassTag, classTag}

package object rinne {

  implicit def intToMeasureOption(value: Int): MeasureExtent = new MeasureExtent(value)

  implicit def doubleToMeasureOption(value: Double): MeasureExtent = new MeasureExtent(value)

  abstract class VCustomField[T: ClassTag] extends CustomField[T] with AbstractFieldMixin[T] {
    override def getType: Class[_ <: T] = classTag[T].runtimeClass.asInstanceOf[Class[_ <: T]]
  }

  class VAbsoluteLayout extends AbsoluteLayoutMixin

  class VComboBox extends ComboBoxMixin

  class VCssLayout extends CssMixin

  class VGridLayout extends GridLayoutMixin

  class VHorizontalLayout extends HorizontalLayout with AbstractOrderedLayoutMixin

  class VVerticalLayout extends VerticalLayout with AbstractOrderedLayoutMixin

  class VFormLayout extends FormLayout with AbstractOrderedLayoutMixin

  class VLabel extends LabelMixin

  class VPasswordField extends PasswordField with AbstractTextFieldMixin

  class VTextField extends TextField with AbstractTextFieldMixin

  class VRichTextArea extends RichTextAreaMixin

  class VTextArea extends TextAreaMixin

  class VWindow extends WindowMixin

  class VPanel extends PanelMixin

  class VButton extends ButtonMixin

  class VNativeButton extends NativeButton with NativeButtonMixin

  class VHorizontalSplitPanel extends HorizontalSplitPanel with AbstractSplitPanelMixin

  class VVerticalSplitPanel extends VerticalSplitPanel with AbstractSplitPanelMixin

  class VTable extends Table with TableMixin

  class VImage extends Image with AbstractEmbeddedMixin

  class VListSelect extends ListSelectMixin

  class VDateField extends DateFieldMixin

  class VPopupDateField extends PopupDateFieldMixin

  class VTabSheet extends TabSheetMixin

  class VAccordion extends Accordion with TabSheetMixin

  class VCustomComponent extends CustomComponent with ComponentMixin {

    def compositionRoot: Option[Component] = Option(getCompositionRoot)

    def compositionRoot_=(component: Component) {
      setCompositionRoot(component)
    }

    def compositionRoot_=(component: Option[Component]) {
      setCompositionRoot(component.orNull)
    }
  }

  class VCheckBox extends CheckBox with CheckBoxMixin

  class VMenuBar extends MenuBar with AbstractComponentMixin

}
