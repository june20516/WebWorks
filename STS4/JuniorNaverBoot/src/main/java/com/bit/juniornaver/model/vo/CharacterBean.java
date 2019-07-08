package com.bit.juniornaver.model.vo;

public class CharacterBean {
	int id;
	int menu_id;
	String name;
	String image_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	@Override
	public String toString() {
		return "CharacterBean [id=" + id + ", menu_id=" + menu_id + ", name=" + name + ", image_path=" + image_path
				+ "]";
	}
	
	
}
