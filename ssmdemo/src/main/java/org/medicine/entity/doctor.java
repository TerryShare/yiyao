package org.medicine.entity;

public class doctor {
	private int id;
	private int panel_id;
	private String  panel_name;//居民姓名
	private String liuyan;
	private  int merdrug_id;
	
	public int getMerdrug_id() {
		return merdrug_id;
	}
	public void setMerdrug_id(int merdrug_id) {
		this.merdrug_id = merdrug_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPanel_id() {
		return panel_id;
	}
	public void setPanel_id(int panel_id) {
		this.panel_id = panel_id;
	}
	public String getPanel_name() {
		return panel_name;
	}
	public void setPanel_name(String panel_name) {
		this.panel_name = panel_name;
	}
	public String getLiuyan() {
		return liuyan;
	}
	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}
	@Override
	public String toString() {
		return "doctor [id=" + id + ", panel_id=" + panel_id + ", panel_name=" + panel_name + ", liuyan=" + liuyan
				+ "]";
	}
	
}
