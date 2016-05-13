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
@Table(name = "image")
public class Image extends BaseEntity<Long> implements Serializable {
    @Column
    private String title;
    //4为轮播新闻
    @Column
    public int type;
    @Column
    private String content;
    @Column
    private int isCarousel;
    @Column
    private String address;
    @Column
    private String attachmentId;

    //    @Column
//    private String shortId;
    public Image() {
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public int getIsCarousel() {
        return isCarousel;
    }

    public void setIsCarousel(int isCarousel) {
        this.isCarousel = isCarousel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
