
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

"""),format.raw/*8.3*/("""

"""),format.raw/*10.1*/("""<html lang="en">
    <head>
        <title>"""),_display_(/*12.17*/videoDetails/*12.29*/.getTitle()),format.raw/*12.40*/("""</title>
        <style>
                /* General Styles */
                body """),format.raw/*15.22*/("""{"""),format.raw/*15.23*/("""
                    """),format.raw/*16.21*/("""font-family: Arial, sans-serif;
                    color: #333;
                    margin: 0;
                    padding: 0;
                    background: #f4f6f9;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    min-height: 100vh;
                """),format.raw/*25.17*/("""}"""),format.raw/*25.18*/("""
                """),format.raw/*26.17*/("""h1, h2, p """),format.raw/*26.27*/("""{"""),format.raw/*26.28*/("""
                    """),format.raw/*27.21*/("""color: #444;
                    margin: 0;
                    padding: 0;
                """),format.raw/*30.17*/("""}"""),format.raw/*30.18*/("""

                """),format.raw/*32.17*/("""/* Container */
                .container """),format.raw/*33.28*/("""{"""),format.raw/*33.29*/("""
                    """),format.raw/*34.21*/("""background: #fff;
                    border-radius: 8px;
                    box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
                    padding: 30px;
                    max-width: 800px;
                    width: 90%;
                    text-align: center;
                """),format.raw/*41.17*/("""}"""),format.raw/*41.18*/("""

                """),format.raw/*43.17*/("""/* Title */
                .container h1 """),format.raw/*44.31*/("""{"""),format.raw/*44.32*/("""
                    """),format.raw/*45.21*/("""font-size: 2.2rem;
                    margin-bottom: 20px;
                    color: #0056b3;
                    text-transform: uppercase;
                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/("""

                """),format.raw/*51.17*/("""/* Thumbnail Image */
                .thumbnail """),format.raw/*52.28*/("""{"""),format.raw/*52.29*/("""
                    """),format.raw/*53.21*/("""width: 100%;
                    max-width: 400px;
                    border-radius: 8px;
                    margin: 20px 0;
                    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.15);
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/("""

                """),format.raw/*60.17*/("""/* Video Title Link */
                .container h2 a """),format.raw/*61.33*/("""{"""),format.raw/*61.34*/("""
                    """),format.raw/*62.21*/("""color: #0073e6;
                    font-size: 1.6rem;
                    text-decoration: none;
                    transition: color 0.3s;
                """),format.raw/*66.17*/("""}"""),format.raw/*66.18*/("""
                """),format.raw/*67.17*/(""".container h2 a:hover """),format.raw/*67.39*/("""{"""),format.raw/*67.40*/("""
                    """),format.raw/*68.21*/("""color: #005bb5;
                    text-decoration: underline;
                """),format.raw/*70.17*/("""}"""),format.raw/*70.18*/("""

                """),format.raw/*72.17*/("""/* Channel Link */
                .channel """),format.raw/*73.26*/("""{"""),format.raw/*73.27*/("""
                    """),format.raw/*74.21*/("""font-size: 1rem;
                    color: #777;
                    margin-top: 10px;
                """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/("""
                """),format.raw/*78.17*/(""".channel a """),format.raw/*78.28*/("""{"""),format.raw/*78.29*/("""
                    """),format.raw/*79.21*/("""color: #0073e6;
                    text-decoration: none;
                    font-weight: bold;
                """),format.raw/*82.17*/("""}"""),format.raw/*82.18*/("""
                """),format.raw/*83.17*/(""".channel a:hover """),format.raw/*83.34*/("""{"""),format.raw/*83.35*/("""
                    """),format.raw/*84.21*/("""color: #005bb5;
                    text-decoration: underline;
                """),format.raw/*86.17*/("""}"""),format.raw/*86.18*/("""

                """),format.raw/*88.17*/("""/* Description */
                .description """),format.raw/*89.30*/("""{"""),format.raw/*89.31*/("""
                    """),format.raw/*90.21*/("""font-size: 1.1rem;
                    line-height: 1.6;
                    margin: 20px 0;
                    color: #555;
                    padding: 0 20px;
                """),format.raw/*95.17*/("""}"""),format.raw/*95.18*/("""

                """),format.raw/*97.17*/("""/* Tags List */
                .tags """),format.raw/*98.23*/("""{"""),format.raw/*98.24*/("""
                    """),format.raw/*99.21*/("""text-align: left;
                    padding: 0;
                    margin-top: 20px;
                """),format.raw/*102.17*/("""}"""),format.raw/*102.18*/("""
                """),format.raw/*103.17*/(""".tags h2 """),format.raw/*103.26*/("""{"""),format.raw/*103.27*/("""
                    """),format.raw/*104.21*/("""font-size: 1.4rem;
                    color: #333;
                    border-bottom: 2px solid #0056b3;
                    padding-bottom: 10px;
                    text-transform: uppercase;
                    text-align: center;
                    margin-bottom: 15px;
                """),format.raw/*111.17*/("""}"""),format.raw/*111.18*/("""
                """),format.raw/*112.17*/(""".tags ul """),format.raw/*112.26*/("""{"""),format.raw/*112.27*/("""
                    """),format.raw/*113.21*/("""list-style: none;
                    padding: 0;
                    margin: 0;
                    display: flex;
                    flex-wrap: wrap;
                    justify-content: center;
                """),format.raw/*119.17*/("""}"""),format.raw/*119.18*/("""
                """),format.raw/*120.17*/(""".tags li """),format.raw/*120.26*/("""{"""),format.raw/*120.27*/("""
                    """),format.raw/*121.21*/("""background: #e1e7f2;
                    border-radius: 20px;
                    padding: 8px 15px;
                    margin: 5px;
                """),format.raw/*125.17*/("""}"""),format.raw/*125.18*/("""
                """),format.raw/*126.17*/(""".tags a """),format.raw/*126.25*/("""{"""),format.raw/*126.26*/("""
                    """),format.raw/*127.21*/("""color: #0056b3;
                    font-size: 1rem;
                    text-decoration: none;
                    font-weight: bold;
                    transition: color 0.3s;
                """),format.raw/*132.17*/("""}"""),format.raw/*132.18*/("""
                """),format.raw/*133.17*/(""".tags a:hover """),format.raw/*133.31*/("""{"""),format.raw/*133.32*/("""
                    """),format.raw/*134.21*/("""color: #004099;
                """),format.raw/*135.17*/("""}"""),format.raw/*135.18*/("""

        """),format.raw/*137.9*/("""</style>
    </head>
    <body>
        <div class="container">
                <!-- Page Title -->
            <h1>Video Details / Tags Page</h1>

                <!-- Video Title as link -->
            <h2><a href="https://www.youtube.com/watch?v="""),_display_(/*145.59*/videoDetails/*145.71*/.getVideoId()),format.raw/*145.84*/("""" target="_blank">
            """),_display_(/*146.14*/videoDetails/*146.26*/.getTitle()),format.raw/*146.37*/("""
            """),format.raw/*147.13*/("""</a></h2>

                <!-- Display channel title as a hyperlink to the channel page -->
            <p class="channel">Channel: <a href="https://www.youtube.com/channel/"""),_display_(/*150.83*/videoDetails/*150.95*/.getChannelId()),format.raw/*150.110*/("""" target="_blank">"""),_display_(/*150.129*/videoDetails/*150.141*/.getChannelTitle()),format.raw/*150.159*/("""</a></p>

                <!-- Display video description -->
            <p class="description">"""),_display_(/*153.37*/videoDetails/*153.49*/.getDescription()),format.raw/*153.66*/("""</p>

                <!-- Tags with Links to Search by Tag -->
            <div class="tags">
                <h2>Tags</h2>
                <ul>
                """),_display_(/*159.18*/for(tag <- videoDetails.getTags()) yield /*159.52*/ {_display_(Seq[Any](format.raw/*159.54*/("""
                    """),format.raw/*160.21*/("""<li><a href=""""),_display_(/*160.35*/routes/*160.41*/.HomeController.searchByTag(tag)),format.raw/*160.73*/("""">"""),_display_(/*160.76*/tag),format.raw/*160.79*/("""</a></li>
                """)))}),format.raw/*161.18*/("""
                """),format.raw/*162.17*/("""</ul>
            </div>
        </div>
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
                  HASH: 71ac845185c3342fde0a43ff7195355580445a2b
                  MATRIX: 615->1|949->30|1070->56|1100->190|1131->194|1204->240|1225->252|1257->263|1371->349|1400->350|1450->372|1832->726|1861->727|1907->745|1945->755|1974->756|2024->778|2147->873|2176->874|2224->894|2296->938|2325->939|2375->961|2694->1252|2723->1253|2771->1273|2842->1316|2871->1317|2921->1339|3112->1502|3141->1503|3189->1523|3267->1573|3296->1574|3346->1596|3587->1809|3616->1810|3664->1830|3748->1886|3777->1887|3827->1909|4017->2071|4046->2072|4092->2090|4142->2112|4171->2113|4221->2135|4331->2217|4360->2218|4408->2238|4481->2283|4510->2284|4560->2306|4695->2413|4724->2414|4770->2432|4809->2443|4838->2444|4888->2466|5033->2583|5062->2584|5108->2602|5153->2619|5182->2620|5232->2642|5342->2724|5371->2725|5419->2745|5495->2793|5524->2794|5574->2816|5786->3000|5815->3001|5863->3021|5930->3060|5959->3061|6009->3083|6145->3190|6175->3191|6222->3209|6260->3218|6290->3219|6341->3241|6669->3540|6699->3541|6746->3559|6784->3568|6814->3569|6865->3591|7114->3811|7144->3812|7191->3830|7229->3839|7259->3840|7310->3862|7493->4016|7523->4017|7570->4035|7607->4043|7637->4044|7688->4066|7917->4266|7947->4267|7994->4285|8037->4299|8067->4300|8118->4322|8180->4355|8210->4356|8250->4368|8537->4627|8559->4639|8594->4652|8655->4685|8677->4697|8710->4708|8753->4722|8959->4900|8981->4912|9019->4927|9067->4946|9090->4958|9131->4976|9259->5076|9281->5088|9320->5105|9517->5274|9568->5308|9609->5310|9660->5332|9702->5346|9718->5352|9772->5384|9803->5387|9828->5390|9888->5418|9935->5436
                  LINES: 23->1|28->2|33->2|35->8|37->10|39->12|39->12|39->12|42->15|42->15|43->16|52->25|52->25|53->26|53->26|53->26|54->27|57->30|57->30|59->32|60->33|60->33|61->34|68->41|68->41|70->43|71->44|71->44|72->45|76->49|76->49|78->51|79->52|79->52|80->53|85->58|85->58|87->60|88->61|88->61|89->62|93->66|93->66|94->67|94->67|94->67|95->68|97->70|97->70|99->72|100->73|100->73|101->74|104->77|104->77|105->78|105->78|105->78|106->79|109->82|109->82|110->83|110->83|110->83|111->84|113->86|113->86|115->88|116->89|116->89|117->90|122->95|122->95|124->97|125->98|125->98|126->99|129->102|129->102|130->103|130->103|130->103|131->104|138->111|138->111|139->112|139->112|139->112|140->113|146->119|146->119|147->120|147->120|147->120|148->121|152->125|152->125|153->126|153->126|153->126|154->127|159->132|159->132|160->133|160->133|160->133|161->134|162->135|162->135|164->137|172->145|172->145|172->145|173->146|173->146|173->146|174->147|177->150|177->150|177->150|177->150|177->150|177->150|180->153|180->153|180->153|186->159|186->159|186->159|187->160|187->160|187->160|187->160|187->160|187->160|188->161|189->162
                  -- GENERATED --
              */
          