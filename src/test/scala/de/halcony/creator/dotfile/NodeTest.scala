package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NodeTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "generate a proper dot string without attributes" in {
      Node("test").dotString shouldBe "test;"
    }
    "generate a proper dot string with attributes" in {
      Node("test",("CODE","SOMECODE"),("value","somevalue"))
        .dotString shouldBe "test [label=\"CODE=SOMECODE,value=somevalue\"];"
    }
    "generate a proper dot string even if attributes contain \"" in {
      Node("test",("label","some\"weird"))
        .dotString shouldBe "test [label=\"label=some\\\"weird\"];"
    }
    "generate a proper string even if attributes contain a newline" in {
      Node("lhs",("label",
        """test
          |test""".stripMargin))
        .dotString shouldBe "lhs [label=\"label=test\\ntest\"];"
    }

  }

}
