package dto;

import java.util.HashMap;
import java.util.Map;

public class ResponseBean {
	private Map <String,String> response = new HashMap<String, String>();

	public Map<String, String> getResponse() {
		return response;
	}

	public void setResponse(Map<String, String> response) {
		this.response = response;
	}


	
}
