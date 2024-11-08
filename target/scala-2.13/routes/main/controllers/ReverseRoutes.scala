// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def display(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def search(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search")
    }
  
    // @LINE:13
    def showTags(videoId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tags/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("videoId", videoId)))
    }
  
    // @LINE:16
    def searchByTag(tag:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchByTag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tag", tag)))
    }
  
    // @LINE:10
    def videoStatistics(keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "videoStatistics/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("keyword", keyword)))
    }
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:9
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def message: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
