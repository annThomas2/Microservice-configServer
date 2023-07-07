package com.miniproject.addressmicroimpl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.addressmicroimpl.entity.Address;
import com.miniproject.addressmicroimpl.repository.AddressRepository;
import com.miniproject.addressmicroimpl.request.AddressRequest;
import com.miniproject.addressmicroimpl.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	Address address = new Address();
	AddressResponse addressResponse = new AddressResponse(); 

	public Address convertRequstToEntity(AddressRequest addressRequest) {
		address.setAddressId(addressRequest.getAddressId());
		address.setCity(addressRequest.getCity());
		address.setCountry(addressRequest.getCountry());
		address.setLine1(addressRequest.getLine1());
		address.setLine2(addressRequest.getLine2());
		address.setPincode(addressRequest.getPincode());
		return address;
	}
public AddressResponse convertEntityToResponse(Address address) {
		
	addressResponse.setAddressId(address.getAddressId());
	addressResponse.setCity(address.getCity());
	addressResponse.setCountry(address.getCountry());
	addressResponse.setLine1(address.getLine1());
	addressResponse.setLine2(address.getLine2());
	addressResponse.setPincode(address.getPincode());
		return addressResponse;
	}
	
	
	public AddressResponse createAddress(AddressRequest request) {
		address = convertRequstToEntity(request);
		addressRepository.save(address);
		return convertEntityToResponse(address);
	}
	
	public AddressResponse getAddressByyId (Long addressId) {
		address = addressRepository.findById(addressId).get();
		return convertEntityToResponse(address);
	}
	
	public AddressResponse updateAddress(AddressRequest request) {
		address = convertRequstToEntity(request);
		addressRepository.save(address);
		return convertEntityToResponse(address);
	}
	
	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}
	
	
	
	
	
	
	

}
