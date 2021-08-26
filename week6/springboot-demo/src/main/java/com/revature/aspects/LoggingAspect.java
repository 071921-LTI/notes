package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.exceptions.GlobalExceptionHandler)")
	public void logExceptions(JoinPoint jp) {
		log.error(jp.getTarget()+ " invoked " + jp.getSignature());
	}
	
	@After("execution(* login(..))")
	public void logLogin(JoinPoint jp) {
		log.info(jp.getTarget()+ " invoked " + jp.getSignature());
	}
}
