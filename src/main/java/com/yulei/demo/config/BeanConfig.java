package com.yulei.demo.config;

import com.yulei.demo.common.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Configuration
public class BeanConfig {
    @Bean(name = "result")
    public Result setResult(){
        return new Result();
    }

}
