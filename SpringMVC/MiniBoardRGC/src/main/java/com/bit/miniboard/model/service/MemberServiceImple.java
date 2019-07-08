package com.bit.miniboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.miniboard.model.dao.MemberMapper;
import com.bit.miniboard.model.dto.MemberBean;

@Service("MemberService")
public class MemberServiceImple implements MemberService {
	
	@Autowired
	MemberMapper freeBoardMapper;
	
	@Override
	public List<MemberBean> allList() {
		return freeBoardMapper.allList();
	}

	@Override
	public boolean isMember(MemberBean bean) {
		return freeBoardMapper.getMemberInfo(bean)!=null;
	}

}
