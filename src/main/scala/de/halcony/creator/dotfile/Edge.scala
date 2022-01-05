package de.halcony.creator.dotfile

import de.halcony.creator.dotfile.DumpEscaping.ShadowString

trait Edge extends DotFileElement {

  def start: String

  def target: String

}

case class DirectedEdge(start: String,
                        target: String,
                        label: String,
                        attributes: (String, String)*)
  extends Edge {

  override def dotString: String = {
    // if (label.dotFileConformEscape != "CFG") return "";
    if (label.dotFileConformEscape == "CONTAINS") return "";
    var ret: String = s"${start} -> ${target} " + "[label=\"" + label.dotFileConformEscape + "\""
    ret += (label.dotFileConformEscape match {
      case "AST" => " color=blue"
      case "REACHING_DEF" => " color=orange"
      case "ARGUMENT" => " style=dashed color=purple"
      case "CALL" => " color=crimson"
      case _ => ""
    })
    ret += "];"
    ret
  }

}
