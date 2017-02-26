package common;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import model.message.MessageDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper<T> {
	
	//
	// fields
	//
	
	private static ObjectMapper sMapper = new ObjectMapper();  
	private final Class<T> type;

	//
	// contructor
	//
	
    public JsonHelper(Class<T> type) {
         this.type = type;
    }

	//
    //	methods
    //
	
	public String convert(T objectDTO) {
		String result = null;
		
		try {
			result = sMapper.writeValueAsString(objectDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public T convert(String json) {		
		try {
			return sMapper.readValue(json, this.type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertList(Collection<MessageDTO> listMessageDTO) {
		try {
			return sMapper.writeValueAsString(listMessageDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String findValueByKeyInJson(String json, String key){
		String result = null;
		
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(json);
			result = jsonObject.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
