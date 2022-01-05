package de.halcony.creator.dotfile

import de.halcony.creator.dotfile.DumpEscaping._

case class Node(identifier: String, label: String, attributes: (String, String)*)
  extends DotFileElement {

  /*override def dotString: String = {
    s"$identifier" + " " + "[label=\"" + label.dotFileConformEscape + "\"" + (attributes match {
      case Nil => ""
      case x => " comment=\"" + x.map(pair => s"${pair._1}=${pair._2}").mkString(",").dotFileConformEscape + "\""
    }) + "];"*/

  override def dotString: String = {
    var ret: String = identifier + " ";
    ret += (label.dotFileConformEscape match {
      case "LITERAL" | "METHOD" | "IDENTIFIER" | "CALL" | "LOCAL" => "[shape=record "
      case _ => "["
    })
    ret += "label=\"" + label.dotFileConformEscape;
    ret += (label.dotFileConformEscape match {
      case "LITERAL" | "METHOD" | "IDENTIFIER" => s"| ${attributes.filter(pair => pair._1 == "CODE").map(_._2.dotFileConformEscape).head}"
      case "CALL" | "LOCAL" => s"| ${attributes.filter(pair => pair._1 == "NAME").map(_._2.dotFileConformEscape).head}"
      case _ => ""
    })
    ret += "\"];"
    ret;
  }

}
