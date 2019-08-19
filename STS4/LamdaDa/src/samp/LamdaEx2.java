package samp;

import java.util.function.*;

public class LamdaEx2 {

	public static void main(String[] args) {
		
		MyFunction f = () -> {
			System.err.println("hohoho");
		};
		MyFunction f2 = (MyFunction)(() -> {
			System.out.println("재밌네~ 람다가 ..");
		});
		
		f.run();
		f2.run();
		
		
		
		System.out.println("f="+f);
		System.out.println("f="+f.toString());
		System.out.println("f=2"+f2);
		
		Supplier<Integer> f3 = () -> (int) (Math.random()*100)+1;
		Consumer<Integer> f4 = i -> System.out.print(i+", ");
		Predicate<Integer> f5 = i -> i%2==0;
		Function<Integer,Integer> f6 = i -> i/10*10;
		
		System.out.println("f3="+f3.get());
		f4.accept(23);
		System.out.println(f5.test(71));
		System.out.println(f6.apply(13));
		
	}
}
