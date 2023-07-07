package com.miniproject.studentmicroimpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.studentmicroimpl.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
