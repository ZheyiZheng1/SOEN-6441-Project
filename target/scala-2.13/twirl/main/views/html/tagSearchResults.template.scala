
package views.html

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

object tagSearchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,java.util.List[services.YTResponse],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(keyword: String, searchResults: java.util.List[services.YTResponse]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.71*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Search Results for """"),_display_(/*7.37*/keyword),format.raw/*7.44*/(""""</title>
        <style>
                /* General Page Styling */
                body """),format.raw/*10.22*/("""{"""),format.raw/*10.23*/("""
                    """),format.raw/*11.21*/("""font-family: Arial, sans-serif;
                    line-height: 1.6;
                    color: #333;
                    margin: 0;
                    padding: 0;
                    background-color: #f9f9f9;
                """),format.raw/*17.17*/("""}"""),format.raw/*17.18*/("""
                """),format.raw/*18.17*/("""h1 """),format.raw/*18.20*/("""{"""),format.raw/*18.21*/("""
                    """),format.raw/*19.21*/("""text-align: center;
                    margin: 20px 0;
                    color: #2c3e50;
                """),format.raw/*22.17*/("""}"""),format.raw/*22.18*/("""

                """),format.raw/*24.17*/("""/* Content Wrapper */
                div """),format.raw/*25.21*/("""{"""),format.raw/*25.22*/("""
                    """),format.raw/*26.21*/("""max-width: 800px;
                    margin: 20px auto;
                    padding: 20px;
                    background: #fff;
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                    border-radius: 8px;
                """),format.raw/*32.17*/("""}"""),format.raw/*32.18*/("""

                """),format.raw/*34.17*/("""/* List Styling */
                ul """),format.raw/*35.20*/("""{"""),format.raw/*35.21*/("""
                    """),format.raw/*36.21*/("""list-style: none;
                    padding: 0;
                """),format.raw/*38.17*/("""}"""),format.raw/*38.18*/("""
                """),format.raw/*39.17*/("""ul li """),format.raw/*39.23*/("""{"""),format.raw/*39.24*/("""
                    """),format.raw/*40.21*/("""margin-bottom: 20px;
                    padding: 15px;
                    border: 1px solid #ddd;
                    border-radius: 5px;
                    background-color: #fcfcfc;
                    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
                """),format.raw/*46.17*/("""}"""),format.raw/*46.18*/("""

                """),format.raw/*48.17*/("""/* Paragraph Styling */
                p """),format.raw/*49.19*/("""{"""),format.raw/*49.20*/("""
                    """),format.raw/*50.21*/("""margin: 10px 0;
                    font-size: 16px;
                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/("""

                """),format.raw/*54.17*/("""/* Highlighted Text */
                strong """),format.raw/*55.24*/("""{"""),format.raw/*55.25*/("""
                    """),format.raw/*56.21*/("""color: #2c3e50;
                    font-weight: bold;
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/("""

                """),format.raw/*60.17*/("""/* Hyperlink Styling */
                a """),format.raw/*61.19*/("""{"""),format.raw/*61.20*/("""
                    """),format.raw/*62.21*/("""color: #2980b9;
                    text-decoration: none;
                    font-weight: bold;
                """),format.raw/*65.17*/("""}"""),format.raw/*65.18*/("""
                """),format.raw/*66.17*/("""a:hover """),format.raw/*66.25*/("""{"""),format.raw/*66.26*/("""
                    """),format.raw/*67.21*/("""text-decoration: underline;
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/("""

                """),format.raw/*70.17*/("""/* Footer Styling */
                footer """),format.raw/*71.24*/("""{"""),format.raw/*71.25*/("""
                    """),format.raw/*72.21*/("""text-align: center;
                    margin-top: 20px;
                    font-size: 14px;
                    color: #7f8c8d;
                """),format.raw/*76.17*/("""}"""),format.raw/*76.18*/("""
        """),format.raw/*77.9*/("""</style>
    </head>
    <body>
        <h1>Search Results for """"),_display_(/*80.34*/keyword),format.raw/*80.41*/(""""</h1>
        <div>
        """),_display_(if(searchResults != null && !searchResults.isEmpty)/*82.61*/ {_display_(Seq[Any](format.raw/*82.63*/("""
            """),format.raw/*83.13*/("""<ul>
            """),_display_(/*84.14*/for(result <- searchResults) yield /*84.42*/ {_display_(Seq[Any](format.raw/*84.44*/("""
                """),format.raw/*85.17*/("""<li>
                    <p><strong>Title:</strong>
                        <a href="https://www.youtube.com/watch?v="""),_display_(/*87.67*/result/*87.73*/.getVideoId()),format.raw/*87.86*/("""" target="_blank">
                        """),_display_(/*88.26*/result/*88.32*/.getTitle()),format.raw/*88.43*/("""
                        """),format.raw/*89.25*/("""</a>
                    </p>
                    <p><strong>Channel:</strong>
                        <a href="https://www.youtube.com/channel/"""),_display_(/*92.67*/result/*92.73*/.getChannelId()),format.raw/*92.88*/("""" target="_blank">
                        """),_display_(/*93.26*/result/*93.32*/.getChannelTitle()),format.raw/*93.50*/("""
                        """),format.raw/*94.25*/("""</a>
                    </p>
                    <p><strong>Description:</strong> """),_display_(/*96.55*/result/*96.61*/.getDescription()),format.raw/*96.78*/("""</p>
                </li>
            """)))}),format.raw/*98.14*/("""
            """),format.raw/*99.13*/("""</ul>
        """)))}else/*100.16*/{_display_(Seq[Any](format.raw/*100.17*/("""
            """),format.raw/*101.13*/("""<p>No results found for """"),_display_(/*101.39*/keyword),format.raw/*101.46*/("""".</p>
        """)))}),format.raw/*102.10*/("""
        """),format.raw/*103.9*/("""</div>
        <footer>
                    &copy; 2024 YT lytics. All Rights Reserved.
        </footer>
    </body>
</html>
"""))
      }
    }
  }

  def render(keyword:String,searchResults:java.util.List[services.YTResponse]): play.twirl.api.HtmlFormat.Appendable = apply(keyword,searchResults)

  def f:((String,java.util.List[services.YTResponse]) => play.twirl.api.HtmlFormat.Appendable) = (keyword,searchResults) => apply(keyword,searchResults)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/tagSearchResults.scala.html
                  HASH: da78c47fd6e8811dc5e06e7db2dfdca72f6f0843
                  MATRIX: 954->1|1118->70|1148->74|1289->189|1316->196|1437->289|1466->290|1516->312|1779->547|1808->548|1854->566|1885->569|1914->570|1964->592|2103->703|2132->704|2180->724|2251->767|2280->768|2330->790|2612->1044|2641->1045|2689->1065|2756->1104|2785->1105|2835->1127|2931->1195|2960->1196|3006->1214|3040->1220|3069->1221|3119->1243|3418->1514|3447->1515|3495->1535|3566->1578|3595->1579|3645->1601|3744->1672|3773->1673|3821->1693|3896->1740|3925->1741|3975->1763|4076->1836|4105->1837|4153->1857|4224->1900|4253->1901|4303->1923|4448->2040|4477->2041|4523->2059|4559->2067|4588->2068|4638->2090|4711->2135|4740->2136|4788->2156|4861->2201|4890->2202|4940->2224|5119->2375|5148->2376|5185->2386|5280->2454|5308->2461|5418->2544|5458->2546|5500->2560|5546->2579|5590->2607|5630->2609|5676->2627|5823->2747|5838->2753|5872->2766|5944->2811|5959->2817|5991->2828|6045->2854|6220->3002|6235->3008|6271->3023|6343->3068|6358->3074|6397->3092|6451->3118|6564->3204|6579->3210|6617->3227|6690->3269|6732->3283|6772->3305|6812->3306|6855->3320|6909->3346|6938->3353|6987->3370|7025->3380
                  LINES: 27->1|32->1|34->3|38->7|38->7|41->10|41->10|42->11|48->17|48->17|49->18|49->18|49->18|50->19|53->22|53->22|55->24|56->25|56->25|57->26|63->32|63->32|65->34|66->35|66->35|67->36|69->38|69->38|70->39|70->39|70->39|71->40|77->46|77->46|79->48|80->49|80->49|81->50|83->52|83->52|85->54|86->55|86->55|87->56|89->58|89->58|91->60|92->61|92->61|93->62|96->65|96->65|97->66|97->66|97->66|98->67|99->68|99->68|101->70|102->71|102->71|103->72|107->76|107->76|108->77|111->80|111->80|113->82|113->82|114->83|115->84|115->84|115->84|116->85|118->87|118->87|118->87|119->88|119->88|119->88|120->89|123->92|123->92|123->92|124->93|124->93|124->93|125->94|127->96|127->96|127->96|129->98|130->99|131->100|131->100|132->101|132->101|132->101|133->102|134->103
                  -- GENERATED --
              */
          