
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
/*1.2*/import services.YTResponse

object tags extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[YTResponse,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(videoDetails: YTResponse):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.28*/("""


"""),format.raw/*9.3*/("""

"""),format.raw/*11.1*/("""<html lang="en">
    <head>
        <title>"""),_display_(/*13.17*/videoDetails/*13.29*/.getTitle()),format.raw/*13.40*/("""</title>
    </head>
    <body>
        <h1>Video Details / Tags Page</h1>

            <!-- Video Title as link -->
        <h2><a href="https://www.youtube.com/watch?v="""),_display_(/*19.55*/videoDetails/*19.67*/.getVideoId()),format.raw/*19.80*/("""" target="_blank">
        """),_display_(/*20.10*/videoDetails/*20.22*/.getTitle()),format.raw/*20.33*/("""
        """),format.raw/*21.9*/("""</a></h2>

            <!-- Display channel title as a hyperlink to the channel page -->
        <p>Channel: <a href="https://www.youtube.com/channel/"""),_display_(/*24.63*/videoDetails/*24.75*/.getChannelId()),format.raw/*24.90*/("""" target="_blank">"""),_display_(/*24.109*/videoDetails/*24.121*/.getChannelTitle()),format.raw/*24.139*/("""</a></p>

            <!-- Display video description -->
        <p>"""),_display_(/*27.13*/videoDetails/*27.25*/.getDescription()),format.raw/*27.42*/("""</p>

            <!-- Tags with Links to Search by Tag -->
        <h2>Tags</h2>
        <ul>
        """),_display_(/*32.10*/for(tag <- videoDetails.getTags()) yield /*32.44*/ {_display_(Seq[Any](format.raw/*32.46*/("""
            """),format.raw/*33.13*/("""<li><a href=""""),_display_(/*33.27*/routes/*33.33*/.TagsController.searchByTag(tag)),format.raw/*33.65*/("""">"""),_display_(/*33.68*/tag),format.raw/*33.71*/("""</a></li>
        """)))}),format.raw/*34.10*/("""
        """),format.raw/*35.9*/("""</ul>

    </body>
</html>
"""))
      }
    }
  }

  def render(videoDetails:YTResponse): play.twirl.api.HtmlFormat.Appendable = apply(videoDetails)

  def f:((YTResponse) => play.twirl.api.HtmlFormat.Appendable) = (videoDetails) => apply(videoDetails)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/tags.scala.html
                  HASH: e606d97090c8ac968c83b5926d49ad46d475368c
                  MATRIX: 615->1|949->30|1070->56|1102->207|1133->211|1206->257|1227->269|1259->280|1463->457|1484->469|1518->482|1574->511|1595->523|1627->534|1664->544|1845->698|1866->710|1902->725|1949->744|1971->756|2011->774|2110->846|2131->858|2169->875|2305->984|2355->1018|2395->1020|2437->1034|2478->1048|2493->1054|2546->1086|2576->1089|2600->1092|2651->1112|2688->1122
                  LINES: 23->1|28->2|33->2|36->9|38->11|40->13|40->13|40->13|46->19|46->19|46->19|47->20|47->20|47->20|48->21|51->24|51->24|51->24|51->24|51->24|51->24|54->27|54->27|54->27|59->32|59->32|59->32|60->33|60->33|60->33|60->33|60->33|60->33|61->34|62->35
                  -- GENERATED --
              */
          