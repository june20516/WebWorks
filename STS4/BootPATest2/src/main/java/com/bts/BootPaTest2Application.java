package com.bts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bts.dao.Member4Repository;
import com.bts.dao.PhoneRepository;
import com.bts.dto.Member4;
import com.bts.dto.Phone;

@SpringBootApplication
public class BootPaTest2Application  implements CommandLineRunner{

	@Autowired
	private Member4Repository mr;
	@Autowired
	private PhoneRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(BootPaTest2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Member4 first = new Member4("Jung"); // (1)
		first.addPhone(new Phone("010-XXXX-XXXX"));
		first.addPhone(new Phone("010-YYYY-YYYY"));
		
		Member4 second = new Member4("Dong");
		second.addPhone(new Phone("010-ZZZZ-ZZZZ"));
		
		Member4 third = new Member4("Min"); // (2)
		mr.save(first); // (3)
		mr.save(second);
		mr.save(third); // (4)
		List<Member4> list = mr.findAll(); // (5)
		for (Member4 m : list) {
			System.out.println(m.toString());
		} // (6)
		
		List<Phone> lists = pr.findAll(); // (5)
		for (Phone p : lists) {
			System.out.println(p.toString());
		} // (6)
		mr.deleteAll(); // (7)
	}

}
