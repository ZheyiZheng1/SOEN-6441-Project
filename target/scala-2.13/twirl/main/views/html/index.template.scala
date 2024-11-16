
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
<!-- Author Zheyi Zheng-->
<!-- Created: 2024/11/14-->
<!-- This is index view, the main view for this project-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YT lytics</title>
    <script>
        let socket = new WebSocket("ws://localhost:9000/search");
        let allResults = [];
        let allKeyword = [];

        socket.onopen = function(event) """),format.raw/*14.41*/("""{"""),format.raw/*14.42*/("""
            """),format.raw/*15.13*/("""console.log("Connection established.");
        """),format.raw/*16.9*/("""}"""),format.raw/*16.10*/(""";

        socket.onmessage = function(event) """),format.raw/*18.44*/("""{"""),format.raw/*18.45*/("""
            """),format.raw/*19.13*/("""console.log("Received new results: " + event.data);
            let newResults = event.data.split('\n');
            allResults.unshift(newResults);

            // Clear previous results from result div
            let resultsDiv = document.getElementById("results");
            resultsDiv.innerHTML = "";

            // Display all results

             for (let i = 0; i < allKeyword.length; i++) """),format.raw/*29.58*/("""{"""),format.raw/*29.59*/("""
                """),format.raw/*30.17*/("""// Display the search term
                resultsDiv.innerHTML += `<p><strong>Search Term:</strong> $"""),format.raw/*31.76*/("""{"""),format.raw/*31.77*/("""allKeyword[i]"""),format.raw/*31.90*/("""}"""),format.raw/*31.91*/("""`;
                // Display average FKGL and FRE (placeholders for now)
                resultsDiv.innerHTML += `<strong>Flesh-Kincaid Grade Level Avg.:</strong> $"""),format.raw/*33.92*/("""{"""),format.raw/*33.93*/("""allResults[i][0]"""),format.raw/*33.109*/("""}"""),format.raw/*33.110*/(""",
                <strong>Flesh Reading Ease Score Avg.:</strong> $"""),format.raw/*34.66*/("""{"""),format.raw/*34.67*/("""allResults[i][1]"""),format.raw/*34.83*/("""}"""),format.raw/*34.84*/("""</p>`;

                // Display individual results
                if (allResults[i] && allResults[i].length > 0) """),format.raw/*37.64*/("""{"""),format.raw/*37.65*/("""
                    """),format.raw/*38.21*/("""for (let j = 2; j < allResults[i].length; j++) """),format.raw/*38.68*/("""{"""),format.raw/*38.69*/("""
                        """),format.raw/*39.25*/("""resultsDiv.innerHTML += `<p>$"""),format.raw/*39.54*/("""{"""),format.raw/*39.55*/("""j-1"""),format.raw/*39.58*/("""}"""),format.raw/*39.59*/(""". $"""),format.raw/*39.62*/("""{"""),format.raw/*39.63*/("""allResults[i][j]"""),format.raw/*39.79*/("""}"""),format.raw/*39.80*/("""</p>`;
                    """),format.raw/*40.21*/("""}"""),format.raw/*40.22*/("""
                """),format.raw/*41.17*/("""}"""),format.raw/*41.18*/(""" """),format.raw/*41.19*/("""else """),format.raw/*41.24*/("""{"""),format.raw/*41.25*/("""
                    """),format.raw/*42.21*/("""resultsDiv.innerHTML += `<p>No results available.</p>`;
                """),format.raw/*43.17*/("""}"""),format.raw/*43.18*/("""
             """),format.raw/*44.14*/("""}"""),format.raw/*44.15*/("""

        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/(""";

        socket.onclose = function(event) """),format.raw/*48.42*/("""{"""),format.raw/*48.43*/("""
            """),format.raw/*49.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/(""";

        socket.onerror = function(error) """),format.raw/*52.42*/("""{"""),format.raw/*52.43*/("""
            """),format.raw/*53.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/(""";

        function sendKeyword() """),format.raw/*56.32*/("""{"""),format.raw/*56.33*/("""
            """),format.raw/*57.13*/("""let keyword = document.getElementById("keyword").value;
            allKeyword.unshift(keyword);
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*60.55*/("""{"""),format.raw/*60.56*/("""
                """),format.raw/*61.17*/("""socket.send(keyword);
            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/(""" """),format.raw/*62.15*/("""else """),format.raw/*62.20*/("""{"""),format.raw/*62.21*/("""
                """),format.raw/*63.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*64.13*/("""}"""),format.raw/*64.14*/("""
        """),format.raw/*65.9*/("""}"""),format.raw/*65.10*/("""
    """),format.raw/*66.5*/("""</script>
</head>
<body>
<h1>Welcome to the YT lytics</h1>
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
                  HASH: c5a10d1d0091b01c845820b4c87bc9476274377a
                  MATRIX: 989->0|1418->401|1447->402|1489->416|1565->465|1594->466|1670->514|1699->515|1741->529|2181->941|2210->942|2256->960|2387->1063|2416->1064|2457->1077|2486->1078|2681->1245|2710->1246|2755->1262|2785->1263|2881->1331|2910->1332|2954->1348|2983->1349|3131->1469|3160->1470|3210->1492|3285->1539|3314->1540|3368->1566|3425->1595|3454->1596|3485->1599|3514->1600|3545->1603|3574->1604|3618->1620|3647->1621|3703->1649|3732->1650|3778->1668|3807->1669|3836->1670|3869->1675|3898->1676|3948->1698|4049->1771|4078->1772|4121->1787|4150->1788|4189->1800|4218->1801|4292->1847|4321->1848|4363->1862|4483->1955|4512->1956|4586->2002|4615->2003|4657->2017|4742->2075|4771->2076|4835->2112|4864->2113|4906->2127|5144->2337|5173->2338|5219->2356|5282->2391|5311->2392|5340->2393|5373->2398|5402->2399|5448->2417|5556->2497|5585->2498|5622->2508|5651->2509|5684->2515
                  LINES: 32->1|45->14|45->14|46->15|47->16|47->16|49->18|49->18|50->19|60->29|60->29|61->30|62->31|62->31|62->31|62->31|64->33|64->33|64->33|64->33|65->34|65->34|65->34|65->34|68->37|68->37|69->38|69->38|69->38|70->39|70->39|70->39|70->39|70->39|70->39|70->39|70->39|70->39|71->40|71->40|72->41|72->41|72->41|72->41|72->41|73->42|74->43|74->43|75->44|75->44|77->46|77->46|79->48|79->48|80->49|81->50|81->50|83->52|83->52|84->53|85->54|85->54|87->56|87->56|88->57|91->60|91->60|92->61|93->62|93->62|93->62|93->62|93->62|94->63|95->64|95->64|96->65|96->65|97->66
                  -- GENERATED --
              */
          