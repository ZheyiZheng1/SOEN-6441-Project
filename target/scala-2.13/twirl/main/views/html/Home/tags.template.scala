
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
                  HASH: fb8c157d8efcd738193ede9700c8a7de442f5085
                  MATRIX: 615->1|949->30|1070->56|1100->170|1131->174|1204->220|1225->232|1257->243|1371->329|1400->330|1450->352|1832->706|1861->707|1907->725|1945->735|1974->736|2024->758|2147->853|2176->854|2224->874|2296->918|2325->919|2375->941|2694->1232|2723->1233|2771->1253|2842->1296|2871->1297|2921->1319|3112->1482|3141->1483|3189->1503|3267->1553|3296->1554|3346->1576|3587->1789|3616->1790|3664->1810|3748->1866|3777->1867|3827->1889|4017->2051|4046->2052|4092->2070|4142->2092|4171->2093|4221->2115|4331->2197|4360->2198|4408->2218|4481->2263|4510->2264|4560->2286|4695->2393|4724->2394|4770->2412|4809->2423|4838->2424|4888->2446|5033->2563|5062->2564|5108->2582|5153->2599|5182->2600|5232->2622|5342->2704|5371->2705|5419->2725|5495->2773|5524->2774|5574->2796|5786->2980|5815->2981|5863->3001|5930->3040|5959->3041|6009->3063|6145->3170|6175->3171|6222->3189|6260->3198|6290->3199|6341->3221|6669->3520|6699->3521|6746->3539|6784->3548|6814->3549|6865->3571|7114->3791|7144->3792|7191->3810|7229->3819|7259->3820|7310->3842|7493->3996|7523->3997|7570->4015|7607->4023|7637->4024|7688->4046|7917->4246|7947->4247|7994->4265|8037->4279|8067->4280|8118->4302|8180->4335|8210->4336|8250->4348|8537->4607|8559->4619|8594->4632|8655->4665|8677->4677|8710->4688|8753->4702|8959->4880|8981->4892|9019->4907|9067->4926|9090->4938|9131->4956|9259->5056|9281->5068|9320->5085|9517->5254|9568->5288|9609->5290|9660->5312|9702->5326|9718->5332|9772->5364|9803->5367|9828->5370|9888->5398|9935->5416
                  LINES: 23->1|28->2|33->2|35->8|37->10|39->12|39->12|39->12|42->15|42->15|43->16|52->25|52->25|53->26|53->26|53->26|54->27|57->30|57->30|59->32|60->33|60->33|61->34|68->41|68->41|70->43|71->44|71->44|72->45|76->49|76->49|78->51|79->52|79->52|80->53|85->58|85->58|87->60|88->61|88->61|89->62|93->66|93->66|94->67|94->67|94->67|95->68|97->70|97->70|99->72|100->73|100->73|101->74|104->77|104->77|105->78|105->78|105->78|106->79|109->82|109->82|110->83|110->83|110->83|111->84|113->86|113->86|115->88|116->89|116->89|117->90|122->95|122->95|124->97|125->98|125->98|126->99|129->102|129->102|130->103|130->103|130->103|131->104|138->111|138->111|139->112|139->112|139->112|140->113|146->119|146->119|147->120|147->120|147->120|148->121|152->125|152->125|153->126|153->126|153->126|154->127|159->132|159->132|160->133|160->133|160->133|161->134|162->135|162->135|164->137|172->145|172->145|172->145|173->146|173->146|173->146|174->147|177->150|177->150|177->150|177->150|177->150|177->150|180->153|180->153|180->153|186->159|186->159|186->159|187->160|187->160|187->160|187->160|187->160|187->160|188->161|189->162
                  -- GENERATED --
              */
          