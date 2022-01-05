package de.halcony.creator.dotfile

object DumpEscaping {

  implicit class ShadowString(str : String) {

    def dotFileConformEscape : String = {
      str.replace("\"","\\\"").replace("\n","\\n").replace("<", raw"\<").replace(">", raw"\>")
    }

  }

}
