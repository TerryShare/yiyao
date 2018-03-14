package org.medicine.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.medicine.dao.UserDaos;
import org.medicine.entity.panel;
import org.medicine.service.UserServices;


@Service
@Transactional
public class UserImpls implements UserServices{

	@Autowired
	private UserDaos userDao;
	//登录 时候的
	public panel login(Map map) {
		panel pa=userDao.login(map);
		return pa;
	}
	public int ptzhuce(Map map) {
		try{
			int a=userDao.ptzhuce(map);
		}catch(Exception e){
			return 0;
		}
		
		return 1;
	}

	public int yszhuece(Map map) {
		int a=0;
		try{
			 a=userDao.yszhuece(map);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	
}	
