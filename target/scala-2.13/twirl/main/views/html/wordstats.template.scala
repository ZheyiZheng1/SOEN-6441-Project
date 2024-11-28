
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
/*1.2*/import com.fasterxml.jackson.databind.JsonNode
/*2.2*/import scala.jdk.CollectionConverters._

object wordstats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[JsonNode,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(wordStats: JsonNode, searchTerm: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.43*/("""

"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word Stats for """),_display_(/*10.28*/searchTerm),format.raw/*10.38*/("""</title>
</head>
<body>
<h1>Word Statistics for Search Term: """"),_display_(/*13.40*/searchTerm),format.raw/*13.50*/(""""</h1>

<table border="1">
    <thead>
    <tr>
        <th>Word</th>
        <th>Frequency</th>
    </tr>
    </thead>
    <tbody>
    """),_display_(/*23.6*/for(entry <- wordStats.fields().asScala) yield /*23.46*/ {_display_(Seq[Any](format.raw/*23.48*/("""
    """),format.raw/*24.5*/("""<tr>
        <td>"""),_display_(/*25.14*/entry/*25.19*/.getKey),format.raw/*25.26*/("""</td>
        <td>"""),_display_(/*26.14*/entry/*26.19*/.getValue.asInt()),format.raw/*26.36*/("""</td>
    </tr>
    """)))}),format.raw/*28.6*/("""
    """),format.raw/*29.5*/("""</tbody>
</table>

<p><a href="/">Back to Search</a></p>
</body>
</html>
"""))
      }
    }
  }

  def render(wordStats:JsonNode,searchTerm:String): play.twirl.api.HtmlFormat.Appendable = apply(wordStats,searchTerm)

  def f:((JsonNode,String) => play.twirl.api.HtmlFormat.Appendable) = (wordStats,searchTerm) => apply(wordStats,searchTerm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/wordstats.scala.html
                  HASH: 6aec44afc388db2444045cd0a2e0515de7df8a4f
                  MATRIX: 610->1|664->50|1021->94|1157->135|1187->139|1312->237|1343->247|1436->313|1467->323|1640->470|1696->510|1736->512|1769->518|1815->537|1829->542|1857->549|1904->569|1918->574|1956->591|2009->614|2042->620
                  LINES: 23->1|24->2|29->4|34->4|36->6|40->10|40->10|43->13|43->13|53->23|53->23|53->23|54->24|55->25|55->25|55->25|56->26|56->26|56->26|58->28|59->29
                  -- GENERATED --
              */
          