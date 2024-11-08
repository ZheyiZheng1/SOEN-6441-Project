
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

         """),format.raw/*95.10*/("""label[for="keyword"] """),format.raw/*95.31*/("""{"""),format.raw/*95.32*/("""
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
    """),format.raw/*116.5*/("""<div class="response">
        <p>
            <!-- Print the keyword here then print search results for this keyword-->
        <h3><b>Search term:</b> """),_display_(/*119.34*/keywords/*119.42*/.get(index)),format.raw/*119.53*/(""" """),_display_(/*119.55*/userReadability/*119.70*/.get(index).get(2)),format.raw/*119.88*/(""" """),format.raw/*119.89*/(""", Flesh-Kincaid Grade Level Avg.= """),_display_(/*119.124*/userReadability/*119.139*/.get(index).get(0)),format.raw/*119.157*/(""" """),format.raw/*119.158*/(""", Flesch Reading Ease Score Avg.= """),_display_(/*119.193*/userReadability/*119.208*/.get(index).get(1)),format.raw/*119.226*/(""" """),format.raw/*119.227*/(""".</h3>
        <a href=""""),_display_(/*120.19*/routes/*120.25*/.HomeController.videoStatistics(keywords.get(index))),format.raw/*120.77*/("""" style="font-weight: bold; color: green;">More stats</a>
        <br/>
            """),_display_(/*122.14*/for(response <- responseList) yield /*122.43*/ {_display_(Seq[Any](format.raw/*122.45*/("""
                """),_display_(/*123.18*/for(segment <- response) yield /*123.42*/ {_display_(Seq[Any](format.raw/*123.44*/("""
                        """),format.raw/*124.25*/("""<!-- Print All Parts of Video Information -->
                        <!-- Display thumbnail image if segment.text is "thumbnail" -->
                    """),_display_(if(segment.url != null && segment.text == "thumbnail")/*126.76*/ {_display_(Seq[Any](format.raw/*126.78*/("""
                        """),format.raw/*127.25*/("""<br/>
                        <img src=""""),_display_(/*128.36*/segment/*128.43*/.url),format.raw/*128.47*/("""" alt="Video thumbnail" />
                    """)))} else {null} ),format.raw/*129.22*/("""

                        """),format.raw/*131.25*/("""<!-- Display "Tags" as a hyperlink if segment.text is "Tags" -->
                    """),_display_(if(segment.text == "Tags"  && segment.videoId != null)/*132.76*/ {_display_(Seq[Any](format.raw/*132.78*/("""
                        """),format.raw/*133.25*/("""<a href=""""),_display_(/*133.35*/routes/*133.41*/.HomeController.showTags(segment.videoId)),format.raw/*133.82*/("""">Tags</a>
                    """)))} else {null} ),format.raw/*134.22*/("""

                        """),format.raw/*136.25*/("""<!-- Display other segments as hyperlinks if URL is present -->
                    """),_display_(if(segment.url != null && segment.text != "thumbnail" && segment.text != "Tags")/*137.102*/ {_display_(Seq[Any](format.raw/*137.104*/("""
                        """),format.raw/*138.25*/("""<a href=""""),_display_(/*138.35*/segment/*138.42*/.url),format.raw/*138.46*/("""">"""),_display_(/*138.49*/segment/*138.56*/.text),format.raw/*138.61*/("""</a>
                    """)))} else {null} ),format.raw/*139.22*/("""

                        """),format.raw/*141.25*/("""<!-- Display plain text if no URL is provided and it’s not "thumbnail" or "Tags" -->
                    """),_display_(if(segment.url == null && segment.text != "thumbnail" && segment.text != "Tags")/*142.102*/ {_display_(Seq[Any](format.raw/*142.104*/("""
                        """),_display_(/*143.26*/segment/*143.33*/.text),format.raw/*143.38*/("""
                    """)))} else {null} ),format.raw/*144.22*/("""
                """)))}),format.raw/*145.18*/("""
                """),format.raw/*146.17*/("""<br/>
            """)))}),format.raw/*147.14*/("""
        """),format.raw/*148.9*/("""</p>

    </div>
""")))}),format.raw/*151.2*/("""
"""),format.raw/*152.1*/("""</body>
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
                  HASH: bb5eb41e48c6b5619a03ee414ebe3036bdcf0193
                  MATRIX: 615->1|646->27|683->59|728->99|1206->126|1519->371|1565->366|1595->388|1624->555|1655->559|1812->688|1841->689|1883->703|2237->1030|2266->1031|2305->1043|2367->1077|2396->1078|2438->1092|2588->1215|2617->1216|2656->1228|2738->1282|2767->1283|2809->1297|3076->1537|3105->1538|3144->1550|3247->1625|3276->1626|3318->1640|3480->1775|3509->1776|3548->1788|3655->1867|3684->1868|3726->1882|4015->2144|4044->2145|4083->2157|4198->2244|4227->2245|4269->2259|4356->2319|4385->2320|4424->2332|4530->2410|4559->2411|4601->2425|4924->2721|4953->2722|4992->2734|5112->2826|5141->2827|5183->2841|5246->2877|5275->2878|5316->2891|5365->2912|5394->2913|5436->2927|5487->2951|5516->2952|5551->2960|5706->3088|5722->3094|5778->3140|5819->3142|5853->3149|5869->3155|5924->3188|5958->3194|6032->3237|6062->3239|6150->3300|6218->3351|6259->3353|6293->3359|6478->3516|6496->3524|6529->3535|6559->3537|6584->3552|6624->3570|6654->3571|6718->3606|6744->3621|6785->3639|6816->3640|6880->3675|6906->3690|6947->3708|6978->3709|7032->3735|7048->3741|7122->3793|7237->3880|7283->3909|7324->3911|7371->3930|7412->3954|7453->3956|7508->3982|7747->4193|7788->4195|7843->4221|7913->4263|7930->4270|7956->4274|8050->4323|8107->4351|8276->4492|8317->4494|8372->4520|8410->4530|8426->4536|8489->4577|8567->4610|8624->4638|8819->4804|8861->4806|8916->4832|8954->4842|8971->4849|8997->4853|9028->4856|9045->4863|9072->4868|9144->4895|9201->4923|9417->5110|9459->5112|9514->5139|9531->5146|9558->5151|9626->5174|9677->5193|9724->5211|9776->5231|9814->5241|9866->5262|9896->5264
                  LINES: 23->1|24->2|25->3|26->4|31->5|34->7|37->5|39->8|40->13|42->15|47->20|47->20|48->21|58->31|58->31|60->33|61->34|61->34|62->35|66->39|66->39|68->41|69->42|69->42|70->43|77->50|77->50|79->52|80->53|80->53|81->54|84->57|84->57|86->59|87->60|87->60|88->61|96->69|96->69|98->71|99->72|99->72|100->73|102->75|102->75|104->77|105->78|105->78|106->79|115->88|115->88|117->90|118->91|118->91|119->92|120->93|120->93|122->95|122->95|122->95|123->96|124->97|124->97|126->99|133->106|133->106|133->106|133->106|134->107|134->107|134->107|135->108|136->109|137->110|142->115|142->115|142->115|143->116|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|146->119|147->120|147->120|147->120|149->122|149->122|149->122|150->123|150->123|150->123|151->124|153->126|153->126|154->127|155->128|155->128|155->128|156->129|158->131|159->132|159->132|160->133|160->133|160->133|160->133|161->134|163->136|164->137|164->137|165->138|165->138|165->138|165->138|165->138|165->138|165->138|166->139|168->141|169->142|169->142|170->143|170->143|170->143|171->144|172->145|173->146|174->147|175->148|178->151|179->152
                  -- GENERATED --
              */
          