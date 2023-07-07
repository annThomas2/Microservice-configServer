package com.miniproject.studentmicroimpl.service;

import com.miniproject.studentmicroimpl.request.AddressRequest;
import com.miniproject.studentmicroimpl.request.StudentRequest;
import com.miniproject.studentmicroimpl.response.AddressResponse;
import com.miniproject.studentmicroimpl.response.StudentResponse;

public interface StudentService {

	public StudentResponse getStudentById(Integer id);

	public StudentResponse createStudent(StudentRequest studentRequest);

	public StudentResponse updateStudent(Integer id, StudentRequest studentRequest );

	public void deleteStudent(Integer id);
	
	public AddressResponse updateStudentAddress(Integer studId,AddressRequest addressRequest);
	
	public String availLeave (Integer studentId, Integer leaveNo);

}
