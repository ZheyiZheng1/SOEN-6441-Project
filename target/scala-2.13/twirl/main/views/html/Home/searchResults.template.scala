
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[ArrayList[String],ArrayList[ArrayList[ArrayList[TextSegment]]],ArrayList[ArrayList[String]],Form[SearchForm],MessagesProvider,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(keywords: ArrayList[String])(userList: ArrayList[ArrayList[ArrayList[TextSegment]]])(userReadability : ArrayList[ArrayList[String]])(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*7.2*/import helper._


Seq[Any](format.raw/*5.242*/("""

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
        <h3><b>Search term:</b> """),_display_(/*32.34*/keywords/*32.42*/.get(index)),format.raw/*32.53*/(""" """),format.raw/*32.54*/("""Flesh-Kincaid Grade Level Avg.= """),_display_(/*32.87*/userReadability/*32.102*/.get(index).get(0)),format.raw/*32.120*/(""" """),format.raw/*32.121*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*32.156*/userReadability/*32.171*/.get(index).get(1)),format.raw/*32.189*/(""" """),format.raw/*32.190*/(""".</h3>
            <a href=""""),_display_(/*33.23*/routes/*33.29*/.WordCountController.videoStatistics(keywords.get(index))),format.raw/*33.86*/("""">More stats</a>
            <br/>
            """),_display_(/*35.14*/for(response <- responseList) yield /*35.43*/ {_display_(Seq[Any](format.raw/*35.45*/("""
                """),_display_(/*36.18*/for(segment <- response) yield /*36.42*/ {_display_(Seq[Any](format.raw/*36.44*/("""
                    """),format.raw/*37.21*/("""<!-- Print all parts of the video information-->
                    """),_display_(if(segment.url != null)/*38.45*/ {_display_(Seq[Any](format.raw/*38.47*/("""
                        """),format.raw/*39.25*/("""<!-- Set hyperlink along with the text-->
                        <a href=""""),_display_(/*40.35*/segment/*40.42*/.url),format.raw/*40.46*/("""">"""),_display_(/*40.49*/segment/*40.56*/.text),format.raw/*40.61*/("""</a>
                    """)))}else/*41.28*/{_display_(Seq[Any](format.raw/*41.29*/("""
                        """),format.raw/*42.25*/("""<!-- Only print the text, no hyperlink-->
                        """),_display_(/*43.26*/segment/*43.33*/.text),format.raw/*43.38*/("""
                    """)))}),format.raw/*44.22*/("""
                """)))}),format.raw/*45.18*/("""
                """),format.raw/*46.17*/("""<br/>
            """)))}),format.raw/*47.14*/("""
        """),format.raw/*48.9*/("""</p>

    </div>
""")))}),format.raw/*51.2*/("""
"""),format.raw/*52.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(keywords:ArrayList[String],userList:ArrayList[ArrayList[ArrayList[TextSegment]]],userReadability:ArrayList[ArrayList[String]],searchForm:Form[SearchForm],messagesProvider:MessagesProvider,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(keywords)(userList)(userReadability)(searchForm)(messagesProvider,request)

  def f:((ArrayList[String]) => (ArrayList[ArrayList[ArrayList[TextSegment]]]) => (ArrayList[ArrayList[String]]) => (Form[SearchForm]) => (MessagesProvider,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (keywords) => (userList) => (userReadability) => (searchForm) => (messagesProvider,request) => apply(keywords)(userList)(userReadability)(searchForm)(messagesProvider,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/searchResults.scala.html
                  HASH: f117a34db1666b8558ed0f13deca239f443162b3
                  MATRIX: 615->1|646->27|683->59|728->99|1206->126|1519->371|1565->366|1595->388|1624->555|1655->559|1841->719|1856->725|1911->771|1951->773|1984->780|1999->786|2053->819|2086->826|2101->832|2137->847|2170->853|2243->896|2272->898|2331->931|2398->982|2438->984|2471->990|2655->1147|2672->1155|2704->1166|2733->1167|2793->1200|2818->1215|2858->1233|2888->1234|2951->1269|2976->1284|3016->1302|3046->1303|3103->1333|3118->1339|3196->1396|3273->1446|3318->1475|3358->1477|3404->1496|3444->1520|3484->1522|3534->1544|3655->1638|3695->1640|3749->1666|3853->1743|3869->1750|3894->1754|3924->1757|3940->1764|3966->1769|4016->1802|4055->1803|4109->1829|4204->1897|4220->1904|4246->1909|4300->1932|4350->1951|4396->1969|4447->1989|4484->1999|4535->2020|4564->2022
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|49->22|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|53->26|54->27|55->28|55->28|55->28|56->29|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|60->33|60->33|60->33|62->35|62->35|62->35|63->36|63->36|63->36|64->37|65->38|65->38|66->39|67->40|67->40|67->40|67->40|67->40|67->40|68->41|68->41|69->42|70->43|70->43|70->43|71->44|72->45|73->46|74->47|75->48|78->51|79->52
                  -- GENERATED --
              */
          