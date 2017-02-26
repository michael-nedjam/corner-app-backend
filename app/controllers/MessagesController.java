package controllers;

import java.util.Collection;
import java.util.Map;

import model.message.MessageDTO;
import model.message.MessageDTOJsonConverter;
import model.message.MessagePostDTO;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.With;
import security.Secured;

import com.fasterxml.jackson.databind.JsonNode;

import common.HttpHelper;
import core.messages.Message;
import core.services.ServiceFactory;
import core.users.Userprofile;

public class MessagesController extends Controller {
	
	//
	//	public
	//
	
	@Security.Authenticated(Secured.class)
	public static Result list() {
		// retrieve params from query string
		Map<String, String> listParam = HttpHelper.GetListQueryParams(request());
		Double longitude = Double.valueOf(listParam.get("longitude"));
		Double latitude = Double.valueOf(listParam.get("latitude"));
		
		Userprofile aUserprofile = Secured.getUser(Context.current());
		
		// get list
		Collection<Message> listMessages = ServiceFactory.getInstance().GetMessagesService().GetListMessageLocalized(latitude, longitude, aUserprofile.showOffensiveContent);
		
		// convert to DTO
		Collection<MessageDTO> listMessagesDTO = MessageDTO.Convert(listMessages);
		
		return ok(MessageDTOJsonConverter.converterListToJson(listMessagesDTO));
    }
	
	@Security.Authenticated(Secured.class)
	public static Result post() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
		MessagePostDTO aMessagePostDTO = MessageDTOJsonConverter.converterFromJsonToMessagePostDTO(json.toString());
		if(aMessagePostDTO == null) return badRequest("Missing parameter");
		
		// add message
		Double latitude = Double.valueOf(aMessagePostDTO.LocalisationLatitude);
		Double longitude = Double.valueOf(aMessagePostDTO.LocalisationLongitute); 
		Message aMessage = ServiceFactory.getInstance().GetMessagesService().CreateMessage(aMessagePostDTO.AuthorId, latitude, longitude, aMessagePostDTO.Text);
		
		// convert to DTO
		MessageDTO aMessageDTO = new MessageDTO(aMessage);
		
		return ok(MessageDTOJsonConverter.converterToJson(aMessageDTO));
    }
	
	@Security.Authenticated(Secured.class)
	public static Result reportOffensiveContent(Long id) {
		
		// Get json format
		Message aMessage = ServiceFactory.getInstance().GetMessagesService().reportOffensiveContent(id.intValue());
		
		// convert to DTO
		MessageDTO aMessageDTO = new MessageDTO(aMessage);
		
		return ok(MessageDTOJsonConverter.converterToJson(aMessageDTO));
    }
}
