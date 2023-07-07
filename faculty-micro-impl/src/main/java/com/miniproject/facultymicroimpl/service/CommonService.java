package com.miniproject.facultymicroimpl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.facultymicroimpl.client.AddressServiceClient;
import com.miniproject.facultymicroimpl.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	@Autowired
	AddressServiceClient addressServiceClient;
	

	Logger logger = LoggerFactory.getLogger(CommonService.class);

	int count = 1;

	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById(long addressId) {

		logger.info("count = " + count);
		count++;
		System.out.println("get address in common service ()");
		AddressResponse addressResponse = addressServiceClient.getAddressById(addressId);
		System.out.println(addressResponse);
		return addressResponse;
	}

	public AddressResponse fallbackGetAddressById(long addressId, Throwable thro) {

		logger.error("Error " + thro);
		return new AddressResponse();
	}


}
