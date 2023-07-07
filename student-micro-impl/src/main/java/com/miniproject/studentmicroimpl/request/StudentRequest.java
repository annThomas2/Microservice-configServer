package com.miniproject.studentmicroimpl.request;

public class StudentRequest {
	
	private Integer studentId;
	private String name;
	private Character gender;
	private Integer departmentId;
	private Integer availableNumberOfLeaves;
	private Long phoneNumber;
	private Long addressId;
	
	
	public StudentRequest(Integer studentId, String name, Character gender, Integer departmentId,
			Integer availableNumberOfLeaves, Long phoneNumber, Long addressId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.departmentId = departmentId;
		this.availableNumberOfLeaves = availableNumberOfLeaves;
		this.phoneNumber = phoneNumber;
		this.addressId = addressId;
	}
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
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public StudentRequest() {
		
	}
	
	
	
	
	

}
