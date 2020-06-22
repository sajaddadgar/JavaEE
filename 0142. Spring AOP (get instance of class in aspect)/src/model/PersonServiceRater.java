package model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonServiceRater {


    @Around("execution(* model.*.*(..))")
    public void r(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //proceedingJoinPoint.getThis()
        //proceedingJoinPoint.getTarget()
        // difference: dar this object ro nabayad daryaft konid chon in object ham rah ba nazer object ast va baes mishe tu loop biofte
        PersonService personService = (PersonService) proceedingJoinPoint.getTarget();
        personService.a();
        proceedingJoinPoint.proceed();

    }
}
