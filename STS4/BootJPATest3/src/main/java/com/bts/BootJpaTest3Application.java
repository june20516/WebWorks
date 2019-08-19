package com.bts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bts.dao.Member2Repository;
import com.bts.dao.PhoneRepository;
import com.bts.dto.Member2;
import com.bts.dto.Phone;

@SpringBootApplication
public class BootJpaTest3Application  implements CommandLineRunner{
	@Autowired 
	private Member2Repository mr; 
	@Autowired 
	private PhoneRepository pr; 

	public static void main(String[] args) {
		SpringApplication.run(BootJpaTest3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Member2 first = new Member2("K"); // (1) 
		first.addPhone(new Phone("010-XXXX-XXXX")); 
		first.addPhone(new Phone("010-YYYY-YYYY")); 
		Member2 second = new Member2("Dong"); 
		second.addPhone(new Phone("010-ZZZZ-ZZZZ")); 
		Member2 third = new Member2("Min"); // (2) 
		mr.save(first); // (3) 
		mr.save(second); 
		mr.save(third); // (4) 
		List<Member2> list = mr.findAll(); // (5) 
		for( Member2 m : list ){ 
			System.out.println(m.toString()); 
		} // (6) 
		//mr.deleteAll(); // (7)
	}
}
