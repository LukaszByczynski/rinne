package org.vaadin.addons.rinne

import com.vaadin.v7.ui.NativeSelect
import org.vaadin.addons.rinne.mixins.{AbstractSelectMixin, BlurNotifierMixin, FocusNotifierMixin}

class VNativeSelect extends NativeSelect with AbstractSelectMixin