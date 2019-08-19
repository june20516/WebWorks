package com.bts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bts.dao.MemberRepository2;
import com.bts.dao.PhoneRepository;
import com.bts.dto.Member2;
import com.bts.dto.Phone;

@SpringBootApplication
public class Jpa3Application implements CommandLineRunner {
	@Autowired
	private MemberRepository2 mr;
	@Autowired
	private PhoneRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(Jpa3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Member2 first = new Member2("장");
		first.addPhone(new Phone("010-XXXX-XXXX"));
		first.addPhone(new Phone("010-YYYY-YYYY"));
		Member2 second = new Member2("동");
		second.addPhone(new Phone("010-ZZZZ-ZZZZ"));
		Member2 third = new Member2("민");
		mr.save(first);
		mr.save(second);
		mr.save(third);
		List<Member2> list = mr.findAll();
		for (Member2 m : list) {
			System.out.println(m.toString());			
		}
		mr.deleteAll(); 
	}
}
