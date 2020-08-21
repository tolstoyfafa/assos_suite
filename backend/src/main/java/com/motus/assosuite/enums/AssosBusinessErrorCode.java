package com.motus.assosuite.enums;

import org.springframework.http.HttpStatus;

/**
 * Enum Contains all business error codes used to normalize the http response of the API
 * @author fbordjah
 *
 */
public enum AssosBusinessErrorCode {
	
	ADHERENT_NOT_FOUND(1000, HttpStatus.NOT_FOUND),
	ADHERENT_EXISTS(1001, HttpStatus.BAD_REQUEST),
	ADMIN_BAD_CREDENTIALS(2001, HttpStatus.UNAUTHORIZED),
	ADMIN_NOT_FOUND(2002, HttpStatus.NOT_FOUND),
	GROUP_NOT_FOUND(3000, HttpStatus.NOT_FOUND),
	GROUP_EXISTS(3001, HttpStatus.BAD_REQUEST);

	private final int code;
	private final HttpStatus status;

	private AssosBusinessErrorCode(int code, HttpStatus status) {
		this.code = code;
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
