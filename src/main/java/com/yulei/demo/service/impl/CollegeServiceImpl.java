package com.yulei.demo.service.impl;

import com.yulei.demo.repository.CollegeRepository;
import com.yulei.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class CollegeServiceImpl implements CollegeService{
    @Autowired
    private CollegeRepository collegeRepository;
}
