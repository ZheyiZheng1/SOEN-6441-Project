// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseNewHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def ChannelProfileWebSocket(channelId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ChannelProfile/" + implicitly[play.api.mvc.PathBindable[String]].unbind("channelId", channelId) + "/ws")
    }
  
    // @LINE:18
    def ChannelProfile(channelID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ChannelProfile/" + implicitly[play.api.mvc.PathBindable[String]].unbind("channelID", channelID))
    }
  
    // @LINE:8
    def GetWordStats(query:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "wordstats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("query", query)))
    }
  
    // @LINE:7
    def ws: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search")
    }
  
    // @LINE:14
    def tagSearch(keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tagSearch" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("keyword", keyword)))))
    }
  
    // @LINE:13
    def tagDetails(videoId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tagDetails" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("videoId", videoId)))))
    }
  
    // @LINE:6
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
