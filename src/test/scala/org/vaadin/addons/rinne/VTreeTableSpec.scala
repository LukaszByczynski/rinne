package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VTreeTableSpec extends FunSpec {

  describe("A VTreeTable") {

    describe("should allow to set") {
      val treeTable = new VTreeTable

      it("hierarchyColumn") {
        assert(treeTable.hierarchyColumn === None)

        treeTable.hierarchyColumn = 'col1
        assert(treeTable.hierarchyColumn === Some('col1))

        treeTable.hierarchyColumn = None
        assert(treeTable.hierarchyColumn === None)

        treeTable.hierarchyColumn = Some('col1)
        assert(treeTable.hierarchyColumn === Some('col1))
      }

      it("animationsEnabled") {
        assert(!treeTable.animationsEnabled)

        treeTable.animationsEnabled = true
        assert(treeTable.animationsEnabled)
      }
    }
  }
}