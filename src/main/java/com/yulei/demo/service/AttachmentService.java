package com.yulei.demo.service;

import com.yulei.demo.model.Attachment;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface AttachmentService {
    void updataNewsId(List<Attachment> attachmentList, long noticeId,int type);
}
