
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
        let searchResultsList = [];

        socket.onopen = function(event) """),format.raw/*16.41*/("""{"""),format.raw/*16.42*/("""
            """),format.raw/*17.13*/("""console.log("Connection established.");
        """),format.raw/*18.9*/("""}"""),format.raw/*18.10*/(""";

        socket.onmessage = function(event) """),format.raw/*20.44*/("""{"""),format.raw/*20.45*/("""
            """),format.raw/*21.13*/("""console.log("Received new results: " + event.data);

            // Clear previous results from result div
            let resultsDiv = document.getElementById("results");
            resultsDiv.innerHTML = "";
            avgFKGLList = [];
            avgFREList = [];
            searchResultsList = [];
            allKeyword = [];

            // Read result from JSON
            let data = JSON.parse(event.data);

            // Process the data
            allKeyword.push(...data.searchHistory);
            avgFKGLList.push(...data.avgFKGL);
            avgFREList.push(...data.avgFRE);
            data.searchResults.forEach(resultList => """),format.raw/*38.54*/("""{"""),format.raw/*38.55*/("""
                """),format.raw/*39.17*/("""resultList.forEach(result => """),format.raw/*39.46*/("""{"""),format.raw/*39.47*/("""
                    """),format.raw/*40.21*/("""// Create an object for each result that contains all information
                    let resultObj = """),format.raw/*41.37*/("""{"""),format.raw/*41.38*/("""
                        """),format.raw/*42.25*/("""title: result.title,
                        videoID: result.videoID,
                        videoLink: result.videoLink,
                        channelTitle: result.channelTitle,
                        channelID: result.channelID,
                        channelProfileLink: result.channelProfileLink,
                        description: result.description,
                        thumbnailUrl: result.thumbnailUrl,
                        fkgl: result.fkgl,
                        fre: result.fre,
                    """),format.raw/*52.21*/("""}"""),format.raw/*52.22*/(""";

                    // Add the result object to the resultsList
                    searchResultsList.push(resultObj);
                """),format.raw/*56.17*/("""}"""),format.raw/*56.18*/(""");
            """),format.raw/*57.13*/("""}"""),format.raw/*57.14*/(""");

            // Display all results
             for (let i = 0; i < allKeyword.length; i++) """),format.raw/*60.58*/("""{"""),format.raw/*60.59*/("""
                """),format.raw/*61.17*/("""// Display the search term, average FKGL and FRE
                resultsDiv.innerHTML += `<p><strong>Search Term:</strong> $"""),format.raw/*62.76*/("""{"""),format.raw/*62.77*/("""allKeyword[i]"""),format.raw/*62.90*/("""}"""),format.raw/*62.91*/(""" """),format.raw/*62.92*/("""<strong>Flesh-Kincaid Grade Level Avg.:</strong> $"""),format.raw/*62.142*/("""{"""),format.raw/*62.143*/("""avgFKGLList[i]"""),format.raw/*62.157*/("""}"""),format.raw/*62.158*/(""", <strong>Flesh Reading Ease Score Avg.:</strong> $"""),format.raw/*62.209*/("""{"""),format.raw/*62.210*/("""avgFREList[i]"""),format.raw/*62.223*/("""}"""),format.raw/*62.224*/("""</p>`;

                // Display each search results
                for(let j = i*10; j<i*10+10; j++)"""),format.raw/*65.50*/("""{"""),format.raw/*65.51*/("""
                    """),format.raw/*66.21*/("""// Display each video information
                    resultsDiv.innerHTML += `<p>$"""),format.raw/*67.50*/("""{"""),format.raw/*67.51*/("""j%10+1"""),format.raw/*67.57*/("""}"""),format.raw/*67.58*/(""". <strong>Title</strong>: <a href="$"""),format.raw/*67.94*/("""{"""),format.raw/*67.95*/("""searchResultsList[j].videoLink"""),format.raw/*67.125*/("""}"""),format.raw/*67.126*/("""">$"""),format.raw/*67.129*/("""{"""),format.raw/*67.130*/("""searchResultsList[j].title"""),format.raw/*67.156*/("""}"""),format.raw/*67.157*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Channel</strong>: <a href="$"""),format.raw/*68.82*/("""{"""),format.raw/*68.83*/("""searchResultsList[j].channelProfileLink"""),format.raw/*68.122*/("""}"""),format.raw/*68.123*/("""">$"""),format.raw/*68.126*/("""{"""),format.raw/*68.127*/("""searchResultsList[j].channelTitle"""),format.raw/*68.160*/("""}"""),format.raw/*68.161*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Description</strong>: "$"""),format.raw/*69.78*/("""{"""),format.raw/*69.79*/("""searchResultsList[j].description"""),format.raw/*69.111*/("""}"""),format.raw/*69.112*/("""", `
                    resultsDiv.innerHTML += `Flesh-Kincaid Grade Level= "$"""),format.raw/*70.75*/("""{"""),format.raw/*70.76*/("""searchResultsList[j].fkgl"""),format.raw/*70.101*/("""}"""),format.raw/*70.102*/("""", `
                    resultsDiv.innerHTML += `Flesh Reading Ease Score= "$"""),format.raw/*71.74*/("""{"""),format.raw/*71.75*/("""searchResultsList[j].fre"""),format.raw/*71.99*/("""}"""),format.raw/*71.100*/("""", `
                    resultsDiv.innerHTML += `<a href="">Tags</a></p>`
                    resultsDiv.innerHTML += `<img src="$"""),format.raw/*73.57*/("""{"""),format.raw/*73.58*/("""searchResultsList[j].thumbnailUrl"""),format.raw/*73.91*/("""}"""),format.raw/*73.92*/("""" alt="thumbnail">`
                """),format.raw/*74.17*/("""}"""),format.raw/*74.18*/("""
             """),format.raw/*75.14*/("""}"""),format.raw/*75.15*/("""
        """),format.raw/*76.9*/("""}"""),format.raw/*76.10*/(""";

        socket.onclose = function(event) """),format.raw/*78.42*/("""{"""),format.raw/*78.43*/("""
            """),format.raw/*79.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""";

        socket.onerror = function(error) """),format.raw/*82.42*/("""{"""),format.raw/*82.43*/("""
            """),format.raw/*83.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/(""";

        function sendKeyword() """),format.raw/*86.32*/("""{"""),format.raw/*86.33*/("""
            """),format.raw/*87.13*/("""let keyword = document.getElementById("keyword").value;
            allKeyword.unshift(keyword);
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*90.55*/("""{"""),format.raw/*90.56*/("""
                """),format.raw/*91.17*/("""socket.send(keyword);
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/(""" """),format.raw/*92.15*/("""else """),format.raw/*92.20*/("""{"""),format.raw/*92.21*/("""
                """),format.raw/*93.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*94.13*/("""}"""),format.raw/*94.14*/("""
        """),format.raw/*95.9*/("""}"""),format.raw/*95.10*/("""
    """),format.raw/*96.5*/("""</script>
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
                  HASH: b98c3c6fe6924e3c817269a5708dca89f418f2b7
                  MATRIX: 989->0|1486->469|1515->470|1557->484|1633->533|1662->534|1738->582|1767->583|1809->597|2504->1264|2533->1265|2579->1283|2636->1312|2665->1313|2715->1335|2846->1438|2875->1439|2929->1465|3493->2001|3522->2002|3692->2144|3721->2145|3765->2161|3794->2162|3921->2261|3950->2262|3996->2280|4149->2405|4178->2406|4219->2419|4248->2420|4277->2421|4356->2471|4386->2472|4429->2486|4459->2487|4539->2538|4569->2539|4611->2552|4641->2553|4776->2660|4805->2661|4855->2683|4967->2767|4996->2768|5030->2774|5059->2775|5123->2811|5152->2812|5211->2842|5241->2843|5273->2846|5303->2847|5358->2873|5388->2874|5506->2964|5535->2965|5603->3004|5633->3005|5665->3008|5695->3009|5757->3042|5787->3043|5901->3129|5930->3130|5991->3162|6021->3163|6129->3243|6158->3244|6212->3269|6242->3270|6349->3349|6378->3350|6430->3374|6460->3375|6621->3508|6650->3509|6711->3542|6740->3543|6805->3580|6834->3581|6877->3596|6906->3597|6943->3607|6972->3608|7046->3654|7075->3655|7117->3669|7237->3762|7266->3763|7340->3809|7369->3810|7411->3824|7496->3882|7525->3883|7589->3919|7618->3920|7660->3934|7898->4144|7927->4145|7973->4163|8036->4198|8065->4199|8094->4200|8127->4205|8156->4206|8202->4224|8310->4304|8339->4305|8376->4315|8405->4316|8438->4322
                  LINES: 32->1|47->16|47->16|48->17|49->18|49->18|51->20|51->20|52->21|69->38|69->38|70->39|70->39|70->39|71->40|72->41|72->41|73->42|83->52|83->52|87->56|87->56|88->57|88->57|91->60|91->60|92->61|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|96->65|96->65|97->66|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|99->68|99->68|99->68|99->68|99->68|99->68|99->68|99->68|100->69|100->69|100->69|100->69|101->70|101->70|101->70|101->70|102->71|102->71|102->71|102->71|104->73|104->73|104->73|104->73|105->74|105->74|106->75|106->75|107->76|107->76|109->78|109->78|110->79|111->80|111->80|113->82|113->82|114->83|115->84|115->84|117->86|117->86|118->87|121->90|121->90|122->91|123->92|123->92|123->92|123->92|123->92|124->93|125->94|125->94|126->95|126->95|127->96
                  -- GENERATED --
              */
          