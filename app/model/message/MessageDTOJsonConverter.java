package model.message;

import java.util.Collection;

import common.JsonHelper;

public class MessageDTOJsonConverter {
	
	//
	//	Fields
	//
	
	private static JsonHelper<MessagePostDTO>  _MessagePOSTDTOJsonConverter = new JsonHelper<MessagePostDTO>(MessagePostDTO.class);
	private static JsonHelper<MessageDTO>  _MessageDTOJsonConverter = new JsonHelper<MessageDTO>(MessageDTO.class);
	
	// methods
	
	public static MessagePostDTO converterFromJsonToMessagePostDTO(String json){
		return _MessagePOSTDTOJsonConverter.convert(json);
	}
	
	public static String converterToJson(MessageDTO aMessageDTO){
		return _MessageDTOJsonConverter.convert(aMessageDTO);
	}
	
	public static String converterListToJson(Collection<MessageDTO> listMessageDTO){
		return _MessageDTOJsonConverter.convertList(listMessageDTO);
	}
}
