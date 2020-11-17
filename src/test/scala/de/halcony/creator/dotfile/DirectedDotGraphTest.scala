package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DirectedDotGraphTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "return the proper graph for 2 nodes and 2 edges" in {
      val graph = new DirectedGraph("test")
      graph.addNode(Node("test"))
      graph.addNode(Node("other",("some","label")))
      graph.addEdge(DirectedEdge("test","other"))
      graph.addEdge(DirectedEdge("other","test",("label","some")))
      graph.dotString shouldBe
        """digraph test {
          |other [label="some=label"];
          |test;
          |other -> test [label="label=some"];
          |test -> other;
          |}""".stripMargin
    }
  }

}
