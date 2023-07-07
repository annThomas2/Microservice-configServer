package com.miniproject.addressmicroimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.addressmicroimpl.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
