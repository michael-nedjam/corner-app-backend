package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import common.LogHelper;

public class CrashreportController extends Controller {
	
	public static Result post() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
    	LogHelper.LogDebug("------------------------");
    	LogHelper.LogDebug(" Crash received ");
    	LogHelper.LogDebug("------------------------");
    	LogHelper.LogDebug("data = " + json);
		
		return ok();
    }
}
