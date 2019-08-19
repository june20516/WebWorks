package com.bts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bts.dto.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	//이메일이 같은 사람이 여려명일 수 있다 = list로 받는다.
	List<Member> findByEmail(String email);
	
	//이메일과 패스워드가 동일한경우 찾기
	List<Member> findByEmailAndPassword(String email, String password);
	
	//비밀번호로 찾기
	List<Member> findByPassword(String password);
	
	//네이티브 쿼리
	@Query(value ="select * from Member where email = ?1", nativeQuery = true)
	List<Member> findByEmailQueryNative(String email);
	
	
	
	
	
	
}
