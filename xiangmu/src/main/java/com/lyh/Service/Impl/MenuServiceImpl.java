package com.lyh.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.Dao.MenuDao;
import com.lyh.Service.MenuService;
import com.lyh.entity.Menu_Info;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired 
	private MenuDao md;

	
	public List findAll() {
		
		return md.findAll();
	}


	
	public Menu_Info findId(int Menu_id) {
		
		return md.findId(Menu_id);
	}




	public List findf() {
	
		return md.findf();
	}




	public int update(Menu_Info mi) {
		
		return md.update(mi);
	}




	public List getson(int Menu_id) {
		
		return md.getson(Menu_id);
	}




	public int delete(int Menu_id) {
	
		return md.delete(Menu_id);
	}




	public int insert(Menu_Info mi) {
		
		return md.insert(mi);
	}
	
}
