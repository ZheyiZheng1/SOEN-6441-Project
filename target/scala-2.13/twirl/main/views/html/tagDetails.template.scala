
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

object tagDetails extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[services.YTResponse,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(videoDetails: services.YTResponse):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Video Details</title>

        <style>
                /* General Page Styling */
                body """),format.raw/*11.22*/("""{"""),format.raw/*11.23*/("""
                    """),format.raw/*12.21*/("""font-family: Arial, sans-serif;
                    line-height: 1.6;
                    color: #333;
                    margin: 0;
                    padding: 0;
                    background-color: #f9f9f9;
                """),format.raw/*18.17*/("""}"""),format.raw/*18.18*/("""
                """),format.raw/*19.17*/("""h1 """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/("""
                    """),format.raw/*20.21*/("""text-align: center;
                    margin: 20px 0;
                    color: #2c3e50;
                """),format.raw/*23.17*/("""}"""),format.raw/*23.18*/("""

                """),format.raw/*25.17*/("""/* Content Wrapper */
                div """),format.raw/*26.21*/("""{"""),format.raw/*26.22*/("""
                    """),format.raw/*27.21*/("""max-width: 800px;
                    margin: 20px auto;
                    padding: 20px;
                    background: #fff;
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                    border-radius: 8px;
                """),format.raw/*33.17*/("""}"""),format.raw/*33.18*/("""

                """),format.raw/*35.17*/("""/* Paragraph Styling */
                p """),format.raw/*36.19*/("""{"""),format.raw/*36.20*/("""
                    """),format.raw/*37.21*/("""margin: 10px 0;
                    font-size: 16px;
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""

                """),format.raw/*41.17*/("""/* Highlighted Text */
                strong """),format.raw/*42.24*/("""{"""),format.raw/*42.25*/("""
                    """),format.raw/*43.21*/("""color: #2c3e50;
                    font-weight: bold;
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""

                """),format.raw/*47.17*/("""/* Hyperlink Styling */
                a """),format.raw/*48.19*/("""{"""),format.raw/*48.20*/("""
                    """),format.raw/*49.21*/("""color: #2980b9;
                    text-decoration: none;
                    font-weight: bold;
                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/("""
                """),format.raw/*53.17*/("""a:hover """),format.raw/*53.25*/("""{"""),format.raw/*53.26*/("""
                    """),format.raw/*54.21*/("""text-decoration: underline;
                """),format.raw/*55.17*/("""}"""),format.raw/*55.18*/("""

                """),format.raw/*57.17*/("""/* Tags Section */
                .tags a """),format.raw/*58.25*/("""{"""),format.raw/*58.26*/("""
                    """),format.raw/*59.21*/("""display: inline-block;
                    margin: 5px;
                    padding: 5px 10px;
                    background: #ecf0f1;
                    border-radius: 15px;
                    color: #34495e;
                    font-size: 14px;
                    transition: background-color 0.3s ease, color 0.3s ease;
                """),format.raw/*67.17*/("""}"""),format.raw/*67.18*/("""
                """),format.raw/*68.17*/(""".tags a:hover """),format.raw/*68.31*/("""{"""),format.raw/*68.32*/("""
                    """),format.raw/*69.21*/("""background: #3498db;
                    color: #fff;
                """),format.raw/*71.17*/("""}"""),format.raw/*71.18*/("""

                """),format.raw/*73.17*/("""/* Loading Placeholder */
                #video-link, #channel-link """),format.raw/*74.44*/("""{"""),format.raw/*74.45*/("""
                    """),format.raw/*75.21*/("""font-style: italic;
                    color: #7f8c8d;
                """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/("""

                """),format.raw/*79.17*/("""/* Results Section */
                #results """),format.raw/*80.26*/("""{"""),format.raw/*80.27*/("""
                    """),format.raw/*81.21*/("""margin-top: 20px;
                    padding: 10px;
                    border: 1px solid #ddd;
                    border-radius: 5px;
                    background: #fcfcfc;
                    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
                """),format.raw/*87.17*/("""}"""),format.raw/*87.18*/("""

                """),format.raw/*89.17*/("""/* Footer Styling */
                footer """),format.raw/*90.24*/("""{"""),format.raw/*90.25*/("""
                    """),format.raw/*91.21*/("""text-align: center;
                    margin-top: 20px;
                    font-size: 14px;
                    color: #7f8c8d;
                """),format.raw/*95.17*/("""}"""),format.raw/*95.18*/("""
        """),format.raw/*96.9*/("""</style>

        <script>
                // Function to dynamically create video and channel links
                function renderLinks(videoId, channelId, channelTitle) """),format.raw/*100.72*/("""{"""),format.raw/*100.73*/("""
                    """),format.raw/*101.21*/("""let videoLink = `https://www.youtube.com/watch?v=$"""),format.raw/*101.71*/("""{"""),format.raw/*101.72*/("""videoId"""),format.raw/*101.79*/("""}"""),format.raw/*101.80*/("""`;
                    let channelLink = `https://www.youtube.com/channel/$"""),format.raw/*102.73*/("""{"""),format.raw/*102.74*/("""channelId"""),format.raw/*102.83*/("""}"""),format.raw/*102.84*/("""`;

                    // Update video link section
                    document.getElementById("video-link").innerHTML =
                            `<a href="$"""),format.raw/*106.40*/("""{"""),format.raw/*106.41*/("""videoLink"""),format.raw/*106.50*/("""}"""),format.raw/*106.51*/("""" target="_blank">Watch Video</a>`;

                    // Update channel link section
                    document.getElementById("channel-link").innerHTML =
                            `<a href="$"""),format.raw/*110.40*/("""{"""),format.raw/*110.41*/("""channelLink"""),format.raw/*110.52*/("""}"""),format.raw/*110.53*/("""" target="_blank">$"""),format.raw/*110.72*/("""{"""),format.raw/*110.73*/("""channelTitle"""),format.raw/*110.85*/("""}"""),format.raw/*110.86*/("""</a>`;
                """),format.raw/*111.17*/("""}"""),format.raw/*111.18*/("""

                """),format.raw/*113.17*/("""// Example data passed from the server
                let videoId = """"),_display_(/*114.33*/videoDetails/*114.45*/.getVideoId()),format.raw/*114.58*/("""";
                let channelId = """"),_display_(/*115.35*/videoDetails/*115.47*/.getChannelId()),format.raw/*115.62*/("""";
                let channelTitle = """"),_display_(/*116.38*/videoDetails/*116.50*/.getChannelTitle()),format.raw/*116.68*/("""";

                // Call renderLinks function on page load
                window.onload = () => """),format.raw/*119.39*/("""{"""),format.raw/*119.40*/("""
                    """),format.raw/*120.21*/("""if (videoId && channelId) """),format.raw/*120.47*/("""{"""),format.raw/*120.48*/("""
                        """),format.raw/*121.25*/("""renderLinks(videoId, channelId, channelTitle);
                    """),format.raw/*122.21*/("""}"""),format.raw/*122.22*/(""" """),format.raw/*122.23*/("""else """),format.raw/*122.28*/("""{"""),format.raw/*122.29*/("""
                        """),format.raw/*123.25*/("""console.error("Video ID or Channel ID is missing.");
                    """),format.raw/*124.21*/("""}"""),format.raw/*124.22*/("""
                """),format.raw/*125.17*/("""}"""),format.raw/*125.18*/(""";

                // Function to send a search request for a tag
                function searchByTag(tag) """),format.raw/*128.43*/("""{"""),format.raw/*128.44*/("""
                    """),format.raw/*129.21*/("""let socket = new WebSocket("ws://localhost:9000/search");
                    socket.onopen = function(event) """),format.raw/*130.53*/("""{"""),format.raw/*130.54*/("""
                        """),format.raw/*131.25*/("""console.log("WebSocket connection established.");
                        socket.send(tag); // Send the tag as the keyword
                    """),format.raw/*133.21*/("""}"""),format.raw/*133.22*/(""";

                    window.location.href = `/tagSearch?keyword=$"""),format.raw/*135.65*/("""{"""),format.raw/*135.66*/("""encodeURIComponent(tag)"""),format.raw/*135.89*/("""}"""),format.raw/*135.90*/("""`;

                    socket.onmessage = function(event) """),format.raw/*137.56*/("""{"""),format.raw/*137.57*/("""
                        """),format.raw/*138.25*/("""console.log("Received results for tag: " + tag);
                        // You can update the page dynamically if needed
                        document.getElementById("results").innerHTML = event.data;
                    """),format.raw/*141.21*/("""}"""),format.raw/*141.22*/(""";

                    socket.onerror = function(error) """),format.raw/*143.54*/("""{"""),format.raw/*143.55*/("""
                        """),format.raw/*144.25*/("""console.error("WebSocket error: " + error.message);
                    """),format.raw/*145.21*/("""}"""),format.raw/*145.22*/(""";

                    socket.onclose = function(event) """),format.raw/*147.54*/("""{"""),format.raw/*147.55*/("""
                        """),format.raw/*148.25*/("""console.log("WebSocket connection closed.");
                    """),format.raw/*149.21*/("""}"""),format.raw/*149.22*/(""";
                """),format.raw/*150.17*/("""}"""),format.raw/*150.18*/("""

                """),format.raw/*152.17*/("""socket.onmessage = function(event) """),format.raw/*152.52*/("""{"""),format.raw/*152.53*/("""
                    """),format.raw/*153.21*/("""console.log("Received results: " + event.data);
                    document.getElementById("results").innerHTML = event.data;
                """),format.raw/*155.17*/("""}"""),format.raw/*155.18*/(""";

        </script>
    </head>
    <body>
        <h1>Video Details</h1>
        <div>
                <!-- Title -->
            <p><strong>Title:</strong> """),_display_(/*163.41*/videoDetails/*163.53*/.getTitle()),format.raw/*163.64*/("""</p>

                <!-- Video Link -->
            <p id="video-link"><strong>Video Link:</strong> Loading...</p>

                <!-- Channel Link -->
            <p id="channel-link"><strong>Channel:</strong> Loading...</p>

                <!-- Description -->
            <p><strong>Description:</strong> """),_display_(/*172.47*/videoDetails/*172.59*/.getDescription()),format.raw/*172.76*/("""</p>

                <!-- Tags -->
            <p><strong>Tags:</strong>
                """),_display_(if(videoDetails.getTags() != null && !videoDetails.getTags().isEmpty)/*176.87*/ {_display_(Seq[Any](format.raw/*176.89*/("""
                    """),_display_(/*177.22*/for(tag <- videoDetails.getTags()) yield /*177.56*/ {_display_(Seq[Any](format.raw/*177.58*/("""
                        """),format.raw/*178.25*/("""<a href="javascript:void(0);" onclick="searchByTag('"""),_display_(/*178.78*/tag),format.raw/*178.81*/("""')">"""),_display_(/*178.86*/tag),format.raw/*178.89*/("""</a>
                    """)))}),format.raw/*179.22*/("""
                """)))}else/*180.24*/{_display_(Seq[Any](format.raw/*180.25*/("""
                    """),format.raw/*181.21*/("""<span>No tags available.</span>
                """)))}),format.raw/*182.18*/("""
            """),format.raw/*183.13*/("""</p>

            <div id="results"></div>

        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(videoDetails:services.YTResponse): play.twirl.api.HtmlFormat.Appendable = apply(videoDetails)

  def f:((services.YTResponse) => play.twirl.api.HtmlFormat.Appendable) = (videoDetails) => apply(videoDetails)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/tagDetails.scala.html
                  HASH: 3aff1084b982ed759883268880d1b5786a729e8f
                  MATRIX: 925->1|1055->36|1085->40|1314->241|1343->242|1393->264|1656->499|1685->500|1731->518|1762->521|1791->522|1841->544|1980->655|2009->656|2057->676|2128->719|2157->720|2207->742|2489->996|2518->997|2566->1017|2637->1060|2666->1061|2716->1083|2815->1154|2844->1155|2892->1175|2967->1222|2996->1223|3046->1245|3147->1318|3176->1319|3224->1339|3295->1382|3324->1383|3374->1405|3519->1522|3548->1523|3594->1541|3630->1549|3659->1550|3709->1572|3782->1617|3811->1618|3859->1638|3931->1682|3960->1683|4010->1705|4389->2056|4418->2057|4464->2075|4506->2089|4535->2090|4585->2112|4685->2184|4714->2185|4762->2205|4860->2275|4889->2276|4939->2298|5041->2372|5070->2373|5118->2393|5194->2441|5223->2442|5273->2464|5563->2726|5592->2727|5640->2747|5713->2792|5742->2793|5792->2815|5971->2966|6000->2967|6037->2977|6242->3153|6272->3154|6323->3176|6402->3226|6432->3227|6468->3234|6498->3235|6603->3311|6633->3312|6671->3321|6701->3322|6896->3488|6926->3489|6964->3498|6994->3499|7226->3702|7256->3703|7296->3714|7326->3715|7374->3734|7404->3735|7445->3747|7475->3748|7528->3772|7558->3773|7607->3793|7707->3865|7729->3877|7764->3890|7830->3928|7852->3940|7889->3955|7958->3996|7980->4008|8020->4026|8152->4129|8182->4130|8233->4152|8288->4178|8318->4179|8373->4205|8470->4273|8500->4274|8530->4275|8564->4280|8594->4281|8649->4307|8752->4381|8782->4382|8829->4400|8859->4401|8999->4512|9029->4513|9080->4535|9220->4646|9250->4647|9305->4673|9479->4818|9509->4819|9607->4888|9637->4889|9689->4912|9719->4913|9809->4974|9839->4975|9894->5001|10151->5229|10181->5230|10268->5288|10298->5289|10353->5315|10455->5388|10485->5389|10572->5447|10602->5448|10657->5474|10752->5540|10782->5541|10830->5560|10860->5561|10909->5581|10973->5616|11003->5617|11054->5639|11228->5784|11258->5785|11454->5953|11476->5965|11509->5976|11860->6299|11882->6311|11921->6328|12113->6492|12154->6494|12205->6517|12256->6551|12297->6553|12352->6579|12433->6632|12458->6635|12491->6640|12516->6643|12575->6670|12618->6695|12658->6696|12709->6718|12791->6768|12834->6782
                  LINES: 27->1|32->1|34->3|42->11|42->11|43->12|49->18|49->18|50->19|50->19|50->19|51->20|54->23|54->23|56->25|57->26|57->26|58->27|64->33|64->33|66->35|67->36|67->36|68->37|70->39|70->39|72->41|73->42|73->42|74->43|76->45|76->45|78->47|79->48|79->48|80->49|83->52|83->52|84->53|84->53|84->53|85->54|86->55|86->55|88->57|89->58|89->58|90->59|98->67|98->67|99->68|99->68|99->68|100->69|102->71|102->71|104->73|105->74|105->74|106->75|108->77|108->77|110->79|111->80|111->80|112->81|118->87|118->87|120->89|121->90|121->90|122->91|126->95|126->95|127->96|131->100|131->100|132->101|132->101|132->101|132->101|132->101|133->102|133->102|133->102|133->102|137->106|137->106|137->106|137->106|141->110|141->110|141->110|141->110|141->110|141->110|141->110|141->110|142->111|142->111|144->113|145->114|145->114|145->114|146->115|146->115|146->115|147->116|147->116|147->116|150->119|150->119|151->120|151->120|151->120|152->121|153->122|153->122|153->122|153->122|153->122|154->123|155->124|155->124|156->125|156->125|159->128|159->128|160->129|161->130|161->130|162->131|164->133|164->133|166->135|166->135|166->135|166->135|168->137|168->137|169->138|172->141|172->141|174->143|174->143|175->144|176->145|176->145|178->147|178->147|179->148|180->149|180->149|181->150|181->150|183->152|183->152|183->152|184->153|186->155|186->155|194->163|194->163|194->163|203->172|203->172|203->172|207->176|207->176|208->177|208->177|208->177|209->178|209->178|209->178|209->178|209->178|210->179|211->180|211->180|212->181|213->182|214->183
                  -- GENERATED --
              */
          