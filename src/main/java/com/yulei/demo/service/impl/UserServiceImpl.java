package com.yulei.demo.service.impl;

import com.yulei.demo.repository.UserRepositoy;
import com.yulei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoy userRepositoy;
}
