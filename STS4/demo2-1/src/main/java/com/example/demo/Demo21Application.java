package com.example.demo;

import java.util.Locale;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;



@SpringBootApplication
//@MapperScan(basePackages = "com.example.demo.dao")
public class Demo21Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Demo21Application.class, args);
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREA);
		cookieLocaleResolver.setCookieName("BIT_INTOBOOKS_LOCALE");
		return cookieLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor change = new LocaleChangeInterceptor();
		change.setParamName("lc");
		return change;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	
	
	
}
