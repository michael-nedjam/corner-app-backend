package controllers;

import model.registration.RegistrationDTO;
import model.registration.RegistrationDTOJsonConverter;
import model.registration.RegistrationPostDTO;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

import core.registrations.Registration;
import core.services.ServiceFactory;

public class NotificationController extends Controller{

	public static Result addRegistration() {
		
		// Get json format
		JsonNode json = request().body().asJson();
    	if(json == null) return badRequest("Expecting Json data that has been modified second time");
    	
		// retrieve data
    	RegistrationPostDTO aRegistrationPostDTO = RegistrationDTOJsonConverter.converterFromJsonToRegistrationPostDTO(json.toString());
		if(aRegistrationPostDTO == null) return badRequest("Missing parameter");
		
		// add RegistrationPostDTO
		try{
			Registration aRegistration = ServiceFactory.getInstance().GetRegistrationService().AddNewRegistrationIdForDevice(aRegistrationPostDTO.RegistrationId, aRegistrationPostDTO.DeviceId, aRegistrationPostDTO.SupportType);
			
			// convert to DTO
			RegistrationDTO aRegistrationDTO = new RegistrationDTO(aRegistration);
			
			return ok(RegistrationDTOJsonConverter.converterToJson(aRegistrationDTO));
		} catch (Exception e){
			return internalServerError();
		}
    }
}
