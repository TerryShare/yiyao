package com.lyh.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.RoleDao;
import com.lyh.Service.RoleService;
import com.lyh.entity.Role_Info;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao rd;
	public List findAll(Role_Info ri) {
		String mhcx=ri.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		ri.setMhcx(mhcx);
		return rd.findAll(ri);
	}


	public Role_Info findid(int id) {
		
		return rd.findid(id);
	}


	public int update(Role_Info ri) {
		
		return rd.update(ri);
	}


	public int insert(Role_Info ri) {
		
		return rd.insert(ri);
	}


	
	public int delete(int id) {
		
		return rd.delete(id);
	}


	public int count(String mhcx) {
		if(mhcx==null){
			mhcx="%%";
		}
		mhcx="%"+mhcx+"%";
		return rd.count(mhcx);
	}

}
