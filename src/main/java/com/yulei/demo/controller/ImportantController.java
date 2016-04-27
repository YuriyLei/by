package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.ImportantRepository;
import com.yulei.demo.service.ImportantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("/important")
public class ImportantController {
    @Autowired
    private ImportantService importantService;
    @Autowired
    private ImportantRepository importantRepository;
    @Autowired
    private Result result;
    @RequestMapping(value = "uploadImportant",method = RequestMethod.POST)
    @ResponseBody
    public Result upLoad(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
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
            while (iter.hasNext()) {

                MultipartFile file = multiRequest.getFile((String) iter.next());
                String pathDir = "/upload/collegeNews/"+ dateformat2.format(new Date()) +"/"+ dateformat1.format(new Date());
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
                    Important important = new Important();
                    important.setTitle(fileName);
                    important.setContentType(1);
                    important.setContent(pathDir+File.separator+realName);
                    result.setStatus(null!=importantRepository.save(important)?1:0);
                }
            }
        }
        return result;
    }

    @RequestMapping(value = "addImportant",method = RequestMethod.POST)
    @ResponseBody
    public Result addImportant(@RequestBody Important important){
        //System.out.println(notice.getContent());
        result.setStatus(importantRepository.save(important)!=null?1:0);
        return result;
    }
    @RequestMapping(value = "addImportantWithAttachment/{shortId}",method = RequestMethod.POST)
    @ResponseBody
    public Result addNoticeWithAttachment(@RequestBody Important important,@PathVariable("shortId") String shortId){
        System.out.println(shortId);
        result.setStatus(importantService.saveImportantWithAttachment(important,shortId)!=null?1:0);
        return result;
    }
}
