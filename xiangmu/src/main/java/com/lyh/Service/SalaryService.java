package com.lyh.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.lyh.entity.Salary_Payment;

public interface SalaryService {
	public List findname(String User_name,String payment_time);
	public List findAll(Salary_Payment sp);
	public List findusername();
	public int insert(Salary_Payment sp);
	public int count(Salary_Payment sp);
	public void insertExcel(InputStream is) throws Exception;
	public String jq(Salary_Payment sp);
	public String rolejq(String Payment_time,int Role_id);
	public String costjq(String Expense_time,int Cost_id);
	public List findida();
	public List findcosta();
}
