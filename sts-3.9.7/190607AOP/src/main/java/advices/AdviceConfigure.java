package advices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AdviceConfigure {
	@Bean
	public MethodAfterLogAdvice methodAfterLogAdvice() {
		return new MethodAfterLogAdvice();
	}
	
	@Bean
	public MethodBeforeLogAdvice methodBeforeLogAdvice() {
		return new MethodBeforeLogAdvice();
	}
	
	@Bean
	public MethodThrowsLogAdvice methodThrowsLogAdvice() {
		return new MethodThrowsLogAdvice();
	}
	
	@Bean
	public PerformanceCheckAdvice performanceCheckAdvice() {
		return new PerformanceCheckAdvice();
	}
}
