package dto;

import java.util.HashMap;
import java.util.Map;

public class ResponseBean {

	public static String RETOUR = "retour";
	public static String SUCCESS = "success";
	public static String FAILED = "failed";
	
	private Map <String,Object> response = new HashMap<String, Object>();

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}


	
}
