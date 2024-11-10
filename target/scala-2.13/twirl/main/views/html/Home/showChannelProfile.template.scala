
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
/*3.2*/import services.ChannelProfile
/*4.2*/import services.Video

object showChannelProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[ChannelProfile,List[Video],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(channelProfile: ChannelProfile, last10Videos: List[Video]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.61*/("""

"""),format.raw/*8.1*/("""<!-- Sakshi Mulik - 40295793 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Channel Profile</title>
    <style>
            body """),format.raw/*16.18*/("""{"""),format.raw/*16.19*/(""" """),format.raw/*16.20*/("""font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; """),format.raw/*16.102*/("""}"""),format.raw/*16.103*/("""
            """),format.raw/*17.13*/("""header, footer """),format.raw/*17.28*/("""{"""),format.raw/*17.29*/(""" """),format.raw/*17.30*/("""background-color: #1b1717; color: #fff; padding: 1rem; text-align: center; """),format.raw/*17.105*/("""}"""),format.raw/*17.106*/("""
            """),format.raw/*18.13*/(""".container """),format.raw/*18.24*/("""{"""),format.raw/*18.25*/(""" """),format.raw/*18.26*/("""max-width: 800px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 4px 8px rgb(40, 96, 156); """),format.raw/*18.162*/("""}"""),format.raw/*18.163*/("""
            """),format.raw/*19.13*/(""".channel-info h2 """),format.raw/*19.30*/("""{"""),format.raw/*19.31*/(""" """),format.raw/*19.32*/("""color: #333; font-size: 1.5em; """),format.raw/*19.63*/("""}"""),format.raw/*19.64*/("""
            """),format.raw/*20.13*/(""".videos-section h3 """),format.raw/*20.32*/("""{"""),format.raw/*20.33*/(""" """),format.raw/*20.34*/("""color: #666; font-size: 1.3em; margin-bottom: 10px; """),format.raw/*20.86*/("""}"""),format.raw/*20.87*/("""
            """),format.raw/*21.13*/(""".video-item """),format.raw/*21.25*/("""{"""),format.raw/*21.26*/(""" """),format.raw/*21.27*/("""padding: 10px 0; border-bottom: 1px solid #ddd; """),format.raw/*21.75*/("""}"""),format.raw/*21.76*/("""
            """),format.raw/*22.13*/(""".video-item a """),format.raw/*22.27*/("""{"""),format.raw/*22.28*/(""" """),format.raw/*22.29*/("""color: #28609c; text-decoration: none; """),format.raw/*22.68*/("""}"""),format.raw/*22.69*/("""
            """),format.raw/*23.13*/(""".video-item a:hover """),format.raw/*23.33*/("""{"""),format.raw/*23.34*/(""" """),format.raw/*23.35*/("""text-decoration: underline; """),format.raw/*23.63*/("""}"""),format.raw/*23.64*/("""
    """),format.raw/*24.5*/("""</style>
  </head>
  <body>
    <header>
      <h1>Channel Profile</h1>
    </header>
      <!-- Sakshi Mulik - 40295793 -->
    <div class="container">
        <!-- Channel Details Section -->
      <div class="channel-info">
        <h2>Channel Details</h2>

          <!-- Displaying Title with fallback text if title is null -->
        <p><strong>Title:</strong>
            <!-- Display the channel title here -->
          """),_display_(if(channelProfile.getTitle() != null && !channelProfile.getTitle().isEmpty())/*39.89*/ {_display_(Seq[Any](format.raw/*39.91*/("""
            """),format.raw/*40.13*/("""<a href=""""),_display_(/*40.23*/channelProfile/*40.37*/.getYoutubeLink()),format.raw/*40.54*/("""" target="_blank">"""),_display_(/*40.73*/channelProfile/*40.87*/.getTitle()),format.raw/*40.98*/("""</a>
          """)))}else/*41.18*/{_display_(Seq[Any](format.raw/*41.19*/("""
            """),format.raw/*42.13*/("""<span>Title Not Available</span>
          """)))}),format.raw/*43.12*/("""
          """),format.raw/*44.11*/("""</p>


          <!-- Displaying Description -->
        <p><strong>Description:</strong>
          """),_display_(if(channelProfile.getDescription() != null && !channelProfile.getDescription().isEmpty())/*49.101*/ {_display_(Seq[Any](format.raw/*49.103*/("""
            """),_display_(/*50.14*/channelProfile/*50.28*/.getDescription()),format.raw/*50.45*/("""
          """)))}else/*51.18*/{_display_(Seq[Any](format.raw/*51.19*/("""
            """),format.raw/*52.13*/("""<span>Not Available</span>
          """)))}),format.raw/*53.12*/("""
        """),format.raw/*54.9*/("""</p>

          <!-- Displaying Country -->
        <p><strong>Country:</strong>
          """),_display_(if(channelProfile.getCountry() != null && !channelProfile.getCountry().isEmpty())/*58.93*/ {_display_(Seq[Any](format.raw/*58.95*/("""
            """),_display_(/*59.14*/channelProfile/*59.28*/.getCountry()),format.raw/*59.41*/("""
          """)))}else/*60.18*/{_display_(Seq[Any](format.raw/*60.19*/("""
            """),format.raw/*61.13*/("""<span>Not Available</span>
          """)))}),format.raw/*62.12*/("""
        """),format.raw/*63.9*/("""</p>

          <!-- Displaying Video Count -->
        <p><strong>Video Count:</strong> """),_display_(/*66.43*/channelProfile/*66.57*/.getVideoCount()),format.raw/*66.73*/("""</p>

          <!-- Displaying YouTube Link -->
        <p><strong>YouTube Link:</strong>
          """),_display_(if(channelProfile.getYoutubeLink() != null && !channelProfile.getYoutubeLink().isEmpty())/*70.101*/ {_display_(Seq[Any](format.raw/*70.103*/("""
            """),format.raw/*71.13*/("""<a href=""""),_display_(/*71.23*/channelProfile/*71.37*/.getYoutubeLink()),format.raw/*71.54*/("""" target="_blank">"""),_display_(/*71.73*/channelProfile/*71.87*/.getYoutubeLink()),format.raw/*71.104*/("""</a>
          """)))}else/*72.18*/{_display_(Seq[Any](format.raw/*72.19*/("""
            """),format.raw/*73.13*/("""<span>Not Available</span>
          """)))}),format.raw/*74.12*/("""
        """),format.raw/*75.9*/("""</p>

          <!-- Displaying Thumbnail -->
        <p><strong>Thumbnail:</strong><br>
          """),_display_(if(channelProfile.getThumbnailUrl() != null && !channelProfile.getThumbnailUrl().isEmpty())/*79.103*/ {_display_(Seq[Any](format.raw/*79.105*/("""
            """),format.raw/*80.13*/("""<img src=""""),_display_(/*80.24*/channelProfile/*80.38*/.getThumbnailUrl()),format.raw/*80.56*/("""" alt="Channel Thumbnail" style="width:100%; max-width:300px;"/>
          """)))}else/*81.18*/{_display_(Seq[Any](format.raw/*81.19*/("""
            """),format.raw/*82.13*/("""<span>No Thumbnail Available</span>
          """)))}),format.raw/*83.12*/("""
        """),format.raw/*84.9*/("""</p>
      </div>

        <!-- Last 10 Videos Section -->
      <div class="videos-section">
        <h3>Last 10 Videos</h3>
        """),_display_(if(last10Videos != null && !last10Videos.isEmpty())/*90.61*/ {_display_(Seq[Any](format.raw/*90.63*/("""
          """),_display_(/*91.12*/for(video <- last10Videos) yield /*91.38*/ {_display_(Seq[Any](format.raw/*91.40*/("""
            """),format.raw/*92.13*/("""<div class="video-item">
              <h4>
              """),_display_(if(video.getVideoUrl() != null && !video.getVideoUrl().isEmpty())/*94.81*/ {_display_(Seq[Any](format.raw/*94.83*/("""
                """),format.raw/*95.17*/("""<a href=""""),_display_(/*95.27*/video/*95.32*/.getVideoUrl()),format.raw/*95.46*/("""" target="_blank">"""),_display_(/*95.65*/video/*95.70*/.getTitle()),format.raw/*95.81*/("""</a>
              """)))}else/*96.22*/{_display_(Seq[Any](format.raw/*96.23*/("""
                """),format.raw/*97.17*/("""<span>"""),_display_(/*97.24*/video/*97.29*/.getTitle()),format.raw/*97.40*/("""</span>
              """)))}),format.raw/*98.16*/("""
              """),format.raw/*99.15*/("""</h4>
              <p>"""),_display_(/*100.19*/video/*100.24*/.getDescription()),format.raw/*100.41*/("""</p>
              """),_display_(if(video.getThumbnailUrl() != null && !video.getThumbnailUrl().isEmpty())/*101.89*/ {_display_(Seq[Any](format.raw/*101.91*/("""
                """),format.raw/*102.17*/("""<img src=""""),_display_(/*102.28*/video/*102.33*/.getThumbnailUrl),format.raw/*102.49*/("""" alt="Video Thumbnail" style="width:100%; max-width:300px;"/>
              """)))}else/*103.22*/{_display_(Seq[Any](format.raw/*103.23*/("""
                """),format.raw/*104.17*/("""<span>No Thumbnail Available</span>
              """)))}),format.raw/*105.16*/("""
            """),format.raw/*106.13*/("""</div>
          """)))}),format.raw/*107.12*/("""
        """)))}else/*108.16*/{_display_(Seq[Any](format.raw/*108.17*/("""
          """),format.raw/*109.11*/("""<p>No videos available for this channel.</p>
        """)))}),format.raw/*110.10*/("""
      """),format.raw/*111.7*/("""</div>
    </div>
  </body>
</html>
"""))
      }
    }
  }

  def render(channelProfile:ChannelProfile,last10Videos:List[Video]): play.twirl.api.HtmlFormat.Appendable = apply(channelProfile,last10Videos)

  def f:((ChannelProfile,List[Video]) => play.twirl.api.HtmlFormat.Appendable) = (channelProfile,last10Videos) => apply(channelProfile,last10Videos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Home/showChannelProfile.scala.html
                  HASH: 9f9fe7c067506171650c94ca1517afa069024bac
                  MATRIX: 615->5|653->38|1012->64|1166->123|1196->127|1473->376|1502->377|1531->378|1642->460|1672->461|1714->475|1757->490|1786->491|1815->492|1919->567|1949->568|1991->582|2030->593|2059->594|2088->595|2253->731|2283->732|2325->746|2370->763|2399->764|2428->765|2487->796|2516->797|2558->811|2605->830|2634->831|2663->832|2743->884|2772->885|2814->899|2854->911|2883->912|2912->913|2988->961|3017->962|3059->976|3101->990|3130->991|3159->992|3226->1031|3255->1032|3297->1046|3345->1066|3374->1067|3403->1068|3459->1096|3488->1097|3521->1103|4071->1626|4111->1628|4153->1642|4190->1652|4213->1666|4251->1683|4297->1702|4320->1716|4352->1727|4392->1750|4431->1751|4473->1765|4549->1810|4589->1822|4812->2017|4853->2019|4895->2034|4918->2048|4956->2065|4992->2084|5031->2085|5073->2099|5143->2138|5180->2148|5384->2325|5424->2327|5466->2342|5489->2356|5523->2369|5559->2388|5598->2389|5640->2403|5710->2442|5747->2452|5867->2545|5890->2559|5927->2575|6150->2770|6191->2772|6233->2786|6270->2796|6293->2810|6331->2827|6377->2846|6400->2860|6439->2877|6479->2900|6518->2901|6560->2915|6630->2954|6667->2964|6890->3159|6931->3161|6973->3175|7011->3186|7034->3200|7073->3218|7173->3301|7212->3302|7254->3316|7333->3364|7370->3374|7589->3566|7629->3568|7669->3581|7711->3607|7751->3609|7793->3623|7946->3749|7986->3751|8032->3769|8069->3779|8083->3784|8118->3798|8164->3817|8178->3822|8210->3833|8254->3860|8293->3861|8339->3879|8373->3886|8387->3891|8419->3902|8474->3926|8518->3942|8571->3967|8586->3972|8625->3989|8747->4083|8788->4085|8835->4103|8874->4114|8889->4119|8927->4135|9030->4220|9070->4221|9117->4239|9201->4291|9244->4305|9295->4324|9330->4341|9370->4342|9411->4354|9498->4409|9534->4417
                  LINES: 23->3|24->4|29->6|34->6|36->8|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|52->24|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|70->42|71->43|72->44|77->49|77->49|78->50|78->50|78->50|79->51|79->51|80->52|81->53|82->54|86->58|86->58|87->59|87->59|87->59|88->60|88->60|89->61|90->62|91->63|94->66|94->66|94->66|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|101->73|102->74|103->75|107->79|107->79|108->80|108->80|108->80|108->80|109->81|109->81|110->82|111->83|112->84|118->90|118->90|119->91|119->91|119->91|120->92|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|125->97|125->97|125->97|125->97|126->98|127->99|128->100|128->100|128->100|129->101|129->101|130->102|130->102|130->102|130->102|131->103|131->103|132->104|133->105|134->106|135->107|136->108|136->108|137->109|138->110|139->111
                  -- GENERATED --
              */
          