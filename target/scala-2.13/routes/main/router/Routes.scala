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
  NewHomeController_0: controllers.NewHomeController,
  // @LINE:10
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    NewHomeController_0: controllers.NewHomeController,
    // @LINE:10
    Assets_1: controllers.Assets
  ) = this(errorHandler, NewHomeController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, NewHomeController_0, Assets_1, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.NewHomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.NewHomeController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private lazy val controllers_NewHomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_NewHomeController_index0_invoker = createInvoker(
    NewHomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Displays homepage.""",
      Seq()
    )
  )

  // @LINE:7
  private lazy val controllers_NewHomeController_ws1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private lazy val controllers_NewHomeController_ws1_invoker = createInvoker(
    NewHomeController_0.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "ws",
      Nil,
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned2_invoker = createInvoker(
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
    case controllers_NewHomeController_index0_route(params@_) =>
      call { 
        controllers_NewHomeController_index0_invoker.call(NewHomeController_0.index)
      }
  
    // @LINE:7
    case controllers_NewHomeController_ws1_route(params@_) =>
      call { 
        controllers_NewHomeController_ws1_invoker.call(NewHomeController_0.ws)
      }
  
    // @LINE:10
    case controllers_Assets_versioned2_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned2_invoker.call(Assets_1.versioned(file))
      }
  }
}
