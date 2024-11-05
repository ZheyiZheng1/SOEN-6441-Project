
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
            """),format.raw/*33.13*/("""<a href=""""),_display_(/*33.23*/routes/*33.29*/.WordCountController.videoStatistics(keywords.get(index))),format.raw/*33.86*/("""">More stats</a>
            """),_display_(/*34.14*/for(response <- responseList) yield /*34.43*/ {_display_(Seq[Any](format.raw/*34.45*/("""
                """),_display_(/*35.18*/for(segment <- response) yield /*35.42*/ {_display_(Seq[Any](format.raw/*35.44*/("""
                    """),format.raw/*36.21*/("""<!-- Print all parts of the video information-->
                    """),_display_(if(segment.url != null)/*37.45*/ {_display_(Seq[Any](format.raw/*37.47*/("""
                        """),format.raw/*38.25*/("""<!-- Set hyperlink along with the text-->
                        <a href=""""),_display_(/*39.35*/segment/*39.42*/.url),format.raw/*39.46*/("""">"""),_display_(/*39.49*/segment/*39.56*/.text),format.raw/*39.61*/("""</a>
                    """)))}else/*40.28*/{_display_(Seq[Any](format.raw/*40.29*/("""
                        """),format.raw/*41.25*/("""<!-- Only print the text, no hyperlink-->
                        """),_display_(/*42.26*/segment/*42.33*/.text),format.raw/*42.38*/("""
                    """)))}),format.raw/*43.22*/("""
                """)))}),format.raw/*44.18*/("""
            """)))}),format.raw/*45.14*/("""
        """),format.raw/*46.9*/("""</p>

    </div>
""")))}),format.raw/*49.2*/("""
"""),format.raw/*50.1*/("""</body>
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
                  HASH: 93600c6eb35f052f94773813398507c93cd24a82
                  MATRIX: 615->1|646->27|683->59|728->99|1177->126|1442->323|1488->318|1518->340|1547->507|1578->511|1764->671|1779->677|1834->723|1874->725|1907->732|1922->738|1976->771|2009->778|2024->784|2060->799|2093->805|2166->848|2195->850|2254->883|2321->934|2361->936|2394->942|2558->1079|2575->1087|2607->1098|2649->1112|2686->1122|2701->1128|2779->1185|2837->1216|2882->1245|2922->1247|2968->1266|3008->1290|3048->1292|3098->1314|3219->1408|3259->1410|3313->1436|3417->1513|3433->1520|3458->1524|3488->1527|3504->1534|3530->1539|3580->1572|3619->1573|3673->1599|3768->1667|3784->1674|3810->1679|3864->1702|3914->1721|3960->1736|3997->1746|4048->1767|4077->1769
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|49->22|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|53->26|54->27|55->28|55->28|55->28|56->29|59->32|59->32|59->32|60->33|60->33|60->33|60->33|61->34|61->34|61->34|62->35|62->35|62->35|63->36|64->37|64->37|65->38|66->39|66->39|66->39|66->39|66->39|66->39|67->40|67->40|68->41|69->42|69->42|69->42|70->43|71->44|72->45|73->46|76->49|77->50
                  -- GENERATED --
              */
          