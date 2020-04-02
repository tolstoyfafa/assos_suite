package com.motus.assosuite.api.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.motus.assosuite.enums.AssosBusinessErrorCode;

public class BusinessException extends RuntimeException {

	private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	private AssosBusinessErrorCode code;

	public BusinessException(String message, AssosBusinessErrorCode code) {
		super();
		logger.error("An excpetion was thrown");
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public AssosBusinessErrorCode getCode() {
		return code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(AssosBusinessErrorCode code) {
		this.code = code;
	}

}
