package com.lyh.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.UserDao;
import com.lyh.Service.UserService;
import com.lyh.entity.Role_Info;
import com.lyh.entity.User_Info;
import com.lyh.entity.Youjian;

@Service
@Transactional
public class UserServiceImpl implements UserService{
@Autowired
	private UserDao userDao;
	

	public User_Info login(User_Info us) {
		User_Info us1=userDao.login(us);
			return us1;
	}


	public int insert(User_Info us) {
		
			return userDao.insert(us);
	}


	public int delete(int id) {
		int i=userDao.delete(id);
		return i;
	}


	public int update(User_Info us) {
	int i=userDao.update(us);
		return i;
	}


	public User_Info findId(int id) {
		User_Info us=userDao.findId(id);
		
		return us;
	}


	public List findAll(User_Info user) {
	String mhcx=user.getMhcx();
		if(mhcx==null){
			mhcx="%%";
		}else{
			mhcx="%"+mhcx+"%";
		}
		user.setMhcx(mhcx);
		return userDao.findAll(user);
	}



	public int dxg(int User_id) {
		return userDao.dxg(User_id);
	}



	public List findrole() {
		
		return userDao.findrole();
	}


	public Role_Info findname(String name) {
				return userDao.findname(name);
	}



	public int count(String mhcx) {
			if(mhcx==null){
				mhcx="%%";
			}
			mhcx="%"+mhcx+"%";
			return userDao.count(mhcx);
	}


	
	public List<User_Info> findqx(int Menu_id) {
		
		return userDao.findqx(Menu_id);
	}



	public List findxj(Youjian yj) {
		String name=yj.getFjrxm();
		if(name==null){
			name="%%";
		}
		name="%"+name+"%";
		yj.setFjrxm(name);
		return userDao.findxj(yj);
	}



	public Youjian xjid(int id) {
		
		return userDao.xjid(id);
	}



	public int fsyj(Youjian yj) {
		
		return userDao.fsyj(yj);
	}


	
	public List findxma() {
		
		return userDao.findxma();
	}



	public int gxzt(int id) {
		
		return userDao.gxzt(id);
	}



	public int deleteyj(int id) {
		
		return userDao.deleteyj(id);
	}





}
