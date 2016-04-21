package com.yulei.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yulei.demo.model.Student;
import com.yulei.demo.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@RequestMapping(value="/findStuByClass/{id}")
	public Page <Student> findStudentByClassId(@PathVariable Integer id,int page,int size){
		Page <Student> ps = studentRepository.findByClassId(id, new PageRequest(page,size));
		return ps;
	}
	@RequestMapping(value="/findStuByStudentNameAndPassword")
	public String findStuByStudentNameAndPassword(Integer studentNumber,String password){
		System.out.println(studentNumber+"  "+ password);
		if( null == studentRepository.findStudentByStudentNumberAndPassword(studentNumber,password))
			return "fail";
		return "visible/home";
	}
}
