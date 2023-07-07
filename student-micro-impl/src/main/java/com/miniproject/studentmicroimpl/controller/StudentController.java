package com.miniproject.studentmicroimpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.studentmicroimpl.request.AddressRequest;
import com.miniproject.studentmicroimpl.request.StudentRequest;
import com.miniproject.studentmicroimpl.response.AddressResponse;
import com.miniproject.studentmicroimpl.response.StudentResponse;
import com.miniproject.studentmicroimpl.service.StudentServiceImpl;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	StudentServiceImpl serviceImpl;

	@GetMapping("/{id}")
	@Timed(value ="getStudentDetails",description = "Time taken to return student details")
	public StudentResponse getStudentById(@PathVariable Integer id) {
		return serviceImpl.getStudentById(id);
	}
	
   @PostMapping
	public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
	 return serviceImpl.createStudent(studentRequest);
	}

	@PutMapping("/{id}")
	public StudentResponse updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
		
		return serviceImpl.updateStudent(id, studentRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		serviceImpl.deleteStudent(id);
	}

	@PutMapping("updateAddress/{id}")
	public AddressResponse updateStudentAddress(@PathVariable Integer id, @RequestBody AddressRequest addressRequest) {
     	return serviceImpl.updateStudentAddress(id, addressRequest);
	}
	
	@PutMapping("availLeave/{studentId}/{leaveNo}")
	public String availLeave(@PathVariable Integer studentId,@PathVariable Integer leaveNo) {
		return serviceImpl.availLeave(studentId, leaveNo);
	
	}
	

}
