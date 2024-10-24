
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(searchQuery: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.23*/("""

"""),format.raw/*3.1*/("""<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<form action="/search" method="post">
  <p>Welcome to YT lytics</p>
  <input type="text" id="search" name="search" placeholder="Enter search terms" value=""""),_display_(/*12.89*/searchQuery),format.raw/*12.100*/(""""><br>
  <input type="submit" value="Go">
</form>

"""),format.raw/*16.49*/("""
"""),_display_(if(searchQuery.nonEmpty)/*17.26*/ {_display_(Seq[Any](format.raw/*17.28*/("""
"""),format.raw/*18.1*/("""<h2>You searched for: """),_display_(/*18.24*/searchQuery),format.raw/*18.35*/("""</h2>
""")))} else {null} ),format.raw/*19.2*/("""
"""),format.raw/*20.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(searchQuery:String): play.twirl.api.HtmlFormat.Appendable = apply(searchQuery)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (searchQuery) => apply(searchQuery)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/searchResults.scala.html
                  HASH: f260f6d1de193a7f5e7e989a0dd92d6ee974180c
                  MATRIX: 920->1|1036->22|1066->26|1378->311|1411->322|1494->425|1548->452|1588->454|1617->456|1667->479|1699->490|1750->498|1779->500
                  LINES: 27->1|32->1|34->3|43->12|43->12|47->16|48->17|48->17|49->18|49->18|49->18|50->19|51->20
                  -- GENERATED --
              */
          