
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
/*5.2*/import java.util

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[util.ArrayList[String],ArrayList[ArrayList[ArrayList[TextSegment]]],ArrayList[ArrayList[String]],Form[SearchForm],MessagesProvider,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(keywords: util.ArrayList[String])(userList: ArrayList[ArrayList[ArrayList[TextSegment]]])(userReadability : ArrayList[ArrayList[String]])(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import helper._


Seq[Any](format.raw/*6.247*/("""

"""),format.raw/*9.1*/("""
"""),format.raw/*14.3*/("""

"""),format.raw/*16.1*/("""<html lang="en">
<head>
    <title>Welcome to YT Lytics</title>
</head>
<body>
    <h1>Welcome to YT Lytics</h1>
    <!-- Input form for keyword-->
    """),_display_(/*23.6*/helper/*23.12*/.form(action = routes.HomeController.search())/*23.58*/ {_display_(Seq[Any](format.raw/*23.60*/("""
    """),_display_(/*24.6*/helper/*24.12*/.inputText(searchForm("keyword"))),format.raw/*24.45*/("""
    """),_display_(/*25.6*/helper/*25.12*/.CSRF.formField),format.raw/*25.27*/("""
    """),format.raw/*26.5*/("""<input type="submit" value="submit">
    """)))}),format.raw/*27.6*/("""
"""),format.raw/*28.1*/("""<!-- Display search results-->
"""),_display_(/*29.2*/for((responseList, index) <- userList.zipWithIndex) yield /*29.53*/ {_display_(Seq[Any](format.raw/*29.55*/("""
    """),format.raw/*30.5*/("""<div class="response">
        <p>
            <!-- Print the keyword here then print search results for this keyword-->
        <h3><b>Search term:</b> """),_display_(/*33.34*/keywords/*33.42*/.get(index)),format.raw/*33.53*/(""" """),format.raw/*33.54*/("""Flesh-Kincaid Grade Level Avg.= """),_display_(/*33.87*/userReadability/*33.102*/.get(index).get(0)),format.raw/*33.120*/(""" """),format.raw/*33.121*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*33.156*/userReadability/*33.171*/.get(index).get(1)),format.raw/*33.189*/(""" """),format.raw/*33.190*/(""".</h3>
            <a href=""""),_display_(/*34.23*/routes/*34.29*/.HomeController.videoStatistics(keywords.get(index))),format.raw/*34.81*/("""">More stats</a>
            <br/>
            """),_display_(/*36.14*/for(response <- responseList) yield /*36.43*/ {_display_(Seq[Any](format.raw/*36.45*/("""
                """),_display_(/*37.18*/for(segment <- response) yield /*37.42*/ {_display_(Seq[Any](format.raw/*37.44*/("""
                        """),format.raw/*38.25*/("""<!-- Print All Parts of Video Information -->
                        <!-- Display thumbnail image if segment.text is "thumbnail" -->
                    """),_display_(if(segment.url != null && segment.text == "thumbnail")/*40.76*/ {_display_(Seq[Any](format.raw/*40.78*/("""
                        """),format.raw/*41.25*/("""<br/>
                        <img src=""""),_display_(/*42.36*/segment/*42.43*/.url),format.raw/*42.47*/("""" alt="Video thumbnail" />
                    """)))} else {null} ),format.raw/*43.22*/("""

                        """),format.raw/*45.25*/("""<!-- Display "Tags" as a hyperlink if segment.text is "Tags" -->
                    """),_display_(if(segment.text == "Tags"  && segment.videoId != null)/*46.76*/ {_display_(Seq[Any](format.raw/*46.78*/("""
                        """),format.raw/*47.25*/("""<a href=""""),_display_(/*47.35*/routes/*47.41*/.TagsController.showTags(segment.videoId)),format.raw/*47.82*/("""">Tags</a>
                    """)))} else {null} ),format.raw/*48.22*/("""

                        """),format.raw/*50.25*/("""<!-- Display other segments as hyperlinks if URL is present -->
                    """),_display_(if(segment.url != null && segment.text != "thumbnail" && segment.text != "Tags")/*51.102*/ {_display_(Seq[Any](format.raw/*51.104*/("""
                        """),format.raw/*52.25*/("""<a href=""""),_display_(/*52.35*/segment/*52.42*/.url),format.raw/*52.46*/("""">"""),_display_(/*52.49*/segment/*52.56*/.text),format.raw/*52.61*/("""</a>
                    """)))} else {null} ),format.raw/*53.22*/("""

                        """),format.raw/*55.25*/("""<!-- Display plain text if no URL is provided and it’s not "thumbnail" or "Tags" -->
                    """),_display_(if(segment.url == null && segment.text != "thumbnail" && segment.text != "Tags")/*56.102*/ {_display_(Seq[Any](format.raw/*56.104*/("""
                        """),_display_(/*57.26*/segment/*57.33*/.text),format.raw/*57.38*/("""
                    """)))} else {null} ),format.raw/*58.22*/("""
                """)))}),format.raw/*59.18*/("""
                """),format.raw/*60.17*/("""<br/>
            """)))}),format.raw/*61.14*/("""
        """),format.raw/*62.9*/("""</p>

    </div>
""")))}),format.raw/*65.2*/("""
"""),format.raw/*66.1*/("""</body>
</html>
"""))
      }
    }
  }

  def render(keywords:util.ArrayList[String],userList:ArrayList[ArrayList[ArrayList[TextSegment]]],userReadability:ArrayList[ArrayList[String]],searchForm:Form[SearchForm],messagesProvider:MessagesProvider,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(keywords)(userList)(userReadability)(searchForm)(messagesProvider,request)

  def f:((util.ArrayList[String]) => (ArrayList[ArrayList[ArrayList[TextSegment]]]) => (ArrayList[ArrayList[String]]) => (Form[SearchForm]) => (MessagesProvider,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (keywords) => (userList) => (userReadability) => (searchForm) => (messagesProvider,request) => apply(keywords)(userList)(userReadability)(searchForm)(messagesProvider,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/searchResults.scala.html
                  HASH: 0cc532cab91fe72a9f33e5f778f287db5ff13839
                  MATRIX: 615->1|646->27|683->59|728->99|760->126|1235->145|1553->395|1599->390|1629->412|1658->579|1689->583|1875->743|1890->749|1945->795|1985->797|2018->804|2033->810|2087->843|2120->850|2135->856|2171->871|2204->877|2277->920|2306->922|2365->955|2432->1006|2472->1008|2505->1014|2689->1171|2706->1179|2738->1190|2767->1191|2827->1224|2852->1239|2892->1257|2922->1258|2985->1293|3010->1308|3050->1326|3080->1327|3137->1357|3152->1363|3225->1415|3302->1465|3347->1494|3387->1496|3433->1515|3473->1539|3513->1541|3567->1567|3805->1778|3845->1780|3899->1806|3968->1848|3984->1855|4009->1859|4102->1908|4158->1936|4326->2077|4366->2079|4420->2105|4457->2115|4472->2121|4534->2162|4611->2195|4667->2223|4861->2389|4902->2391|4956->2417|4993->2427|5009->2434|5034->2438|5064->2441|5080->2448|5106->2453|5177->2480|5233->2508|5448->2695|5489->2697|5543->2724|5559->2731|5585->2736|5652->2759|5702->2778|5748->2796|5799->2816|5836->2826|5887->2847|5916->2849
                  LINES: 23->1|24->2|25->3|26->4|27->5|32->6|35->8|38->6|40->9|41->14|43->16|50->23|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|54->27|55->28|56->29|56->29|56->29|57->30|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|63->36|63->36|63->36|64->37|64->37|64->37|65->38|67->40|67->40|68->41|69->42|69->42|69->42|70->43|72->45|73->46|73->46|74->47|74->47|74->47|74->47|75->48|77->50|78->51|78->51|79->52|79->52|79->52|79->52|79->52|79->52|79->52|80->53|82->55|83->56|83->56|84->57|84->57|84->57|85->58|86->59|87->60|88->61|89->62|92->65|93->66
                  -- GENERATED --
              */
          