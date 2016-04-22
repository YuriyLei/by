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
@Table(name = "college")
public class College extends BaseEntity<Long> implements Serializable{

    @Column
    private short collegeId;
    @Column
    private String collegeName;
    @Column
    private String address;

    public College(){}

    public short getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(short collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
