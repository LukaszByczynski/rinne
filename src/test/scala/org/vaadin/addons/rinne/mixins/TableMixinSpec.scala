package org.vaadin.addons.rinne.mixins

import com.vaadin.server.ThemeResource
import com.vaadin.ui.Table
import com.vaadin.ui.Table._
import org.mockito.Mockito
import org.scalatest.FunSpec
import org.vaadin.addons.rinne.{SelectionMode, VTable}

class TableMixinSpec extends FunSpec {

  describe("A VTableMixin") {

    val table: VTable = Mockito.spy(new VTable())
    table.addContainerProperty("col1", classOf[String], Some(""))
    table.addContainerProperty("col2", classOf[String], Some(""))

    it("visibleColumns") {
      Mockito.reset(table)

      assert(table.visibleColumns === "col1" :: "col2" :: Nil)
      assert(table.visibleColumns === "col1" :: "col2" :: Nil)

      table.visibleColumns = "col1" :: Nil
      Mockito.verify(table).setVisibleColumns("col1")

      assert(table.visibleColumns === "col1" :: Nil)

      table.visibleColumns = Nil
      assert(table.visibleColumns === Nil)
    }

    it("columnHeaders") {
      table.visibleColumns = "col1" :: "col2" :: Nil

      table.columnHeaderMode = Table.ColumnHeaderMode.EXPLICIT_DEFAULTS_ID

      table.columnHeaders = Some("Header 1") :: Some("Header 2") :: Nil
      Mockito.verify(table).setColumnHeaders("Header 1", "Header 2")
      assert(table.columnHeaders === Some("Header 1") :: Some("Header 2") :: Nil)
      assert(table.columnHeaders === Some("Header 1") :: Some("Header 2") :: Nil)
    }

    it("columnIcons") {
      val icons = Seq(Some(new ThemeResource("1.png")), None)

      assert(table.columnIcons === Array(None, None))

      table.columnIcons = icons
      Mockito.verify(table).setColumnIcons(icons.head.get, null)

      assert(table.columnIcons === icons)
    }

    it("columnAlignments") {
      import com.vaadin.ui.Table.Align._

      table.columnAlignments = Table.Align.LEFT :: Table.Align.LEFT :: Nil
      assert(table.columnAlignments === Table.Align.LEFT :: Table.Align.LEFT :: Nil)

      table.columnAlignments = Table.Align.CENTER :: Table.Align.RIGHT :: Nil
      Mockito.verify(table).setColumnAlignments(CENTER, RIGHT)

      assert(table.columnAlignments === Table.Align.CENTER :: Table.Align.RIGHT :: Nil)
    }

    it("columnExpandRatio") {
      assert(table.getColumnExpandRatio('myPropertyId) === -1)

      table.setColumnExpandRatio('myPropertyId, 1)
      assert(table.getColumnExpandRatio('myPropertyId) === 1)
    }

    it("columnWidth") {
      assert(table.getColumnWidth('myPropertyId) === -1)

      table.setColumnWidth('myPropertyId, 30)
      assert(table.getColumnWidth('myPropertyId) === 30)
    }

    it("columnIcon") {
      assert(table.getColumnIcon('myPropertyId) === null)

      val icon = new ThemeResource("test.png")

      table.setColumnIcon('myPropertyId, icon)
      assert(table.getColumnIcon('myPropertyId) === icon)

      table.setColumnIcon('myPropertyId, null)
      assert(table.getColumnIcon('myPropertyId) === null)

      table.setColumnIcon('myPropertyId, icon)
      assert(table.getColumnIcon('myPropertyId) === icon)
    }


    it("columnAlignment") {
      assert(table.getColumnAlignment('myPropertyId) === Table.Align.LEFT)

      table.setColumnAlignment('myPropertyId, Table.Align.RIGHT)
      assert(table.getColumnAlignment('myPropertyId) === Table.Align.RIGHT)
    }

    it("pageLength") {
      assert(table.pageLength === 15)

      table.pageLength = 23
      assert(table.pageLength === 23)
    }

    it("cacheRate") {
      assert(table.cacheRate === 2)

      table.cacheRate = 0.33
      assert(table.cacheRate === 0.33)
    }

    it("currentPageFirstItemIndex") {
      assert(table.currentPageFirstItemIndex === 0)
      Mockito.verify(table).getCurrentPageFirstItemIndex

      table.currentPageFirstItemIndex = 10
      Mockito.verify(table).setCurrentPageFirstItemIndex(10)
    }

    it("currentPageFirstItemId") {
      assert(table.currentPageFirstItemId === None)
      Mockito.verify(table).getCurrentPageFirstItemId

      table.currentPageFirstItemId = "test"
      Mockito.verify(table).setCurrentPageFirstItemId("test")
    }

    it("columnCollapsingAllowed") {
      assert(!table.columnCollapsingAllowed)

      table.columnCollapsingAllowed = true
      assert(table.columnCollapsingAllowed)
    }

    it("columnCollapsible") {
      assert(table.isColumnCollapsible("col1"))

      table.setColumnCollapsible("col1", false)
      assert(!table.isColumnCollapsible("col1"))
    }

    it("columnReorderingAllowed") {
      assert(!table.columnReorderingAllowed)

      table.columnReorderingAllowed = true
      assert(table.columnReorderingAllowed)
    }

    it("editable") {
      assert(!table.editable)

      table.editable = true
      assert(table.editable)
    }

    it("sortable") {
      assert(table.sortable)

      table.sortable = false
      assert(!table.sortable)
    }

    it("sortContainerPropertyId") {
      assert(table.sortContainerPropertyId === None)

      table.sortContainerPropertyId = Some("col1")
      assert(table.sortContainerPropertyId === Some("col1"))

      table.sortContainerPropertyId = None
      assert(table.sortContainerPropertyId === None)

      table.sortContainerPropertyId = "col1"
      assert(table.sortContainerPropertyId === Some("col1"))
    }

    it("selectionMode, default should be None") {
      assert(table.selectionMode === SelectionMode.None)

    }

    it("selectionMode, None") {
      import SelectionMode._
      table.selectionMode = None
      assert(table.selectionMode === None)
    }

    it("selectionMode, Single") {
      import SelectionMode._
      table.selectionMode = Single
      assert(table.selectionMode === Single)
    }

    it("selectionMode, Multi") {
      table.selectionMode = SelectionMode.Multi
      assert(table.selectionMode === SelectionMode.Multi)
    }

    it("selectionMode, MultiSimple") {
      table.selectionMode = SelectionMode.MultiSimple
      assert(table.selectionMode === SelectionMode.MultiSimple)
    }

    it("columnHeaderMode") {
      assert(table.columnHeaderMode === Table.ColumnHeaderMode.EXPLICIT_DEFAULTS_ID)

      table.columnHeaderMode = Table.ColumnHeaderMode.EXPLICIT
      assert(table.columnHeaderMode === Table.ColumnHeaderMode.EXPLICIT)
    }

    it("rowHeaderMode") {
      assert(table.rowHeaderMode === Table.RowHeaderMode.HIDDEN)

      table.rowHeaderMode = Table.RowHeaderMode.ICON_ONLY
      assert(table.rowHeaderMode === Table.RowHeaderMode.ICON_ONLY)
    }

    it("footerVisible") {
      assert(!table.footerVisible)

      table.footerVisible = true
      assert(table.footerVisible)
    }

    describe("headerClickListeners should") {

      val listener1 = (e: HeaderClickEvent) => println("1")
      val listener2 = (e: HeaderClickEvent) => println(e)

      it("headerClickListeners.add a listener to table") {
        val table = new VTable

        table.headerClickListeners += (println(_))

        assert(table.headerClickListeners.size === 1)
      }

      it("headerClickListeners.remove a listener from table") {
        val table = new VTable

        table.headerClickListeners += listener1
        table.headerClickListeners -= listener1

        assert(table.headerClickListeners.size === 0)
      }

      it("headerClickListeners.iterator returns added listeners") {
        val table = new VTable

        table.headerClickListeners += listener1
        table.headerClickListeners += listener2

        val iter = table.headerClickListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("headerClickListeners.contains returns true for added listener") {
        val table = new VTable

        table.headerClickListeners += listener1
        assert(table.headerClickListeners.contains(listener1))
      }

      it("headerClickListeners.contains returns false for non-added listener") {
        val table = new VTable

        assert(!table.headerClickListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val table = new VTable {
          headerClickListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        table.getListeners(classOf[HeaderClickEvent]).asScala
          .foreach { case e: HeaderClickListener => e.headerClick(null) }
        assert(executed)
      }
    }

    describe("footerClickListeners should") {

      val listener1 = (e: FooterClickEvent) => println("1")
      val listener2 = (e: FooterClickEvent) => println(e)

      it("footerClickListeners.add a listener to table") {
        val table = new VTable

        table.footerClickListeners += (println(_))

        assert(table.footerClickListeners.size === 1)
      }

      it("footerClickListeners.remove a listener from table") {
        val table = new VTable

        table.footerClickListeners += listener1
        table.footerClickListeners -= listener1

        assert(table.footerClickListeners.size === 0)
      }

      it("footerClickListeners.iterator returns added listeners") {
        val table = new VTable

        table.footerClickListeners += listener1
        table.footerClickListeners += listener2

        val iter = table.footerClickListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("footerClickListeners.contains returns true for added listener") {
        val table = new VTable

        table.footerClickListeners += listener1
        assert(table.footerClickListeners.contains(listener1))
      }

      it("footerClickListeners.contains returns false for non-added listener") {
        val table = new VTable

        assert(!table.footerClickListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val table = new VTable {
          footerClickListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        table.getListeners(classOf[FooterClickEvent]).asScala
          .foreach { case e: FooterClickListener => e.footerClick(null) }
        assert(executed)
      }
    }

    describe("columnResizeListeners should") {

      val listener1 = (e: ColumnResizeEvent) => println("1")
      val listener2 = (e: ColumnResizeEvent) => println(e)

      it("columnResizeListeners.add a listener to table") {
        val table = new VTable

        table.columnResizeListeners += (println(_))

        assert(table.columnResizeListeners.size === 1)
      }

      it("columnResizeListeners.remove a listener from table") {
        val table = new VTable

        table.columnResizeListeners += listener1
        table.columnResizeListeners -= listener1

        assert(table.columnResizeListeners.size === 0)
      }

      it("columnResizeListeners.iterator returns added listeners") {
        val table = new VTable

        table.columnResizeListeners += listener1
        table.columnResizeListeners += listener2

        val iter = table.columnResizeListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("columnResizeListeners.contains returns true for added listener") {
        val table = new VTable

        table.columnResizeListeners += listener1
        assert(table.columnResizeListeners.contains(listener1))
      }

      it("columnResizeListeners.contains returns false for non-added listener") {
        val table = new VTable

        assert(!table.columnResizeListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val table = new VTable {
          columnResizeListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        table.getListeners(classOf[ColumnResizeEvent]).asScala
          .foreach { case e: ColumnResizeListener => e.columnResize(null) }
        assert(executed)
      }
    }

    describe("columnReorderListeners should") {

      val listener1 = (e: ColumnReorderEvent) => println("1")
      val listener2 = (e: ColumnReorderEvent) => println(e)

      it("columnReorderListeners.add a listener to table") {
        val table = new VTable

        table.columnReorderListeners += (println(_))

        assert(table.columnReorderListeners.size === 1)
      }

      it("columnReorderListeners.remove a listener from table") {
        val table = new VTable

        table.columnReorderListeners += listener1
        table.columnReorderListeners -= listener1

        assert(table.columnReorderListeners.size === 0)
      }

      it("columnReorderListeners.iterator returns added listeners") {
        val table = new VTable

        table.columnReorderListeners += listener1
        table.columnReorderListeners += listener2

        val iter = table.columnReorderListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("columnReorderListeners.contains returns true for added listener") {
        val table = new VTable

        table.columnReorderListeners += listener1
        assert(table.columnReorderListeners.contains(listener1))
      }

      it("columnReorderListeners.contains returns false for non-added listener") {
        val table = new VTable

        assert(!table.columnReorderListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val table = new VTable {
          columnReorderListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        table.getListeners(classOf[ColumnReorderEvent]).asScala
          .foreach { case e: ColumnReorderListener => e.columnReorder(null) }
        assert(executed)
      }
    }
  }
}