
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Keyword Search</title>
    <script>
        let socket = new WebSocket("ws://localhost:9000/search");
        let allResults = [];

        socket.onopen = function(event) """),format.raw/*10.41*/("""{"""),format.raw/*10.42*/("""
            """),format.raw/*11.13*/("""console.log("Connection established.");
        """),format.raw/*12.9*/("""}"""),format.raw/*12.10*/(""";

        socket.onmessage = function(event) """),format.raw/*14.44*/("""{"""),format.raw/*14.45*/("""
            """),format.raw/*15.13*/("""console.log("Received new results: " + event.data); // Debugging
            let newResults = event.data.split('\n');
            allResults = newResults.concat(allResults); // Combine new results with history

            // Clear previous results
            let resultsDiv = document.getElementById("results");
            resultsDiv.innerHTML = "";

            // Display all results
            allResults.forEach(result => """),format.raw/*24.42*/("""{"""),format.raw/*24.43*/("""
                """),format.raw/*25.17*/("""resultsDiv.innerHTML += `<p>$"""),format.raw/*25.46*/("""{"""),format.raw/*25.47*/("""result"""),format.raw/*25.53*/("""}"""),format.raw/*25.54*/("""</p>`;
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""");
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/(""";

        socket.onclose = function(event) """),format.raw/*29.42*/("""{"""),format.raw/*29.43*/("""
            """),format.raw/*30.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/(""";

        socket.onerror = function(error) """),format.raw/*33.42*/("""{"""),format.raw/*33.43*/("""
            """),format.raw/*34.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*35.9*/("""}"""),format.raw/*35.10*/(""";

        function sendKeyword() """),format.raw/*37.32*/("""{"""),format.raw/*37.33*/("""
            """),format.raw/*38.13*/("""let keyword = document.getElementById("keyword").value;
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*40.55*/("""{"""),format.raw/*40.56*/("""
                """),format.raw/*41.17*/("""socket.send(keyword);
            """),format.raw/*42.13*/("""}"""),format.raw/*42.14*/(""" """),format.raw/*42.15*/("""else """),format.raw/*42.20*/("""{"""),format.raw/*42.21*/("""
                """),format.raw/*43.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/("""
        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/("""
    """),format.raw/*46.5*/("""</script>
</head>
<body>
<h1>Welcome to the WebSocket Search Page!</h1>
<input type="text" id="keyword" placeholder="Enter keyword">
<button onclick="sendKeyword()">Search</button>
<div id="results"></div>
</body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 262f00fb0d1ee98bdff54a44174d14917cfba237
                  MATRIX: 989->0|1276->259|1305->260|1347->274|1423->323|1452->324|1528->372|1557->373|1599->387|2066->826|2095->827|2141->845|2198->874|2227->875|2261->881|2290->882|2338->902|2367->903|2406->915|2435->916|2509->962|2538->963|2580->977|2700->1070|2729->1071|2803->1117|2832->1118|2874->1132|2959->1190|2988->1191|3052->1227|3081->1228|3123->1242|3319->1410|3348->1411|3394->1429|3457->1464|3486->1465|3515->1466|3548->1471|3577->1472|3623->1490|3731->1570|3760->1571|3797->1581|3826->1582|3859->1588
                  LINES: 32->1|41->10|41->10|42->11|43->12|43->12|45->14|45->14|46->15|55->24|55->24|56->25|56->25|56->25|56->25|56->25|57->26|57->26|58->27|58->27|60->29|60->29|61->30|62->31|62->31|64->33|64->33|65->34|66->35|66->35|68->37|68->37|69->38|71->40|71->40|72->41|73->42|73->42|73->42|73->42|73->42|74->43|75->44|75->44|76->45|76->45|77->46
                  -- GENERATED --
              */
          