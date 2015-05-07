package org.vaadin.addons.rinne

import com.vaadin.ui.NativeSelect
import org.vaadin.addons.rinne.mixins.{FocusNotifierMixin, BlurNotifierMixin, AbstractSelectMixin}

class VNativeSelect extends NativeSelect with AbstractSelectMixin with BlurNotifierMixin with FocusNotifierMixin