package com.lyh.Service.Impl;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.AnthorityDao;
import com.lyh.Service.AnthorityService;
import com.lyh.entity.Menu_Info;
import com.lyh.entity.Role_Info;

@Service
@Transactional
public class AnthorityServiceImpl implements AnthorityService{

	@Autowired
	private AnthorityDao ad;
	public List findAll(Role_Info ri) {
		String mhcx=ri.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		ri.setMhcx(mhcx);
		return ad.findAll(ri);
	}

	public int count(String mhcx) {
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		return ad.count(mhcx);
	}

	
	public List findzs() {
		
		return ad.findzs();
	}


	public List findf(int id) {
		
		return ad.findf(id);
	}


	public List findz(int id) {
		
		return ad.findz(id);
	}

	
	public Menu_Info findid(int id) {
		
		return ad.findid(id);
	}

	
	public List findfjd() {
		
		return ad.findfjd();
	}


	public List findzjd(int Menu_id) {
		
		return ad.findzjd(Menu_id);
	}


	public List lsdancha(int id) {
		
		return ad.lsdancha(id);
	}

	
	public List lsfindall() {
		
		return ad.lsfindall();
	}


	public int delete(int id) {
		
		return ad.delete(id);
	}


	public int insert(int Menu_id, int Role_id) {
		Map map=new HashMap();
		map.put("Menu_id", Menu_id);
		map.put("Role_id", Role_id);
		return ad.insert(map);
	}

}
