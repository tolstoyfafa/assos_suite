package com.motus.assosuite.enums;

import org.springframework.http.HttpStatus;

public enum AssosBusinessErrorCode {
	
	ADHERENT_NOT_FOUND(1000, HttpStatus.NOT_FOUND),
	ADHERENT_EXISTS(1001, HttpStatus.BAD_REQUEST),
	ADMIN_BAD_CREDENTIALS(2001, HttpStatus.UNAUTHORIZED),
	ADMIN_NOT_FOUND(2002, HttpStatus.NOT_FOUND),
	MAIL_SEND_ERROR(3002, HttpStatus.INTERNAL_SERVER_ERROR);
	
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
