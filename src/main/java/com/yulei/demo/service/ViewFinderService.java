package com.yulei.demo.service;

import com.yulei.demo.model.Activity;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface ViewFinderService {
    Activity saveActivityWithAttachment(Activity activity, String shortId);

    Activity findOne(long id);
}
