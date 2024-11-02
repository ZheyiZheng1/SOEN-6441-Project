
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
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.i18n.MessagesProvider

object display extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[SearchForm],MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import helper._


Seq[Any](format.raw/*4.77*/("""

"""),format.raw/*7.1*/("""
"""),format.raw/*12.3*/("""

"""),format.raw/*14.1*/("""<html lang="en">
<head>
    <title>Welcome to YT Lytics</title>
</head>
    <body>
        """),_display_(/*19.10*/helper/*19.16*/.form(action = routes.HomeController.search())/*19.62*/ {_display_(Seq[Any](format.raw/*19.64*/("""
            """),_display_(/*20.14*/helper/*20.20*/.inputText(searchForm("keyword"))),format.raw/*20.53*/("""
            """),format.raw/*21.13*/("""<input type="submit" value="submit">
        """)))}),format.raw/*22.10*/("""
    """),format.raw/*23.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(searchForm:Form[SearchForm],messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(searchForm)(messagesProvider)

  def f:((Form[SearchForm]) => (MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (searchForm) => (messagesProvider) => apply(searchForm)(messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/display.scala.html
                  HASH: 8a3f547b8ee6cc5f95c5b586bb8b6b16548a0633
                  MATRIX: 615->1|646->27|683->59|1054->99|1202->179|1247->174|1277->196|1306->321|1337->325|1461->422|1476->428|1531->474|1571->476|1613->491|1628->497|1682->530|1724->544|1802->591|1835->597
                  LINES: 23->1|24->2|25->3|30->4|33->6|36->4|38->7|39->12|41->14|46->19|46->19|46->19|46->19|47->20|47->20|47->20|48->21|49->22|50->23
                  -- GENERATED --
              */
          