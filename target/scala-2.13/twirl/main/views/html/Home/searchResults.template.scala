
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Form[SearchForm],MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(keyword: String)(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import helper._


Seq[Any](format.raw/*4.94*/("""

"""),format.raw/*7.1*/("""
"""),format.raw/*12.3*/("""

"""),format.raw/*14.1*/("""<html lang="en">
<head>
  <title>Welcome to YT Lytics</title>
</head>
    <body>
        <h1>Welcome to YT Lytics</h1>
        <!-- Input form for keyword-->
        """),_display_(/*21.10*/helper/*21.16*/.form(action = routes.HomeController.search())/*21.62*/ {_display_(Seq[Any](format.raw/*21.64*/("""
            """),_display_(/*22.14*/helper/*22.20*/.inputText(searchForm("keyword"))),format.raw/*22.53*/("""
            """),format.raw/*23.13*/("""<input type="submit" value="submit">
        """)))}),format.raw/*24.10*/("""
        """),format.raw/*25.9*/("""<!-- Display search results-->
        <p>"""),_display_(/*26.13*/keyword),format.raw/*26.20*/(""" """),format.raw/*26.21*/("""</p>
    </body>
</html>"""))
      }
    }
  }

  def render(keyword:String,searchForm:Form[SearchForm],messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(keyword)(searchForm)(messagesProvider)

  def f:((String) => (Form[SearchForm]) => (MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (keyword) => (searchForm) => (messagesProvider) => apply(keyword)(searchForm)(messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/searchResults.scala.html
                  HASH: b13b35ca43cc5e2c8020125ddab5bb4ef57151fe
                  MATRIX: 615->1|646->27|683->59|1067->99|1232->196|1277->191|1307->213|1336->380|1367->384|1568->558|1583->564|1638->610|1678->612|1720->627|1735->633|1789->666|1831->680|1909->727|1946->737|2017->781|2045->788|2074->789
                  LINES: 23->1|24->2|25->3|30->4|33->6|36->4|38->7|39->12|41->14|48->21|48->21|48->21|48->21|49->22|49->22|49->22|50->23|51->24|52->25|53->26|53->26|53->26
                  -- GENERATED --
              */
          