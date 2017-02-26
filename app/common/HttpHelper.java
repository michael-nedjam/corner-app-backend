package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import play.mvc.Http.Request;

public class HttpHelper {
	public static Map<String, String> GetListQueryParams(Request request){
		Map<String, String> result = null;
		
		if(request != null && request.queryString() != null){
			final Set<Map.Entry<String,String[]>> entries = request.queryString().entrySet();
			
			if(entries!= null){
				
				result = new HashMap<String, String>(); 
				for (Map.Entry<String,String[]> entry : entries) {
		            final String key = entry.getKey();
		            final String value = entry.getValue()[0];
		            result.put(key, value);
		        }	
			}
	        	
		}
		
        return result;
	}
}
