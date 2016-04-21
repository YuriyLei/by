package com.yulei.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4729754693544778962L;

	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer teacherId;
	@Column
	private String teacherName;
	@Column
	private Integer age;


}
