package com.miniproject.facultymicroimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.facultymicroimpl.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
