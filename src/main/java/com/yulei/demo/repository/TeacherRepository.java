package com.yulei.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.yulei.demo.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
