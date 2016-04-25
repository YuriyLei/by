package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.NoticeRepository;
import com.yulei.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private Result result;
    @RequestMapping(value = "addNotice",method = RequestMethod.POST)
    @ResponseBody
    public Result addNotice(@RequestBody Notice notice){
        //System.out.println(notice.getContent());
        result.setStatus(noticeRepository.save(notice)!=null?1:0);
        return result;
    }

    @RequestMapping(value = "uploadNotice",method = RequestMethod.POST)
    @ResponseBody
    public Result upLoad(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        //解析器解析request的上下文
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        //先判断request中是否包涵multipart类型的数据，
        if(multipartResolver.isMultipart(request)) {
            //再将request中的数据转化成multipart类型的数据
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                MultipartFile file = multiRequest.getFile((String) iter.next());
                String pathDir = "/upload/news/"+ dateformat.format(new Date());
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
                    Notice notice = new Notice();
                    notice.setTitle(fileName);
                    notice.setContentType(1);
                    notice.setContent(pathDir+File.separator+realName);
                    result.setStatus(null!=noticeRepository.save(notice)?1:0);
                }
            }
        }
        return result;
    }
    @RequestMapping(value="readOne/{id}")
    public String readOneNews(@PathVariable long id, Model model){
        model.addAttribute("notice",noticeRepository.findOne(id));
        return "showNews";
    }
    @RequestMapping(value="getOne/{id}")
    @ResponseBody
    public Result getOne(@PathVariable long id){
        result.setStatus(1);
        result.setObject(noticeRepository.findOne(id));
        return result;
    }
}
