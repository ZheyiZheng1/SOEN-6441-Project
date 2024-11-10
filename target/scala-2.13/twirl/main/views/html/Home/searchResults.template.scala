
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
        <style>
                /* General body styling */
                body """),format.raw/*20.22*/("""{"""),format.raw/*20.23*/("""
                    """),format.raw/*21.21*/("""font-family: 'Arial', sans-serif;
                    background-color: #f4f4f9;
                    margin: 0;
                    padding: 0;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    flex-direction: column;
                    min-height: 100vh;
                    color: #333;
                """),format.raw/*31.17*/("""}"""),format.raw/*31.18*/("""

                """),format.raw/*33.17*/("""/* Heading styling */
                h1 """),format.raw/*34.20*/("""{"""),format.raw/*34.21*/("""
                    """),format.raw/*35.21*/("""color: #007bff;
                    font-size: 2.5em;
                    text-align: center;
                    margin-bottom: 20px;
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""

                """),format.raw/*41.17*/("""/* Form container styling */
                .form-container """),format.raw/*42.33*/("""{"""),format.raw/*42.34*/("""
                    """),format.raw/*43.21*/("""background-color: white;
                    border-radius: 8px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    padding: 30px;
                    width: 100%;
                    max-width: 500px;
                    text-align: center;
                """),format.raw/*50.17*/("""}"""),format.raw/*50.18*/("""

                """),format.raw/*52.17*/("""/* Form styling to align input and button */
                .form-container form """),format.raw/*53.38*/("""{"""),format.raw/*53.39*/("""
                    """),format.raw/*54.21*/("""display: flex;
                    flex-direction: column; /* Stack input and button vertically */
                    align-items: center;
                """),format.raw/*57.17*/("""}"""),format.raw/*57.18*/("""

                """),format.raw/*59.17*/("""/* Styling for input text field */
                .form-container input[type="text"] """),format.raw/*60.52*/("""{"""),format.raw/*60.53*/("""
                    """),format.raw/*61.21*/("""width: 80%;
                    padding: 12px;
                    margin-top: 10px;
                    border-radius: 5px;
                    border: 1px solid #ccc;
                    font-size: 1.1em;
                    box-sizing: border-box;
                    transition: border-color 0.3s;
                """),format.raw/*69.17*/("""}"""),format.raw/*69.18*/("""

                """),format.raw/*71.17*/("""/* Focus effect on the input text */
                .form-container input[type="text"]:focus """),format.raw/*72.58*/("""{"""),format.raw/*72.59*/("""
                    """),format.raw/*73.21*/("""border-color: #007bff;
                    outline: none;
                """),format.raw/*75.17*/("""}"""),format.raw/*75.18*/("""

                """),format.raw/*77.17*/("""/* Styling for submit button */
                .form-container input[type="submit"] """),format.raw/*78.54*/("""{"""),format.raw/*78.55*/("""
                    """),format.raw/*79.21*/("""background-color: #007bff;
                    color: white;
                    padding: 12px 25px;
                    border: none;
                    border-radius: 5px;
                    font-size: 1.2em;
                    cursor: pointer;
                    margin-top: 15px;
                    transition: background-color 0.3s;
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/("""

                """),format.raw/*90.17*/("""/* Hover effect on the submit button */
                .form-container input[type="submit"]:hover """),format.raw/*91.60*/("""{"""),format.raw/*91.61*/("""
                    """),format.raw/*92.21*/("""background-color: #0056b3;
                """),format.raw/*93.17*/("""}"""),format.raw/*93.18*/("""

                """),format.raw/*95.17*/("""label[for="keyword"] """),format.raw/*95.38*/("""{"""),format.raw/*95.39*/("""
                    """),format.raw/*96.21*/("""display: none;
                """),format.raw/*97.17*/("""}"""),format.raw/*97.18*/("""

        """),format.raw/*99.9*/("""</style>
    </head>
    <body>
        <h1>Welcome to YT Lytics</h1>

            <!-- Input form for keyword -->
        <div class="form-container">
        """),_display_(/*106.10*/helper/*106.16*/.form(action = routes.HomeController.search())/*106.62*/ {_display_(Seq[Any](format.raw/*106.64*/("""
            """),_display_(/*107.14*/helper/*107.20*/.inputText(searchForm("keyword"))),format.raw/*107.53*/("""
            """),format.raw/*108.13*/("""<input type="submit" value="Submit">
            """)))}),format.raw/*109.14*/("""
        """),format.raw/*110.9*/("""</div>
    </body>
</html>

    <!-- Display search results-->
"""),_display_(/*115.2*/for((responseList, index) <- userList.zipWithIndex) yield /*115.53*/ {_display_(Seq[Any](format.raw/*115.55*/("""
    """),format.raw/*116.5*/("""<div class="response">
        <p>
                <!-- Print the keyword here then print search results for this keyword-->
    <h3><b>Search term:</b> """),_display_(/*119.30*/keywords/*119.38*/.get(index)),format.raw/*119.49*/(""" """),_display_(/*119.51*/userReadability/*119.66*/.get(index).get(2)),format.raw/*119.84*/(""" """),format.raw/*119.85*/(""", Flesh-Kincaid Grade Level Avg.= """),_display_(/*119.120*/userReadability/*119.135*/.get(index).get(0)),format.raw/*119.153*/(""" """),format.raw/*119.154*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*119.189*/userReadability/*119.204*/.get(index).get(1)),format.raw/*119.222*/(""" """),format.raw/*119.223*/(""".</h3>
        <a href=""""),_display_(/*120.19*/routes/*120.25*/.HomeController.videoStatistics(keywords.get(index))),format.raw/*120.77*/("""" style="font-weight: bold; color: green;">More stats</a>
        <br/>
            """),_display_(/*122.14*/for(response <- responseList) yield /*122.43*/ {_display_(Seq[Any](format.raw/*122.45*/("""
                """),_display_(/*123.18*/for(segment <- response) yield /*123.42*/ {_display_(Seq[Any](format.raw/*123.44*/("""
                        """),format.raw/*124.25*/("""<!-- Print All Parts of Video Information -->
                        <!-- Display thumbnail image if segment.text is "thumbnail" -->
                    """),_display_(if(segment.url != null && segment.text == "thumbnail")/*126.76*/ {_display_(Seq[Any](format.raw/*126.78*/("""
                        """),format.raw/*127.25*/("""<br/>
                        <img src=""""),_display_(/*128.36*/segment/*128.43*/.url),format.raw/*128.47*/("""" alt="Video thumbnail" />
                    """)))} else {null} ),format.raw/*129.22*/("""   """),format.raw/*129.25*/("""<!-- Sakshi Mulik - 40295793 -->
                    """),_display_(if(segment.url != null && segment.url.contains("channel"))/*130.80*/ {_display_(Seq[Any](format.raw/*130.82*/("""
                        """),format.raw/*131.25*/("""<a href=""""),_display_(/*131.35*/routes/*131.41*/.HomeController.showChannelProfile(segment.url)),format.raw/*131.88*/("""">"""),_display_(/*131.91*/segment/*131.98*/.text),format.raw/*131.103*/("""</a>
                    """)))} else {null} ),format.raw/*132.22*/("""

                        """),format.raw/*134.25*/("""<!-- Display "Tags" as a hyperlink if segment.text is "Tags" -->
                    """),_display_(if(segment.text == "Tags"  && segment.videoId != null)/*135.76*/ {_display_(Seq[Any](format.raw/*135.78*/("""
                        """),format.raw/*136.25*/("""<a href=""""),_display_(/*136.35*/routes/*136.41*/.HomeController.showTags(segment.videoId)),format.raw/*136.82*/("""">Tags</a>
                    """)))} else {null} ),format.raw/*137.22*/("""

                        """),format.raw/*139.25*/("""<!-- Display other segments as hyperlinks if URL is present -->  <!-- Sakshi Mulik - 40295793 -->
                    """),_display_(if(segment.url != null && segment.text != "thumbnail" && segment.text != "Tags" && !(segment.url.contains("channel")))/*140.140*/ {_display_(Seq[Any](format.raw/*140.142*/("""
                        """),format.raw/*141.25*/("""<a href=""""),_display_(/*141.35*/segment/*141.42*/.url),format.raw/*141.46*/("""">"""),_display_(/*141.49*/segment/*141.56*/.text),format.raw/*141.61*/("""</a>
                    """)))} else {null} ),format.raw/*142.22*/("""

                        """),format.raw/*144.25*/("""<!-- Display plain text if no URL is provided and it’s not "thumbnail" or "Tags" -->
                    """),_display_(if(segment.url == null && segment.text != "thumbnail" && segment.text != "Tags")/*145.102*/ {_display_(Seq[Any](format.raw/*145.104*/("""
                        """),_display_(/*146.26*/segment/*146.33*/.text),format.raw/*146.38*/("""
                    """)))} else {null} ),format.raw/*147.22*/("""
                """)))}),format.raw/*148.18*/("""
                """),format.raw/*149.17*/("""<br/>
            """)))}),format.raw/*150.14*/("""
        """),format.raw/*151.9*/("""</p>

    </div>
""")))}),format.raw/*154.2*/("""
    """),format.raw/*155.5*/("""</body>
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
                  HASH: ad9fa81bf5aafbfdd58fef156bbebb7ee8280348
                  MATRIX: 615->1|646->27|683->59|728->99|1206->126|1519->371|1565->366|1595->388|1624->555|1655->559|1840->716|1869->717|1919->739|2354->1146|2383->1147|2431->1167|2501->1209|2530->1210|2580->1232|2763->1387|2792->1388|2840->1408|2930->1470|2959->1471|3009->1493|3333->1789|3362->1790|3410->1810|3521->1893|3550->1894|3600->1916|3787->2075|3816->2076|3864->2096|3979->2183|4008->2184|4058->2206|4412->2532|4441->2533|4489->2553|4612->2648|4641->2649|4691->2671|4795->2747|4824->2748|4872->2768|4986->2854|5015->2855|5065->2877|5461->3245|5490->3246|5538->3266|5666->3366|5695->3367|5745->3389|5817->3433|5846->3434|5894->3454|5943->3475|5972->3476|6022->3498|6082->3530|6111->3531|6150->3543|6346->3711|6362->3717|6418->3763|6459->3765|6502->3780|6518->3786|6573->3819|6616->3833|6699->3884|6737->3894|6833->3963|6901->4014|6942->4016|6976->4022|7161->4179|7179->4187|7212->4198|7242->4200|7267->4215|7307->4233|7337->4234|7401->4269|7427->4284|7468->4302|7499->4303|7563->4338|7589->4353|7630->4371|7661->4372|7715->4398|7731->4404|7805->4456|7920->4543|7966->4572|8007->4574|8054->4593|8095->4617|8136->4619|8191->4645|8430->4856|8471->4858|8526->4884|8596->4926|8613->4933|8639->4937|8733->4986|8765->4989|8906->5102|8947->5104|9002->5130|9040->5140|9056->5146|9125->5193|9156->5196|9173->5203|9201->5208|9273->5235|9330->5263|9499->5404|9540->5406|9595->5432|9633->5442|9649->5448|9712->5489|9790->5522|9847->5550|10114->5788|10156->5790|10211->5816|10249->5826|10266->5833|10292->5837|10323->5840|10340->5847|10367->5852|10439->5879|10496->5907|10712->6094|10754->6096|10809->6123|10826->6130|10853->6135|10921->6158|10972->6177|11019->6195|11071->6215|11109->6225|11161->6246|11195->6252
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|47->20|47->20|48->21|58->31|58->31|60->33|61->34|61->34|62->35|66->39|66->39|68->41|69->42|69->42|70->43|77->50|77->50|79->52|80->53|80->53|81->54|84->57|84->57|86->59|87->60|87->60|88->61|96->69|96->69|98->71|99->72|99->72|100->73|102->75|102->75|104->77|105->78|105->78|106->79|115->88|115->88|117->90|118->91|118->91|119->92|120->93|120->93|122->95|122->95|122->95|123->96|124->97|124->97|126->99|133->106|133->106|133->106|133->106|134->107|134->107|134->107|135->108|136->109|137->110|142->115|142->115|142->115|143->116|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|147->120|147->120|147->120|149->122|149->122|149->122|150->123|150->123|150->123|151->124|153->126|153->126|154->127|155->128|155->128|155->128|156->129|156->129|157->130|157->130|158->131|158->131|158->131|158->131|158->131|158->131|158->131|159->132|161->134|162->135|162->135|163->136|163->136|163->136|163->136|164->137|166->139|167->140|167->140|168->141|168->141|168->141|168->141|168->141|168->141|168->141|169->142|171->144|172->145|172->145|173->146|173->146|173->146|174->147|175->148|176->149|177->150|178->151|181->154|182->155
                  -- GENERATED --
              */
          