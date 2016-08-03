package com.yulei.demo;

import com.yulei.demo.model.News;

/**
 * Created by 余磊 on 2016/5/29.
 */
public interface NewsService {
        News saveNewsWithAttachment(News notice, String string);

        News findOne(long id);
}
