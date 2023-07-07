package com.miniproject.studentmicroimpl.response;

public class StudentResponse {

	private Integer studentId;
	private String name;
	private Character gender;
	private Integer departmentId;
	private Integer availableNumberOfLeaves;
	private Long phoneNumber;
	
	private AddressResponse addressResponse;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	public StudentResponse(Integer studentId, String name, Character gender, Integer departmentId,
			Integer availableNumberOfLeaves, Long phoneNumber, AddressResponse addressResponse) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.departmentId = departmentId;
		this.availableNumberOfLeaves = availableNumberOfLeaves;
		this.phoneNumber = phoneNumber;
		this.addressResponse = addressResponse;
	}

	public StudentResponse() {

	}

}
