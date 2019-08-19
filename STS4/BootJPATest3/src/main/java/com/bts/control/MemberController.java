package com.bts.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;
import com.bts.service.MemberService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberService memberService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Member>> getAll(){
		List<Member> members = memberRepository.findAll();
		return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
	}
	
	//1명 조회
	@GetMapping(value = "/{id}") //http://localhost/mem/51
	public ResponseEntity<Member> getMember(@PathVariable int id){
		return new ResponseEntity<Member>(memberRepository.findById(id), HttpStatus.OK);
	}
	
	//1명 삭제
	@DeleteMapping(value = "/{id}") //http://localhost/mem/51
	public ResponseEntity<Void> deleteMember(@PathVariable int id){
		memberRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//1명 갱신
	@PutMapping(value = "/{id}") //http://localhost/mem/51
	public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member){
		memberService.updateById(id, member); //==> service필요
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	//1명 insert PostMapping save
	@PostMapping() 
	public ResponseEntity<Member> insertMember(@RequestBody Member member){
		return new ResponseEntity<Member>(memberRepository.save(member) ,HttpStatus.OK);
		
	}
	
	
}


