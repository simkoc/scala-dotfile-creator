package de.halcony.creator.dotfile

trait DotGraph extends DotFileElement {

  def addEdge(edge : Edge) : DotGraph
  def addNode(node : Node) : DotGraph

}

class DirectedGraph(name : String) extends DotGraph {

  val edges : collection.mutable.Set[Edge] = collection.mutable.Set()
  val nodes : collection.mutable.Map[String, Node] = collection.mutable.Map()

  def addEdge(edge: Edge): DotGraph = {
    assert(nodes.contains(edge.start))
    assert(nodes.contains(edge.target))
    edges.addOne(edge)
    this
  }

  override def addNode(node: Node): DotGraph = {
    nodes.addOne((node.identifier, node))
    this
  }

  override def dotString: String = {
    val stringBuilder = new StringBuilder()
    stringBuilder.append(s"digraph $name {" + "\n")
    nodes.foreach(pair => stringBuilder.append(pair._2.dotString + "\n"))
    edges.foreach(edge => stringBuilder.append(edge.dotString + "\n"))
    stringBuilder.append("}")
    stringBuilder.toString()
  }
}
