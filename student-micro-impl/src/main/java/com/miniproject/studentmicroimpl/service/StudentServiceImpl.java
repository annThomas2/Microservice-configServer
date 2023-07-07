package com.miniproject.studentmicroimpl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.studentmicroimpl.entity.Student;
import com.miniproject.studentmicroimpl.feign.client.AddressServiceClient;
import com.miniproject.studentmicroimpl.repository.StudentRepository;
import com.miniproject.studentmicroimpl.request.AddressRequest;
import com.miniproject.studentmicroimpl.request.StudentRequest;
import com.miniproject.studentmicroimpl.response.AddressResponse;
import com.miniproject.studentmicroimpl.response.StudentResponse;

import feign.FeignException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	AddressServiceClient addressServiceClient;

	@Autowired
	CommonService commonService;

	public Student convertRequestToEntity(StudentRequest request) {
		Student student = new Student();
		student.setStudentId(request.getStudentId());
		student.setName(request.getName());
		student.setDepartmentId(request.getDepartmentId());
		student.setAvailableNumberOfLeaves(request.getAvailableNumberOfLeaves());
		student.setGender(request.getGender());
		student.setPhoneNumber(request.getPhoneNumber());
		student.setAddressId(request.getAddressId());
		return student;
	}

	public StudentResponse convertEntityToResponse(Student student) {
		StudentResponse response = new StudentResponse();
		System.out.println("Student id is " + student.getStudentId());
		response.setStudentId(student.getStudentId());
		response.setName(student.getName());
		response.setDepartmentId(student.getDepartmentId());
		response.setAvailableNumberOfLeaves(student.getAvailableNumberOfLeaves());
		response.setGender(student.getGender());
		response.setPhoneNumber(student.getPhoneNumber());
		try {

			response.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		} catch (FeignException exception) {
			// Handle the case when the address is not found
			System.out.println("Address not found for ID: " + student.getAddressId());

		}

		return response;
	}

	@Override
	public StudentResponse getStudentById(Integer id) {
		System.out.println("Inside student service getstudent by id");
		Student student = studentRepository.findById(id).get();
		return convertEntityToResponse(student);
	}

	@Override
	public StudentResponse createStudent(StudentRequest studentRequest) {

		Student student = convertRequestToEntity(studentRequest);
		studentRepository.save(student);
		System.out.println();
		return convertEntityToResponse(student);
	}

	@Override
	public StudentResponse updateStudent(Integer id, StudentRequest studentRequest) {
		Student student = convertRequestToEntity(studentRequest);
		studentRepository.save(student);
		return convertEntityToResponse(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.deleteById(id);
		addressServiceClient.deleteAddress(student.getAddressId());
	}

	@Override
	public AddressResponse updateStudentAddress(Integer studId, AddressRequest addressRequest) {
		Student student = studentRepository.findById(studId).get();
		return addressServiceClient.updateAddress(addressRequest, student.getAddressId()).getBody();
	}

	@Override
	public String availLeave(Integer studentId, Integer leaveNo) {
		Student student = new Student();
		if (leaveNo >= 0) {
			student = studentRepository.findById(studentId).get();
			int a = student.getAvailableNumberOfLeaves();
			while (a != 0) {
				if (a - leaveNo >= 0) {
					System.out.println(student);
					System.out.println(a - leaveNo);
					student.setAvailableNumberOfLeaves(a - leaveNo);
					return "Leave Applied";
				} else
					return "Leaves cannot be granted due to insufficient leave balance";
			}
			return "Leaves cannot be granted due to insufficient leave balance";
		} else
			return "Enter a Number greater than 0";
	}

}
