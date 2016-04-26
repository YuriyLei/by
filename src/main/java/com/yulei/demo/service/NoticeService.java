package com.yulei.demo.service;

import com.yulei.demo.model.Notice;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface NoticeService {
    Notice saveNoticeWithAttachment(Notice notice,String string);
}
