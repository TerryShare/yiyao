package com.lyh.entity;

import com.lyh.util.BaseBean;

public class Role_Info extends BaseBean{
	private int Role_id;
	private String Role_name;
	private String Role_desc;
	private int Role_mark;
	private String mhcx;
	public int getRole_id() {
		return Role_id;
	}
	public void setRole_id(int role_id) {
		Role_id = role_id;
	}
	public String getRole_name() {
		return Role_name;
	}
	public void setRole_name(String role_name) {
		Role_name = role_name;
	}
	public String getRole_desc() {
		return Role_desc;
	}
	public void setRole_desc(String role_desc) {
		Role_desc = role_desc;
	}
	public int getRole_mark() {
		return Role_mark;
	}
	public void setRole_mark(int role_mark) {
		Role_mark = role_mark;
	}
	public String getMhcx() {
		return mhcx;
	}
	public void setMhcx(String mhcx) {
		this.mhcx = mhcx;
	}
	
}
