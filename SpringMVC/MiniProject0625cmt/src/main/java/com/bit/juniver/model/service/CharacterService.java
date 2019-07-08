package com.bit.juniver.model.service;

import java.util.List;

import com.bit.juniver.model.dto.CharacterBean;

public interface CharacterService {
	public List<CharacterBean> getAllCharacters(int menuId);

	public CharacterBean getCharacter(int characterId);
}
