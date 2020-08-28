package com.kamfu.web.util;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.log4j.Log4j2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @desc: 日志切面
 * @author: ruanjianbo
 **/
@Aspect
@Component
@Log4j2
public class LogAspect {


    private JSONObject jsonObject = new JSONObject();

    /**
     * 定义切入点
     */
    @Pointcut("execution(public * com.kamfu.*.controller..*.*(..))")
    public void pointcut(){
    	log.info("pointcut");
    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
    	log.info("before");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning(pointcut = "pointcut()", returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("请求参数 : " + Arrays.toString(joinPoint.getArgs()));
        log.info("请求结果 : " + jsonObject.toJSONString(object));
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("请求参数 : " + Arrays.toString(joinPoint.getArgs()));
        log.info("请求异常 : " + ex);
        log.info("异常位置 : " + ex.getStackTrace()[0]);
    }
}