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
  // @LINE:11
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    NewHomeController_0: controllers.NewHomeController,
    // @LINE:11
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """wordstats/""" + "$" + """query<[^/]+>""", """controllers.NewHomeController.GetWordStats(query:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tagDetails""", """controllers.NewHomeController.tagDetails(videoId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tagSearch""", """controllers.NewHomeController.tagSearch(keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ChannelProfile/""" + "$" + """channelID<[^/]+>""", """controllers.NewHomeController.ChannelProfile(channelID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ChannelProfile/""" + "$" + """channelId<[^/]+>/ws""", """controllers.NewHomeController.ChannelProfileWebSocket(channelId:String)"""),
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

  // @LINE:8
  private lazy val controllers_NewHomeController_GetWordStats2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("wordstats/"), DynamicPart("query", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_NewHomeController_GetWordStats2_invoker = createInvoker(
    NewHomeController_0.GetWordStats(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "GetWordStats",
      Seq(classOf[String]),
      "GET",
      this.prefix + """wordstats/""" + "$" + """query<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned3_invoker = createInvoker(
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

  // @LINE:13
  private lazy val controllers_NewHomeController_tagDetails4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tagDetails")))
  )
  private lazy val controllers_NewHomeController_tagDetails4_invoker = createInvoker(
    NewHomeController_0.tagDetails(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "tagDetails",
      Seq(classOf[String]),
      "GET",
      this.prefix + """tagDetails""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private lazy val controllers_NewHomeController_tagSearch5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tagSearch")))
  )
  private lazy val controllers_NewHomeController_tagSearch5_invoker = createInvoker(
    NewHomeController_0.tagSearch(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "tagSearch",
      Seq(classOf[String]),
      "GET",
      this.prefix + """tagSearch""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private lazy val controllers_NewHomeController_ChannelProfile6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ChannelProfile/"), DynamicPart("channelID", """[^/]+""", encodeable=false)))
  )
  private lazy val controllers_NewHomeController_ChannelProfile6_invoker = createInvoker(
    NewHomeController_0.ChannelProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "ChannelProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ChannelProfile/""" + "$" + """channelID<[^/]+>""",
      """ Route for serving the channel profile page""",
      Seq()
    )
  )

  // @LINE:19
  private lazy val controllers_NewHomeController_ChannelProfileWebSocket7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ChannelProfile/"), DynamicPart("channelId", """[^/]+""", encodeable=false), StaticPart("/ws")))
  )
  private lazy val controllers_NewHomeController_ChannelProfileWebSocket7_invoker = createInvoker(
    NewHomeController_0.ChannelProfileWebSocket(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewHomeController",
      "ChannelProfileWebSocket",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ChannelProfile/""" + "$" + """channelId<[^/]+>/ws""",
      """""",
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
  
    // @LINE:8
    case controllers_NewHomeController_GetWordStats2_route(params@_) =>
      call(params.fromPath[String]("query", None)) { (query) =>
        controllers_NewHomeController_GetWordStats2_invoker.call(NewHomeController_0.GetWordStats(query))
      }
  
    // @LINE:11
    case controllers_Assets_versioned3_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned3_invoker.call(Assets_1.versioned(file))
      }
  
    // @LINE:13
    case controllers_NewHomeController_tagDetails4_route(params@_) =>
      call(params.fromQuery[String]("videoId", None)) { (videoId) =>
        controllers_NewHomeController_tagDetails4_invoker.call(NewHomeController_0.tagDetails(videoId))
      }
  
    // @LINE:14
    case controllers_NewHomeController_tagSearch5_route(params@_) =>
      call(params.fromQuery[String]("keyword", None)) { (keyword) =>
        controllers_NewHomeController_tagSearch5_invoker.call(NewHomeController_0.tagSearch(keyword))
      }
  
    // @LINE:18
    case controllers_NewHomeController_ChannelProfile6_route(params@_) =>
      call(params.fromPath[String]("channelID", None)) { (channelID) =>
        controllers_NewHomeController_ChannelProfile6_invoker.call(NewHomeController_0.ChannelProfile(channelID))
      }
  
    // @LINE:19
    case controllers_NewHomeController_ChannelProfileWebSocket7_route(params@_) =>
      call(params.fromPath[String]("channelId", None)) { (channelId) =>
        controllers_NewHomeController_ChannelProfileWebSocket7_invoker.call(NewHomeController_0.ChannelProfileWebSocket(channelId))
      }
  }
}
