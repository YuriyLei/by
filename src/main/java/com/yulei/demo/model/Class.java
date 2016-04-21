package com.yulei.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="class")
public class Class implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer classId;
	@Column
	private int year;
	@Column
	private int colleageCode;
	@Column
	private int claCode;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getColleageCode() {
		return colleageCode;
	}
	public void setColleageCode(int colleageCode) {
		this.colleageCode = colleageCode;
	}
	public int getClaCode() {
		return claCode;
	}
	public void setClaCode(int claCode) {
		this.claCode = claCode;
	}
	
}
