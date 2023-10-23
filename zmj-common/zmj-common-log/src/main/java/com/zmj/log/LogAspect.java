package com.zmj.log;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.log
 * @describe 日志切面
 * @date 2023/10/16 21:17
 */
@Aspect
@Slf4j
@Component
@ConditionalOnProperty(name = {"log.aspect.enable"}, havingValue = "true", matchIfMissing = true)
public class LogAspect {


    @Pointcut("execution(* com.zmj.*.controller.*Controller.*(..)) || execution(* com.zmj.*.service.*Service.*(..))")
    private void pointCut() {
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        String req = new Gson().toJson(args);

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String methodName = methodSignature.getDeclaringType().getName() + "." + methodSignature.getName();

        log.info("{},req:{}", methodName, req);

        Long startTime = System.currentTimeMillis();

        Object responseObj = pjp.proceed();

        String response = new Gson().toJson(responseObj);

        Long endTime = System.currentTimeMillis();

        log.info("{},response:{},costTime:{}", methodName, response, endTime - startTime);

        return responseObj;

    }
}
