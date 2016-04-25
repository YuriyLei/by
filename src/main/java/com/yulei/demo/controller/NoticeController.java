package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.NoticeRepository;
import com.yulei.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
