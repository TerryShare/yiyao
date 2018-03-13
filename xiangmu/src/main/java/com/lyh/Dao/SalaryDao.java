package com.lyh.Dao;

import java.util.List;
import java.util.Map;

import com.lyh.entity.Salary_Payment;

public interface SalaryDao {
	public List findname(Map map);
	public List findAll(Salary_Payment sp);
	public List findusername();
	public int insert(Salary_Payment sp);
	public int count(Salary_Payment sp);
	public String jq(Salary_Payment sp);
	public String rolejq(Map map);
	public String costjq(Map map);
	public List findida();
	public List findcosta();
}
