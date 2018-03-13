package com.lyh.Service.Impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.SalaryDao;
import com.lyh.Service.SalaryService;
import com.lyh.entity.Salary_Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;


@Service
@Transactional
public class SalaryServiceImpl implements SalaryService{
	@Autowired
	private SalaryDao sd;


	public List findname(String User_name, String Payment_time) {
		Map map=new HashMap();
		map.put("User_name", User_name);
		map.put("Payment_time", Payment_time);
		return sd.findname(map);
	}



	public List findAll(Salary_Payment sp) {
		String mhcx=sp.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		String time=sp.getPayment_time();
		if(time==null){
			time="%%";
		}
		time="%"+time+"%";
		sp.setMhcx(mhcx);
		sp.setPayment_time(time);
		return sd.findAll(sp);
	}

	public List findusername() {
		
		return sd.findusername();
	}



	
	public int insert(Salary_Payment sp) {
		
		return sd.insert(sp);
	}




	public int count(Salary_Payment sp) {
		
		return sd.count(sp);
	}
	
	
	public void insertExcel(InputStream is) throws Exception {
		//创建读取Excel类
	Workbook book = Workbook.getWorkbook(is);
		//获取页数
	Sheet sheet = book.getSheet(0);
	for(int i=1;i<sheet.getRows();i++){
			//实例化封装类
		Salary_Payment salarypayment = new Salary_Payment();
			//获取id
		Cell id = sheet.getCell(0,i);
		int user_id = Integer.parseInt(id.getContents());
		salarypayment.setUser_id(user_id);
			//获取时间
		Cell time = sheet.getCell(1,i);
		
		String payment_time = time.getContents();
		salarypayment.setPayment_time(payment_time+"");
			//获取money
		Cell money = sheet.getCell(2,i);
		double payment_money = Double.parseDouble(money.getContents());
		salarypayment.setPayment_money(payment_money);
			//调取添加方法
		this.sd.insert(salarypayment);
	}
}



	
	public String jq(Salary_Payment sp) {
		if(sp==null){
			sp=new Salary_Payment();
		}
		String yf=sp.getPayment_time();
		yf="%"+yf+"%";
		sp.setPayment_time(yf);
		String ss=sd.jq(sp);
		if(ss==null){
			ss="0";
		}
		return ss;
	}



	
	public String rolejq(String Payment_time, int Role_id) {
		Payment_time="%"+Payment_time+"%";
		Map map=new HashMap();
		map.put("Payment_time", Payment_time);
		map.put("Role_id", Role_id);
		String ss=sd.rolejq(map);
		if(ss==null){
			ss="0";
		}
		return ss;
	}




	public String costjq(String Expense_time, int Cost_id) {
		Map map=new HashMap();
		Expense_time ="%"+Expense_time+"%";
		map .put("Expense_time", Expense_time);
		map.put("Cost_id", Cost_id);
		String ss=sd.costjq(map);
		if(ss==null){
			ss="0";
		}
		return ss;
	}




	public List findida() {
		
		return sd.findida();
	}




	public List findcosta() {
		
		return sd.findcosta();
	}
	
	
	
	
	
}
