package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	
	public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		long startTime = System.nanoTime();
		System.out.println("[Log]METHOD Before : " + methodName + " time check start");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println("[Log]METHOD error : " + methodName);
		}
		long endTime = System.nanoTime();
		System.out.println("[Log]METHOD After : " + methodName + " time check end");
		System.out.println("[Log] " + methodName + " Processing time is " + (endTime - startTime) + "ns");
		return obj;
	}
}