package com.bit.juniornaver.model.vo;

import java.util.List;


public class HomeBean {
	
	private List<MenuBean> menus;
	private List<CharacterBean> allCharacters;
	private List<ContentBean> contents;
	private CharacterBean character;
	
	public List<MenuBean> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuBean> menus) {
		this.menus = menus;
	}
	public List<CharacterBean> getAllCharacters() {
		return allCharacters;
	}
	public void setAllCharacters(List<CharacterBean> allCharacters) {
		this.allCharacters = allCharacters;
	}
	public List<ContentBean> getContents() {
		return contents;
	}
	public void setContents(List<ContentBean> contents) {
		this.contents = contents;
	}
	public CharacterBean getCharacter() {
		return character;
	}
	public void setCharacter(CharacterBean character) {
		this.character = character;
	}
	@Override
	public String toString() {
		return "HomeBean [menus=" + menus + ", allCharacters=" + allCharacters + ", contents=" + contents
				+ ", character=" + character + "]";
	}
	
	
	
	
	
}
