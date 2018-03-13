package com.lyh.Service.Impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.ExpenseDao;
import com.lyh.Service.ExpenseService;
import com.lyh.entity.Audit_history;
import com.lyh.entity.Expense_account;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{
	@Autowired 
	private ExpenseDao ed;


	public List findAll(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
	
		return ed.findAll(ea);
	}

	
	public List findname(String User_name, String Expense_time) {
		
		return ed.findname(User_name, Expense_time);
	}



	public List findmybxd(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.findmybxd(ea);
	}


	
	public List findfin() {
	
		return ed.findfin();
	}



	public List findman() {
		
		return ed.findman();
	}


	
	public List findid(int id) {
		
		return ed.findid(id);
	}



	public List bxmx(int id) {
		
		return ed.bxmx(id);
	}



	public List lsxx(int id) {
		
		return ed.lsxx(id);
	}



	public List findcost() {
		
		return ed.findcost();
	}



	public int insert(Expense_account ea) {
		
		return ed.insert(ea);
	}


	
	public int insertex(int expense_id, int cost_id, double expense_details_amount) {
		Map map=new HashMap();
		map.put("expense_id", expense_id);
		map.put("cost_id", cost_id);
		map.put("expense_details_amount", expense_details_amount);
		return ed.insertex(map);
	}



	public int update(Audit_history ea) {
		
		return ed.update(ea);
	}



	public int update2(Expense_account ea) {
		
		return ed.update2(ea);
	}



	public int delete(int Expense_id) {
		
		return ed.delete(Expense_id);
	}



	public int updatxg(Expense_account ea) {
		
		return ed.updatxg(ea);
	}



	public List jlfindAll(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.jlfindAll(ea);
	}



	public int jlcount(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.jlcount(ea);
	}



	public int cwcount(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.cwcount(ea);
	}



	public List cwfindAll(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.cwfindAll(ea);
	}



	public int allcount(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.allcount(ea);
	}



	public int mycount(Expense_account ea) {
		String User_name=ea.getUser_name();
		if(User_name!=null){
			User_name="%"+User_name+"%";
		}else{
			User_name="%%";
		}
		String time=ea.getExpense_time();
		if(time==null){
			time="%%";
		}else{
			time="%"+time+"%";
		}
		ea.setUser_name(User_name);
		ea.setExpense_time(time);
		return ed.mycount(ea);
	}



	public List shls(int Expense_id) {
	
		return ed.shtjls(Expense_id);
	}

	public int jltjls(Audit_history ah) {
	
		return ed.jltjls(ah);
	}



	public int cwtjls(Audit_history ah) {
		
		return ed.cwtjls(ah);
	}



	
}
