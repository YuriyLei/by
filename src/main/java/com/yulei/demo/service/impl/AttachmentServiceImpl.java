package com.yulei.demo.service.impl;

import com.yulei.demo.model.Attachment;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService{
    @Autowired
    private AttachmentRepository attachmentRepository;

    public void updataNewsId(List<Attachment> attachmentList, long newsId,int type) {
        for (Attachment attachment:attachmentList) {
            attachment.setNewsId(newsId);
            attachment.setType(type);
            attachmentRepository.save(attachment);
        }
    }
}
