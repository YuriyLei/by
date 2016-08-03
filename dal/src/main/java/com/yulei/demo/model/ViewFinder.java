package com.yulei.demo.model;

import com.yulei.demo.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 余磊 on 2016/5/30.
 */
@Entity
@Table(name="viewfinder")
public class ViewFinder extends BaseEntity<Long> implements Serializable{

    private String viewName;

    private Long parentId;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
