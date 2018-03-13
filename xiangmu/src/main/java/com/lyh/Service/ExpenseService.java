package com.lyh.Service;

import java.util.List;
import java.util.Map;

import com.lyh.entity.Audit_history;
import com.lyh.entity.Expense_account;

public interface ExpenseService {
	public List findAll(Expense_account ea);
	public List findname(String User_name,String Expense_time);
	public List findmybxd(Expense_account ea);
	public List findfin();
	public List findman();
	public List findid(int id);
	public List bxmx(int id);
	public List lsxx(int id);
	public List findcost();
	public int insert(Expense_account ea);
	public int insertex(int expense_id,int cost_id,double expense_details_amount);
	public int update(Audit_history ea);
	public int update2(Expense_account ea);
	public int delete(int Expense_id);
	public int updatxg(Expense_account ea);
	public List jlfindAll(Expense_account ea);
	public int jlcount(Expense_account ea);
	public int cwcount(Expense_account ea);
	public List cwfindAll(Expense_account ea);
	public int allcount(Expense_account ea);
	
	public int mycount(Expense_account ea);
	public List shls(int Expense_id);
	
	public int jltjls(Audit_history ah);
	public int cwtjls(Audit_history ah);
}
