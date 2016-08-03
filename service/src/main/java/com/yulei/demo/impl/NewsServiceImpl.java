package com.yulei.demo.impl;

import com.yulei.demo.AttachmentService;
import com.yulei.demo.NewsService;
import com.yulei.demo.common.WordToHtml;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.News;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 余磊 on 2016/5/29.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;
    public News saveNewsWithAttachment(News news, String shortId) {
        List<Attachment> list= attachmentRepository.findAllByShortId(shortId);
        StringBuffer sb = new StringBuffer();
        for(Attachment attachment:list){
            sb.append(attachment.getId());
            sb.append(";");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        news.setAttachmentId(sb.toString());
        news = newsRepository.save(news);
        attachmentService.updataNewsId(list,news.getId(),1);
        return news;
    }

    public News findOne(long id) {
        News news = newsRepository.findOne(id);
        if (news.getContentType()==1){
            String fileName = "E:\\demo\\src\\main\\webapp"+news.getContent();
            try {
                String str = new WordToHtml().getWordAndStyle(fileName);
                news.setContent(str);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return news;
    }
}
