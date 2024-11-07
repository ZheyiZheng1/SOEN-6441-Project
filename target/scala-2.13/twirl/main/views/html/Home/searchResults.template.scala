
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
/*3.2*/import play.data.Form
/*4.2*/import play.api.i18n.MessagesProvider
/*5.2*/import Model.TextSegment

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[ArrayList[String],ArrayList[ArrayList[ArrayList[TextSegment]]],ArrayList[ArrayList[String]],Form[SearchForm],MessagesProvider,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(keywords: ArrayList[String])(userList: ArrayList[ArrayList[ArrayList[TextSegment]]])(userReadability : ArrayList[ArrayList[String]])(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import helper._


Seq[Any](format.raw/*6.242*/("""

"""),format.raw/*9.1*/("""
"""),format.raw/*14.3*/("""

"""),format.raw/*16.1*/("""<html lang="en">
    <head>
        <title>Welcome to YT Lytics</title>
    </head>
    <body>
        <h1>Welcome to YT Lytics</h1>
            <!-- Input form for keyword-->
        """),_display_(/*23.10*/helper/*23.16*/.form(action = routes.HomeController.search())/*23.62*/ {_display_(Seq[Any](format.raw/*23.64*/("""
            """),_display_(/*24.14*/helper/*24.20*/.inputText(searchForm("keyword"))),format.raw/*24.53*/("""
            """),_display_(/*25.14*/helper/*25.20*/.CSRF.formField),format.raw/*25.35*/("""
            """),format.raw/*26.13*/("""<input type="submit" value="submit">
        """)))}),format.raw/*27.10*/("""
            """),format.raw/*28.13*/("""<!-- Display search results-->
        """),_display_(/*29.10*/for((responseList, index) <- userList.zipWithIndex) yield /*29.61*/ {_display_(Seq[Any](format.raw/*29.63*/("""
            """),format.raw/*30.13*/("""<div class="response">
                <p>
                        <!-- Print the keyword here then print search results for this keyword-->
            <h3><b>Search term:</b> """),_display_(/*33.38*/keywords/*33.46*/.get(index)),format.raw/*33.57*/(""" """),format.raw/*33.58*/("""Flesh-Kincaid Grade Level Avg.= """),_display_(/*33.91*/userReadability/*33.106*/.get(index).get(0)),format.raw/*33.124*/(""" """),format.raw/*33.125*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*33.160*/userReadability/*33.175*/.get(index).get(1)),format.raw/*33.193*/(""" """),format.raw/*33.194*/(""".</h3>
                <a href=""""),_display_(/*34.27*/routes/*34.33*/.WordCountController.videoStatistics(keywords.get(index))),format.raw/*34.90*/("""">More stats</a>
                <br/>
                """),_display_(/*36.18*/for(response <- responseList) yield /*36.47*/ {_display_(Seq[Any](format.raw/*36.49*/("""
                    """),_display_(/*37.22*/for(segment <- response) yield /*37.46*/ {_display_(Seq[Any](format.raw/*37.48*/("""
                            """),format.raw/*38.29*/("""<!-- Print all parts of the video information-->
                        """),_display_(if(segment.url != null)/*39.49*/ {_display_(Seq[Any](format.raw/*39.51*/("""
                            """),format.raw/*40.29*/("""<!-- Set hyperlink along with the text-->
                        <a href=""""),_display_(/*41.35*/segment/*41.42*/.url),format.raw/*41.46*/("""">"""),_display_(/*41.49*/segment/*41.56*/.text),format.raw/*41.61*/("""</a>
                    """)))}else/*42.28*/{_display_(Seq[Any](format.raw/*42.29*/("""
                                """),format.raw/*43.33*/("""<!-- Only print the text, no hyperlink-->
                                """),_display_(/*44.34*/segment/*44.41*/.text),format.raw/*44.46*/("""
                        """)))}),format.raw/*45.26*/("""
                        """),format.raw/*46.25*/("""<!-- Check if segment is a tag and has a videoId -->
                        <!-- Conditional hyperlink only for Tags with videoId -->
                        """),_display_(if(segment.text == "Tags" && segment.getVideoId() != null)/*48.84*/ {_display_(Seq[Any](format.raw/*48.86*/("""
                            """),format.raw/*49.29*/("""<a href=""""),_display_(/*49.39*/routes/*49.45*/.TagsController.showTags(segment.getVideoId())),format.raw/*49.91*/("""">Tags</a>
                        """)))} else {null} ),format.raw/*50.26*/("""
                    """)))}),format.raw/*51.22*/("""

                    """),format.raw/*53.21*/("""<br/>
                """)))}),format.raw/*54.18*/("""
                """),format.raw/*55.17*/("""</p>



            </div>
        """)))}),format.raw/*60.10*/("""
    """),format.raw/*61.5*/("""</body>
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
                  HASH: e99b6be5e1b067ec3f51008dec9158621a1181e0
                  MATRIX: 615->1|646->27|683->59|712->83|757->123|1235->150|1548->395|1594->390|1624->412|1653->579|1684->583|1903->775|1918->781|1973->827|2013->829|2055->844|2070->850|2124->883|2166->898|2181->904|2217->919|2259->933|2337->980|2379->994|2447->1035|2514->1086|2554->1088|2596->1102|2804->1283|2821->1291|2853->1302|2882->1303|2942->1336|2967->1351|3007->1369|3037->1370|3100->1405|3125->1420|3165->1438|3195->1439|3256->1473|3271->1479|3349->1536|3434->1594|3479->1623|3519->1625|3569->1648|3609->1672|3649->1674|3707->1704|3832->1802|3872->1804|3930->1834|4034->1911|4050->1918|4075->1922|4105->1925|4121->1932|4147->1937|4197->1970|4236->1971|4298->2005|4401->2081|4417->2088|4443->2093|4501->2120|4555->2146|4802->2366|4842->2368|4900->2398|4937->2408|4952->2414|5019->2460|5100->2497|5154->2520|5206->2544|5261->2568|5307->2586|5379->2627|5412->2633
                  LINES: 23->1|24->2|25->3|26->4|27->5|32->6|35->8|38->6|40->9|41->14|43->16|50->23|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|54->27|55->28|56->29|56->29|56->29|57->30|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|63->36|63->36|63->36|64->37|64->37|64->37|65->38|66->39|66->39|67->40|68->41|68->41|68->41|68->41|68->41|68->41|69->42|69->42|70->43|71->44|71->44|71->44|72->45|73->46|75->48|75->48|76->49|76->49|76->49|76->49|77->50|78->51|80->53|81->54|82->55|87->60|88->61
                  -- GENERATED --
              */
          