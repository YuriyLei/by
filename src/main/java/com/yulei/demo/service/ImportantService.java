package com.yulei.demo.service;

import com.yulei.demo.model.Important;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface ImportantService {
    Important saveImportantWithAttachment(Important important, String shortId);
}
