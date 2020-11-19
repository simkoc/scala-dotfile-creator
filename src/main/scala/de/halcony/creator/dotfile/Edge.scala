package de.halcony.creator.dotfile

import de.halcony.creator.dotfile.DumpEscaping.ShadowString

trait Edge extends DotFileElement {

  def start: String
  def target: String

}

case class DirectedEdge(start: String,
                        target: String,
                        attributes: (String, String)*)
    extends Edge {

  override def dotString: String = {
    attributes match {
      case Nil => s"${start} -> ${target};"
      case x =>
        s"${start} -> ${target} " + "[label=\"" + x
          .map(pair => s"${pair._1}=${pair._2}")
          .mkString(",").dotFileConformEscape + "\"];"
    }
  }

}
