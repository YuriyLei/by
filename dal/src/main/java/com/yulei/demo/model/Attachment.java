package com.yulei.demo.model;

import com.yulei.demo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Entity
@Table(name="attachment")
public class Attachment extends BaseEntity<Long> implements Serializable{
    @Column
    private String attachmentName;
    @Column
    private String attachmentAddress;
    @Column
    private String shortId;
    @Column Long newsId;
    @Column int type;//1:notice;2:activity;3:important
    public Attachment(){}

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentAddress() {
        return attachmentAddress;
    }

    public void setAttachmentAddress(String attachmentAddress) {
        this.attachmentAddress = attachmentAddress;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}
