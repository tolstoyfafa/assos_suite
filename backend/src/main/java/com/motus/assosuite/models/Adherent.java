package com.motus.assosuite.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.motus.assosuite.enums.FamilialSituationType;
import com.motus.assosuite.enums.GenderType;

public class Adherent {

	@Id
	private Long id;
	
	private UUID uuid;

	private String firstName;

	private String lastName;

	private Date birthDay;

	private String mail;

	private String phone;

	private FamilialSituationType familialSituation;
	
	private GenderType genderType;

	private Address address;

	private Date creationDate;

	private Date modificationDate;
	

	public Adherent() {
		super();
	}

	public Adherent(UUID uuid, String firstName, String lastName, Date birthDay, String mail, String phone,
			FamilialSituationType familialSituation, GenderType genderType, Address address, Date creationDate,
			Date modificationDate) {
		super();
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.mail = mail;
		this.phone = phone;
		this.familialSituation = familialSituation;
		this.genderType = genderType;
		this.address = address;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
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

	public String getPhone() {
		return phone;
	}

	public FamilialSituationType getPermitNum() {
		return familialSituation;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
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

	public void setPhone(String phone) {
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
