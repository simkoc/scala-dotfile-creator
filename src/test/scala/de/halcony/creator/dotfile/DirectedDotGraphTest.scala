package de.halcony.creator.dotfile

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DirectedDotGraphTest extends AnyWordSpec with Matchers {

  "dotString" should {
    "return the proper graph for 2 nodes and 2 edges" in {
      val graph = new DirectedGraph("test")
      graph.addNode(Node("test","label"))
      graph.addNode(Node("other","label",("some","further")))
      graph.addEdge(DirectedEdge("test","other","label"))
      graph.addEdge(DirectedEdge("other","test","label",("further","some")))
      graph.dotString shouldBe
        """digraph test {
          |other [label="label" some="further"];
          |test [label="label" ];
          |other -> test [label="label" further="some"];
          |test -> other [label="label" ];
          |}""".stripMargin
    }
  }

}
