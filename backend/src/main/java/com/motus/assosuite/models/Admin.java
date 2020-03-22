package com.motus.assosuite.models;

import java.util.UUID;

import javax.validation.constraints.Email;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.motus.assosuite.enums.RoleType;

/**
 * Authentication class for assosuite
 * 
 * @author fbordjah
 *
 */
public class Admin {

	@Id
	private ObjectId id;

	private String uuid;

	@Email
	private String mail;

	private String password;

	private RoleType roleType;

	public Admin() {
		super();
		this.uuid = UUID.randomUUID().toString();
	}

	public Admin(@Email String mail, RoleType roleType) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.mail = mail;
		this.roleType = roleType;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", uuid=" + uuid + ", mail=" + mail + ", roleType=" + roleType + "]";
	}

}
