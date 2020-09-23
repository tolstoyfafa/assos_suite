package com.motus.assosuite.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Group of adherents")
public class Group {

	@Id
	@JsonIgnore
	private ObjectId id;

	@NotNull
	private String uuid;
	
	private String name;
	
	private Date creationDate;
	
	private Date modificationDate;
	
	private List<Adherent> members;

	public Group(String name, List<Adherent> members) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.name = name;
		this.creationDate = new Date();
		this.modificationDate = new Date();
		this.members = members;
	}

	public ObjectId getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public List<Adherent> getMembers() {
		return members;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public void setMembers(List<Adherent> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", uuid=" + uuid + ", name=" + name + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + ", members=" + members + "]";
	}
	
}
