package com.miniproject.facultymicroimpl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.miniproject.facultymicroimpl.request.AddressRequest;
import com.miniproject.facultymicroimpl.response.AddressResponse;

@FeignClient(name = "api-gateway", url = "localhost:9090")
public interface AddressServiceClient {

	@GetMapping("address-service/api/address/{id}")
	public AddressResponse getAddressById(@PathVariable Long id);

	@PostMapping("address-service/api/address")
	public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest request);

	@GetMapping("address-service/api/address/{addressId}")
	public ResponseEntity<AddressResponse> getAddress(@PathVariable Long addressId);

	@PutMapping("address-service/api/address/{id}")
	public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest request, @PathVariable Long id);

	@DeleteMapping("address-service/api/address/{id}")
	public void deleteAddress(@PathVariable Long id);

}
