package com.yulei.demo.controller;

import com.yulei.demo.common.BaseEntity;
import com.yulei.demo.common.Result;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private Result result;

    @RequestMapping(value = "uploadAttachment",method = RequestMethod.POST)
    @ResponseBody
    public Result upLoad(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        String shortId = request.getParameter("shortId");
        //解析器解析request的上下文
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        //先判断request中是否包涵multipart类型的数据，
        if(multipartResolver.isMultipart(request)) {
            //再将request中的数据转化成multipart类型的数据
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multiRequest.getFileNames();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy");
            Attachment attachment = new Attachment();
            //attachment.setShortId(UUID.randomUUID().toString().replace("-",""));
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                String pathDir = "/upload/attachment/"+ dateformat2.format(new Date()) +"/"+ dateformat1.format(new Date());
                /**得到保存目录的真实路径**/
                String realPathDir = request.getSession().getServletContext().getRealPath(pathDir);
                /**根据真实路径创建目录**/
                File saveFile = new File(realPathDir);
                if(!saveFile.exists())
                    saveFile.mkdirs();
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    String pre = fileName.substring(0,fileName.lastIndexOf("."));
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String realName = pre+"."+dateformat.format(new Date())+suffix;
                    System.out.println(realName);
                    File localFile = new File(realPathDir + File.separator+realName);
                    //写文件到本地
                    file.transferTo(localFile);
                    //保存记录

                    attachment.setAttachmentAddress(pathDir+File.separator+realName);
                    attachment.setAttachmentName(fileName);
                    attachment.setCreatedAt(new Date());
                    attachment.setDeleted(BaseEntity.UNDELETED);
                    attachment.setShortId(shortId);
                    attachment = attachmentRepository.save(attachment);

                    if(null!=attachment){
                        result.setStatus(1);
                        result.setObject(attachment.getId());
                        return  result;
                    }else{
                        result.setStatus(0);
                        return result;
                    }
                }
            }
        }
        return result;
    }

}
