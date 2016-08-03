package com.yulei.demo.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.yulei.demo.AttachmentService;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;

    public void updataNewsId(List<Attachment> attachmentList, long newsId,int type) {
        for (Attachment attachment:attachmentList) {
            attachment.setNewsId(newsId);
            attachment.setType(type);
            attachmentRepository.save(attachment);
        }
    }

    public List<Attachment> getAttachmentListByIds(String attachmentIds) {
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        List<String> idList= Lists.newArrayList(Splitter.on(";").trimResults().omitEmptyStrings().split(attachmentIds));
        for(String s:idList){
            attachmentList.add(attachmentRepository.findOne( Long.parseLong(s)));
        }
        return attachmentList;
    }
}
