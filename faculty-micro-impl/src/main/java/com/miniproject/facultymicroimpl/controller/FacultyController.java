package com.miniproject.facultymicroimpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.facultymicroimpl.request.FacultyRequest;
import com.miniproject.facultymicroimpl.response.FacultyResponse;
import com.miniproject.facultymicroimpl.service.FacultyService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

	@Autowired
	FacultyService facultyService;

	@GetMapping("/{id}")
	public FacultyResponse getFacultyById(@PathVariable Integer id) {
		return facultyService.getFacultyById(id);
	}

	@PostMapping
	public FacultyResponse createFaculty(@RequestBody FacultyRequest facultyRequest) {
		return facultyService.createFaculty(facultyRequest);
	}

	@PutMapping("/{id}")
	public FacultyResponse updateFaculty(@PathVariable Integer id, @RequestBody FacultyRequest facultyRequest) {

		return facultyService.updateFaculty(id, facultyRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteFaculty(@PathVariable Integer id) {
		facultyService.deleteFaculty(id);
	}

	@PutMapping("availLeave/{id}/{leaveNo}")
	public String availLeave(@PathVariable Integer id, @PathVariable Integer leaveNo) {
		return facultyService.availLeave(id, leaveNo);

	}

}