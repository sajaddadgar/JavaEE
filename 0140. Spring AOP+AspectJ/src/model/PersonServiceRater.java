package model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonServiceRater {

    // before: mored taeed nist
    // after : mored taeed nist
    // around: az in estefade kon, yani bein before o after

    // execution az right be left:
    // har vorudiE(..) -> har methodi* -> dar har class* -> ba har khorujiE* ->dar package model

    // har methodi tu around bashe method monitor(ya har name dg) ejra mishavad
    @Around("execution(* model.*.*(..))")
    public void monitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("before");
        proceedingJoinPoint.proceed();
        System.out.println("after");

    }

}
