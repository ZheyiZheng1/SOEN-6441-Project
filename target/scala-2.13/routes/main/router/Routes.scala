// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_4: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:9
  AsyncController_2: controllers.AsyncController,
  // @LINE:10
  WordCountController_3: controllers.WordCountController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_4: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:9
    AsyncController_2: controllers.AsyncController,
    // @LINE:10
    WordCountController_3: controllers.WordCountController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_4, CountController_0, AsyncController_2, WordCountController_3, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, CountController_0, AsyncController_2, WordCountController_3, Assets_1, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.display(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.HomeController.search(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """videoStatistics/""" + "$" + """keyword<[^/]+>""", """controllers.WordCountController.videoStatistics(keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private lazy val controllers_HomeController_display0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_display0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.display(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "display",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """ Displays homepage.""",
      Seq()
    )
  )

  // @LINE:7
  private lazy val controllers_HomeController_search1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private lazy val controllers_HomeController_search1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.search(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "search",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private lazy val controllers_CountController_count2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private lazy val controllers_CountController_count2_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private lazy val controllers_AsyncController_message3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private lazy val controllers_AsyncController_message3_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val controllers_WordCountController_videoStatistics4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("videoStatistics/"), DynamicPart("keyword", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_WordCountController_videoStatistics4_invoker = createInvoker(
    WordCountController_3.videoStatistics(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WordCountController",
      "videoStatistics",
      Seq(classOf[String]),
      "GET",
      this.prefix + """videoStatistics/""" + "$" + """keyword<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_display0_route(params@_) =>
      call { 
        controllers_HomeController_display0_invoker.call(
          req => HomeController_4.display(req))
      }
  
    // @LINE:7
    case controllers_HomeController_search1_route(params@_) =>
      call { 
        controllers_HomeController_search1_invoker.call(
          req => HomeController_4.search(req))
      }
  
    // @LINE:8
    case controllers_CountController_count2_route(params@_) =>
      call { 
        controllers_CountController_count2_invoker.call(CountController_0.count)
      }
  
    // @LINE:9
    case controllers_AsyncController_message3_route(params@_) =>
      call { 
        controllers_AsyncController_message3_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:10
    case controllers_WordCountController_videoStatistics4_route(params@_) =>
      call(params.fromPath[String]("keyword", None)) { (keyword) =>
        controllers_WordCountController_videoStatistics4_invoker.call(WordCountController_3.videoStatistics(keyword))
      }
  
    // @LINE:13
    case controllers_Assets_versioned5_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(file))
      }
  }
}
