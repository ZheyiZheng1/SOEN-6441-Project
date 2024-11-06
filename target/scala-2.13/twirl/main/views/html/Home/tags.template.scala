
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

"""),format.raw/*4.1*/("""<html lang="en">
    <head>
        <title>"""),_display_(/*6.17*/videoDetails/*6.29*/.getTitle()),format.raw/*6.40*/("""</title>
    </head>
    <body>
        <h1>Video Details / Tags Page</h1>

            <!-- Video Title as link -->
        <h2><a href="https://www.youtube.com/watch?v="""),_display_(/*12.55*/videoDetails/*12.67*/.getVideoId()),format.raw/*12.80*/("""" target="_blank">
        """),_display_(/*13.10*/videoDetails/*13.22*/.getTitle()),format.raw/*13.33*/("""
        """),format.raw/*14.9*/("""</a></h2>

            <!-- Display channel title as a hyperlink to the channel page -->
        <p>Channel: <a href="https://www.youtube.com/channel/"""),_display_(/*17.63*/videoDetails/*17.75*/.getChannelId()),format.raw/*17.90*/("""" target="_blank">"""),_display_(/*17.109*/videoDetails/*17.121*/.getChannelTitle()),format.raw/*17.139*/("""</a></p>

            <!-- Display video description -->
        <p>"""),_display_(/*20.13*/videoDetails/*20.25*/.getDescription()),format.raw/*20.42*/("""</p>

            <!-- Tags with Links to Search by Tag -->
        <h2>Tags</h2>
        <ul>
        """),_display_(/*25.10*/for(tag <- videoDetails.getTags()) yield /*25.44*/ {_display_(Seq[Any](format.raw/*25.46*/("""
            """),format.raw/*26.13*/("""<li><a href=""""),_display_(/*26.27*/routes/*26.33*/.TagsController.searchByTag(tag)),format.raw/*26.65*/("""">"""),_display_(/*26.68*/tag),format.raw/*26.71*/("""</a></li>
        """)))}),format.raw/*27.10*/("""
        """),format.raw/*28.9*/("""</ul>

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
                  HASH: c8e79272d2608df36520e0f6fb0c8086f4060e30
                  MATRIX: 615->1|949->30|1070->56|1100->60|1172->106|1192->118|1223->129|1427->306|1448->318|1482->331|1538->360|1559->372|1591->383|1628->393|1809->547|1830->559|1866->574|1913->593|1935->605|1975->623|2074->695|2095->707|2133->724|2269->833|2319->867|2359->869|2401->883|2442->897|2457->903|2510->935|2540->938|2564->941|2615->961|2652->971
                  LINES: 23->1|28->2|33->2|35->4|37->6|37->6|37->6|43->12|43->12|43->12|44->13|44->13|44->13|45->14|48->17|48->17|48->17|48->17|48->17|48->17|51->20|51->20|51->20|56->25|56->25|56->25|57->26|57->26|57->26|57->26|57->26|57->26|58->27|59->28
                  -- GENERATED --
              */
          