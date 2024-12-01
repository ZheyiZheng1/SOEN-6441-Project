
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
                            channelProfileLink: result.channelProfileLink,
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
                            resultsDiv.innerHTML += `<strong>Channel</strong>: <a href="$"""),format.raw/*78.90*/("""{"""),format.raw/*78.91*/("""searchResultsList[j].channelProfileLink"""),format.raw/*78.130*/("""}"""),format.raw/*78.131*/("""" target="_blank">$"""),format.raw/*78.150*/("""{"""),format.raw/*78.151*/("""searchResultsList[j].channelTitle"""),format.raw/*78.184*/("""}"""),format.raw/*78.185*/("""</a>, `;
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

    """),format.raw/*123.5*/("""</script>
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
                  HASH: e5aeb6d159c9cf42c898aba6431586348d0c233a
                  MATRIX: 989->0|1531->514|1560->515|1602->529|1678->578|1707->579|1783->627|1812->628|1854->642|1985->745|2014->746|2060->764|2179->855|2208->856|2237->857|2270->862|2299->863|2347->883|3106->1614|3135->1615|3185->1637|3242->1666|3271->1667|3325->1693|3460->1800|3489->1801|3547->1831|4208->2464|4237->2465|4419->2619|4448->2620|4496->2640|4525->2641|4659->2747|4688->2748|4738->2770|4895->2899|4924->2900|4965->2913|4994->2914|5023->2915|5073->2936|5103->2937|5145->2950|5175->2951|5267->3015|5296->3016|5336->3028|5365->3029|5444->3080|5473->3081|5516->3095|5546->3096|5626->3147|5656->3148|5698->3161|5728->3162|5880->3286|5909->3287|5963->3313|6017->3339|6046->3340|6075->3341|6187->3425|6216->3426|6254->3436|6283->3437|6348->3473|6378->3474|6437->3504|6467->3505|6515->3524|6545->3525|6600->3551|6630->3552|6757->3651|6786->3652|6854->3691|6884->3692|6932->3711|6962->3712|7024->3745|7054->3746|7177->3841|7206->3842|7267->3874|7297->3875|7414->3964|7443->3965|7497->3990|7527->3991|7643->4079|7672->4080|7725->4104|7755->4105|7875->4197|7904->4198|7961->4226|7991->4227|8105->4313|8134->4314|8196->4347|8226->4348|8300->4394|8329->4395|8379->4417|8408->4418|8454->4436|8483->4437|8525->4451|8554->4452|8591->4462|8620->4463|8694->4509|8723->4510|8765->4524|8885->4617|8914->4618|8988->4664|9017->4665|9059->4679|9144->4737|9173->4738|9238->4774|9268->4775|9311->4789|9550->4999|9580->5000|9627->5018|9691->5053|9721->5054|9751->5055|9785->5060|9815->5061|9862->5079|9971->5159|10001->5160|10039->5170|10069->5171|10109->5183|10330->5375|10360->5376|10403->5390|10585->5543|10615->5544|10674->5574|10704->5575|10736->5578|10766->5579|10805->5589|10835->5590|10958->5684|10988->5685|11025->5693|11055->5694|11099->5710|11129->5711|11165->5719
                  LINES: 32->1|48->17|48->17|49->18|50->19|50->19|52->21|52->21|53->22|55->24|55->24|56->25|58->27|58->27|58->27|58->27|58->27|60->29|77->46|77->46|78->47|78->47|78->47|79->48|80->49|80->49|81->50|92->61|92->61|96->65|96->65|97->66|97->66|100->69|100->69|101->70|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|102->71|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|103->72|106->75|106->75|107->76|107->76|107->76|107->76|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|108->77|109->78|109->78|109->78|109->78|109->78|109->78|109->78|109->78|110->79|110->79|110->79|110->79|111->80|111->80|111->80|111->80|112->81|112->81|112->81|112->81|114->83|114->83|114->83|114->83|116->85|116->85|116->85|116->85|117->86|117->86|118->87|118->87|119->88|119->88|120->89|120->89|121->90|121->90|123->92|123->92|124->93|125->94|125->94|127->96|127->96|128->97|129->98|129->98|131->100|131->100|132->101|135->104|135->104|136->105|137->106|137->106|137->106|137->106|137->106|138->107|139->108|139->108|140->109|140->109|142->111|146->115|146->115|147->116|149->118|149->118|149->118|149->118|149->118|149->118|149->118|149->118|151->120|151->120|151->120|151->120|152->121|152->121|154->123
                  -- GENERATED --
              */
          