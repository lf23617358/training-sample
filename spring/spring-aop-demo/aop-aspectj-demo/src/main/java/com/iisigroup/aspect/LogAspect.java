package com.iisigroup.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	@Pointcut("execution(* com.iisigroup.service..*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("******");
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("******");
	}

	@After("pointcut()")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("******");
		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("******");
		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("******");
		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}

	@Around("pointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("******");
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Around before is running!");
		Object retVal = joinPoint.proceed();
		System.out.println("Around after is running!");
		System.out.println("******");
		return retVal;
	}

}
