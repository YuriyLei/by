package com.yulei.demo.controller;

import com.yulei.demo.AttachmentService;
import com.yulei.demo.NewsService;
import com.yulei.demo.ViewFinderService;
import com.yulei.demo.config.Result;
import com.yulei.demo.model.Attachment;
import com.yulei.demo.model.News;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.AttachmentRepository;
import com.yulei.demo.repository.NewsRepository;
import com.yulei.demo.repository.SectorRepository;
import com.yulei.demo.repository.UserRepository;
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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.yulei.demo.BaseEntity.UNDELETED;
import static com.yulei.demo.controller.ShiroController.getSession;


/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private SectorRepository sectorRepository;
    @Autowired
    private AttachmentService attachmentService;
@Autowired
private ViewFinderService viewFinderService;
    @Autowired
    private Result result;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private UserRepository userRepository;
    /**
     * 添加新闻
     * @param news
     * @return Json
     */
    @RequiresPermissions("news:addNews")
    @RequestMapping(value = "addNews",method = RequestMethod.POST)
    @ResponseBody
    public Result addNews(@RequestBody News news){
        news.setCreatedBy(((User)getSession().getAttribute("user")).getId());
        news.setCreatedAt(new Date());
        result.setStatus(newsRepository.save(news)!=null?1:0);
        return result;
    }

    /**
     * 添加通知公告，带附件id
     * @param news
     * @param shortId
     * @return
     */
    @RequiresPermissions("news:addNewsWithAttachment")
    @RequestMapping(value = "addNewsWithAttachment/{shortId}",method = RequestMethod.POST)
    @ResponseBody
    public Result addNewsWithAttachment(@RequestBody News news,@PathVariable("shortId") String shortId){
        news.setCreatedAt(new Date());
        result.setStatus(newsService.saveNewsWithAttachment(news,shortId)!=null?1:0);
        return result;
    }

    /**
     * 上传word文档
     * @param request
     * @param type
     * @return Json
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequiresPermissions("news:uploadNews")
    @RequestMapping(value = "uploadNews/{type}",method = RequestMethod.POST)
    @ResponseBody
    public Result upLoad(HttpServletRequest request, @PathVariable Long type) throws IllegalStateException, IOException{

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
                String pathDir = String.format("/upload/news/" + dateformat2.format(new Date()) +"/"+ dateformat1.format(new Date()) );
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
                    News news = new News();
                    news.setTitle(pre);
                    news.setCreatedBy(((User)getSession().getAttribute("user")).getId());
                    news.setContentType(1);
                    news.setCreatedAt(new Date());
                    news.setType(type);
                    news.setContent(pathDir+File.separator+realName);
                    result.setStatus(null!=newsRepository.save(news)?1:0);
                }
            }
        }
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
        News news = newsService.findOne(id);
        Long sectorId = userRepository.findSectorIdById(news.getCreatedBy());

        if(null!=news.getAttachmentId()) {
            List<Attachment> attachmentList = attachmentService.getAttachmentListByIds(news.getAttachmentId());
            model.addAttribute("attachmentList",attachmentList);
        }
        Map<String,Object> leftInfo = viewFinderService.getLeftInfoMapById(news.getType());
        model.addAttribute("leftInfo",leftInfo);
        model.addAttribute("news",news);
        model.addAttribute("sector",sectorRepository.findOne(sectorId));
        return "showNews";
    }

    /**
     * 获取分页排序的notice列表
     * @param model
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/newsListShow/{type}")
    public String newsList(Model model,Pageable pageable,@PathVariable Long type){
        Page<News> list =  newsRepository.findAllByDeletedAndType(pageable,UNDELETED,type);
        System.out.println(pageable.getPageSize()+" "+pageable.getPageNumber());
        model.addAttribute("newsList",list.getContent());
        model.addAttribute("leftInfo",viewFinderService.getLeftInfoMapById(type));
        model.addAttribute("pageUrl","/news/newsListShow/"+type+"?size="+pageable.getPageSize()+"&sort=createdAt,desc");
        model.addAttribute("pageable",list);
        return "newsList";
    }
}
