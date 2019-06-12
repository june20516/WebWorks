package advices;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class MethodThrowsLogAdvice implements ThrowsAdvice{
	
	public void afterThrowing(Exception e) {
		System.out.println(" Exception is occured.");
	}

}
