package com.example.experiment04.aspect;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Aspect
public aspect MyAspect {
    @Around("execution(* com.example..*.Buy*(..))")
    public Object CalculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug("方法:{}()的执行时间:{}", joinPoint.getSignature().getName(), end - start);
        return result;
    }

    @Around("@within(MyInterceptor) || @annotation(MyInterceptor)")
    public Object interceptorTarget(ProceedingJoinPoint joinPoint,MyInterceptor myInterceptor) throws Throwable{
        Optional.ofNullable(myInterceptor)
                .or()
    }
}
