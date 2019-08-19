package com.bts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bts.dto.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	List<Member> findByEmail(String email);

	List<Member> findByEmailAndPassword(String email, String password);

	//List<Member> findByPassword( String password);
	List<Member> findByPassword(@Param("password") String password);
	
	//네이티브쿼리
	@Query(value = "select * from Member where email = ?1", nativeQuery = true)
	List<Member> findByEmailQueryNative(String email);
}
