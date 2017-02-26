package model.registration;

import common.JsonHelper;
import core.registrations.SupportType;

public class RegistrationDTOJsonConverter {
	
	//
	//	Fields
	//
	
	private static JsonHelper<RegistrationPostDTO>  _RegistrationPOSTDTOJsonConverter = new JsonHelper<RegistrationPostDTO>(RegistrationPostDTO.class);
	private static JsonHelper<RegistrationDTO>  _RegistrationDTOJsonConverter = new JsonHelper<RegistrationDTO>(RegistrationDTO.class);
	
	// methods
	
	public static RegistrationPostDTO converterFromJsonToRegistrationPostDTO(String json){
		RegistrationPostDTO result =  _RegistrationPOSTDTOJsonConverter.convert(json);
		
		// convert from json
		String supportType = JsonHelper.findValueByKeyInJson(json, RegistrationPostDTO.SupportTypeField);
		
		// default value
		if(supportType == null){
			supportType = SupportType.ANDROID.toString();
		}
		
		// restrain value
		SupportType supportTypeControlled = SupportType.GetSupportType(supportType);
		result.setSupportType(supportTypeControlled.toString());
		
		return result;
	}
	
	public static String converterToJson(RegistrationDTO aRegistrationDTO){
		return _RegistrationDTOJsonConverter.convert(aRegistrationDTO);
	}
}