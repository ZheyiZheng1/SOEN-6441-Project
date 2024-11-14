
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
        body """),format.raw/*20.14*/("""{"""),format.raw/*20.15*/("""
            """),format.raw/*21.13*/("""font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            color: #333;
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/("""

        """),format.raw/*33.9*/("""/* Heading styling */
        h1 """),format.raw/*34.12*/("""{"""),format.raw/*34.13*/("""
            """),format.raw/*35.13*/("""color: #007bff;
            font-size: 2.5em;
            text-align: center;
            margin-bottom: 20px;
        """),format.raw/*39.9*/("""}"""),format.raw/*39.10*/("""

        """),format.raw/*41.9*/("""/* Form container styling */
        .form-container """),format.raw/*42.25*/("""{"""),format.raw/*42.26*/("""
            """),format.raw/*43.13*/("""background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 500px;
            text-align: center;
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/("""

        """),format.raw/*52.9*/("""/* Form styling to align input and button */
        .form-container form """),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""
            """),format.raw/*54.13*/("""display: flex;
            flex-direction: column; /* Stack input and button vertically */
            align-items: center;
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/("""

        """),format.raw/*59.9*/("""/* Styling for input text field */
        .form-container input[type="text"] """),format.raw/*60.44*/("""{"""),format.raw/*60.45*/("""
            """),format.raw/*61.13*/("""width: 80%;
            padding: 12px;
            margin-top: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1.1em;
            box-sizing: border-box;
            transition: border-color 0.3s;
        """),format.raw/*69.9*/("""}"""),format.raw/*69.10*/("""

        """),format.raw/*71.9*/("""/* Focus effect on the input text */
        .form-container input[type="text"]:focus """),format.raw/*72.50*/("""{"""),format.raw/*72.51*/("""
            """),format.raw/*73.13*/("""border-color: #007bff;
            outline: none;
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""

        """),format.raw/*77.9*/("""/* Styling for submit button */
        .form-container input[type="submit"] """),format.raw/*78.46*/("""{"""),format.raw/*78.47*/("""
            """),format.raw/*79.13*/("""background-color: #007bff;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 5px;
            font-size: 1.2em;
            cursor: pointer;
            margin-top: 15px;
            transition: background-color 0.3s;
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/("""

        """),format.raw/*90.9*/("""/* Hover effect on the submit button */
        .form-container input[type="submit"]:hover """),format.raw/*91.52*/("""{"""),format.raw/*91.53*/("""
            """),format.raw/*92.13*/("""background-color: #0056b3;
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/("""

        """),format.raw/*95.9*/("""label[for="keyword"] """),format.raw/*95.30*/("""{"""),format.raw/*95.31*/("""
            """),format.raw/*96.13*/("""display: none;
        """),format.raw/*97.9*/("""}"""),format.raw/*97.10*/("""

    """),format.raw/*99.5*/("""</style>
</head>
<body>
<h1>Welcome to YT Lytics</h1>

<!-- Input form for keyword -->
<div class="form-container">
    """),_display_(/*106.6*/helper/*106.12*/.form(action = routes.HomeController.search())/*106.58*/ {_display_(Seq[Any](format.raw/*106.60*/("""
    """),_display_(/*107.6*/helper/*107.12*/.inputText(searchForm("keyword"))),format.raw/*107.45*/("""
    """),format.raw/*108.5*/("""<input type="submit" value="Submit">
    """)))}),format.raw/*109.6*/("""
"""),format.raw/*110.1*/("""</div>
</body>
</html>

<!-- Display search results-->
"""),_display_(/*115.2*/for((responseList, index) <- userList.zipWithIndex) yield /*115.53*/ {_display_(Seq[Any](format.raw/*115.55*/("""
"""),format.raw/*116.1*/("""<div class="response">
    <p>
        <!-- Print the keyword here then print search results for this keyword-->
    <h3><b>Search term:</b> """),_display_(/*119.30*/keywords/*119.38*/.get(index)),format.raw/*119.49*/(""" """),_display_(/*119.51*/userReadability/*119.66*/.get(index).get(2)),format.raw/*119.84*/(""" """),format.raw/*119.85*/(""", Flesh-Kincaid Grade Level Avg.= """),_display_(/*119.120*/userReadability/*119.135*/.get(index).get(0)),format.raw/*119.153*/(""" """),format.raw/*119.154*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*119.189*/userReadability/*119.204*/.get(index).get(1)),format.raw/*119.222*/(""" """),format.raw/*119.223*/(""".</h3>
    <a href=""""),_display_(/*120.15*/routes/*120.21*/.HomeController.videoStatistics(keywords.get(index))),format.raw/*120.73*/("""" style="font-weight: bold; color: green;">More stats</a>
    <br/>
    """),_display_(/*122.6*/for(response <- responseList) yield /*122.35*/ {_display_(Seq[Any](format.raw/*122.37*/("""
    """),_display_(/*123.6*/for(segment <- response) yield /*123.30*/ {_display_(Seq[Any](format.raw/*123.32*/("""
    """),format.raw/*124.5*/("""<!-- Print All Parts of Video Information -->
    <!-- Display thumbnail image if segment.text is "thumbnail" -->
    """),_display_(if(segment.url != null && segment.text == "thumbnail")/*126.60*/ {_display_(Seq[Any](format.raw/*126.62*/("""
    """),format.raw/*127.5*/("""<br/>
    <img src=""""),_display_(/*128.16*/segment/*128.23*/.url),format.raw/*128.27*/("""" alt="Video thumbnail" />
    """)))} else {null} ),format.raw/*129.6*/("""   """),format.raw/*129.9*/("""<!-- Sakshi Mulik - 40295793 -->
    """),_display_(if(segment.url != null && segment.url.contains("channel"))/*130.64*/ {_display_(Seq[Any](format.raw/*130.66*/("""
    """),format.raw/*131.5*/("""<a href=""""),_display_(/*131.15*/routes/*131.21*/.HomeController.showChannelProfile(segment.url)),format.raw/*131.68*/("""">"""),_display_(/*131.71*/segment/*131.78*/.text),format.raw/*131.83*/("""</a>
    """)))} else {null} ),format.raw/*132.6*/("""

    """),format.raw/*134.5*/("""<!-- Display "Tags" as a hyperlink if segment.text is "Tags" -->
    """),_display_(if(segment.text == "Tags"  && segment.videoId != null)/*135.60*/ {_display_(Seq[Any](format.raw/*135.62*/("""
    """),format.raw/*136.5*/("""<a href=""""),_display_(/*136.15*/routes/*136.21*/.HomeController.showTags(segment.videoId)),format.raw/*136.62*/("""">Tags</a>
    """)))} else {null} ),format.raw/*137.6*/("""

    """),format.raw/*139.5*/("""<!-- Display other segments as hyperlinks if URL is present -->  <!-- Sakshi Mulik - 40295793 -->
    """),_display_(if(segment.url != null && segment.text != "thumbnail" && segment.text != "Tags" && !(segment.url.contains("channel")))/*140.124*/ {_display_(Seq[Any](format.raw/*140.126*/("""
    """),format.raw/*141.5*/("""<a href=""""),_display_(/*141.15*/segment/*141.22*/.url),format.raw/*141.26*/("""">"""),_display_(/*141.29*/segment/*141.36*/.text),format.raw/*141.41*/("""</a>
    """)))} else {null} ),format.raw/*142.6*/("""

    """),format.raw/*144.5*/("""<!-- Display plain text if no URL is provided and it’s not "thumbnail" or "Tags" -->
    """),_display_(if(segment.url == null && segment.text != "thumbnail" && segment.text != "Tags")/*145.86*/ {_display_(Seq[Any](format.raw/*145.88*/("""
    """),_display_(/*146.6*/segment/*146.13*/.text),format.raw/*146.18*/("""
    """)))} else {null} ),format.raw/*147.6*/("""
    """)))}),format.raw/*148.6*/("""
    """),format.raw/*149.5*/("""<br/>
    """)))}),format.raw/*150.6*/("""
    """),format.raw/*151.5*/("""</p>

</div>
""")))}),format.raw/*154.2*/("""
"""),format.raw/*155.1*/("""</body>
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
                  HASH: 1c4edf6b59e5ce5231f9a4bb55f926a1be5d8824
                  MATRIX: 615->1|646->27|683->59|728->99|1206->126|1519->371|1565->366|1595->388|1624->555|1655->559|1812->688|1841->689|1883->703|2237->1030|2266->1031|2305->1043|2367->1077|2396->1078|2438->1092|2588->1215|2617->1216|2656->1228|2738->1282|2767->1283|2809->1297|3076->1537|3105->1538|3144->1550|3247->1625|3276->1626|3318->1640|3480->1775|3509->1776|3548->1788|3655->1867|3684->1868|3726->1882|4015->2144|4044->2145|4083->2157|4198->2244|4227->2245|4269->2259|4356->2319|4385->2320|4424->2332|4530->2410|4559->2411|4601->2425|4924->2721|4953->2722|4992->2734|5112->2826|5141->2827|5183->2841|5246->2877|5275->2878|5314->2890|5363->2911|5392->2912|5434->2926|5485->2950|5514->2951|5549->2959|5704->3087|5720->3093|5776->3139|5817->3141|5851->3148|5867->3154|5922->3187|5956->3193|6030->3236|6060->3238|6148->3299|6216->3350|6257->3352|6287->3354|6460->3499|6478->3507|6511->3518|6541->3520|6566->3535|6606->3553|6636->3554|6700->3589|6726->3604|6767->3622|6798->3623|6862->3658|6888->3673|6929->3691|6960->3692|7010->3714|7026->3720|7100->3772|7202->3847|7248->3876|7289->3878|7323->3885|7364->3909|7405->3911|7439->3917|7642->4092|7683->4094|7717->4100|7767->4122|7784->4129|7810->4133|7887->4166|7918->4169|8043->4266|8084->4268|8118->4274|8156->4284|8172->4290|8241->4337|8272->4340|8289->4347|8316->4352|8371->4363|8407->4371|8560->4496|8601->4498|8635->4504|8673->4514|8689->4520|8752->4561|8813->4578|8849->4586|9100->4808|9142->4810|9176->4816|9214->4826|9231->4833|9257->4837|9288->4840|9305->4847|9332->4852|9387->4863|9423->4871|9622->5042|9663->5044|9697->5051|9714->5058|9741->5063|9792->5070|9830->5077|9864->5083|9907->5095|9941->5101|9989->5118|10019->5120
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|47->20|47->20|48->21|58->31|58->31|60->33|61->34|61->34|62->35|66->39|66->39|68->41|69->42|69->42|70->43|77->50|77->50|79->52|80->53|80->53|81->54|84->57|84->57|86->59|87->60|87->60|88->61|96->69|96->69|98->71|99->72|99->72|100->73|102->75|102->75|104->77|105->78|105->78|106->79|115->88|115->88|117->90|118->91|118->91|119->92|120->93|120->93|122->95|122->95|122->95|123->96|124->97|124->97|126->99|133->106|133->106|133->106|133->106|134->107|134->107|134->107|135->108|136->109|137->110|142->115|142->115|142->115|143->116|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|147->120|147->120|147->120|149->122|149->122|149->122|150->123|150->123|150->123|151->124|153->126|153->126|154->127|155->128|155->128|155->128|156->129|156->129|157->130|157->130|158->131|158->131|158->131|158->131|158->131|158->131|158->131|159->132|161->134|162->135|162->135|163->136|163->136|163->136|163->136|164->137|166->139|167->140|167->140|168->141|168->141|168->141|168->141|168->141|168->141|168->141|169->142|171->144|172->145|172->145|173->146|173->146|173->146|174->147|175->148|176->149|177->150|178->151|181->154|182->155
                  -- GENERATED --
              */
          