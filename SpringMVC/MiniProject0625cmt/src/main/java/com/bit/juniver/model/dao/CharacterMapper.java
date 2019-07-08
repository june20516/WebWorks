package com.bit.juniver.model.dao;

import java.util.List;

import com.bit.juniver.model.dto.CharacterBean;

public interface CharacterMapper {
	
	// 지정된 매뉴에 해당되는 모든 캐릭터를 가져온다
	public List<CharacterBean> listCharacter(int menuId);
	// 지정된 캐릭터의 정보를 가져온다
	public CharacterBean getCharacter(int characterId);

}
