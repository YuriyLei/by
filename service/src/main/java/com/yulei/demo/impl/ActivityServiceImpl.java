package com.yulei.demo.impl;

import com.yulei.demo.ActivityService;
import com.yulei.demo.AttachmentService;
import com.yulei.demo.common.WordToHtml;
import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.repository.ActivityRepository;
import com.yulei.demo.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;
    public Activity saveActivityWithAttachment(Activity activity, String shortId) {
        List<Attachment> list= attachmentRepository.findAllByShortId(shortId);
        StringBuffer sb = new StringBuffer();
        for(Attachment attachment:list){
            sb.append(attachment.getId());
            sb.append(";");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        activity.setAttachmentId(sb.toString());
        activity = activityRepository.save(activity);
        attachmentService.updataNewsId(list,activity.getId(),2);
        return activity;
    }

    public Activity findOne(long id) {
        Activity activity = activityRepository.findOne(id);
        if(activity.getContentType()==1){
            try {
                activity.setContent(new WordToHtml().getWordAndStyle("E:\\demo\\src\\main\\webapp" + activity.getContent()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return activity;
    }
}
