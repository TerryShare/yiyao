package com.lyh.entity;

import com.lyh.util.BaseBean;

public class Expense_account extends BaseBean{
	private int Expense_id;
	private int User_id;
	private String Expense_name;
	private String Expense_desc;
	private String Expense_time;
	private String Expense_state;
	private double Expense_total;
	private String User_name;
	
	public int getExpense_id() {
		return Expense_id;
	}
	public void setExpense_id(int expense_id) {
		Expense_id = expense_id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getExpense_name() {
		return Expense_name;
	}
	public void setExpense_name(String expense_name) {
		Expense_name = expense_name;
	}
	public String getExpense_desc() {
		return Expense_desc;
	}
	public void setExpense_desc(String expense_desc) {
		Expense_desc = expense_desc;
	}
	public String getExpense_time() {
		return Expense_time;
	}
	public void setExpense_time(String expense_time) {
		Expense_time = expense_time;
	}
	public String getExpense_state() {
		return Expense_state;
	}
	public void setExpense_state(String expense_state) {
		Expense_state = expense_state;
	}
	public double getExpense_total() {
		return Expense_total;
	}
	public void setExpense_total(double expense_total) {
		Expense_total = expense_total;
	}


	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	@Override
	public String toString() {
		return "Expense_account [Expense_id=" + Expense_id + ", User_id=" + User_id + ", Expense_name=" + Expense_name
				+ ", Expense_desc=" + Expense_desc + ", Expense_time=" + Expense_time + ", Expense_state="
				+ Expense_state + ", Expense_total=" + Expense_total + ", User_name=" + User_name + "]";
	}
	
}
