package controllers;

import java.util.Map;

import model.user.UserDTO;
import model.user.UserDTOJsonConverter;
import model.user.UserPostDTO;
import model.user.UserPutDTO;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;
import security.Secured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.HttpHelper;
import common.JsonHelper;
import core.services.ServiceFactory;
import core.users.Userprofile;

public class UsersController extends Controller {

	@Security.Authenticated(Secured.class)
	public static Result get() {
		
		// retrieve params from query string
		Map<String, String> listParam = HttpHelper.GetListQueryParams(request());
		String userId = listParam.get("id");
		
		// get list
		Userprofile aUserprofile = ServiceFactory.getInstance().GetUsersService().FindById(Integer.decode(userId));
		
		// convert to DTO
		UserDTO aUserDTO = new UserDTO(aUserprofile);
		
		return ok(UserDTOJsonConverter.converterToJson(aUserDTO));
    }
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result sayHello() {
	  JsonNode json = request().body().asJson();
	  ObjectNode result = Json.newObject();
	  String name = json.findPath("name").textValue();
	  if(name == null) {
	    result.put("status", "KO");
	    result.put("message", "Missing parameter [name]");
	    return badRequest(result);
	  } else {
	    result.put("status", "OK");
	    result.put("message", "Hello " + name);
	    return ok(result);
	  }
	}
	
	public static Result post() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
		UserPostDTO aUserPostDTO = UserDTOJsonConverter.converterFromJsonToUserPostDTO(json.toString());
		if(aUserPostDTO == null) return badRequest("Missing parameter");
		
		// add User
		try{
			Userprofile aUser = ServiceFactory.getInstance().GetUsersService().Create(aUserPostDTO.Email, aUserPostDTO.FirstName, aUserPostDTO.LastName, aUserPostDTO.Password);
			
			// convert to DTO
			UserDTO aUserDTO = new UserDTO(aUser);
			
			return ok(UserDTOJsonConverter.converterToJson(aUserDTO));	
			
		} catch (Exception e){
			return internalServerError();
		}
    }
	
	@Security.Authenticated(Secured.class)
	public static Result put() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
		UserPutDTO aUserPutDTO = UserDTOJsonConverter.converterFromJsonToUserPutDTO(json.toString());
		if(aUserPutDTO == null) return badRequest("Missing parameter");
		
		// find current user
		Userprofile aUserprofile = Secured.getUser(Context.current());
		
		
		// add User
		try{
			Boolean showOffensiveContent = Boolean.valueOf(aUserPutDTO.ShowOffensiveContent);
			Userprofile aUser = ServiceFactory.getInstance().GetUsersService().Update(aUserprofile.id, showOffensiveContent);
			
			// convert to DTO
			UserDTO aUserDTO = new UserDTO(aUser);
			
			return ok(UserDTOJsonConverter.converterToJson(aUserDTO));	
			
		} catch (Exception e){
			return internalServerError();
		}
    }
}
