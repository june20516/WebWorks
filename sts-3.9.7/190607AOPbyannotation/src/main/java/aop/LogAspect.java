package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
	
	@Pointcut("execution(public * greeting..*sayHello(..))")
	private void profileTarget() {}
	
	@Before("profileTarget()")
	public void beforeLogging() {
		System.out.println("** 메서드 호출 전**");
	}
	@After("profileTarget()")
	public void afterLogging() {
		System.out.println("** 메서드 호출 후**");
	}
//	@AfterThrowing("profileTarget()")
	public void throwingLogging(Exception ex) {
		System.out.println("** 예외 발생 : " + ex.getMessage() + "**");
	}
	
	
	public void alwaysLogging() {
		System.out.println("** 항상 실행 **");
	}
}
