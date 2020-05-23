package com.motus.assosuite.api.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * AuthDto class contains admin credentials for authentication
 * @author fbordjah
 *
 */
public class AuthDto {

	@NotEmpty(message = "mail must be set")
	private String mail;

	@NotEmpty(message = "password must be set")
	private String password;

	/**
	 * Default constructor
	 */
	protected AuthDto() {
	}

	/**
	 * Full constructor
	 * 
	 * @param mail     The user email
	 * @param password The user password
	 */
	public AuthDto(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
