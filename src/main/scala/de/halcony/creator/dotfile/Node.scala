package de.halcony.creator.dotfile

case class Node(identifier: String, attributes: (String, String)*)
    extends DotFileElement {

  override def dotString: String = {
    attributes match {
      case Nil => s"$identifier;"
      case x =>
        s"$identifier " + "[label=\"" + x
          .map(pair => s"${pair._1}=${pair._2}")
          .mkString(",").replace("\"","\\\"") + "\"];"
    }

  }

}
