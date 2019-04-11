package com.example.experiment04.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Aspect
public class MyAspect {
    @Around("execution(* com.example..*.Buy*(..))")
    public Object CalculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug("方法:{}()的执行时间:{}", joinPoint.getSignature().getName(), end - start);
        return result;
    }

    @Around("@within(myInterceptor) || @annotation(myInterceptor)")
    public Object interceptorTarget(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        Optional.ofNullable(myInterceptor)
                .or(() -> {
                    MyInterceptor myInterceptor1 = joinPoint.getTarget().getClass().getAnnotation(MyInterceptor.class);
                    return Optional.of(myInterceptor1);
                })
                .ifPresent(myInterceptor1 -> {
                    for (MyInterceptor.AuthorityType type : myInterceptor1.value()) {
                        log.debug("当前执行方法的权限：{}", type);
                    }
                });
        return joinPoint.proceed();
    }
}
