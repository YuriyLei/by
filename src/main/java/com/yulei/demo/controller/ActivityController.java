package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.ActivityRepository;
import com.yulei.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Date;
import java.util.Iterator;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private Result result;
    @Autowired
    private ActivityRepository activityRepository;
    @RequestMapping(value = "uploadActivity",method = RequestMethod.POST)
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
                String pathDir = "/upload/activityNews/"+ dateformat2.format(new Date()) +"/"+ dateformat1.format(new Date());
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
                    Activity activity = new Activity();
                    activity.setTitle(fileName);
                    activity.setContentType(1);
                    activity.setContent(pathDir+File.separator+realName);
                    result.setStatus(null!=activityRepository.save(activity)?1:0);
                }
            }
        }
        return result;
    }


    @RequestMapping(value = "addActivity",method = RequestMethod.POST)
    @ResponseBody
    public Result addNotice(@RequestBody Activity activity){
        //System.out.println(notice.getContent());
        result.setStatus(activityRepository.save(activity)!=null?1:0);
        return result;
    }
    @RequestMapping(value = "addNoticeWithAttachment/{shortId}",method = RequestMethod.POST)
    @ResponseBody
        public Result addActivityWithAttachment(@RequestBody Activity activity,@PathVariable("shortId") String shortId){
        System.out.println(shortId);
        result.setStatus(activityService.saveActivityWithAttachment(activity,shortId)!=null?1:0);
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
        Activity activity = activityService.findOne(id);
        model.addAttribute("activity",activity);
        return "showNews";
    }
}
