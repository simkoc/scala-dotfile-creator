package de.halcony.creator.dotfile

import de.halcony.creator.dotfile.DumpEscaping.ShadowString

trait Edge extends DotFileElement {

  def start: String
  def target: String

}

case class DirectedEdge(start: String,
                        target: String,
                        label : String,
                        attributes: (String, String)*)
    extends Edge {

  override def dotString: String = {
    s"${start} -> ${target}" + " " + "[label=\"" + label + "\"" +  (attributes match {
      case Nil => ""
      case x => " comment=\"" + x.map(pair => s"${pair._1}=${pair._2}").mkString(",").dotFileConformEscape + "\""
    }) + "];"
  }

}
