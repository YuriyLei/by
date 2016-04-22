package com.yulei.demo.service.impl;

import com.yulei.demo.repository.ImportantRepository;
import com.yulei.demo.service.ImportantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class ImportantServiceImpl implements ImportantService{
    @Autowired
    private ImportantRepository importantRepository;
}
