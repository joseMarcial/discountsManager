package com.discounts.service.api;

public class RestResponse {
	
	String responseCode;
	String codeDescription;
	
	
	public RestResponse(String responseCode, String codeDescription) {
		super();
		this.responseCode = responseCode;
		this.codeDescription = codeDescription;
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getCodeDescription() {
		return codeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

}
