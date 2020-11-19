package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EdgeTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "result in proper string without attributes" in {
      DirectedEdge("lhs","rhs","label").dotString shouldBe "lhs -> rhs [label=\"label\"];"
    }
    "result in proper string with attributes" in {
      DirectedEdge("lhs","rhs","label",("further","REACHES"),("variable","$x"))
        .dotString shouldBe "lhs -> rhs [label=\"label\" comment=\"further=REACHES,variable=$x\"];"
    }
    "result in proper string even if attributes contain \"" in {
      DirectedEdge("lhs","rhs","label",("further","some\"weird"))
        .dotString shouldBe "lhs -> rhs [label=\"label\" comment=\"further=some\\\"weird\"];"
    }
    "result in a proper string even if attributes contain a newline" in {
      DirectedEdge("lhs","rhs","label",("further",
        """test
          |test""".stripMargin))
        .dotString shouldBe "lhs -> rhs [label=\"label\" comment=\"further=test\\ntest\"];"
    }
  }

}
