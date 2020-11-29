package de.halcony.creator.dotfile

import de.halcony.creator.dotfile.DumpEscaping._

case class Node(identifier: String, label: String, attributes: (String, String)*)
    extends DotFileElement {

  override def dotString: String = {
    s"$identifier" + " " + "[label=\"" + label.dotFileConformEscape + "\"" + (attributes match {
      case Nil => ""
      case x => " comment=\"" + x.map(pair => s"${pair._1}=${pair._2}").mkString(",").dotFileConformEscape + "\""
    }) + "];"

  }

}
