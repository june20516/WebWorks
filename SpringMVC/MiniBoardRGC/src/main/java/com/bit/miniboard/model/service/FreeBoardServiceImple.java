package com.bit.miniboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.miniboard.model.dao.FreeBoardMapper;
import com.bit.miniboard.model.dao.MemberMapper;
import com.bit.miniboard.model.dto.FreeBoardBean;
import com.bit.miniboard.model.dto.MemberBean;

@Service("FreeBoardService")
public class FreeBoardServiceImple implements FreeBoardService {
	
	@Autowired
	FreeBoardMapper freeBoardMapper;
	
	@Override
	public List<FreeBoardBean> getAllList() {
		return freeBoardMapper.getAllList();
	}
	
}
