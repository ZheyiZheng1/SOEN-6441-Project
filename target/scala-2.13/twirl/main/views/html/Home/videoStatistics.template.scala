
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

object videoStatistics extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(sortedWordFrequency: Map[String, Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.42*/("""

"""),format.raw/*4.1*/("""<h1 style="text-align: center;">Word Frequency Statistics</h1>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word Frequency Table</title>
    <style>
        /* Table container styling */
        .table-container """),format.raw/*12.26*/("""{"""),format.raw/*12.27*/("""
            """),format.raw/*13.13*/("""max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/("""

        """),format.raw/*21.9*/("""/* Table styling */
        table """),format.raw/*22.15*/("""{"""),format.raw/*22.16*/("""
            """),format.raw/*23.13*/("""width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            color: #333;
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/("""

        """),format.raw/*29.9*/("""th, td """),format.raw/*29.16*/("""{"""),format.raw/*29.17*/("""
            """),format.raw/*30.13*/("""padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        """),format.raw/*33.9*/("""}"""),format.raw/*33.10*/("""

        """),format.raw/*35.9*/("""/* Header row styling */
        thead th """),format.raw/*36.18*/("""{"""),format.raw/*36.19*/("""
            """),format.raw/*37.13*/("""background-color: #4CAF50;
            color: white;
            font-weight: bold;
            text-transform: uppercase;
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/("""

        """),format.raw/*43.9*/("""/* Zebra striping for table rows */
        tbody tr:nth-child(even) """),format.raw/*44.34*/("""{"""),format.raw/*44.35*/("""
            """),format.raw/*45.13*/("""background-color: #f2f2f2;
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""

        """),format.raw/*48.9*/("""/* Hover effect on rows */
        tbody tr:hover """),format.raw/*49.24*/("""{"""),format.raw/*49.25*/("""
            """),format.raw/*50.13*/("""background-color: #d0e9c6;
            cursor: pointer;
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/("""


    """),format.raw/*55.5*/("""</style>
</head>
<body>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Word</th>
            <th>Frequency</th>
        </tr>
        </thead>
        <tbody>
        """),_display_(/*67.10*/for((word, frequency) <- sortedWordFrequency) yield /*67.55*/ {_display_(Seq[Any](format.raw/*67.57*/("""
        """),format.raw/*68.9*/("""<tr>
            <td>"""),_display_(/*69.18*/word),format.raw/*69.22*/("""</td>
            <td>"""),_display_(/*70.18*/frequency),format.raw/*70.27*/("""</td>
        </tr>
        """)))}),format.raw/*72.10*/("""
        """),format.raw/*73.9*/("""</tbody>
    </table>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(sortedWordFrequency:Map[String, Long]): play.twirl.api.HtmlFormat.Appendable = apply(sortedWordFrequency)

  def f:((Map[String, Long]) => play.twirl.api.HtmlFormat.Appendable) = (sortedWordFrequency) => apply(sortedWordFrequency)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/videoStatistics.scala.html
                  HASH: f15e5faef66f70b7a3368c58de98d41c94d5856b
                  MATRIX: 933->3|1068->43|1098->47|1379->300|1408->301|1450->315|1695->533|1724->534|1763->546|1826->581|1855->582|1897->596|2057->729|2086->730|2125->742|2160->749|2189->750|2231->764|2357->863|2386->864|2425->876|2496->919|2525->920|2567->934|2729->1069|2758->1070|2797->1082|2895->1152|2924->1153|2966->1167|3029->1203|3058->1204|3097->1216|3176->1267|3205->1268|3247->1282|3340->1348|3369->1349|3406->1359|3653->1579|3714->1624|3754->1626|3791->1636|3841->1659|3866->1663|3917->1687|3947->1696|4009->1727|4046->1737
                  LINES: 27->2|32->2|34->4|42->12|42->12|43->13|49->19|49->19|51->21|52->22|52->22|53->23|57->27|57->27|59->29|59->29|59->29|60->30|63->33|63->33|65->35|66->36|66->36|67->37|71->41|71->41|73->43|74->44|74->44|75->45|76->46|76->46|78->48|79->49|79->49|80->50|82->52|82->52|85->55|97->67|97->67|97->67|98->68|99->69|99->69|100->70|100->70|102->72|103->73
                  -- GENERATED --
              */
          