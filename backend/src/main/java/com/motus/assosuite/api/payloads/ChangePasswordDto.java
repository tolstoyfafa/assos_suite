package com.motus.assosuite.api.payloads;

import javax.validation.constraints.NotEmpty;

public class ChangePasswordDto extends AuthDto{

	@NotEmpty(message = "new password must be set")
	private String newPassword;

	public ChangePasswordDto() {
		super();
	}
	
	

	public ChangePasswordDto(String mail, String password, String newPassword) {
		super(mail, password);
		this.newPassword = newPassword;
	}



	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordDto [newPassword=" + newPassword + "]";
	}

}
