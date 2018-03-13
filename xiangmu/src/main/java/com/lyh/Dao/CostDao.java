package com.lyh.Dao;

import java.util.List;

import com.lyh.entity.Cost_Info;

public interface CostDao {
	public List findAll(Cost_Info ci);
	public int insert(Cost_Info ci);
	public Cost_Info findId(int Cost_id);
	public int update(Cost_Info ci);
	public int delete(int Cost_id);
	public int costcount(Cost_Info ci);
}
