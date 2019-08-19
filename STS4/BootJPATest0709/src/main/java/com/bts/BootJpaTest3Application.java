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
		Member2 fstMember2 = new Member2("Lee");
		Member2 secMember2 = new Member2("Soo");
		Member2 thdMember2 = new Member2("Jin");
		fstMember2.addPhone(new Phone("010-XXXX-XXXX")); 
		secMember2.addPhone(new Phone("010-XXXX-XXXX")); 
		thdMember2.addPhone(new Phone("010-ZZZZ-ZZZZ"));
		mr.save(fstMember2); // (3) 
		mr.save(secMember2); 
		mr.save(thdMember2); // (4)
		List<Member2> list = mr.findAll(); // (5)
		for( Member2 m : list ){ 
			System.out.println(m.toString());
		} // (6) 
		List<Phone> lists = pr.findAll(); // (5)
		for (Phone p : lists) {
			System.out.println(p.toString());
		} // (6)
		//mr.deleteAll(); // (7)
	}
}