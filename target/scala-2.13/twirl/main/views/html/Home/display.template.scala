
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

object display extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[SearchForm],MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(searchForm: Form[SearchForm])(implicit messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import helper._


Seq[Any](format.raw/*4.77*/("""

"""),format.raw/*7.1*/("""
"""),format.raw/*12.3*/("""

"""),format.raw/*14.1*/("""<html lang="en">
<head>
    <title>Welcome to YT Lytics</title>
    <style>
        /* General body styling */
        body """),format.raw/*19.14*/("""{"""),format.raw/*19.15*/("""
            """),format.raw/*20.13*/("""font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""

        """),format.raw/*31.9*/("""/* Heading styling */
        h1 """),format.raw/*32.12*/("""{"""),format.raw/*32.13*/("""
            """),format.raw/*33.13*/("""color: #007bff;
            font-size: 2.5em;
            text-align: center;
            margin-bottom: 20px;
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/("""

        """),format.raw/*39.9*/("""/* Container for the form */
        .form-container """),format.raw/*40.25*/("""{"""),format.raw/*40.26*/("""
            """),format.raw/*41.13*/("""background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/("""

        """),format.raw/*50.9*/("""/* Input text styling */
        .form-container input[type="text"] """),format.raw/*51.44*/("""{"""),format.raw/*51.45*/("""
            """),format.raw/*52.13*/("""width: 70%;
            padding: 10px;
            margin: 15px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1.1em;
            box-sizing: border-box;
            transition: border-color 0.3s;
        """),format.raw/*60.9*/("""}"""),format.raw/*60.10*/("""

        """),format.raw/*62.9*/(""".form-container input[type="text"]:focus """),format.raw/*62.50*/("""{"""),format.raw/*62.51*/("""
            """),format.raw/*63.13*/("""border-color: #007bff;
            outline: none;
        """),format.raw/*65.9*/("""}"""),format.raw/*65.10*/("""

        """),format.raw/*67.9*/("""/* Styling for submit button */
        .form-container input[type="submit"] """),format.raw/*68.46*/("""{"""),format.raw/*68.47*/("""
            """),format.raw/*69.13*/("""background-color: #007bff;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 5px;
            font-size: 1.2em;
            cursor: pointer;
            margin-top: 15px;
            transition: background-color 0.3s;
        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/("""

        """),format.raw/*80.9*/(""".form-container input[type="submit"]:hover """),format.raw/*80.52*/("""{"""),format.raw/*80.53*/("""
            """),format.raw/*81.13*/("""background-color: #0056b3;
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/("""

        """),format.raw/*84.9*/("""/* Form container spacing and styling */
        .form-container label """),format.raw/*85.31*/("""{"""),format.raw/*85.32*/("""
            """),format.raw/*86.13*/("""font-size: 1.1em;
            color: #333;
            margin-bottom: 10px;
            display: block;
        """),format.raw/*90.9*/("""}"""),format.raw/*90.10*/("""
         """),format.raw/*91.10*/("""label[for="keyword"] """),format.raw/*91.31*/("""{"""),format.raw/*91.32*/("""
            """),format.raw/*92.13*/("""display: none;
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/("""
    """),format.raw/*94.5*/("""</style>
</head>
<body>
<div class="form-container">
    <h1>Welcome to YT Lytics</h1>
    <!-- Input form for keyword-->
    """),_display_(/*100.6*/helper/*100.12*/.form(action = routes.HomeController.search())/*100.58*/ {_display_(Seq[Any](format.raw/*100.60*/("""
    """),format.raw/*101.5*/("""<div>
        <label for="keyword"></label>
        """),_display_(/*103.10*/helper/*103.16*/.inputText(searchForm("keyword"))),format.raw/*103.49*/("""
    """),format.raw/*104.5*/("""</div>
    <input type="submit" value="Submit">
    """)))}),format.raw/*106.6*/("""
"""),format.raw/*107.1*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(searchForm:Form[SearchForm],messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(searchForm)(messagesProvider)

  def f:((Form[SearchForm]) => (MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (searchForm) => (messagesProvider) => apply(searchForm)(messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/display.scala.html
                  HASH: 40d4f7815fadde61f9d7bd875ac873213b350d00
                  MATRIX: 615->1|646->27|683->59|1054->99|1202->179|1247->174|1277->196|1306->321|1337->325|1494->454|1523->455|1565->469|1878->755|1907->756|1946->768|2008->802|2037->803|2079->817|2229->940|2258->941|2297->953|2379->1007|2408->1008|2450->1022|2717->1262|2746->1263|2785->1275|2882->1344|2911->1345|2953->1359|3240->1619|3269->1620|3308->1632|3377->1673|3406->1674|3448->1688|3535->1748|3564->1749|3603->1761|3709->1839|3738->1840|3780->1854|4103->2150|4132->2151|4171->2163|4242->2206|4271->2207|4313->2221|4376->2257|4405->2258|4444->2270|4544->2342|4573->2343|4615->2357|4758->2473|4787->2474|4826->2485|4875->2506|4904->2507|4946->2521|4997->2545|5026->2546|5059->2552|5219->2685|5235->2691|5291->2737|5332->2739|5366->2745|5449->2800|5465->2806|5520->2839|5554->2845|5640->2900|5670->2902
                  LINES: 23->1|24->2|25->3|30->4|33->6|36->4|38->7|39->12|41->14|46->19|46->19|47->20|56->29|56->29|58->31|59->32|59->32|60->33|64->37|64->37|66->39|67->40|67->40|68->41|75->48|75->48|77->50|78->51|78->51|79->52|87->60|87->60|89->62|89->62|89->62|90->63|92->65|92->65|94->67|95->68|95->68|96->69|105->78|105->78|107->80|107->80|107->80|108->81|109->82|109->82|111->84|112->85|112->85|113->86|117->90|117->90|118->91|118->91|118->91|119->92|120->93|120->93|121->94|127->100|127->100|127->100|127->100|128->101|130->103|130->103|130->103|131->104|133->106|134->107
                  -- GENERATED --
              */
          