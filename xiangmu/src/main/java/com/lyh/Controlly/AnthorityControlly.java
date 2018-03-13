package com.lyh.Controlly;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.AnthorityService;
import com.lyh.entity.Menu_Info;
import com.lyh.entity.Role_Info;
import com.lyh.util.Page;

@Controller
@RequestMapping("/anthority/")
public class AnthorityControlly  extends Page{
	@Autowired
	private AnthorityService as;
	
	
	/**
	 * 查全
	 * */
	
	@RequestMapping("findAll")
	public String findAll(Role_Info ri,HttpServletRequest request){
		if(ri==null){
			ri=new Role_Info();
		}
		this.setCurrentPage(0);
		this.initPage(request);
		String mhcx=ri.getMhcx();
		ri.setCurrentPage(this.getCurrentPage());
		ri.setLineSize(this.getLineSize());
		List <Role_Info>list=as.findAll(ri);
		
		request.setAttribute("Rolelist", list);
		request.setAttribute("mhcx", mhcx);
		request.setAttribute("total", this.as.count(mhcx));
		return "anthority/anthority_list";
	}
	
	/**
	 * 改变 存值
	 * */
	@RequestMapping("change")
	public String change(Role_Info ri,HttpServletRequest request){
		List alllist=as.lsfindall();
		String mhcx=ri.getMhcx();
		request.setAttribute("mhcx", mhcx);
		//查全
		request.setAttribute("id", ri.getRole_id());
		request.setAttribute("alllist", alllist);
		request.setAttribute("alllist1", alllist);
		//单查
		List dclist=as.lsdancha(ri.getRole_id());
		request.setAttribute("dclist", dclist);
		
		
		return "anthority/anthority_change";
		
		
	}
	
	/**
	 * 更新
	 * */
	@RequestMapping("update")
	public String update(String Menu_id[],int id,HttpServletRequest request,Role_Info ri){
		if(Menu_id==null){
			as.delete(id);
			return findAll(ri,request);
		}
		as.delete(id);
		for(int a=0;a<Menu_id.length;a++){
			int idd=Integer.parseInt(Menu_id[a]);
			as.insert(idd, id);
		}
		return findAll(ri,request);
	}
	
	
	
	
	
	
}
