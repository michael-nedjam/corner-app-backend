// @SOURCE:C:/Users/michael/Dropbox/common/projet pro/2 - Corner/source/guarded-crag-9863/conf/routes
// @HASH:47242e130131563d83f4f4f7a4abceec5e34e506
// @DATE:Sat Mar 26 13:25:27 CET 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:36
class ReverseActivityController {
    

// @LINE:36
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "activity")
}
                                                
    
}
                          

// @LINE:24
class ReverseAccessController {
    

// @LINE:24
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "access")
}
                                                
    
}
                          

// @LINE:30
class ReverseTestController {
    

// @LINE:30
def sendNotification(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "test/notify")
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsersController {
    

// @LINE:14
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users")
}
                                                

// @LINE:13
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users")
}
                                                

// @LINE:15
def put(): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "users")
}
                                                
    
}
                          

// @LINE:27
class ReverseCrashreportController {
    

// @LINE:27
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "crashreport")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:33
class ReverseNotificationController {
    

// @LINE:33
def addRegistration(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "notification/registration")
}
                                                
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseMessagesController {
    

// @LINE:19
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "messages")
}
                                                

// @LINE:18
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "messages/list")
}
                                                

// @LINE:20
def reportOffensiveContent(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "messages/" + implicitly[PathBindable[Long]].unbind("id", id) + "/reportOffensiveContent")
}
                                                
    
}
                          
}
                  


// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:36
class ReverseActivityController {
    

// @LINE:36
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ActivityController.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "activity"})
      }
   """
)
                        
    
}
              

// @LINE:24
class ReverseAccessController {
    

// @LINE:24
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AccessController.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "access"})
      }
   """
)
                        
    
}
              

// @LINE:30
class ReverseTestController {
    

// @LINE:30
def sendNotification : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.TestController.sendNotification",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test/notify"})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsersController {
    

// @LINE:14
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UsersController.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        

// @LINE:13
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UsersController.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        

// @LINE:15
def put : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UsersController.put",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        
    
}
              

// @LINE:27
class ReverseCrashreportController {
    

// @LINE:27
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CrashreportController.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "crashreport"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:33
class ReverseNotificationController {
    

// @LINE:33
def addRegistration : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NotificationController.addRegistration",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "notification/registration"})
      }
   """
)
                        
    
}
              

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseMessagesController {
    

// @LINE:19
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagesController.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messages"})
      }
   """
)
                        

// @LINE:18
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagesController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messages/list"})
      }
   """
)
                        

// @LINE:20
def reportOffensiveContent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagesController.reportOffensiveContent",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messages/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/reportOffensiveContent"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:36
class ReverseActivityController {
    

// @LINE:36
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ActivityController.post(), HandlerDef(this, "controllers.ActivityController", "post", Seq(), "POST", """ Activity""", _prefix + """activity""")
)
                      
    
}
                          

// @LINE:24
class ReverseAccessController {
    

// @LINE:24
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AccessController.post(), HandlerDef(this, "controllers.AccessController", "post", Seq(), "POST", """ Access""", _prefix + """access""")
)
                      
    
}
                          

// @LINE:30
class ReverseTestController {
    

// @LINE:30
def sendNotification(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.TestController.sendNotification(), HandlerDef(this, "controllers.TestController", "sendNotification", Seq(), "GET", """ Test""", _prefix + """test/notify""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsersController {
    

// @LINE:14
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UsersController.post(), HandlerDef(this, "controllers.UsersController", "post", Seq(), "POST", """""", _prefix + """users""")
)
                      

// @LINE:13
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UsersController.get(), HandlerDef(this, "controllers.UsersController", "get", Seq(), "GET", """ User""", _prefix + """users""")
)
                      

// @LINE:15
def put(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UsersController.put(), HandlerDef(this, "controllers.UsersController", "put", Seq(), "PUT", """""", _prefix + """users""")
)
                      
    
}
                          

// @LINE:27
class ReverseCrashreportController {
    

// @LINE:27
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CrashreportController.post(), HandlerDef(this, "controllers.CrashreportController", "post", Seq(), "POST", """ CrashReport""", _prefix + """crashreport""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:33
class ReverseNotificationController {
    

// @LINE:33
def addRegistration(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NotificationController.addRegistration(), HandlerDef(this, "controllers.NotificationController", "addRegistration", Seq(), "POST", """ device""", _prefix + """notification/registration""")
)
                      
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseMessagesController {
    

// @LINE:19
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagesController.post(), HandlerDef(this, "controllers.MessagesController", "post", Seq(), "POST", """""", _prefix + """messages""")
)
                      

// @LINE:18
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagesController.list(), HandlerDef(this, "controllers.MessagesController", "list", Seq(), "GET", """ Messages""", _prefix + """messages/list""")
)
                      

// @LINE:20
def reportOffensiveContent(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagesController.reportOffensiveContent(id), HandlerDef(this, "controllers.MessagesController", "reportOffensiveContent", Seq(classOf[Long]), "POST", """""", _prefix + """messages/$id<[^/]+>/reportOffensiveContent""")
)
                      
    
}
                          
}
        
    