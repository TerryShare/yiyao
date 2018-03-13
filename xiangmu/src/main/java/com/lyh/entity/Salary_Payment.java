package com.lyh.entity;

import com.lyh.util.BaseBean;

public class Salary_Payment extends BaseBean{
	private int Payment_id;
	private int User_id;
	private String Payment_time;
	private double Payment_money;
	private String mhcx;
	public int getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(int payment_id) {
		Payment_id = payment_id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getPayment_time() {
		return Payment_time;
	}
	public void setPayment_time(String payment_time) {
		Payment_time = payment_time;
	}
	public double getPayment_money() {
		return Payment_money;
	}
	public void setPayment_money(double payment_money) {
		Payment_money = payment_money;
	}
	public String getMhcx() {
		return mhcx;
	}
	public void setMhcx(String mhcx) {
		this.mhcx = mhcx;
	}
}
