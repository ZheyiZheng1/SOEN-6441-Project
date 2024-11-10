
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

  /*
* @author - Praneet Avhad
* ID - 40279347
* @param sortedWordFrequency Map[String, Long]
* This parameter is a Map containing words as keys (Strings) and their corresponding frequency as values (Long).
* The Map is expected to be sorted by word frequency, where each entry represents a unique word and the number of occurrences in a dataset.
* The HTML template iterates over the Map and dynamically generates a table where:
* - The first column displays the word.
* - The second column displays the frequency of the word.
*
* Example structure:
* sortedWordFrequency = {
*     "hello" -> 5,
*     "world" -> 3,
*      "java" -> 2
* }
*/
  def apply/*19.2*/(sortedWordFrequency: Map[String, Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*19.42*/("""

"""),format.raw/*21.1*/("""<h1 style="text-align: center;">Word Frequency Statistics</h1>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word Frequency Table</title>
    <style>
        /* Table container styling */
        .table-container """),format.raw/*29.26*/("""{"""),format.raw/*29.27*/("""
            """),format.raw/*30.13*/("""max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/("""

        """),format.raw/*38.9*/("""/* Table styling */
        table """),format.raw/*39.15*/("""{"""),format.raw/*39.16*/("""
            """),format.raw/*40.13*/("""width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            color: #333;
        """),format.raw/*44.9*/("""}"""),format.raw/*44.10*/("""

        """),format.raw/*46.9*/("""th, td """),format.raw/*46.16*/("""{"""),format.raw/*46.17*/("""
            """),format.raw/*47.13*/("""padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/("""

        """),format.raw/*52.9*/("""/* Header row styling */
        thead th """),format.raw/*53.18*/("""{"""),format.raw/*53.19*/("""
            """),format.raw/*54.13*/("""background-color: #4CAF50;
            color: white;
            font-weight: bold;
            text-transform: uppercase;
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""

        """),format.raw/*60.9*/("""/* Zebra striping for table rows */
        tbody tr:nth-child(even) """),format.raw/*61.34*/("""{"""),format.raw/*61.35*/("""
            """),format.raw/*62.13*/("""background-color: #f2f2f2;
        """),format.raw/*63.9*/("""}"""),format.raw/*63.10*/("""

        """),format.raw/*65.9*/("""/* Hover effect on rows */
        tbody tr:hover """),format.raw/*66.24*/("""{"""),format.raw/*66.25*/("""
            """),format.raw/*67.13*/("""background-color: #d0e9c6;
            cursor: pointer;
        """),format.raw/*69.9*/("""}"""),format.raw/*69.10*/("""


    """),format.raw/*72.5*/("""</style>
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
        """),_display_(/*84.10*/for((word, frequency) <- sortedWordFrequency) yield /*84.55*/ {_display_(Seq[Any](format.raw/*84.57*/("""
        """),format.raw/*85.9*/("""<tr>
            <td>"""),_display_(/*86.18*/word),format.raw/*86.22*/("""</td>
            <td>"""),_display_(/*87.18*/frequency),format.raw/*87.27*/("""</td>
        </tr>
        """)))}),format.raw/*89.10*/("""
        """),format.raw/*90.9*/("""</tbody>
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
                  HASH: ef48f376fe7ee9212e777c7956d6eb6e64009bdc
                  MATRIX: 1586->661|1722->701|1753->705|2034->958|2063->959|2105->973|2350->1191|2379->1192|2418->1204|2481->1239|2510->1240|2552->1254|2712->1387|2741->1388|2780->1400|2815->1407|2844->1408|2886->1422|3012->1521|3041->1522|3080->1534|3151->1577|3180->1578|3222->1592|3384->1727|3413->1728|3452->1740|3550->1810|3579->1811|3621->1825|3684->1861|3713->1862|3752->1874|3831->1925|3860->1926|3902->1940|3995->2006|4024->2007|4061->2017|4308->2237|4369->2282|4409->2284|4446->2294|4496->2317|4521->2321|4572->2345|4602->2354|4664->2385|4701->2395
                  LINES: 43->19|48->19|50->21|58->29|58->29|59->30|65->36|65->36|67->38|68->39|68->39|69->40|73->44|73->44|75->46|75->46|75->46|76->47|79->50|79->50|81->52|82->53|82->53|83->54|87->58|87->58|89->60|90->61|90->61|91->62|92->63|92->63|94->65|95->66|95->66|96->67|98->69|98->69|101->72|113->84|113->84|113->84|114->85|115->86|115->86|116->87|116->87|118->89|119->90
                  -- GENERATED --
              */
          