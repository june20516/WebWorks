package advices;



import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class PerformanceCheckAdvice implements org.aopalliance.intercept.MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		long startTime = System.nanoTime();
		System.out.println("[Log] METHOD Before --> " + methodName + " time check start");
		Object obj = null;
		try {
			obj=invocation.proceed();
		}catch(Exception e) {
			System.out.println("[Log] METHOD error --> " +methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("[Log] METHOD After --> "+methodName+" time check end. ");
		System.out.println("[Log] "+methodName+" Processing time is " +(endTime - startTime)+ " ns");
		return obj;
	}

	
	
	
	
}
