package advices;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class MethodBeforeLogAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("[Log] METHOD Before : "
				+ method.getName() + " on " + target + " calling.");
	}
	

}
