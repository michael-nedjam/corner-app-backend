// @SOURCE:C:/Users/michael/Dropbox/common/projet pro/2 - Corner/source/guarded-crag-9863/conf/routes
// @HASH:47242e130131563d83f4f4f7a4abceec5e34e506
// @DATE:Sat Mar 26 13:25:27 CET 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:13
private[this] lazy val controllers_UsersController_get2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:14
private[this] lazy val controllers_UsersController_post3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:15
private[this] lazy val controllers_UsersController_put4 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:18
private[this] lazy val controllers_MessagesController_list5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messages/list"))))
        

// @LINE:19
private[this] lazy val controllers_MessagesController_post6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messages"))))
        

// @LINE:20
private[this] lazy val controllers_MessagesController_reportOffensiveContent7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messages/"),DynamicPart("id", """[^/]+""",true),StaticPart("/reportOffensiveContent"))))
        

// @LINE:24
private[this] lazy val controllers_AccessController_post8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("access"))))
        

// @LINE:27
private[this] lazy val controllers_CrashreportController_post9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("crashreport"))))
        

// @LINE:30
private[this] lazy val controllers_TestController_sendNotification10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("test/notify"))))
        

// @LINE:33
private[this] lazy val controllers_NotificationController_addRegistration11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("notification/registration"))))
        

// @LINE:36
private[this] lazy val controllers_ActivityController_post12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("activity"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.UsersController.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.UsersController.post()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.UsersController.put()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messages/list""","""controllers.MessagesController.list()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messages""","""controllers.MessagesController.post()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messages/$id<[^/]+>/reportOffensiveContent""","""controllers.MessagesController.reportOffensiveContent(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """access""","""controllers.AccessController.post()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """crashreport""","""controllers.CrashreportController.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """test/notify""","""controllers.TestController.sendNotification()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """notification/registration""","""controllers.NotificationController.addRegistration()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """activity""","""controllers.ActivityController.post()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:13
case controllers_UsersController_get2(params) => {
   call { 
        invokeHandler(controllers.UsersController.get(), HandlerDef(this, "controllers.UsersController", "get", Nil,"GET", """ User""", Routes.prefix + """users"""))
   }
}
        

// @LINE:14
case controllers_UsersController_post3(params) => {
   call { 
        invokeHandler(controllers.UsersController.post(), HandlerDef(this, "controllers.UsersController", "post", Nil,"POST", """""", Routes.prefix + """users"""))
   }
}
        

// @LINE:15
case controllers_UsersController_put4(params) => {
   call { 
        invokeHandler(controllers.UsersController.put(), HandlerDef(this, "controllers.UsersController", "put", Nil,"PUT", """""", Routes.prefix + """users"""))
   }
}
        

// @LINE:18
case controllers_MessagesController_list5(params) => {
   call { 
        invokeHandler(controllers.MessagesController.list(), HandlerDef(this, "controllers.MessagesController", "list", Nil,"GET", """ Messages""", Routes.prefix + """messages/list"""))
   }
}
        

// @LINE:19
case controllers_MessagesController_post6(params) => {
   call { 
        invokeHandler(controllers.MessagesController.post(), HandlerDef(this, "controllers.MessagesController", "post", Nil,"POST", """""", Routes.prefix + """messages"""))
   }
}
        

// @LINE:20
case controllers_MessagesController_reportOffensiveContent7(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.MessagesController.reportOffensiveContent(id), HandlerDef(this, "controllers.MessagesController", "reportOffensiveContent", Seq(classOf[Long]),"POST", """""", Routes.prefix + """messages/$id<[^/]+>/reportOffensiveContent"""))
   }
}
        

// @LINE:24
case controllers_AccessController_post8(params) => {
   call { 
        invokeHandler(controllers.AccessController.post(), HandlerDef(this, "controllers.AccessController", "post", Nil,"POST", """ Access""", Routes.prefix + """access"""))
   }
}
        

// @LINE:27
case controllers_CrashreportController_post9(params) => {
   call { 
        invokeHandler(controllers.CrashreportController.post(), HandlerDef(this, "controllers.CrashreportController", "post", Nil,"POST", """ CrashReport""", Routes.prefix + """crashreport"""))
   }
}
        

// @LINE:30
case controllers_TestController_sendNotification10(params) => {
   call { 
        invokeHandler(controllers.TestController.sendNotification(), HandlerDef(this, "controllers.TestController", "sendNotification", Nil,"GET", """ Test""", Routes.prefix + """test/notify"""))
   }
}
        

// @LINE:33
case controllers_NotificationController_addRegistration11(params) => {
   call { 
        invokeHandler(controllers.NotificationController.addRegistration(), HandlerDef(this, "controllers.NotificationController", "addRegistration", Nil,"POST", """ device""", Routes.prefix + """notification/registration"""))
   }
}
        

// @LINE:36
case controllers_ActivityController_post12(params) => {
   call { 
        invokeHandler(controllers.ActivityController.post(), HandlerDef(this, "controllers.ActivityController", "post", Nil,"POST", """ Activity""", Routes.prefix + """activity"""))
   }
}
        
}

}
     