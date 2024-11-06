
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
            <a href=""""),_display_(/*33.23*/routes/*33.29*/.HomeController.videoStatistics(keywords.get(index))),format.raw/*33.81*/("""">More stats</a>
            <br/>
            """),_display_(/*35.14*/for(response <- responseList) yield /*35.43*/ {_display_(Seq[Any](format.raw/*35.45*/("""
                """),_display_(/*36.18*/for(segment <- response) yield /*36.42*/ {_display_(Seq[Any](format.raw/*36.44*/("""
                    """),format.raw/*37.21*/("""<!-- Print all parts of the video information-->
                    """),_display_(if(segment.url != null)/*38.45*/ {_display_(Seq[Any](format.raw/*38.47*/("""
                        """),_display_(if(segment.text == "thumbnail")/*39.57*/{_display_(Seq[Any](format.raw/*39.58*/("""
                            """),format.raw/*40.29*/("""</br>
                            <img src=""""),_display_(/*41.40*/segment/*41.47*/.url),format.raw/*41.51*/("""" alt="Video thumbnail" />
                        """)))}else/*42.32*/{_display_(Seq[Any](format.raw/*42.33*/("""
                            """),format.raw/*43.29*/("""<!-- Set hyperlink along with the text-->
                            <a href=""""),_display_(/*44.39*/segment/*44.46*/.url),format.raw/*44.50*/("""">"""),_display_(/*44.53*/segment/*44.60*/.text),format.raw/*44.65*/("""</a>
                        """)))}),format.raw/*45.26*/("""
                    """)))}else/*46.28*/{_display_(Seq[Any](format.raw/*46.29*/("""
                        """),format.raw/*47.25*/("""<!-- Only print the text, no hyperlink-->
                        """),_display_(/*48.26*/segment/*48.33*/.text),format.raw/*48.38*/("""
                    """)))}),format.raw/*49.22*/("""
                """)))}),format.raw/*50.18*/("""
                """),format.raw/*51.17*/("""<br/>
            """)))}),format.raw/*52.14*/("""
        """),format.raw/*53.9*/("""</p>

    </div>
""")))}),format.raw/*56.2*/("""
"""),format.raw/*57.1*/("""</body>
</html>
"""))
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
                  HASH: f68f49c6b9997790fff01fe8dbad5eb111f8d159
                  MATRIX: 615->1|646->27|683->59|728->99|1206->126|1519->371|1565->366|1595->388|1624->555|1655->559|1841->719|1856->725|1911->771|1951->773|1984->780|1999->786|2053->819|2086->826|2101->832|2137->847|2170->853|2243->896|2272->898|2331->931|2398->982|2438->984|2471->990|2655->1147|2672->1155|2704->1166|2733->1167|2793->1200|2818->1215|2858->1233|2888->1234|2951->1269|2976->1284|3016->1302|3046->1303|3103->1333|3118->1339|3191->1391|3268->1441|3313->1470|3353->1472|3399->1491|3439->1515|3479->1517|3529->1539|3650->1633|3690->1635|3775->1693|3814->1694|3872->1724|3945->1770|3961->1777|3986->1781|4062->1840|4101->1841|4159->1871|4267->1952|4283->1959|4308->1963|4338->1966|4354->1973|4380->1978|4442->2009|4488->2038|4527->2039|4581->2065|4676->2133|4692->2140|4718->2145|4772->2168|4822->2187|4868->2205|4919->2225|4956->2235|5007->2256|5036->2258
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|49->22|49->22|49->22|49->22|50->23|50->23|50->23|51->24|51->24|51->24|52->25|53->26|54->27|55->28|55->28|55->28|56->29|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|59->32|60->33|60->33|60->33|62->35|62->35|62->35|63->36|63->36|63->36|64->37|65->38|65->38|66->39|66->39|67->40|68->41|68->41|68->41|69->42|69->42|70->43|71->44|71->44|71->44|71->44|71->44|71->44|72->45|73->46|73->46|74->47|75->48|75->48|75->48|76->49|77->50|78->51|79->52|80->53|83->56|84->57
                  -- GENERATED --
              */
          