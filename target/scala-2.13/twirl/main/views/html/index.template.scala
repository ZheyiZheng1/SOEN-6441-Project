
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

            if (event.data.startsWith("Tags:")) """),format.raw/*24.49*/("""{"""),format.raw/*24.50*/("""
                """),format.raw/*25.17*/("""let tagData = event.data.substring(5);
                displayTags(tagData);
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/(""" """),format.raw/*27.15*/("""else """),format.raw/*27.20*/("""{"""),format.raw/*27.21*/("""

                """),format.raw/*29.17*/("""// Clear previous results from result div
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
                data.searchResults.forEach(resultList => """),format.raw/*46.58*/("""{"""),format.raw/*46.59*/("""
                    """),format.raw/*47.21*/("""resultList.forEach(result => """),format.raw/*47.50*/("""{"""),format.raw/*47.51*/("""
                        """),format.raw/*48.25*/("""// Create an object for each result that contains all information
                        let resultObj = """),format.raw/*49.41*/("""{"""),format.raw/*49.42*/("""
                            """),format.raw/*50.29*/("""title: result.title,
                            videoID: result.videoID,
                            videoLink: result.videoLink,
                            channelTitle: result.channelTitle,
                            channelID: result.channelID,
                            channelProfileLink: result.channelID,
                            description: result.description,
                            thumbnailUrl: result.thumbnailUrl,
                            fkgl: result.fkgl,
                            fre: result.fre,
                            // tags: result.tags || [],
                        """),format.raw/*61.25*/("""}"""),format.raw/*61.26*/(""";

                        // Add the result object to the resultsList
                        searchResultsList.push(resultObj);
                    """),format.raw/*65.21*/("""}"""),format.raw/*65.22*/(""");
                """),format.raw/*66.17*/("""}"""),format.raw/*66.18*/(""");

                // Display all results
                for (let i = 0; i < allKeyword.length; i++) """),format.raw/*69.61*/("""{"""),format.raw/*69.62*/("""
                    """),format.raw/*70.21*/("""// Display the search term, average FKGL and FRE
                    resultsDiv.innerHTML += `<p><strong>Search Term:</strong> $"""),format.raw/*71.80*/("""{"""),format.raw/*71.81*/("""allKeyword[i]"""),format.raw/*71.94*/("""}"""),format.raw/*71.95*/(""" """),format.raw/*71.96*/("""<a href="/wordstats/$"""),format.raw/*71.117*/("""{"""),format.raw/*71.118*/("""allKeyword[i]"""),format.raw/*71.131*/("""}"""),format.raw/*71.132*/("""" target="_blank">Word Stats</a>
 <strong>Sentiment:</strong> $"""),format.raw/*72.31*/("""{"""),format.raw/*72.32*/("""sentiment[0]"""),format.raw/*72.44*/("""}"""),format.raw/*72.45*/(""",<strong>Flesh-Kincaid Grade Level Avg.:</strong> $"""),format.raw/*72.96*/("""{"""),format.raw/*72.97*/("""avgFKGLList[i]"""),format.raw/*72.111*/("""}"""),format.raw/*72.112*/(""", <strong>Flesh Reading Ease Score Avg.:</strong> $"""),format.raw/*72.163*/("""{"""),format.raw/*72.164*/("""avgFREList[i]"""),format.raw/*72.177*/("""}"""),format.raw/*72.178*/("""</p>`;

                    // Display each search result
                    for (let j = i * 10; j < i * 10 + 10; j++) """),format.raw/*75.64*/("""{"""),format.raw/*75.65*/("""
                        """),format.raw/*76.25*/("""if (searchResultsList[j]) """),format.raw/*76.51*/("""{"""),format.raw/*76.52*/(""" """),format.raw/*76.53*/("""// Check if result exists
                            resultsDiv.innerHTML += `<p>$"""),format.raw/*77.58*/("""{"""),format.raw/*77.59*/("""j % 10 + 1"""),format.raw/*77.69*/("""}"""),format.raw/*77.70*/(""". <strong>Title</strong>: <a href="$"""),format.raw/*77.106*/("""{"""),format.raw/*77.107*/("""searchResultsList[j].videoLink"""),format.raw/*77.137*/("""}"""),format.raw/*77.138*/("""" target="_blank">$"""),format.raw/*77.157*/("""{"""),format.raw/*77.158*/("""searchResultsList[j].title"""),format.raw/*77.184*/("""}"""),format.raw/*77.185*/("""</a>, `;
                            resultsDiv.innerHTML += `<strong>Channel</strong>: <a href="/ChannelProfile/$"""),format.raw/*78.106*/("""{"""),format.raw/*78.107*/("""searchResultsList[j].channelProfileLink"""),format.raw/*78.146*/("""}"""),format.raw/*78.147*/("""" target="_blank">$"""),format.raw/*78.166*/("""{"""),format.raw/*78.167*/("""searchResultsList[j].channelTitle"""),format.raw/*78.200*/("""}"""),format.raw/*78.201*/("""</a>, `;
                            resultsDiv.innerHTML += `<strong>Description</strong>: "$"""),format.raw/*79.86*/("""{"""),format.raw/*79.87*/("""searchResultsList[j].description"""),format.raw/*79.119*/("""}"""),format.raw/*79.120*/("""", `;
                            resultsDiv.innerHTML += `Flesh-Kincaid Grade Level= "$"""),format.raw/*80.83*/("""{"""),format.raw/*80.84*/("""searchResultsList[j].fkgl"""),format.raw/*80.109*/("""}"""),format.raw/*80.110*/("""", `;
                            resultsDiv.innerHTML += `Flesh Reading Ease Score= "$"""),format.raw/*81.82*/("""{"""),format.raw/*81.83*/("""searchResultsList[j].fre"""),format.raw/*81.107*/("""}"""),format.raw/*81.108*/("""", `;

                            resultsDiv.innerHTML += `<a href="/tagDetails?videoId=$"""),format.raw/*83.84*/("""{"""),format.raw/*83.85*/("""searchResultsList[j].videoID"""),format.raw/*83.113*/("""}"""),format.raw/*83.114*/(""""> Tags </a>`;

                            resultsDiv.innerHTML += `</p><img src="$"""),format.raw/*85.69*/("""{"""),format.raw/*85.70*/("""searchResultsList[j].thumbnailUrl"""),format.raw/*85.103*/("""}"""),format.raw/*85.104*/("""" alt="thumbnail">`;
                        """),format.raw/*86.25*/("""}"""),format.raw/*86.26*/("""
                    """),format.raw/*87.21*/("""}"""),format.raw/*87.22*/("""
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/("""
            """),format.raw/*89.13*/("""}"""),format.raw/*89.14*/("""
        """),format.raw/*90.9*/("""}"""),format.raw/*90.10*/(""";

        socket.onclose = function(event) """),format.raw/*92.42*/("""{"""),format.raw/*92.43*/("""
            """),format.raw/*93.13*/("""console.log("Connection closed. Code: " + event.code + " Reason: " + event.reason);
        """),format.raw/*94.9*/("""}"""),format.raw/*94.10*/(""";

        socket.onerror = function(error) """),format.raw/*96.42*/("""{"""),format.raw/*96.43*/("""
            """),format.raw/*97.13*/("""console.log("Error occurred: " + error.message);
        """),format.raw/*98.9*/("""}"""),format.raw/*98.10*/(""";

        function sendKeyword() """),format.raw/*100.32*/("""{"""),format.raw/*100.33*/("""
            """),format.raw/*101.13*/("""let keyword = document.getElementById("keyword").value;
            allKeyword.unshift(keyword);
            console.log("Sending keyword: " + keyword);
            if (socket.readyState === WebSocket.OPEN) """),format.raw/*104.55*/("""{"""),format.raw/*104.56*/("""
                """),format.raw/*105.17*/("""socket.send(keyword);
            """),format.raw/*106.13*/("""}"""),format.raw/*106.14*/(""" """),format.raw/*106.15*/("""else """),format.raw/*106.20*/("""{"""),format.raw/*106.21*/("""
                """),format.raw/*107.17*/("""console.log("WebSocket is not open. State: " + socket.readyState);
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/("""
        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/("""

        """),format.raw/*111.9*/("""/**
         * Displays the tags in the dedicated tags section.
         * tagData - The HTML-formatted tags received from the WebSocket.
         */
        function displayTags(tagData) """),format.raw/*115.39*/("""{"""),format.raw/*115.40*/("""
            """),format.raw/*116.13*/("""let tagsDiv = document.getElementById("tags");
            let tagsHTML = tagData.split(',').map(tag =>
                    `<a href="/tagdetails?tag=$"""),format.raw/*118.48*/("""{"""),format.raw/*118.49*/("""encodeURIComponent(tag.trim())"""),format.raw/*118.79*/("""}"""),format.raw/*118.80*/("""">$"""),format.raw/*118.83*/("""{"""),format.raw/*118.84*/("""tag.trim()"""),format.raw/*118.94*/("""}"""),format.raw/*118.95*/("""</a>`
            ).join(", ");
            tagsDiv.innerHTML = `<p><strong>Tags:</strong> $"""),format.raw/*120.61*/("""{"""),format.raw/*120.62*/("""tagsHTML"""),format.raw/*120.70*/("""}"""),format.raw/*120.71*/("""</p>`;
        """),format.raw/*121.9*/("""}"""),format.raw/*121.10*/("""

        """),format.raw/*123.9*/("""/**
         * Displays the Channelprofile
         * connectChannelprofile
         */
        function connectChannelProfile(channelID) """),format.raw/*127.51*/("""{"""),format.raw/*127.52*/("""
            """),format.raw/*128.13*/("""let socket = new WebSocket(`ws://localhost:9000/ChannelProfile/$"""),format.raw/*128.77*/("""{"""),format.raw/*128.78*/("""channelID"""),format.raw/*128.87*/("""}"""),format.raw/*128.88*/("""/ws`);

            socket.onopen = function (event) """),format.raw/*130.46*/("""{"""),format.raw/*130.47*/("""
                """),format.raw/*131.17*/("""console.log(`WebSocket connection established for channel: $"""),format.raw/*131.77*/("""{"""),format.raw/*131.78*/("""channelID"""),format.raw/*131.87*/("""}"""),format.raw/*131.88*/("""`);
            """),format.raw/*132.13*/("""}"""),format.raw/*132.14*/(""";

            socket.onmessage = function (event) """),format.raw/*134.49*/("""{"""),format.raw/*134.50*/("""
                """),format.raw/*135.17*/("""console.log("Received channel profile data: " + event.data);

                // Display channel profile data
                let profileDiv = document.getElementById("channelProfile");
                profileDiv.innerHTML = `<h2>Channel Profile for $"""),format.raw/*139.66*/("""{"""),format.raw/*139.67*/("""channelID"""),format.raw/*139.76*/("""}"""),format.raw/*139.77*/("""</h2><pre>$"""),format.raw/*139.88*/("""{"""),format.raw/*139.89*/("""event.data"""),format.raw/*139.99*/("""}"""),format.raw/*139.100*/("""</pre>`;
            """),format.raw/*140.13*/("""}"""),format.raw/*140.14*/(""";

            socket.onclose = function (event) """),format.raw/*142.47*/("""{"""),format.raw/*142.48*/("""
                """),format.raw/*143.17*/("""console.log(`WebSocket connection closed for channel: $"""),format.raw/*143.72*/("""{"""),format.raw/*143.73*/("""channelID"""),format.raw/*143.82*/("""}"""),format.raw/*143.83*/(""". Code: $"""),format.raw/*143.92*/("""{"""),format.raw/*143.93*/("""event.code"""),format.raw/*143.103*/("""}"""),format.raw/*143.104*/("""`);
            """),format.raw/*144.13*/("""}"""),format.raw/*144.14*/(""";

            socket.onerror = function (error) """),format.raw/*146.47*/("""{"""),format.raw/*146.48*/("""
                """),format.raw/*147.17*/("""console.error(`WebSocket error for channel $"""),format.raw/*147.61*/("""{"""),format.raw/*147.62*/("""channelID"""),format.raw/*147.71*/("""}"""),format.raw/*147.72*/(""": `, error);
            """),format.raw/*148.13*/("""}"""),format.raw/*148.14*/(""";
        """),format.raw/*149.9*/("""}"""),format.raw/*149.10*/("""

    """),format.raw/*151.5*/("""</script>
    </head>
    <body>
        <h1>Welcome to the YT lytics</h1>
        <input type="text" id="keyword" placeholder="Enter keyword">
        <button onclick="sendKeyword()">Search</button>
        <div id="results"></div>
        <div id="tags"></div>
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
                  HASH: 44bd6ad2672b9235918acac95d923202cd18b7e7
                  MATRIX: 989->0|1531->514|1560->515|1602->529|1678->578|1707->579|1783->627|1812->628|1854->642|1985->745|2014->746|2060->764|2179->855|2208->856|2237->857|2270->862|2299->863|2347->883|3106->1614|3135->1615|3185->1637|3242->1666|3271->1667|3325->1693|3460->1800|3489->1801|3547->1831|4199->2455|4228->2456|4410->2610|4439->2611|4487->2631|4516->2632|4650->2738|4679->2739|4729->2761|4886->2890|4915->2891|4956->2904|4985->2905|5014->2906|5064->2927|5094->2928|5136->2941|5166->2942|5258->3006|5287->3007|5327->3019|5356->3020|5435->3071|5464->3072|5507->3086|5537->3087|5617->3138|5647->3139|5689->3152|5719->3153|5871->3277|5900->3278|5954->3304|6008->3330|6037->3331|6066->3332|6178->3416|6207->3417|6245->3427|6274->3428|6339->3464|6369->3465|6428->3495|6458->3496|6506->3515|6536->3516|6591->3542|6621->3543|6765->3658|6795->3659|6863->3698|6893->3699|6941->3718|6971->3719|7033->3752|7063->3753|7186->3848|7215->3849|7276->3881|7306->3882|7423->3971|7452->3972|7506->3997|7536->3998|7652->4086|7681->4087|7734->4111|7764->4112|7884->4204|7913->4205|7970->4233|8000->4234|8114->4320|8143->4321|8205->4354|8235->4355|8309->4401|8338->4402|8388->4424|8417->4425|8463->4443|8492->4444|8534->4458|8563->4459|8600->4469|8629->4470|8703->4516|8732->4517|8774->4531|8894->4624|8923->4625|8997->4671|9026->4672|9068->4686|9153->4744|9182->4745|9247->4781|9277->4782|9320->4796|9559->5006|9589->5007|9636->5025|9700->5060|9730->5061|9760->5062|9794->5067|9824->5068|9871->5086|9980->5166|10010->5167|10048->5177|10078->5178|10118->5190|10339->5382|10369->5383|10412->5397|10594->5550|10624->5551|10683->5581|10713->5582|10745->5585|10775->5586|10814->5596|10844->5597|10967->5691|10997->5692|11034->5700|11064->5701|11108->5717|11138->5718|11178->5730|11349->5872|11379->5873|11422->5887|11515->5951|11545->5952|11583->5961|11613->5962|11697->6017|11727->6018|11774->6036|11863->6096|11893->6097|11931->6106|11961->6107|12007->6124|12037->6125|12119->6178|12149->6179|12196->6197|12480->6452|12510->6453|12548->6462|12578->6463|12618->6474|12648->6475|12687->6485|12718->6486|12769->6508|12799->6509|12879->6560|12909->6561|12956->6579|13040->6634|13070->6635|13108->6644|13138->6645|13176->6654|13206->6655|13246->6665|13277->6666|13323->6683|13353->6684|13433->6735|13463->6736|13510->6754|13583->6798|13613->6799|13651->6808|13681->6809|13736->6835|13766->6836|13805->6847|13835->6848|13871->6856
                  LINES: 32->1|48->17|48->17|49->18|50->19|50->19|52->21|52->21|53->22|55->24|55->24|56->25|58->27|58->27|58->27|58->27|58->27|60->29|77->46|77->46|78->47|78->47|78->47|79->48|80->49|80->49|81->50|92->61|92->61|96->65|96->65|97->66|97->66|100->69|100->69|101->70|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|106->75|106->75|107->76|107->76|107->76|107->76|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|109->78|109->78|109->78|109->78|109->78|109->78|109->78|109->78|110->79|110->79|110->79|110->79|111->80|111->80|111->80|111->80|112->81|112->81|112->81|112->81|114->83|114->83|114->83|114->83|116->85|116->85|116->85|116->85|117->86|117->86|118->87|118->87|119->88|119->88|120->89|120->89|121->90|121->90|123->92|123->92|124->93|125->94|125->94|127->96|127->96|128->97|129->98|129->98|131->100|131->100|132->101|135->104|135->104|136->105|137->106|137->106|137->106|137->106|137->106|138->107|139->108|139->108|140->109|140->109|142->111|146->115|146->115|147->116|149->118|149->118|149->118|149->118|149->118|149->118|149->118|149->118|151->120|151->120|151->120|151->120|152->121|152->121|154->123|158->127|158->127|159->128|159->128|159->128|159->128|159->128|161->130|161->130|162->131|162->131|162->131|162->131|162->131|163->132|163->132|165->134|165->134|166->135|170->139|170->139|170->139|170->139|170->139|170->139|170->139|170->139|171->140|171->140|173->142|173->142|174->143|174->143|174->143|174->143|174->143|174->143|174->143|174->143|174->143|175->144|175->144|177->146|177->146|178->147|178->147|178->147|178->147|178->147|179->148|179->148|180->149|180->149|182->151
                  -- GENERATED --
              */
          