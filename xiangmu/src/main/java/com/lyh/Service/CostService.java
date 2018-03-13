package com.lyh.Service;

import java.util.List;

import com.lyh.entity.Cost_Info;

public interface CostService {
	public List findAll(Cost_Info ci);
	public int insert(Cost_Info ci);
	public Cost_Info findId(int Cost_id);
	public int update(Cost_Info ci);
	public int delete(int Cost_id);
	public int costcount(Cost_Info ci);
}
