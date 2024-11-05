
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "java"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.43*/("""

"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

    """),format.raw/*5.5*/("""<section id="top">
        <div class="wrapper">
            <h1><a href="https://playframework.com/documentation/"""),_display_(/*7.67*/version),format.raw/*7.74*/("""/Home">"""),_display_(/*7.82*/message),format.raw/*7.89*/("""</a></h1>
        </div>
    </section>

    <div id="content" class="wrapper doc">
        <article>

            <h1>Welcome to Play</h1>

            <p>
                Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
            </p>

            <blockquote>
                <p>
                    You’re using Play """),_display_(/*22.40*/version),format.raw/*22.47*/("""
                """),format.raw/*23.17*/("""</p>
            </blockquote>

            <h2>Why do you see this page?</h2>

            <p>
                The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
                whenever a browser requests the <code>/</code> URI using the GET method:
            </p>

            <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>


            <p>
                Play has invoked the <code>controllers.HomeController.index</code> method:
            </p>

            <pre><code>public Result index() """),format.raw/*41.46*/("""{"""),format.raw/*41.47*/("""
    """),format.raw/*42.5*/("""return ok(
        index.render(
            "Your new application is ready.",
            assetsFinder
        ));
"""),format.raw/*47.1*/("""}"""),format.raw/*47.2*/("""</code></pre>

            <p>
                An action method handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
                Here we send a <code>200 OK</code> response, using a template to fill its content.
            </p>

            <p>
                The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a standard Java class.
            </p>

            <pre><code>@(message: String)(implicit assetsFinder: AssetsFinder)

  @main("Welcome to Play") """),format.raw/*60.29*/("""{"""),format.raw/*60.30*/("""

  """),format.raw/*62.3*/("""@welcome(message, style = "Java")

"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/("""</code></pre>

            <p>
                The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
                Then this template calls another function defined in <code>app/views/main.scala.html</code> which displays the HTML layout, and another
                function that displays this welcome message. You can freely add any HTML fragment mixed with Scala code in this file.
            </p>

            <blockquote>
                <p>
                    <strong>Note</strong> that Scala is fully compatible with Java, so if you don’t know Scala don’t panic, a Scala statement is very similar to a Java one.
                </p>
            </blockquote>

            <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*78.94*/version),format.raw/*78.101*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*78.240*/version),format.raw/*78.247*/("""/JavaActions">actions</a>.</p>

            <h2>Async Controller</h2>

            Now that you've seen how Play renders a page, take a look at <code>AsyncController.java</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.java</code>, but instead of returning <code>Result</code>, the action returns <code>CompletionStage&lt;Result&gt;</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.

            <p>
                <a href=""""),_display_(/*85.27*/routes/*85.33*/.AsyncController.message),format.raw/*85.57*/("""">Click here for the AsyncController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*89.95*/version),format.raw/*89.102*/("""/JavaAsync">asynchronous actions</a> in the documentation.
            </p>

            <h2>Count Controller</h2>

            <p>
                Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you refresh the page, so keep refreshing to see the numbers go up.
            </p>

            <p>
                <a href=""""),_display_(/*99.27*/routes/*99.33*/.CountController.count),format.raw/*99.55*/("""">Click here for the CountController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*103.95*/version),format.raw/*103.102*/("""/JavaDependencyInjection">dependency injection</a> in the documentation.
            </p>

            <h2>Need more info on the console?</h2>

            <p>
                For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*109.199*/version),format.raw/*109.206*/("""/PlayConsole">Using the Play console</a>.
            </p>

            <h2>Need to set up an IDE?</h2>

            <p>
                You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
                including modifications made to Scala source files.
            </p>

            <p>
                If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
                <a href="https://www.playframework.com/documentation/"""),_display_(/*121.71*/version),format.raw/*121.78*/("""/IDE">Setting up your preferred IDE</a> page.
            </p>

            <h2>Need more documentation?</h2>

            <p>
                Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*127.106*/version),format.raw/*127.113*/("""">https://www.playframework.com/documentation</a>.
            </p>

            <p>
                Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
            </p>

            <h2>Need more help?</h2>

            <p>
                Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
            </p>

            <p>
                The <a href="https://github.com/playframework/playframework/discussions">Play Forum</a>  is where Play users come to seek help,
                announce projects, and discuss issues and new features.
            </p>

            <p>
                Discord is a real time chat channel, like IRC. The <a href="https://discord.gg/g5s2vtZ4Fa">playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
            </p>

        </article>

        <aside>
            <h3>Browse</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*154.71*/version),format.raw/*154.78*/("""">Documentation</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*155.71*/version),format.raw/*155.78*/("""/api/"""),_display_(/*155.84*/style),format.raw/*155.89*/("""/index.html">Browse the """),_display_(/*155.114*/{style.capitalize}),format.raw/*155.132*/(""" """),format.raw/*155.133*/("""API</a></li>
            </ul>
            <h3>Start here</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*159.71*/version),format.raw/*159.78*/("""/PlayConsole">Using the Play console</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*160.71*/version),format.raw/*160.78*/("""/IDE">Setting up your preferred IDE</a></li>
                <li><a href="https://playframework.com/download#examples">Example Projects</a>
            </ul>
            <h3>Help here</h3>
            <ul>
                <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
                <li><a href="https://github.com/playframework/playframework/discussions">Play Forum</a> </li>
                <li><a href="https://discord.gg/g5s2vtZ4Fa">Discord Server</a></li>
                <li><a href="https://www.playframework.com/sponsors">Sponsor Play</a></li>
            </ul>

        </aside>

    </div>
""")))}),format.raw/*174.2*/("""
"""))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/welcome.scala.html
                  HASH: 98163d87e8f77f4365fa492c668d615f4887e684
                  MATRIX: 916->1|1052->42|1082->47|1129->86|1179->99|1213->107|1356->224|1383->231|1417->239|1444->246|1871->646|1899->653|1945->671|2608->1306|2637->1307|2670->1313|2818->1434|2846->1435|3435->1998|3464->1999|3497->2005|3561->2043|3589->2044|4462->2890|4491->2897|4658->3036|4687->3043|5326->3655|5341->3661|5386->3685|5594->3866|5623->3873|6282->4505|6297->4511|6340->4533|6549->4714|6579->4721|6972->5085|7002->5092|7610->5672|7639->5679|7906->5917|7936->5924|9269->7229|9298->7236|9422->7332|9451->7339|9485->7345|9512->7350|9566->7375|9607->7393|9638->7394|9820->7548|9849->7555|9994->7672|10023->7679|10719->8344
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|38->7|38->7|38->7|38->7|53->22|53->22|54->23|72->41|72->41|73->42|78->47|78->47|91->60|91->60|93->62|95->64|95->64|109->78|109->78|109->78|109->78|116->85|116->85|116->85|120->89|120->89|130->99|130->99|130->99|134->103|134->103|140->109|140->109|152->121|152->121|158->127|158->127|185->154|185->154|186->155|186->155|186->155|186->155|186->155|186->155|186->155|190->159|190->159|191->160|191->160|205->174
                  -- GENERATED --
              */
          