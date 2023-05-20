package com.restful.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.studentmgmt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
