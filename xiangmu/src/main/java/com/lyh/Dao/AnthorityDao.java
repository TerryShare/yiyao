package com.lyh.Dao;

import java.util.List;
import java.util.Map;

import com.lyh.entity.Menu_Info;
import com.lyh.entity.Role_Info;

public interface AnthorityDao {
	public List findAll(Role_Info ri);
	public int count(String mhcx);
	
	
	public List findzs();
	public List findf(int id);
	public List findz(int id);
	public Menu_Info findid(int id);
	
	
	//(*╹▽╹*)(*╹▽╹*)(*╹▽╹*)(*╹▽╹*)(*╹▽╹*)
	public List findfjd();
	public List findzjd(int Menu_id);
	
	
	//最新的
	public List lsdancha (int id);
	public List lsfindall();
	public int delete(int id);
	public int insert(Map map);
	
	
}
