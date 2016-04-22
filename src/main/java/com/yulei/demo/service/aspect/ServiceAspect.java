package com.yulei.demo.service.aspect;

import com.yulei.demo.common.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ServiceAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);
    @Around("execution(* com.yulei.demo.service.*Impl.*(..))")
    public Object process(ProceedingJoinPoint jp) throws Throwable {
        try {
        	String methodInfo = jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
        	String paramInfo = JsonUtil.toJson(jp.getArgs());
        	logger.info("[SI_REQ]:[{}]:---->: {}", methodInfo, paramInfo);
        	
        	Object rvt = jp.proceed();
            String returnInfo = JsonUtil.toJson(rvt);
            logger.info("[SI_RSP]:[{}]:---->: {}", methodInfo, returnInfo);
            return rvt; 
        } catch (Exception e) {
            logger.error("SYS_ERROR:"+ e.getMessage(), e);
        	throw e;
        }
    }
}
