package com.yulei.demo.impl;

import com.yulei.demo.ViewFinderService;
import com.yulei.demo.repository.ViewFinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.yulei.demo.BaseEntity.UNDELETED;


/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class ViewFinderServiceImpl implements ViewFinderService {
    @Autowired
    private ViewFinderRepository viewFinderRepository;

    public Map<String, Object> getLeftInfoMapById(Long type) {
        Map<String, Object> left = new HashMap<String, Object>();
        Long parentId = viewFinderRepository.findOne(type).getParentId();
        left.put("firstView",viewFinderRepository.findOne(parentId));
        left.put("currentView",type);
        left.put("secondView",viewFinderRepository.findAllByParentIdAndDeleted(parentId,UNDELETED));
        return left;
    }
}
