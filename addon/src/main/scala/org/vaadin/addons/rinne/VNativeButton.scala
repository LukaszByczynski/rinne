package org.vaadin.addons.rinne

import com.vaadin.ui.{Button, NativeButton}
import org.vaadin.addons.rinne.events._
import org.vaadin.addons.rinne.mixins.{ButtonMixin, AbstractComponentMixin, FocusableMixin}

class VNativeButton extends NativeButton with ButtonMixin