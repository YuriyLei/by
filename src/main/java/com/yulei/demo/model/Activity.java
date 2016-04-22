package com.yulei.demo.model;

import com.yulei.demo.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/4/22.
 * @author lei.yu
 */
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity<Long> implements Serializable{
    @Column
    private String content;
    //0:文本  1：word   2.excel
    @Column
    private Short contentType;
    @Column
    private String attachment_id;

    public Activity(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getContentType() {
        return contentType;
    }

    public void setContentType(Short contentType) {
        this.contentType = contentType;
    }

    public String getAttachment_id() {
        return attachment_id;
    }

    public void setAttachment_id(String attachment_id) {
        this.attachment_id = attachment_id;
    }
}
