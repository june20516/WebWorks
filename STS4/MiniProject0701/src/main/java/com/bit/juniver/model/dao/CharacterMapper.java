package com.bit.juniver.model.dao;

import java.util.List;

import com.bit.juniver.model.dto.CharacterBean;

public interface CharacterMapper {
	public List<CharacterBean> listCharacter(int menuId);
	
	public CharacterBean getCharacter(int characterId);

}
