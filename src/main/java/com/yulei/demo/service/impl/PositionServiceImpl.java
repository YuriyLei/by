package com.yulei.demo.service.impl;

import com.yulei.demo.repository.PositionRepository;
import com.yulei.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionRepository positionRepository;
}
