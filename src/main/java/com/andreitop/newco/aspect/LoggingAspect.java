package com.andreitop.newco.aspect;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @After("com.andreitop.newco.aspect.PointcutContainer.allControllerMethods()")
    public void logControllersAfter(JoinPoint jp){
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " has  been called");
    }

   @Around("com.andreitop.newco.aspect.PointcutContainer.idMethodsInService()")
    public Object serviceMethodsWithId(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Long id = (Long) pjp.getArgs()[0];
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called with argument " + id);
        Object o = pjp.proceed();
        logger.info(" ---> Method " + className + "." + methodName + " has  been called");
        return o;
    }

}
