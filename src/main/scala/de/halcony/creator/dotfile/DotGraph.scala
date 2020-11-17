package de.halcony.creator.dotfile

trait DotGraph extends DotFileElement {

  def addEdge(edge : Edge)
  def addNode(node : Node)

}

class DirectedGraph(name : String) extends DotGraph {

  val edges : collection.mutable.Set[Edge] = collection.mutable.Set()
  val nodes : collection.mutable.Map[String, Node] = collection.mutable.Map()

  def addEdge(edge: Edge): Unit = {
    assert(nodes.contains(edge.start))
    assert(nodes.contains(edge.target))
    edges.addOne(edge)
  }

  override def addNode(node: Node): Unit = {
    nodes.addOne((node.identifier, node))
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
