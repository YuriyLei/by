package com.yulei.demo.service.impl;

import com.yulei.demo.common.WordToHtml;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.repository.NoticeRepository;
import com.yulei.demo.service.AttachmentService;
import com.yulei.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;
    public Notice saveNoticeWithAttachment(Notice notice, String shortId) {
        List<Attachment> list= attachmentRepository.findAllByShortId(shortId);
        StringBuffer sb = new StringBuffer();
        for(Attachment attachment:list){
            sb.append(attachment.getId());
            sb.append(";");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        notice.setAttachmentId(sb.toString());
        notice = noticeRepository.save(notice);
        attachmentService.updataNewsId(list,notice.getId(),1);
        return notice;
    }

    public Notice findOne(long id) {
        Notice notice = noticeRepository.findOne(id);
        if (notice.getContentType()==1){
            String fileName = "E:\\demo\\src\\main\\webapp"+notice.getContent();
            try {
                String str = new WordToHtml().getWordAndStyle(fileName);
                notice.setContent(str);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return notice;
    }
}
