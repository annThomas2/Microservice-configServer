package com.miniproject.facultymicroimpl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Faculty {

	@Id
	private Integer facultyId;
	private String name;
	private Character gender;
	private Integer departmentId;
	private Integer availableNumberOfLeaves;
	private Long phoneNumber;
	private Long addressId;

	public Faculty(Integer facultyId, String name, Character gender, Integer departmentId,
			Integer availableNumberOfLeaves, Long phoneNumber, Long addressId) {
		super();
		this.facultyId = facultyId;
		this.name = name;
		this.gender = gender;
		this.departmentId = departmentId;
		this.availableNumberOfLeaves = availableNumberOfLeaves;
		this.phoneNumber = phoneNumber;
		this.addressId = addressId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getAvailableNumberOfLeaves() {
		return availableNumberOfLeaves;
	}

	public void setAvailableNumberOfLeaves(Integer availableNumberOfLeaves) {
		this.availableNumberOfLeaves = availableNumberOfLeaves;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Faculty() {

	}

}
