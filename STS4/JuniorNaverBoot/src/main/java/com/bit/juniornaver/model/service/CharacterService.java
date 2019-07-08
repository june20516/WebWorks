package com.bit.juniornaver.model.service;

import java.util.List;

import com.bit.juniornaver.model.vo.CharacterBean;

public interface CharacterService {
	public List<CharacterBean> getAllCharacters(int menuId);

	public CharacterBean getCharacter(int characterId);
}
