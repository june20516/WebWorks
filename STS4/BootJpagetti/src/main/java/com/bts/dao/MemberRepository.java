package com.bts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.dto.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
