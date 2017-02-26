package model.access;

import common.JsonHelper;

public class AccessDTOJsonConverter {
	
	//
	//	Fields
	//
	
	private static JsonHelper<AccessPostDTO>  _AccessPostDTOConverter = new JsonHelper<AccessPostDTO>(AccessPostDTO.class);
	private static JsonHelper<AccessDTO>  _AccessDTOConverter = new JsonHelper<AccessDTO>(AccessDTO.class);
	
	// methods
	
	public static AccessPostDTO converterFromJsonToAccessPostDTO(String json){
		return _AccessPostDTOConverter.convert(json);
	}
	
	public static String converterToJson(AccessDTO aAccessDTO){
		return _AccessDTOConverter.convert(aAccessDTO);
	}
}
