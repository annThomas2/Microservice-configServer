package com.miniproject.studentmicroimpl.request;

public class StudentAddressRequest {
	private StudentRequest studentRequest;
	private AddressRequest addressRequest;
	public StudentRequest getStudentRequest() {
		return studentRequest;
	}
	public void setStudentRequest(StudentRequest studentRequest) {
		this.studentRequest = studentRequest;
	}
	public AddressRequest getAddressRequest() {
		return addressRequest;
	}
	public void setAddressRequest(AddressRequest addressRequest) {
		this.addressRequest = addressRequest;
	}
	public StudentAddressRequest(StudentRequest studentRequest, AddressRequest addressRequest) {
		super();
		this.studentRequest = studentRequest;
		this.addressRequest = addressRequest;
	}
	public StudentAddressRequest() {
		
	}
	
	

}
