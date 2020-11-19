package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EdgeTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "result in proper string without attributes" in {
      DirectedEdge("lhs","rhs").dotString shouldBe "lhs -> rhs;"
    }
    "result in proper string with attributes" in {
      DirectedEdge("lhs","rhs",("label","REACHES"),("variable","$x"))
        .dotString shouldBe "lhs -> rhs [label=\"label=REACHES,variable=$x\"];"
    }
    "result in proper string even if attributes contain \"" in {
      DirectedEdge("lhs","rhs",("label","some\"weird"))
        .dotString shouldBe "lhs -> rhs [label=\"label=some\\\"weird\"];"
    }
    "result in a proper string even if attributes contain a newline" in {
      DirectedEdge("lhs","rhs",("label",
        """test
          |test""".stripMargin))
        .dotString shouldBe "lhs -> rhs [label=\"label=test\\ntest\"];"
    }
  }

}
