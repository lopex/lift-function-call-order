package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._

import common._
import http._
import sitemap._
import Loc._

class Boot {
  def boot {
    val logger = Logger(classOf[Boot])
    LiftRules.addToPackages("code")
    LiftRules.explicitlyParsedSuffixes = Set("htm", "html", "shtml")

    val entries = List(Menu.i("Home") / "index")

    LiftRules.setSiteMap(SiteMap(entries:_*))
    LiftRules.ajaxStart = Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    LiftRules.ajaxEnd = Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))
  }
}
