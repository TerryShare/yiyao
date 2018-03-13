package com.lyh.entity;

public class Menu_Info {
	private int Menu_id;
	private int Prent_menu_id;
	private String Menu_name;
	private String Menu_url;
	public int getMenu_id() {
		return Menu_id;
	}
	public void setMenu_id(int menu_id) {
		Menu_id = menu_id;
	}
	public int getPrent_menu_id() {
		return Prent_menu_id;
	}
	public void setPrent_menu_id(int prent_menu_id) {
		Prent_menu_id = prent_menu_id;
	}
	public String getMenu_name() {
		return Menu_name;
	}
	public void setMenu_name(String menu_name) {
		Menu_name = menu_name;
	}
	public String getMenu_url() {
		return Menu_url;
	}
	public void setMenu_url(String menu_url) {
		Menu_url = menu_url;
	}
	
}
