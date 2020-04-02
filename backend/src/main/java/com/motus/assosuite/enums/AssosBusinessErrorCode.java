package com.motus.assosuite.enums;

import org.springframework.http.HttpStatus;

public enum AssosBusinessErrorCode {
	
	ADHERENT_NOT_FOUND(100, HttpStatus.NOT_FOUND),
	ADHERENT_EXISTS(101, HttpStatus.BAD_REQUEST);
	
	private final int code;
	private final HttpStatus status;

	private AssosBusinessErrorCode(int code, HttpStatus status) {
		this.code = code;
		this.status = status;
	}
	
	private AssosBusinessErrorCode(int code) {
		this.code = code;
		this.status = HttpStatus.BAD_REQUEST;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
