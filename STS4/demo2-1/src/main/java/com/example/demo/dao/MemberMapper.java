package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Member;

@Mapper
public interface MemberMapper {
	// member table의 모든 데이터(레코드, 모든사람, 모든정보) 검색
	List<Member> selectAll();
	@Select("SELECT * FROM MEMBER WHERE ID=#{ID}")
	
	
	//이것과 대응이 될 수 있게 mapper xml을 만든다.
	Member memberSearch(String id);
	
}
