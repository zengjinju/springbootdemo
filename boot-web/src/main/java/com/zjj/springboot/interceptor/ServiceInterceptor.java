package com.zjj.springboot.interceptor;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * Created by admin on 2017/9/11.
 */
@Aspect
@Order(-99)
@Service
public class ServiceInterceptor {
    Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

    @Pointcut("execution(public * com.zjj.springboot.service.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Class clazz = joinPoint.getTarget().getClass();
        Method targetMethod = MethodSignature.class.cast(joinPoint.getSignature()).getMethod();
        logger.info("当前正在执行:" + clazz.getName() + "." + targetMethod.getName() + "方法");
        parameterString(joinPoint);
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("未知异常{}", throwable);
            throwable.printStackTrace();
        }
        return result;
    }

    private void parameterString(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        try {
            MethodSignature methodSignature = MethodSignature.class.cast(joinPoint.getSignature());
            String[] parameterNames = methodSignature.getParameterNames();
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < parameterNames.length; i++) {
                sb.append(parameterNames[i]).append("=").append(JSON.toJSONString(args[i]));
                if (i != parameterNames.length - 1) {
                    sb.append(",");
                }
            }
            logger.info("请求参数{}：", JSON.toJSONString(sb));
        } catch (Exception e) {
            logger.error("打印参数信息出现未知异常{}", e);
        }
    }
}
