package controllers;

import model.activity.ActivityDTOJsonConverter;
import model.activity.ActivityPostDTO;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import security.Secured;

import com.fasterxml.jackson.databind.JsonNode;

import core.activities.Activity;
import core.services.ServiceFactory;

public class ActivityController  extends Controller {

	@Security.Authenticated(Secured.class)	
	public static Result post() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
		ActivityPostDTO aActivityPostDTO = ActivityDTOJsonConverter.converterFromJsonToActivityPostDTO(json.toString());
		if(aActivityPostDTO == null) return badRequest("Missing parameter");
		
		// add User
		try{
			Activity aActivity = ServiceFactory.getInstance().GetActivityService().Create(aActivityPostDTO.UserId, aActivityPostDTO.Type);
			
			return ok();	
		} catch (Exception e){
			return internalServerError();
		}
	}
		
}
