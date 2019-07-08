package com.bit.juniornaver.model.dao;

import java.util.List;

import com.bit.juniornaver.model.vo.CharacterBean;

public interface CharacterMapper {
	public List<CharacterBean> listCharacter(int menuId);
	
	public CharacterBean getCharacter(int characterId);

}
