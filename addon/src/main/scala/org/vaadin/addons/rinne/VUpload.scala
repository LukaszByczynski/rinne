package org.vaadin.addons.rinne

import com.vaadin.ui.Upload
import com.vaadin.ui.Upload.Receiver
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VUpload extends Upload with AbstractComponentMixin {


  def receiver: Option[Receiver] = Option(getReceiver)

  def receiver_=(receiver: Receiver): Unit = receiver_=(Option(receiver))

  def receiver_=(receiverOption: Option[Receiver]): Unit = setReceiver(receiverOption.orNull)

  def uploading: Boolean = isUploading

  def bytesRead: Long = getBytesRead

  def uploadSize: Long = getUploadSize

  def buttonCaption: Option[String] = Option(getButtonCaption)

  def buttonCaption_=(buttonCaption: Option[String]) {
    setButtonCaption(buttonCaption.orNull)
  }

  def buttonCaption_=(buttonCaption: String) {
    setButtonCaption(buttonCaption)
  }

  //  lazy val progressListeners: ListenersSet[Upload.ProgressEvent => Unit] =
  //    new ListenersTrait[Upload.ProgressEvent, UploadProgressListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.server.StreamVariable.StreamingProgressEvent])
  //      override def addListener(elem: Upload.ProgressEvent => Unit) =
  //        addProgressListener(new UploadProgressListener(elem))
  //      override def removeListener(elem: UploadProgressListener) = removeProgressListener(elem)
  //    }
  //
  //  lazy val startedListeners: ListenersSet[Upload.StartedEvent => Unit] =
  //    new ListenersTrait[Upload.StartedEvent, UploadStartedListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.ui.Upload.StartedEvent])
  //      override def addListener(elem: Upload.StartedEvent => Unit) =
  //        addStartedListener(new UploadStartedListener(elem))
  //      override def removeListener(elem: UploadStartedListener) = removeStartedListener(elem)
  //    }
  //
  //  lazy val finishedListeners: ListenersSet[Upload.FinishedEvent => Unit] =
  //    new ListenersTrait[Upload.FinishedEvent, UploadFinishedListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.ui.Upload.FinishedEvent])
  //      override def addListener(elem: Upload.FinishedEvent => Unit) =
  //        addFinishedListener(new UploadFinishedListener(elem))
  //      override def removeListener(elem: UploadFinishedListener) = removeFinishedListener(elem)
  //    }
  //
  //  lazy val failedListeners: ListenersSet[Upload.FailedEvent => Unit] =
  //    new ListenersTrait[Upload.FailedEvent, UploadFailedListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.ui.Upload.FailedEvent])
  //      override def addListener(elem: Upload.FailedEvent => Unit) = addFailedListener(new UploadFailedListener(elem))
  //      override def removeListener(elem: UploadFailedListener) = removeFailedListener(elem)
  //    }
  //
  //  lazy val succeededListeners: ListenersSet[Upload.SucceededEvent => Unit] =
  //    new ListenersTrait[Upload.SucceededEvent, UploadSucceededListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.ui.Upload.SucceededEvent])
  //      override def addListener(elem: Upload.SucceededEvent => Unit) =
  //        addSucceededListener(new UploadSucceededListener(elem))
  //      override def removeListener(elem: UploadSucceededListener) = removeSucceededListener(elem)
  //    }
}