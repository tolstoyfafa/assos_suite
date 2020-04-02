package com.motus.assosuite.api.exceptions;

public class ErrorResponse {

	private String message;

	private Integer code;

	public ErrorResponse(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
