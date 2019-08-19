package com.rubypaper.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Member2;

public interface MemberRepository extends CrudRepository<Member2, String> {
}
