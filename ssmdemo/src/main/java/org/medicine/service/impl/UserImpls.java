package org.medicine.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.medicine.dao.UserDaos;
import org.medicine.entity.fenlei;
import org.medicine.entity.panel;
import org.medicine.entity.register;
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
	public List hypcq(int id) {
		List list=new ArrayList();
		try{
			list=userDao.hypcq(id);
		}catch(Exception e ){
			return null;
		}
		return list;
	}
	public List hflcq() {
		List list=new ArrayList();
		try{
			list=userDao.hflcq();
		}catch(Exception e){
			return null;
		}
		return list;
	}
	public fenlei hfldc(int id) {
		fenlei fl=new fenlei();
		fl=userDao.hfldc(id);
		return fl;
	}
	public int ypxg(Map map) {
		int a=0;
		try{
			a=userDao.ypxg(map);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public int spzj(Map map) {
		int a=0;
		try{
			a=userDao.spzj(map);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public List hglycq() {
		List list=new  ArrayList();
		try{
			list=userDao.hglycq();
			
		}catch(Exception e){
			return null;
		}
		return list;
	}
	public int hglyxg(Map map) {
		int a=0;
	try{
		a=userDao.hglyxg(map);
	}catch(Exception e){
		return 0;
	}
		return a;
	}
	public int yhglsc(int id) {
		int a=0;
		try{
			a=userDao.yhglsc(id);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public int hglytj(Map map) {
		int a=0;
		try{
			a=userDao.hglytj(map);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public List glyypcq() {
		List list=new ArrayList();
		try{
			list=userDao.glyypcq();
		}catch(Exception e){
			return null;
		}
		return list;
	}
	public int glyyptg(int id) {
		int a=0;
		try{
			a=userDao.glyyptg(id);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public int glyypzf(int id) {
		int a=0;
		try{
			a=userDao.glyypzf(id);
		}catch(Exception e){
			return 0;
		}
		return a;
	}
	public List glyyscq() {
		List list=new ArrayList();
		try{
			list=userDao.glyyscq();
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		return list;
	}
	public int glyystg(int id) {
		// TODO Auto-generated method stub
		int a =0;
		try{
			register re=userDao.glyysdc(id);
			String name=re.getName();
			String password=re.getPassword();
			Map map=new HashMap();
			map.put("name", name);
			map.put("password", password);
			map.put("shenfen", "2");
			int b=userDao.hglytj(map);
			if(b==1){
				int c=userDao.glyystg(id);
				if(c==1){
					return 1;
				}else{
					return 0;
				}
				
			}else{
				return 0;
			}
			
		}catch(Exception e){
			System.out.println(e.toString());
			return 0;
		}
	}
	public int glyyszf(int id) {
		int a=0;
		try{
			a=userDao.glyyszf(id);
			
		}catch(Exception e){
			System.out.println(e.toString());
			return 0;
		}
		return a;
	}
	//查询现有医师
	public  List cxys(int shenfen) {
		return this.userDao.cxys(shenfen);
	}
	
	//根据id查医师
	public panel ysly(int id) {
		return this.userDao.ysly(id);		
	}
}	
