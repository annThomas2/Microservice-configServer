package com.miniproject.addressmicroimpl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
    private Long addressId;
    private String city;
    private String country;
    private String line1;
    private String line2;
    private Integer pincode;
	public Address(Long addressId, String city, String country, String line1, String line2, Integer pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.line1 = line1;
		this.line2 = line2;
		this.pincode = pincode;
	}
	public Address() {
		
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", country=" + country + ", line1=" + line1
				+ ", line2=" + line2 + ", pincode=" + pincode + "]";
	}
    
    
    
    
	

}
