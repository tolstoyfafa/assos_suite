package com.motus.assosuite.models;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motus.assosuite.enums.FamilialSituationType;
import com.motus.assosuite.enums.GenderType;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Adherent entity, contains all required informations about a member of association,"
		+ "the class is serilized and stocked on mongodb with same structure", value = "Adherent")
public class Adherent {

	@Id
	@JsonIgnore
	private ObjectId id;

	@NotNull
	private String uuid;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private Date birthDay;

	@NotNull
	private String mail;

	@NotNull
	private Integer phone;

	@NotNull
	private FamilialSituationType familialSituation;

	@NotNull
	private GenderType genderType;

	@NotNull
	private Address address;

	private Date creationDate;

	private Date modificationDate;

	public Adherent() {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.creationDate = new Date();
		this.modificationDate = new Date();
	}

	public Adherent(String firstName, String lastName, Date birthDay, String mail, @NotNull Integer phone,
			FamilialSituationType familialSituation, GenderType genderType, Address address) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.mail = mail;
		this.phone = phone;
		this.familialSituation = familialSituation;
		this.genderType = genderType;
		this.address = address;
		this.creationDate = new Date();
		this.modificationDate = new Date();
	}

	public ObjectId getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public String getMail() {
		return mail;
	}

	public Integer getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPhone(@NotNull Integer phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public FamilialSituationType getFamilialSituation() {
		return familialSituation;
	}

	public GenderType getGenderType() {
		return genderType;
	}

	public void setFamilialSituation(FamilialSituationType familialSituation) {
		this.familialSituation = familialSituation;
	}

	public void setGenderType(GenderType genderType) {
		this.genderType = genderType;
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", uuid=" + uuid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDay=" + birthDay + ", mail=" + mail + ", phone=" + phone + ", familialSituation="
				+ familialSituation + ", genderType=" + genderType + ", address=" + address + ", creationDate="
				+ creationDate + ", modificationDate=" + modificationDate + "]";
	}

}
