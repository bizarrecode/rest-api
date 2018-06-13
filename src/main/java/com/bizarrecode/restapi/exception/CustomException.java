package com.bizarrecode.restapi.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = -8790275002801865326L;
	
	private String errorMessage;
	
	public CustomException() {
		super();
	}
	
	public CustomException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

}
