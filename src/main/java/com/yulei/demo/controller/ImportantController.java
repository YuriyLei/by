package com.yulei.demo.controller;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.yulei.demo.common.Result;
import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.repository.ImportantRepository;
import com.yulei.demo.repository.UserRepository;
import com.yulei.demo.service.ImportantService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
    private UserRepository userRepository;
    @Autowired
    private Result result;
@Autowired
private AttachmentRepository attachmentRepository;
    /**
     * 上传word文档类型的学院新闻
     * @param request
     * @param response
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequiresPermissions("important:uploadImportant")
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
                    important.setTitle(pre);
                    important.setType(3);
                    important.setCreatedAt(new Date());
                    important.setContentType(1);
                    important.setContent(pathDir+File.separator+realName);
                    result.setStatus(null!=importantRepository.save(important)?1:0);
                }
            }
        }
        return result;
    }

    /**
     * 添加学院新闻
     * @param important
     * @return
     */
    @RequiresPermissions("important:addImportant")
    @RequestMapping(value = "addImportant",method = RequestMethod.POST)
    @ResponseBody
    public Result addImportant(@RequestBody Important important){
        important.setType(3);
        important.setCreatedAt(new Date());
        result.setStatus(importantRepository.save(important)!=null?1:0);
        return result;
    }

    /**
     * 添加带附件的学院新闻
     * @param important
     * @param shortId
     * @return
     */
    @RequiresPermissions("important:addImportantWithAttachment")
    @RequestMapping(value = "addImportantWithAttachment/{shortId}",method = RequestMethod.POST)
    @ResponseBody
    public Result addNoticeWithAttachment(@RequestBody Important important,@PathVariable("shortId") String shortId){
        important.setType(3);
        result.setStatus(importantService.saveImportantWithAttachment(important,shortId)!=null?1:0);
        return result;
    }

    /**
     * 根据请求id，读取一条新闻
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="readOne/{id}")
    public String readOneNews(@PathVariable long id, Model model){
        Important important = importantService.findOne(id);
        User user = userRepository.findSectorById(important.getCreatedBy());
        if(null != important.getAttachmentId()) {
            List<Attachment> attachmentList = new ArrayList<Attachment>();
            List<String> idList= Lists.newArrayList(Splitter.on(";").trimResults().omitEmptyStrings().split(important.getAttachmentId()));
            for(String s:idList){
                attachmentList.add(attachmentRepository.findOne( Long.parseLong(s)));
            }
            model.addAttribute("attachmentList",attachmentList);
        }
        model.addAttribute("user",user);
        model.addAttribute("news",important);
        return "showNews";
    }

    /**
     * 获取分页排序的important列表
     * @param model
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/newsListShow")
    public String newsList(Model model,Pageable pageable){
        System.out.println(pageable.getPageSize()+" "+pageable.getPageNumber());
        Page<Important> list =  importantRepository.findAll(pageable);
        System.out.println(pageable.getPageSize()+" "+pageable.getPageNumber());
        model.addAttribute("pageable",list);
        model.addAttribute("newsList",list.getContent());
        model.addAttribute("pageUrl","/important/newsListShow?size="+pageable.getPageSize()+"&sort=createdAt,desc");
        model.addAttribute("type", 3);
        return "newsList";
    }
}
