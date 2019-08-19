package com.rubypaper.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.domain.Member2;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;

	public SecurityUser(Member2 member) {
		super(member.getId(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
