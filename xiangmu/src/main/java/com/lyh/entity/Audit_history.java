package com.lyh.entity;

public class Audit_history {
	private int Audit_id;
	private int Expense_id;
	private int User_id;
	private String Audit_time;
	private String Audit_state;
	private String Audit_desc;
	public int getAudit_id() {
		return Audit_id;
	}
	public void setAudit_id(int audit_id) {
		Audit_id = audit_id;
	}
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
	public String getAudit_time() {
		return Audit_time;
	}
	public void setAudit_time(String audit_time) {
		Audit_time = audit_time;
	}
	public String getAudit_state() {
		return Audit_state;
	}
	public void setAudit_state(String audit_state) {
		Audit_state = audit_state;
	}
	public String getAudit_desc() {
		return Audit_desc;
	}
	public void setAudit_desc(String audit_desc) {
		Audit_desc = audit_desc;
	}
	
}
