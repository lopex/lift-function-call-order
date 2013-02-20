package code.snippet

import net.liftweb._
import util._
import http._
import js.JsCmds.{SetHtml}
import Helpers._

import scala.xml._


object Test {

    def input = "*" #> SHtml.text("", s => println("Text filled"))

    def submit = "*" #> SHtml.hidden(() => println("Submit called"))

    def swap = "*" #> SHtml.a(Text("swap")) {
        SetHtml("swapped", SHtml.text("", s => println("Text2 filled")))
    }
}