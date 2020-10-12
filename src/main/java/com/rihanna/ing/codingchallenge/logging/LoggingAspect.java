package com.rihanna.ing.codingchallenge.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * An aspect to log events at certain points of reaching to a method
 * @see om.rihanna.ing.codingchallenge.logging.Log
 * @author reihanesadat.zekri
 *
 */
@Aspect
@Component
public class LoggingAspect {
	public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("@annotation(com.rihanna.ing.codingchallenge.logging.Log)")
	public void enterMethodLogger(JoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		if (logger.isInfoEnabled()) {
			logger.info(getClassMethodName(methodSignature) + " - Enter method");
		}

	}
	
	@After("@annotation(com.rihanna.ing.codingchallenge.logging.Log)")
	public void methodLogger(JoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		if (logger.isInfoEnabled()) {
			logger.info(getClassMethodName(methodSignature) + " - Exit method");
		}
		
	}
	
	private String getClassMethodName(MethodSignature methodSignature) {
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		return className + "." + methodName;
	}
}
