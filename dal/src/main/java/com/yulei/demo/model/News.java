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
@Table(name = "news")
public class News extends BaseEntity<Long> implements Serializable {
    @Column
    private String title;
    @Column
    public Long type;
    @Column
    private String content;
    //0:文本  1：word地址
    @Column
    private int contentType;
    @Column
    private String attachmentId;

    public News() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentType() {
        return contentType;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
