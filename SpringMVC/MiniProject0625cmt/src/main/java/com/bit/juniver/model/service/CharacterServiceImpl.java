package com.bit.juniver.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.CharacterMapper;
import com.bit.juniver.model.dto.CharacterBean;

@Service("CharacterService")
public class CharacterServiceImpl implements CharacterService{
	@Autowired
	CharacterMapper characterMapper;
	
	@Override
	public List<CharacterBean> getAllCharacters(int menuId) {
		return characterMapper.listCharacter(menuId);
	}
	
	@Override
	public CharacterBean getCharacter(int id) {
		return characterMapper.getCharacter(id);
	}
}
