Rinne
=====

Rinne is addon for a [Vaadin Framework](https://vaadin.com), that provides more comfortable API for [Scala](http://www.scala-lang.org/) programming language.

Unlike to the [Scaladin](https://github.com/henrikerola/scaladin) Rinne uses CAKE Pattern to provide Scala API. 

## Discussion

[Vaadin Forum](https://vaadin.com/forum) is the place for discussion about Rinne. You can use the existing [Vaadin & Scala](https://vaadin.com/forum#!/thread/530127) thread or create your own.

## How to use it?

Rinne is designed for use with Vaadin7. Following example shows simple usage:

````scala
@Theme("valo")
class RinneUI extends UI {
  override def init(p1: VaadinRequest): Unit = {
    setContent(new VVerticalLayout {
      sizeFull()

      componentSet += new VLabel {
        styleName = ValoTheme.LABEL_H1
        value = "RinneUI"
      }
    })
  }
}
````

## Credits

The following people have contributed code or ideas to Rinne:

 * Łukasz Byczyński
 
Rinne based on the excellent work and creativity of the Scaladin authors:

 * Matti Heinola 
 * Henri Kerola 
 * Henri Muurimaa 
 * Risto Yrjänä 

## License

Rinne is licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
