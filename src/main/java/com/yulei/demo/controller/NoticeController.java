package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.NoticeRepository;
import com.yulei.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    @RequestMapping(value = "addNotice")
    @ResponseBody
    public Result addNotice(@PathVariable Notice notice){
        result.setStatus(noticeRepository.save(notice)!=null?1:0);
        return result;
    }
}
