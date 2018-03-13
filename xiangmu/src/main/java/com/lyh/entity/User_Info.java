package com.lyh.entity;

import com.lyh.util.BaseBean;

public class User_Info extends BaseBean{
	private int User_id;
	private int Role_id;
	private String User_name;
	private String User_sex;
	private int User_age;
	private String User_account;
	private String User_password;
	private double User_salary;
	private int User_mark;
	private String mhcx;

	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public int getRole_id() {
		return Role_id;
	}
	public void setRole_id(int role_id) {
		Role_id = role_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getUser_sex() {
		return User_sex;
	}
	public void setUser_sex(String user_sex) {
		User_sex = user_sex;
	}
	public int getUser_age() {
		return User_age;
	}
	public void setUser_age(int user_age) {
		User_age = user_age;
	}
	public String getUser_account() {
		return User_account;
	}
	public void setUser_account(String user_account) {
		User_account = user_account;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	public double getUser_salary() {
		return User_salary;
	}
	public void setUser_salary(double user_salary) {
		User_salary = user_salary;
	}
	public int getUser_mark() {
		return User_mark;
	}
	public void setUser_mark(int user_mark) {
		User_mark = user_mark;
	}
	public String getMhcx() {
		return mhcx;
	}
	public void setMhcx(String mhcx) {
		this.mhcx = mhcx;
	}

	
}
