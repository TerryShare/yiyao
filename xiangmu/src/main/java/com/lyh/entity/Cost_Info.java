package com.lyh.entity;

import com.lyh.util.BaseBean;

public class Cost_Info extends BaseBean{
	private  int Cost_id;
	private String Cost_name;
	private String Cost_desc;
	private int Cost_mark;
	private String mhcx;
	public int getCost_id() {
		return Cost_id;
	}
	public void setCost_id(int cost_id) {
		Cost_id = cost_id;
	}
	public String getCost_name() {
		return Cost_name;
	}
	public void setCost_name(String cost_name) {
		Cost_name = cost_name;
	}
	public String getCost_desc() {
		return Cost_desc;
	}
	public void setCost_desc(String cost_desc) {
		Cost_desc = cost_desc;
	}
	public int getCost_mark() {
		return Cost_mark;
	}
	public void setCost_mark(int cost_mark) {
		Cost_mark = cost_mark;
	}
	public String getMhcx() {
		return mhcx;
	}
	public void setMhcx(String mhcx) {
		this.mhcx = mhcx;
	}
	
}
