
package views.html.Home

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._
/*1.2*/import Model.SearchForm

object display extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[SearchForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(searchForm: Form[SearchForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import helper._


Seq[Any](format.raw/*2.32*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*10.3*/("""

"""),format.raw/*12.1*/("""<html lang="en">
<head>
    <title>Welcome to YT Lytics</title>
</head>
    <body>
        """),_display_(/*17.10*/helper/*17.16*/.form(action = routes.HomeController.search())/*17.62*/ {_display_(Seq[Any](format.raw/*17.64*/("""
            """),_display_(/*18.14*/helper/*18.20*/.inputText(searchForm("keyword"))),format.raw/*18.53*/("""
            """),format.raw/*19.13*/("""<input type="submit" value="submit">
        """)))}),format.raw/*20.10*/("""
    """),format.raw/*21.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(searchForm:Form[SearchForm]): play.twirl.api.HtmlFormat.Appendable = apply(searchForm)

  def f:((Form[SearchForm]) => play.twirl.api.HtmlFormat.Appendable) = (searchForm) => apply(searchForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/display.scala.html
                  HASH: 6be217f35b00d5e8b71274bba2f2b3d22f7e1238
                  MATRIX: 615->1|955->27|1058->62|1103->57|1133->79|1162->204|1193->208|1317->305|1332->311|1387->357|1427->359|1469->374|1484->380|1538->413|1580->427|1658->474|1691->480
                  LINES: 23->1|28->2|31->4|34->2|36->5|37->10|39->12|44->17|44->17|44->17|44->17|45->18|45->18|45->18|46->19|47->20|48->21
                  -- GENERATED --
              */
          