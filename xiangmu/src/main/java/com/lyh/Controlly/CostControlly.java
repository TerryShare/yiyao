package com.lyh.Controlly;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.CostService;
import com.lyh.entity.Cost_Info;
import com.lyh.util.Page;

@Controller
@RequestMapping("/cost/")
public class CostControlly extends Page{
	@Autowired
	private CostService cs;
	
	@RequestMapping("findAll")
	public String findAll(HttpServletRequest request,Cost_Info ci){



		if(ci==null){
			ci=new Cost_Info();
		}

		this.setCurrentPage(0);
		String mhcx=ci.getMhcx();
		request.setAttribute("mhcx", mhcx);
		
		this.initPage(request);
		ci.setCurrentPage(this.getCurrentPage());
		ci.setLineSize(this.getLineSize());
		List list=cs.findAll(ci);
		request.setAttribute("Costlist", list);
		request.setAttribute("total", this.cs.costcount(ci));
		return "cost/cost_list";
	}
	/**
	 * 添加跳转
	 * */
	@RequestMapping("tjtz")
	public String tjtz(String mhcx,HttpServletRequest request){
		request.setAttribute("mhcx", mhcx);
		return "cost/cost_add";
		
	}
	/**
	 * 添加用户
	 * */
	@RequestMapping("insert")
	public String insert(Cost_Info ci,HttpServletRequest request){
		String mhcx=ci.getMhcx();
		cs.insert(ci);
		return findAll(request,ci);
	}
	
	/**
	 * 单查
	 * */
	@RequestMapping("dancha")
	public String dancha(String mhcx,int Cost_id,HttpServletRequest request){
		request.setAttribute("mhcx", mhcx);
		Cost_Info ci=cs.findId(Cost_id);
		request.setAttribute("Cost_Info", ci);
		return "cost/cost_update";
		
	}
	/**
	 * 修改
	 * */
	@RequestMapping("update")
	public String update(Cost_Info ui,HttpServletRequest request){
		String mhcx=ui.getMhcx();
		request.setAttribute("mhcx", mhcx);
		cs.update(ui);
		return findAll(request,ui);
	}
	/**
	 * 删除
	 * */
	@RequestMapping("delete")
	public String delete (String Cost_id[],String mhcx,HttpServletRequest request){
		for(int a=0;a<Cost_id.length;a++){
			int id=Integer.parseInt(Cost_id[a]);
			cs.delete(id);
		}
		Cost_Info ci=new Cost_Info();
		ci.setMhcx(mhcx);
		return findAll(request,ci);
		
	}
	
	
}
