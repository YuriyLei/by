package com.yulei.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.yulei.demo.model.Student;

public interface StudentRepository extends Repository<Student,Integer>{
	Page<Student> findByClassId(Integer classid,Pageable pageable);

	Student findStudentByStudentNumberAndPassword(Integer studentNumber,String password);
}
