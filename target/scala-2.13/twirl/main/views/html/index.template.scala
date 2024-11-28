
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
        let allKeyword = [];
        let avgFKGLList = [];
        let avgFREList = [];
        let sentiment = [];
        let searchResultsList = [];

        socket.onopen = function(event) """),format.raw/*17.41*/("""{"""),format.raw/*17.42*/("""
            """),format.raw/*18.13*/("""console.log("Connection established.");
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""";

        socket.onmessage = function(event) """),format.raw/*21.44*/("""{"""),format.raw/*21.45*/("""
            """),format.raw/*22.13*/("""console.log("Received new results: " + event.data);

            // Clear previous results from result div
            let resultsDiv = document.getElementById("results");
            resultsDiv.innerHTML = "";
            avgFKGLList = [];
            avgFREList = [];
            searchResultsList = [];
            allKeyword = [];
            sentiment = [];

            // Read result from JSON
            let data = JSON.parse(event.data);

            // Process the data
            allKeyword.push(...data.searchHistory);
            avgFKGLList.push(...data.avgFKGL);
            avgFREList.push(...data.avgFRE);
            sentiment.push(...data.stm);
            data.searchResults.forEach(resultList => """),format.raw/*41.54*/("""{"""),format.raw/*41.55*/("""
                """),format.raw/*42.17*/("""resultList.forEach(result => """),format.raw/*42.46*/("""{"""),format.raw/*42.47*/("""
                    """),format.raw/*43.21*/("""// Create an object for each result that contains all information
                    let resultObj = """),format.raw/*44.37*/("""{"""),format.raw/*44.38*/("""
                        """),format.raw/*45.25*/("""title: result.title,
                        videoID: result.videoID,
                        videoLink: result.videoLink,
                        channelTitle: result.channelTitle,
                        channelID: result.channelID,
                        channelProfileLink: result.channelProfileLink,
                        description: result.description,
                        thumbnailUrl: result.thumbnailUrl,
                        fkgl: result.fkgl,
                        fre: result.fre,
                    """),format.raw/*55.21*/("""}"""),format.raw/*55.22*/(""";

                    // Add the result object to the resultsList
                    searchResultsList.push(resultObj);
                """),format.raw/*59.17*/("""}"""),format.raw/*59.18*/(""");
            """),format.raw/*60.13*/("""}"""),format.raw/*60.14*/(""");

            // Display all results
             for (let i = 0; i < allKeyword.length; i++) """),format.raw/*63.58*/("""{"""),format.raw/*63.59*/("""
                """),format.raw/*64.17*/("""// Display the search term, average FKGL and FRE
                resultsDiv.innerHTML += `<p><strong>Search Term:</strong> $"""),format.raw/*65.76*/("""{"""),format.raw/*65.77*/("""allKeyword[i]"""),format.raw/*65.90*/("""}"""),format.raw/*65.91*/(""" """),format.raw/*65.92*/("""<a href="/wordstats/$"""),format.raw/*65.113*/("""{"""),format.raw/*65.114*/("""allKeyword[i]"""),format.raw/*65.127*/("""}"""),format.raw/*65.128*/("""" target="_blank">Word Stats</a>
 <strong>Sentiment:</strong> $"""),format.raw/*66.31*/("""{"""),format.raw/*66.32*/("""sentiment[0]"""),format.raw/*66.44*/("""}"""),format.raw/*66.45*/(""",<strong>Flesh-Kincaid Grade Level Avg.:</strong> $"""),format.raw/*66.96*/("""{"""),format.raw/*66.97*/("""avgFKGLList[i]"""),format.raw/*66.111*/("""}"""),format.raw/*66.112*/(""", <strong>Flesh Reading Ease Score Avg.:</strong> $"""),format.raw/*66.163*/("""{"""),format.raw/*66.164*/("""avgFREList[i]"""),format.raw/*66.177*/("""}"""),format.raw/*66.178*/("""</p>`;

                // Display each search results
                for(let j = i*10; j<i*10+10; j++)"""),format.raw/*69.50*/("""{"""),format.raw/*69.51*/("""
                    """),format.raw/*70.21*/("""// Display each video information
                    resultsDiv.innerHTML += `<p>$"""),format.raw/*71.50*/("""{"""),format.raw/*71.51*/("""j%10+1"""),format.raw/*71.57*/("""}"""),format.raw/*71.58*/(""". <strong>Title</strong>: <a href="$"""),format.raw/*71.94*/("""{"""),format.raw/*71.95*/("""searchResultsList[j].videoLink"""),format.raw/*71.125*/("""}"""),format.raw/*71.126*/("""">$"""),format.raw/*71.129*/("""{"""),format.raw/*71.130*/("""searchResultsList[j].title"""),format.raw/*71.156*/("""}"""),format.raw/*71.157*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Channel</strong>: <a href="$"""),format.raw/*72.82*/("""{"""),format.raw/*72.83*/("""searchResultsList[j].channelProfileLink"""),format.raw/*72.122*/("""}"""),format.raw/*72.123*/("""">$"""),format.raw/*72.126*/("""{"""),format.raw/*72.127*/("""searchResultsList[j].channelTitle"""),format.raw/*72.160*/("""}"""),format.raw/*72.161*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Description</strong>: "$"""),format.raw/*73.78*/("""{"""),format.raw/*73.79*/("""searchResultsList[j].description"""),format.raw/*73.111*/("""}"""),format.raw/*73.112*/("""", `
                    resultsDiv.innerHTML += `Flesh-Kincaid Grade Level= "$"""),format.raw/*74.75*/("""{"""),format.raw/*74.76*/("""searchResultsList[j].fkgl"""),format.raw/*74.101*/("""}"""),format.raw/*74.102*/("""", `
                    resultsDiv.innerHTML += `Flesh Reading Ease Score= "$"""),format.raw/*75.74*/("""{"""),format.raw/*75.75*/("""searchResultsList[j].fre"""),format.raw/*75.99*/("""}"""),format.raw/*75.100*/("""", `
                    resultsDiv.innerHTML += `<a href="">Tags</a></p>`
                    resultsDiv.innerHTML += `<img src="$"""),format.raw/*77.57*/("""{"""),format.raw/*77.58*/("""searchResultsList[j].thumbnailUrl"""),format.raw/*77.91*/("""}"""),format.raw/*77.92*/("""" alt="thumbnail">`
                """),format.raw/*78.17*/("""}"""),format.raw/*78.18*/("""
             """),format.raw/*79.14*/("""}"""),format.raw/*79.15*/("""
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""";

        socket.onclose = function(event) """),format.raw/*82.42*/("""{"""),format.raw/*82.43*/("""
            """),format.raw/*83.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/(""";

        socket.onerror = function(error) """),format.raw/*86.42*/("""{"""),format.raw/*86.43*/("""
            """),format.raw/*87.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/(""";

        function sendKeyword() """),format.raw/*90.32*/("""{"""),format.raw/*90.33*/("""
            """),format.raw/*91.13*/("""let keyword = document.getElementById("keyword").value;
            allKeyword.unshift(keyword);
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*94.55*/("""{"""),format.raw/*94.56*/("""
                """),format.raw/*95.17*/("""socket.send(keyword);
            """),format.raw/*96.13*/("""}"""),format.raw/*96.14*/(""" """),format.raw/*96.15*/("""else """),format.raw/*96.20*/("""{"""),format.raw/*96.21*/("""
                """),format.raw/*97.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*98.13*/("""}"""),format.raw/*98.14*/("""
        """),format.raw/*99.9*/("""}"""),format.raw/*99.10*/("""
    """),format.raw/*100.5*/("""</script>
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
                  HASH: 4001c3458b094313f27731da6792c8c1456ef8cb
                  MATRIX: 989->0|1515->498|1544->499|1586->513|1662->562|1691->563|1767->611|1796->612|1838->626|2604->1364|2633->1365|2679->1383|2736->1412|2765->1413|2815->1435|2946->1538|2975->1539|3029->1565|3593->2101|3622->2102|3792->2244|3821->2245|3865->2261|3894->2262|4021->2361|4050->2362|4096->2380|4249->2505|4278->2506|4319->2519|4348->2520|4377->2521|4427->2542|4457->2543|4499->2556|4529->2557|4621->2621|4650->2622|4690->2634|4719->2635|4798->2686|4827->2687|4870->2701|4900->2702|4980->2753|5010->2754|5052->2767|5082->2768|5217->2875|5246->2876|5296->2898|5408->2982|5437->2983|5471->2989|5500->2990|5564->3026|5593->3027|5652->3057|5682->3058|5714->3061|5744->3062|5799->3088|5829->3089|5947->3179|5976->3180|6044->3219|6074->3220|6106->3223|6136->3224|6198->3257|6228->3258|6342->3344|6371->3345|6432->3377|6462->3378|6570->3458|6599->3459|6653->3484|6683->3485|6790->3564|6819->3565|6871->3589|6901->3590|7062->3723|7091->3724|7152->3757|7181->3758|7246->3795|7275->3796|7318->3811|7347->3812|7384->3822|7413->3823|7487->3869|7516->3870|7558->3884|7678->3977|7707->3978|7781->4024|7810->4025|7852->4039|7937->4097|7966->4098|8030->4134|8059->4135|8101->4149|8339->4359|8368->4360|8414->4378|8477->4413|8506->4414|8535->4415|8568->4420|8597->4421|8643->4439|8751->4519|8780->4520|8817->4530|8846->4531|8880->4537
                  LINES: 32->1|48->17|48->17|49->18|50->19|50->19|52->21|52->21|53->22|72->41|72->41|73->42|73->42|73->42|74->43|75->44|75->44|76->45|86->55|86->55|90->59|90->59|91->60|91->60|94->63|94->63|95->64|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|100->69|100->69|101->70|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|104->73|104->73|104->73|104->73|105->74|105->74|105->74|105->74|106->75|106->75|106->75|106->75|108->77|108->77|108->77|108->77|109->78|109->78|110->79|110->79|111->80|111->80|113->82|113->82|114->83|115->84|115->84|117->86|117->86|118->87|119->88|119->88|121->90|121->90|122->91|125->94|125->94|126->95|127->96|127->96|127->96|127->96|127->96|128->97|129->98|129->98|130->99|130->99|131->100
                  -- GENERATED --
              */
          