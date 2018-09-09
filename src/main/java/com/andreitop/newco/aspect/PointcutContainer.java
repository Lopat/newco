package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {}

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void allControllerMethods() {}

    @Pointcut("@target(org.springframework.stereotype.Service)")
    public void serviceMethods() {}

    @Pointcut("execution(* *..*(Long))")
    public void longParamMethods() {}

    @Pointcut("serviceMethods() && longParamMethods()")
    public void idMethodsInService() {}

//    @Pointcut("@annotation( org.springframework.boot.autoconfigure.SpringBootApplication)")
//    public void mainClassMethods() {}
}

