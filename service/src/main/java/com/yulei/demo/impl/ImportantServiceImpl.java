package com.yulei.demo.impl;

import com.yulei.demo.AttachmentService;
import com.yulei.demo.ImportantService;
import com.yulei.demo.common.WordToHtml;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.Important;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.repository.ImportantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class ImportantServiceImpl implements ImportantService {
    @Autowired
    private ImportantRepository importantRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private AttachmentService attachmentService;
    public Important saveImportantWithAttachment(Important important, String shortId) {
        List<Attachment> list= attachmentRepository.findAllByShortId(shortId);
        StringBuffer sb = new StringBuffer();
        for(Attachment attachment:list){
            sb.append(attachment.getId());
            sb.append(";");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        important.setAttachmentId(sb.toString());
        important = importantRepository.save(important);
        attachmentService.updataNewsId(list,important.getId(),3);
        return important;
    }

    public Important findOne(long id) {
        Important important = importantRepository.findOne(id);
        if(important.getContentType()==1){
            try {
                important.setContent(new WordToHtml().getWordAndStyle("E:\\demo\\src\\main\\webapp" + important.getContent()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return important;
    }
}
