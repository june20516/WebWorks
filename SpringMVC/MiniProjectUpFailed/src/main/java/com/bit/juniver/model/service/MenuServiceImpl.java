package com.bit.juniver.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.MenuMapper;
import com.bit.juniver.model.dto.MenuBean;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuMapper menuMapper;
	
	public List<MenuBean> listAllMenus() {
		return menuMapper.listMenu();
	}
}
