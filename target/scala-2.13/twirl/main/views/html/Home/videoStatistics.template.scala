
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


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<h1>Word Frequency Statistics</h1>
<table>
    <thead>
    <tr>
        <th>Word</th>
        <th>Frequency</th>
    </tr>
    </thead>
    <tbody>
    """),_display_(/*13.6*/for((word, frequency) <- sortedWordFrequency) yield /*13.51*/ {_display_(Seq[Any](format.raw/*13.53*/("""
    """),format.raw/*14.5*/("""<tr>
        <td>"""),_display_(/*15.14*/word),format.raw/*15.18*/("""</td>
        <td>"""),_display_(/*16.14*/frequency),format.raw/*16.23*/("""</td>
    </tr>
    """)))}),format.raw/*18.6*/("""
    """),format.raw/*19.5*/("""</tbody>
</table>

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
                  HASH: d666a882bf3d00653140a7b7105f211174c9b839
                  MATRIX: 933->2|1067->43|1094->44|1273->197|1334->242|1374->244|1406->249|1451->267|1476->271|1522->290|1552->299|1603->320|1635->325
                  LINES: 27->2|32->3|33->4|42->13|42->13|42->13|43->14|44->15|44->15|45->16|45->16|47->18|48->19
                  -- GENERATED --
              */
          