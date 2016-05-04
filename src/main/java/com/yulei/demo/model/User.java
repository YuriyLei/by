package com.yulei.demo.model;

import com.yulei.demo.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity<Long> implements Serializable{

    @Column
    private Long userCode;
    @Column
    private String password;
    @Column
    private String realName;
    @Column
    private short power;
    @Column
    private short collegeId;
    @Column
    private int positionID;
    @Column
    private String subject;
    @Column
    private String intro;
    @Column
    private String portrait;
    @Column
    private String degree;
    @Column
    private String sector;
    @Column
    private String jobTitle;
    @Column
    private short year;
    public User(){}

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public short getPower() {
        return power;
    }

    public void setPower(short power) {
        this.power = power;
    }

    public short getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(short collegeId) {
        this.collegeId = collegeId;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
