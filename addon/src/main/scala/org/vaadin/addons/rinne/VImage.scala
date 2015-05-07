package org.vaadin.addons.rinne

import com.vaadin.ui.Image
import org.vaadin.addons.rinne.mixins.{MouseClickNotifierMixin, AbstractEmbeddedMixin}

class VImage extends Image with AbstractEmbeddedMixin with MouseClickNotifierMixin
