package com.iisigroup.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
	public void pointcut() {
	}

	public void logBefore(JoinPoint joinPoint) {
		System.out.println("******");
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("******");
	}

	public void logAfter(JoinPoint joinPoint) {
		System.out.println("******");
		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("******");
		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}

	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("******");
		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}

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
