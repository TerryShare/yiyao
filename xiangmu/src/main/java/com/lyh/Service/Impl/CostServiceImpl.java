package com.lyh.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.CostDao;
import com.lyh.Service.CostService;
import com.lyh.entity.Cost_Info;

@Service
@Transactional
public class CostServiceImpl implements CostService{
	@Autowired
	private CostDao cd;

	
	public List findAll(Cost_Info ci) {
		String mhcx=ci.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		ci.setMhcx(mhcx);
		return cd.findAll(ci);
	}


	public int insert(Cost_Info ci) {
		
		return cd.insert(ci);
	}


	
	public Cost_Info findId(int Cost_id) {
		
		return cd.findId(Cost_id);
	}


	
	public int update(Cost_Info ci) {
		
		return cd.update(ci);
	}


	
	public int delete(int Cost_id) {
		
		return cd.delete(Cost_id);
	}



	public int costcount(Cost_Info ci) {
		String mhcx=ci.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		ci.setMhcx(mhcx);
		return cd.costcount(ci);
	}
}
