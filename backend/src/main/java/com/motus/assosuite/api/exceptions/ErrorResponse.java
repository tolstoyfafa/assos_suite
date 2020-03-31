package com.motus.assosuite.api.exceptions;

import java.util.List;

public class ErrorResponse {

	private String message;

	private List<String> details;

	private Integer code;

	public ErrorResponse(String message, List<String> details, Integer code) {
		super();
		this.message = message;
		this.code = code;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getDetails() {
		return details;
	}

	public Integer getCode() {
		return code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
