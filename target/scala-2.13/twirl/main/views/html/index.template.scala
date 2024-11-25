
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

            // Read result from JSON
            let data = JSON.parse(event.data);

            // Process the data
            avgFKGLList.push(...data.avgFKGL);
            avgFREList.push(...data.avgFRE);
            data.searchResults.forEach(resultList => """),format.raw/*36.54*/("""{"""),format.raw/*36.55*/("""
                """),format.raw/*37.17*/("""resultList.forEach(result => """),format.raw/*37.46*/("""{"""),format.raw/*37.47*/("""
                    """),format.raw/*38.21*/("""// Create an object for each result that contains all information
                    let resultObj = """),format.raw/*39.37*/("""{"""),format.raw/*39.38*/("""
                        """),format.raw/*40.25*/("""title: result.title,
                        videoID: result.videoID,
                        videoLink: result.videoLink,
                        channelTitle: result.channelTitle,
                        channelID: result.channelID,
                        channelProfileLink: result.channelProfileLink,
                        description: result.description,
                        thumbnailUrl: result.thumbnailUrl,
                        fkgl: result.fkgl,
                        fre: result.fre,
                    """),format.raw/*50.21*/("""}"""),format.raw/*50.22*/(""";

                    // Add the result object to the resultsList
                    searchResultsList.push(resultObj);
                """),format.raw/*54.17*/("""}"""),format.raw/*54.18*/(""");
            """),format.raw/*55.13*/("""}"""),format.raw/*55.14*/(""");

            // Display all results
             for (let i = 0; i < allKeyword.length; i++) """),format.raw/*58.58*/("""{"""),format.raw/*58.59*/("""
                """),format.raw/*59.17*/("""// Display the search term, average FKGL and FRE
                resultsDiv.innerHTML += `<p><strong>Search Term:</strong> $"""),format.raw/*60.76*/("""{"""),format.raw/*60.77*/("""allKeyword[i]"""),format.raw/*60.90*/("""}"""),format.raw/*60.91*/(""" """),format.raw/*60.92*/("""<strong>Flesh-Kincaid Grade Level Avg.:</strong> $"""),format.raw/*60.142*/("""{"""),format.raw/*60.143*/("""avgFKGLList[i]"""),format.raw/*60.157*/("""}"""),format.raw/*60.158*/(""", <strong>Flesh Reading Ease Score Avg.:</strong> $"""),format.raw/*60.209*/("""{"""),format.raw/*60.210*/("""avgFREList[i]"""),format.raw/*60.223*/("""}"""),format.raw/*60.224*/("""</p>`;

                // Display each search results
                for(let j = i*10; j<i*10+10; j++)"""),format.raw/*63.50*/("""{"""),format.raw/*63.51*/("""
                    """),format.raw/*64.21*/("""// Display each video information
                    resultsDiv.innerHTML += `<p>$"""),format.raw/*65.50*/("""{"""),format.raw/*65.51*/("""j%10+1"""),format.raw/*65.57*/("""}"""),format.raw/*65.58*/(""". <strong>Title</strong>: <a href="$"""),format.raw/*65.94*/("""{"""),format.raw/*65.95*/("""searchResultsList[j].videoLink"""),format.raw/*65.125*/("""}"""),format.raw/*65.126*/("""">$"""),format.raw/*65.129*/("""{"""),format.raw/*65.130*/("""searchResultsList[j].title"""),format.raw/*65.156*/("""}"""),format.raw/*65.157*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Channel</strong>: <a href="$"""),format.raw/*66.82*/("""{"""),format.raw/*66.83*/("""searchResultsList[j].channelProfileLink"""),format.raw/*66.122*/("""}"""),format.raw/*66.123*/("""">$"""),format.raw/*66.126*/("""{"""),format.raw/*66.127*/("""searchResultsList[j].channelTitle"""),format.raw/*66.160*/("""}"""),format.raw/*66.161*/("""</a>, `
                    resultsDiv.innerHTML += `<strong>Description</strong>: "$"""),format.raw/*67.78*/("""{"""),format.raw/*67.79*/("""searchResultsList[j].description"""),format.raw/*67.111*/("""}"""),format.raw/*67.112*/("""", `
                    resultsDiv.innerHTML += `Flesh-Kincaid Grade Level= "$"""),format.raw/*68.75*/("""{"""),format.raw/*68.76*/("""searchResultsList[j].fkgl"""),format.raw/*68.101*/("""}"""),format.raw/*68.102*/("""", `
                    resultsDiv.innerHTML += `Flesh Reading Ease Score= "$"""),format.raw/*69.74*/("""{"""),format.raw/*69.75*/("""searchResultsList[j].fre"""),format.raw/*69.99*/("""}"""),format.raw/*69.100*/("""", `
                    resultsDiv.innerHTML += `<a href="">Tags</a></p>`
                    resultsDiv.innerHTML += `<img src="$"""),format.raw/*71.57*/("""{"""),format.raw/*71.58*/("""searchResultsList[j].thumbnailUrl"""),format.raw/*71.91*/("""}"""),format.raw/*71.92*/("""" alt="thumbnail">`
                """),format.raw/*72.17*/("""}"""),format.raw/*72.18*/("""
             """),format.raw/*73.14*/("""}"""),format.raw/*73.15*/("""
        """),format.raw/*74.9*/("""}"""),format.raw/*74.10*/(""";

        socket.onclose = function(event) """),format.raw/*76.42*/("""{"""),format.raw/*76.43*/("""
            """),format.raw/*77.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/(""";

        socket.onerror = function(error) """),format.raw/*80.42*/("""{"""),format.raw/*80.43*/("""
            """),format.raw/*81.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/(""";

        function sendKeyword() """),format.raw/*84.32*/("""{"""),format.raw/*84.33*/("""
            """),format.raw/*85.13*/("""let keyword = document.getElementById("keyword").value;
            allKeyword.unshift(keyword);
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*88.55*/("""{"""),format.raw/*88.56*/("""
                """),format.raw/*89.17*/("""socket.send(keyword);
            """),format.raw/*90.13*/("""}"""),format.raw/*90.14*/(""" """),format.raw/*90.15*/("""else """),format.raw/*90.20*/("""{"""),format.raw/*90.21*/("""
                """),format.raw/*91.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/("""
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/("""
    """),format.raw/*94.5*/("""</script>
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
                  HASH: a9875891caf01cb3471e322ca59032b5774038a4
                  MATRIX: 989->0|1486->469|1515->470|1557->484|1633->533|1662->534|1738->582|1767->583|1809->597|2421->1181|2450->1182|2496->1200|2553->1229|2582->1230|2632->1252|2763->1355|2792->1356|2846->1382|3410->1918|3439->1919|3609->2061|3638->2062|3682->2078|3711->2079|3838->2178|3867->2179|3913->2197|4066->2322|4095->2323|4136->2336|4165->2337|4194->2338|4273->2388|4303->2389|4346->2403|4376->2404|4456->2455|4486->2456|4528->2469|4558->2470|4693->2577|4722->2578|4772->2600|4884->2684|4913->2685|4947->2691|4976->2692|5040->2728|5069->2729|5128->2759|5158->2760|5190->2763|5220->2764|5275->2790|5305->2791|5423->2881|5452->2882|5520->2921|5550->2922|5582->2925|5612->2926|5674->2959|5704->2960|5818->3046|5847->3047|5908->3079|5938->3080|6046->3160|6075->3161|6129->3186|6159->3187|6266->3266|6295->3267|6347->3291|6377->3292|6538->3425|6567->3426|6628->3459|6657->3460|6722->3497|6751->3498|6794->3513|6823->3514|6860->3524|6889->3525|6963->3571|6992->3572|7034->3586|7154->3679|7183->3680|7257->3726|7286->3727|7328->3741|7413->3799|7442->3800|7506->3836|7535->3837|7577->3851|7815->4061|7844->4062|7890->4080|7953->4115|7982->4116|8011->4117|8044->4122|8073->4123|8119->4141|8227->4221|8256->4222|8293->4232|8322->4233|8355->4239
                  LINES: 32->1|47->16|47->16|48->17|49->18|49->18|51->20|51->20|52->21|67->36|67->36|68->37|68->37|68->37|69->38|70->39|70->39|71->40|81->50|81->50|85->54|85->54|86->55|86->55|89->58|89->58|90->59|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|91->60|94->63|94->63|95->64|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|96->65|97->66|97->66|97->66|97->66|97->66|97->66|97->66|97->66|98->67|98->67|98->67|98->67|99->68|99->68|99->68|99->68|100->69|100->69|100->69|100->69|102->71|102->71|102->71|102->71|103->72|103->72|104->73|104->73|105->74|105->74|107->76|107->76|108->77|109->78|109->78|111->80|111->80|112->81|113->82|113->82|115->84|115->84|116->85|119->88|119->88|120->89|121->90|121->90|121->90|121->90|121->90|122->91|123->92|123->92|124->93|124->93|125->94
                  -- GENERATED --
              */
          