package model.user;

import common.JsonHelper;

public class UserDTOJsonConverter {
	
	//
	//	Fields
	//
	
	private static JsonHelper<UserPostDTO>  _UserPOSTDTOJsonConverter = new JsonHelper<UserPostDTO>(UserPostDTO.class);
	private static JsonHelper<UserPutDTO>  _UserPUTDTOJsonConverter = new JsonHelper<UserPutDTO>(UserPutDTO.class);
	private static JsonHelper<UserDTO>  _UserDTOJsonConverter = new JsonHelper<UserDTO>(UserDTO.class);
	
	// methods
	
	public static UserPostDTO converterFromJsonToUserPostDTO(String json){
		return _UserPOSTDTOJsonConverter.convert(json);
	}
	
	public static UserPutDTO converterFromJsonToUserPutDTO(String json){
		return _UserPUTDTOJsonConverter.convert(json);
	}
	
	public static String converterToJson(UserDTO aUserDTO){
		return _UserDTOJsonConverter.convert(aUserDTO);
	}
}

