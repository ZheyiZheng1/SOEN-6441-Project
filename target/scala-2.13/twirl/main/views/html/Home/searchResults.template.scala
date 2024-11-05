
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
/*4.2*/import Model.TextSegment

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[ArrayList[String],ArrayList[ArrayList[ArrayList[TextSegment]]],Form[SearchForm],MessagesProvider,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(keywords: ArrayList[String])(userList: ArrayList[ArrayList[ArrayList[TextSegment]]])(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*7.2*/import helper._


Seq[Any](format.raw/*5.194*/("""

"""),format.raw/*8.1*/("""
"""),format.raw/*13.3*/("""

"""),format.raw/*15.1*/("""<html lang="en">
<head>
    <title>Welcome to YT Lytics</title>
</head>
<body>
    <h1>Welcome to YT Lytics</h1>
    <!-- Input form for keyword-->
    """),_display_(/*22.6*/helper/*22.12*/.form(action = routes.HomeController.search())/*22.58*/ {_display_(Seq[Any](format.raw/*22.60*/("""
    """),_display_(/*23.6*/helper/*23.12*/.inputText(searchForm("keyword"))),format.raw/*23.45*/("""
    """),_display_(/*24.6*/helper/*24.12*/.CSRF.formField),format.raw/*24.27*/("""
    """),format.raw/*25.5*/("""<input type="submit" value="submit">
    """)))}),format.raw/*26.6*/("""
"""),format.raw/*27.1*/("""<!-- Display search results-->
"""),_display_(/*28.2*/for((responseList, index) <- userList.zipWithIndex) yield /*28.53*/ {_display_(Seq[Any](format.raw/*28.55*/("""
    """),format.raw/*29.5*/("""<div class="response">
        <p>
            <!-- Print the keyword here then print search results for this keyword-->
            """),_display_(/*32.14*/keywords/*32.22*/.get(index)),format.raw/*32.33*/("""
            """),_display_(/*33.14*/for(response <- responseList) yield /*33.43*/ {_display_(Seq[Any](format.raw/*33.45*/("""
                """),_display_(/*34.18*/for(segment <- response) yield /*34.42*/ {_display_(Seq[Any](format.raw/*34.44*/("""
                    """),format.raw/*35.21*/("""<!-- Print all parts of the video information-->
                    """),_display_(if(segment.url != null)/*36.45*/ {_display_(Seq[Any](format.raw/*36.47*/("""
                        """),format.raw/*37.25*/("""<!-- Set hyperlink along with the text-->
                        <a href=""""),_display_(/*38.35*/segment/*38.42*/.url),format.raw/*38.46*/("""">"""),_display_(/*38.49*/segment/*38.56*/.text),format.raw/*38.61*/("""</a>
                    """)))}else/*39.28*/{_display_(Seq[Any](format.raw/*39.29*/("""
                        """),format.raw/*40.25*/("""<!-- Only print the text, no hyperlink-->
                        """),_display_(/*41.26*/segment/*41.33*/.text),format.raw/*41.38*/("""
                    """)))}),format.raw/*42.22*/("""
                """)))}),format.raw/*43.18*/("""
            """)))}),format.raw/*44.14*/("""
        """),format.raw/*45.9*/("""</p>
    </div>
""")))}),format.raw/*47.2*/("""
"""),format.raw/*48.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(keywords:ArrayList[String],userList:ArrayList[ArrayList[ArrayList[TextSegment]]],searchForm:Form[SearchForm],messagesProvider:MessagesProvider,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(keywords)(userList)(searchForm)(messagesProvider,request)

  def f:((ArrayList[String]) => (ArrayList[ArrayList[ArrayList[TextSegment]]]) => (Form[SearchForm]) => (MessagesProvider,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (keywords) => (userList) => (searchForm) => (messagesProvider,request) => apply(keywords)(userList)(searchForm)(messagesProvider,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/searchResults.scala.html
                  HASH: 5fdcffde0e3b55c49c2841b7c8406422aab26138
                  MATRIX: 615->1|646->27|683->59|728->99|1177->126|1442->323|1488->318|1518->340|1547->507|1578->511|1764->671|1779->677|1834->723|1874->725|1907->732|1922->738|1976->771|2009->778|2024->784|2060->799|2093->805|2166->848|2195->850|2254->883|2321->934|2361->936|2394->942|2558->1079|2575->1087|2607->1098|2649->1113|2694->1142|2734->1144|2780->1163|2820->1187|2860->1189|2910->1211|3031->1305|3071->1307|3125->1333|3229->1410|3245->1417|3270->1421|3300->1424|3316->1431|3342->1436|3392->1469|3431->1470|3485->1496|3580->1564|3596->1571|3622->1576|3676->1599|3726->1618|3772->1633|3809->1643|3858->1662|3887->1664
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|49->22|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|53->26|54->27|55->28|55->28|55->28|56->29|59->32|59->32|59->32|60->33|60->33|60->33|61->34|61->34|61->34|62->35|63->36|63->36|64->37|65->38|65->38|65->38|65->38|65->38|65->38|66->39|66->39|67->40|68->41|68->41|68->41|69->42|70->43|71->44|72->45|74->47|75->48
                  -- GENERATED --
              */
          