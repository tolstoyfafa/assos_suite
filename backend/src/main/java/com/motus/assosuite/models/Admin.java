package com.motus.assosuite.models;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.motus.assosuite.enums.RoleType;

/**
 * Authentication class for assosuite
 * 
 * @author fbordjah
 *
 */
public class Admin implements UserDetails, UserPrincipal{

	/**
	 * 
	 */
	private static final long serialVersionUID = -644713787682430702L;

	@Id
	private ObjectId id;

	private String uuid;

	@Email
	@Indexed(unique = true)
	private String mail;

	private String password;

	private List<RoleType> roles;

	public Admin() {
		super();
		this.uuid = UUID.randomUUID().toString();
	}

	public Admin(String mail, List<RoleType> roles) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.mail = mail;
		this.roles = roles;
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

	public List<RoleType> getRoleType() {
		return roles;
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

	public void setRoleType(List<RoleType> roleType) {
		this.roles = roleType;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", uuid=" + uuid + ", mail=" + mail + ", roles=" + roles + "]";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return mail;
	}
}
