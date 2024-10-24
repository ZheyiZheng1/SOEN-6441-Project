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
  HomeController_0: controllers.HomeController,
  // @LINE:9
  CountController_1: controllers.CountController,
  // @LINE:10
  AsyncController_2: controllers.AsyncController,
  // @LINE:13
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    CountController_1: controllers.CountController,
    // @LINE:10
    AsyncController_2: controllers.AsyncController,
    // @LINE:13
    Assets_3: controllers.Assets
  ) = this(errorHandler, HomeController_0, CountController_1, AsyncController_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, CountController_1, AsyncController_2, Assets_3, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ytlytics""", """controllers.HomeController.display"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.HomeController.search()"""),
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private lazy val controllers_HomeController_display0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ytlytics")))
  )
  private lazy val controllers_HomeController_display0_invoker = createInvoker(
    HomeController_0.display,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "display",
      Nil,
      "GET",
      this.prefix + """ytlytics""",
      """ Displays homepage.""",
      Seq()
    )
  )

  // @LINE:7
  private lazy val controllers_HomeController_search1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private lazy val controllers_HomeController_search1_invoker = createInvoker(
    HomeController_0.search(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "search",
      Nil,
      "POST",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private lazy val controllers_HomeController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_index2_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private lazy val controllers_CountController_count3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private lazy val controllers_CountController_count3_invoker = createInvoker(
    CountController_1.count,
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

  // @LINE:10
  private lazy val controllers_AsyncController_message4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private lazy val controllers_AsyncController_message4_invoker = createInvoker(
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

  // @LINE:13
  private lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String]),
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
        controllers_HomeController_display0_invoker.call(HomeController_0.display)
      }
  
    // @LINE:7
    case controllers_HomeController_search1_route(params@_) =>
      call { 
        controllers_HomeController_search1_invoker.call(HomeController_0.search())
      }
  
    // @LINE:8
    case controllers_HomeController_index2_route(params@_) =>
      call { 
        controllers_HomeController_index2_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_CountController_count3_route(params@_) =>
      call { 
        controllers_CountController_count3_invoker.call(CountController_1.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message4_route(params@_) =>
      call { 
        controllers_AsyncController_message4_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned5_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned5_invoker.call(Assets_3.versioned(file))
      }
  }
}
