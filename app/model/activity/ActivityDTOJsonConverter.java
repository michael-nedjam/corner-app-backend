package model.activity;

import common.JsonHelper;

public class ActivityDTOJsonConverter{
	
	//
	//	Fields
	//
	
	private static JsonHelper<ActivityPostDTO>  _ActivityPOSTDTOJsonConverter = new JsonHelper<ActivityPostDTO>(ActivityPostDTO.class);
	
	// methods
	
	public static ActivityPostDTO converterFromJsonToActivityPostDTO(String json){
		return _ActivityPOSTDTOJsonConverter.convert(json);
	}
}