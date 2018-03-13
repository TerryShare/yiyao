package com.lyh.Controlly;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.RoleService;
import com.lyh.entity.Role_Info;
import com.lyh.entity.User_Info;
import com.lyh.util.Page;

@Controller
@RequestMapping("/role/")
public class RoleControlly  extends Page{
	@Autowired
	private RoleService rs;
	
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
		ri.setMhcx(mhcx);
		List list=rs.findAll(ri);
		request.setAttribute("Rolelist", list);
		request.setAttribute("mhcx", mhcx);
		request.setAttribute("total", this.rs.count(mhcx));
		return "role/role_list";
	}
	/**
	 * 删除
	 * */
	@RequestMapping("delete")
	public String delete (Role_Info ri ,String roleids[],HttpServletRequest request){
		if(ri==null){
			ri=new Role_Info();
		}
		
		if(roleids!=null){
		for(int a=0;a<roleids.length;a++){
			int id=Integer.parseInt(roleids[a]);
			rs.delete(id);
		}}
		return findAll(ri,request);
	}
	/**
	 * 单查
	 * @return 
	 * */
	@RequestMapping("dancha")
	public  String dancha (String mhcx,int roleids,HttpServletRequest request){
		Role_Info ri=rs.findid(roleids);
		request.setAttribute("mhcx", mhcx);
		request.setAttribute("Role_Info", ri);
		return "role/role_update";
		
	}
	/**
	 * 更新
	 * */
	@RequestMapping("update")
	public String update(HttpServletRequest request,Role_Info ri){
		
		int i=rs.update(ri);
		return findAll(ri,request);	
	}
	
	
	/**
	 * 这是添加的一个跳转页面
	 * */
	@RequestMapping("tiaozhuan")
	public String tiaozhuan(String mhcx,HttpServletRequest request){
		request.setAttribute("mhcx", mhcx);
		return "role/role_add";
		
	}
	
	/**
	 * 添加
	 * */
	@RequestMapping("insert")
	public String insert(Role_Info ri,HttpServletRequest request){
		rs.insert(ri);
		return findAll(ri,request);
	}
	
	
	
	
	
	
	
}
