package com.lyh.Service;

import java.util.List;

import com.lyh.entity.Menu_Info;



public interface MenuService {
	public List findAll();
	public Menu_Info findId(int Menu_id);
	public List findf();
	public int update(Menu_Info mi);
	public List getson(int Menu_id);
	public int delete(int Menu_id);
	public int insert(Menu_Info mi);
}
