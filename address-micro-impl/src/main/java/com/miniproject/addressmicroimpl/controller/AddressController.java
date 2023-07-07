package com.miniproject.addressmicroimpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.addressmicroimpl.request.AddressRequest;
import com.miniproject.addressmicroimpl.response.AddressResponse;
import com.miniproject.addressmicroimpl.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

	@Autowired
	AddressService addressService;
	@Value("${address.test}")
	private String test;
	

	@PostMapping
	public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest request) {
		AddressResponse response = addressService.createAddress(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{addressId}")
	public ResponseEntity<AddressResponse> getAddress(@PathVariable Long addressId) {
		AddressResponse addressResponse = addressService.getAddressByyId(addressId);
		if (addressResponse == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(addressResponse);
	}
	@PutMapping("{id}")
	public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest request,@PathVariable Long id) {
		AddressResponse response = addressService.updateAddress(request);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
	}
	@GetMapping("/test")
	public String test() {
		return test;
	}

}
