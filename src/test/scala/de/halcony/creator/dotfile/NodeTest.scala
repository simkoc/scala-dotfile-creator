package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NodeTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "generate a proper dot string without attributes" in {
      Node("test","label").dotString shouldBe "test [label=\"label\" ];"
    }
    "generate a proper dot string with attributes" in {
      Node("test","label",("CODE","SOMECODE"),("value","somevalue"))
        .dotString shouldBe "test [label=\"label\" CODE=\"SOMECODE\",value=\"somevalue\"];"
    }
    "generate a proper dot string even if attributes contain \"" in {
      Node("test","label",("further","some\"weird"))
        .dotString shouldBe "test [label=\"label\" further=\"some\\\"weird\"];"
    }
    "generate a proper string even if attributes contain a newline" in {
      Node("lhs","label",("further",
        """test
          |test""".stripMargin))
        .dotString shouldBe "lhs [label=\"label\" further=\"test\\ntest\"];"
    }

  }

}
