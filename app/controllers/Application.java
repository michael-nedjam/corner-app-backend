package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index2() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result index() {
    	JsonNode json = request().body().asJson();
    	if(json == null) {
    		return badRequest("Expecting Json data that has been modified second time");
    	} else {
    		String name = json.findPath("name").textValue();
    		if(name == null) {
    			return badRequest("Missing parameter [name]");
    		} else {
    			return ok("Hello " + name);
    		}
    	}
    }
}
