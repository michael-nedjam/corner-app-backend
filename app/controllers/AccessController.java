package controllers;

import model.access.AccessDTO;
import model.access.AccessDTOJsonConverter;
import model.access.AccessPostDTO;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

import core.oauth.GrantType;
import core.oauth.OAuthReponse;
import core.services.ServiceFactory;

public class AccessController extends Controller {
	public static Result post() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
    	AccessPostDTO aAccessPostDTO = AccessDTOJsonConverter.converterFromJsonToAccessPostDTO(json.toString());
		if(aAccessPostDTO == null) return badRequest("Missing parameter");
		
		// Authentify
		String clientID = null;
		String clientSecret = null;
		OAuthReponse aOAuthReponse = ServiceFactory.getInstance().GetOAuthService().AccessTokenForPasswordGrantViaLoginPassword(GrantType.PASSWORD, aAccessPostDTO.Email, aAccessPostDTO.Password, null, clientID, clientSecret, aAccessPostDTO.DeviceId);
		
		// convert to DTO
		AccessDTO aAccessDTO = new AccessDTO(aOAuthReponse);
		
		return ok(AccessDTOJsonConverter.converterToJson(aAccessDTO));
    }
}
