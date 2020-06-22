package model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonServiceRater {

    // baad az throw kardan exception -> @AfterThrowing
    // baad az return kardan ->@AfterReturning
    @Around("execution(* model.*.*(..))")
    public Object r(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = proceedingJoinPoint.proceed();
        return "MR." + result;
        
    }
}
