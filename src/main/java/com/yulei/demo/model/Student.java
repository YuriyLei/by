package com.yulei.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lei.yu
 *
 */
@Entity
@Table(name="student")
public class Student implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	  @Id
	  @Column(name="id")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Integer studentId;
	  @Column
	  private Integer studentNumber;

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Column
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	  private Integer classId;
	  @Column
	  private Integer teacherId;
	  @Column
	  private int age;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}






}
