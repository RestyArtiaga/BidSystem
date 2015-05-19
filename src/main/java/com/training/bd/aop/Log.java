package com.training.bd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@Aspect
public class Log{
	
	 @Before("execution(* com.training.bd.services.UserService.isUser(..))")
	 public void doBefore(JoinPoint joinPoint) {
	         System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
	         Object[] objs = joinPoint.getArgs();
	         for(int init=0;init<objs.length;init++){
	        	 System.out.println(objs[init]);
	         }
	 }
	 
}
