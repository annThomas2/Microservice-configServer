package com.miniproject.facultymicroimpl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.facultymicroimpl.client.AddressServiceClient;
import com.miniproject.facultymicroimpl.entity.Faculty;
import com.miniproject.facultymicroimpl.repository.FacultyRepository;
import com.miniproject.facultymicroimpl.request.FacultyRequest;
import com.miniproject.facultymicroimpl.response.FacultyResponse;

import feign.FeignException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacultyService {

	@Autowired
	FacultyRepository facultyRepo;

	@Autowired
	CommonService commonService;

	@Autowired
	AddressServiceClient addressServiceclient;

	public Faculty convertRequestToEntity(FacultyRequest request) {
		Faculty faculty = new Faculty();
		faculty.setFacultyId(request.getFacultyId());
		faculty.setName(request.getName());
		faculty.setDepartmentId(request.getDepartmentId());
		faculty.setAvailableNumberOfLeaves(request.getAvailableNumberOfLeaves());
		faculty.setGender(request.getGender());
		faculty.setPhoneNumber(request.getPhoneNumber());
		faculty.setAddressId(request.getAddressId());
		return faculty;
	}

	public FacultyResponse convertEntityToResponse(Faculty faculty) {
		FacultyResponse response = new FacultyResponse();
		System.out.println("Faculty id is " + faculty.getFacultyId());
		response.setFacultyId(faculty.getFacultyId());
		response.setName(faculty.getName());
		response.setDepartmentId(faculty.getDepartmentId());
		response.setAvailableNumberOfLeaves(faculty.getAvailableNumberOfLeaves());
		response.setGender(faculty.getGender());
		response.setPhoneNumber(faculty.getPhoneNumber());
		try {

			response.setAddressResponse(commonService.getAddressById(faculty.getAddressId()));
		} catch (FeignException exception) {
			// Handle the case when the address is not found
			System.out.println("Address not found for ID: " + faculty.getAddressId());

		}

		return response;

	}

	public FacultyResponse getFacultyById(Integer id) {
		Faculty student = facultyRepo.findById(id).get();
		return convertEntityToResponse(student);

	}

	public FacultyResponse createFaculty(FacultyRequest studentRequest) {

		Faculty faculty = convertRequestToEntity(studentRequest);
		facultyRepo.save(faculty);
		System.out.println();
		return convertEntityToResponse(faculty);
	}

	public FacultyResponse updateFaculty(Integer id, FacultyRequest facultyRequest) {
		Faculty faculty = convertRequestToEntity(facultyRequest);
		facultyRepo.save(faculty);
		return convertEntityToResponse(faculty);
	}

	public void deleteFaculty(Integer id) {
		Faculty faculty = facultyRepo.findById(id).get();
		facultyRepo.deleteById(id);
		addressServiceclient.deleteAddress(faculty.getAddressId());
	}

	public String availLeave(Integer id, Integer leaveNo) {
		Faculty student = new Faculty();
		if (leaveNo >= 0) {
			student = facultyRepo.findById(id).get();
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
