package com.lyh.Controlly;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.ExpenseService;
import com.lyh.entity.Audit_history;
import com.lyh.entity.Expense_account;
import com.lyh.entity.User_Info;
import com.lyh.util.BaseBean;
import com.lyh.util.Page;

@Controller
@RequestMapping("/expense/")
public class ExpenseControlly extends Page{
	@Autowired
	private ExpenseService es;
	
	/**
	 * 查询全部
	 * */
	@RequestMapping("findAll")
	public String findAll(HttpServletRequest request,Expense_account ea){
		this.setCurrentPage(0);
		this.initPage(request);
		ea.setCurrentPage(this.getCurrentPage());
		ea.setLineSize(this.getLineSize());
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		
		
		List list=es.findAll(ea);
		request.setAttribute("Expenselist", list);
		request.setAttribute("total", this.es.allcount(ea));
		return "expense/expense_list";
	}
	
	
	
	/**
	 * 我的报销单
	 * */
	@RequestMapping("mybxd")
	public String mybxd(HttpServletRequest request,Expense_account ea){
		this.setCurrentPage(0);
		HttpSession session =request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		this.initPage(request);
	
		ea.setCurrentPage(this.getCurrentPage());
		ea.setLineSize(this.getLineSize());
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		int id=ui.getUser_id();
		ea.setUser_id(id);
		List list=es.findmybxd(ea);
		request.setAttribute("total", this.es.mycount(ea));
		request.setAttribute("mylist", list);
		return "expense/expense_myauditlist";
	}
	
	/**
	 * 财务查全
	 * */
	@RequestMapping("finance")
	public String finance(HttpServletRequest request,Expense_account ea){
		/*this.initPage(request);
		ea.setCurrentPage(this.getCurrentPage());
		ea.setLineSize(this.getLineSize());
		
		ea.setExpense_name(User_name);
		request.setAttribute("User_name", User_name);
		List list=es.findAll(ea);
		request.setAttribute("finlist", list);*/
		this.setCurrentPage(0);
		this.initPage(request);
		ea.setCurrentPage(this.getCurrentPage());
		ea.setLineSize(this.getLineSize());
		String User_name =ea.getUser_name();		
		String Expense_time=ea.getExpense_time();
		List list=es.cwfindAll(ea);
		request.setAttribute("User_name", User_name);
		request.setAttribute("total", this.es.cwcount(ea));
		request.setAttribute("Expense_time", Expense_time);
		request.setAttribute("finlist", list);
		return "expense/expense_audit_finance";
	}
	
	/**
	 * 经理查全
	 * */
	@RequestMapping("manager")
	public String manager(HttpServletRequest request,Expense_account ea){
		this.setCurrentPage(0);
		this.initPage(request);
		ea.setCurrentPage(this.getCurrentPage());
		ea.setLineSize(this.getLineSize());
		String User_name =ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		List list=es.jlfindAll(ea);
		request.setAttribute("User_name", User_name);
		request.setAttribute("total", this.es.jlcount(ea));
		request.setAttribute("Expense_time", Expense_time);
		request.setAttribute("manlist", list);
		return "expense/expense_audit_manager";
	}
	

	
	/**
	 * 查看明细
	 * */
	@RequestMapping("ckmx")
	public String ckmx(HttpServletRequest request,Expense_account ea){
		int expense_id=ea.getExpense_id();
		List jblist=es.findid(expense_id);
		List bxlist=es.bxmx(expense_id);
		List lslist=es.shls(expense_id);
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		request.setAttribute("jblist", jblist);
		request.setAttribute("bxlist", bxlist);
		request.setAttribute("lslist", lslist);
		return "expense/expense_show";
	}
	
/**
 * load添加
 * */	
	
@RequestMapping("insert")
	public String insert(HttpServletRequest request){
		List list =es.findcost();
		request.setAttribute("costlist", list);
		return "expense/expense_add";
}
	/**
	 * 添加
	 * */
@RequestMapping("add")
	public String add(Expense_account ea,double[] detailsAmount,HttpServletRequest request,int[]costId,Model model){
		double zong=0;
		for(int a=0;a<detailsAmount.length;a++){
			zong+=detailsAmount[a]*100;
		}
		zong=zong/100;
		ea.setExpense_total(zong);
		HttpSession session=request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		int id=ui.getUser_id();
		ea.setUser_id(id);
		int rid=ui.getRole_id();
		
		
		if(rid==1){//		判断是否是经理或 财务
			ea.setExpense_state("1");
		}else if(rid==2){
			ea.setExpense_state("2");
		}else{
			ea.setExpense_state("0");
		}
		es.insert(ea);
		int id1=ea.getExpense_id();
		//经理或财务 添加历史
		Audit_history ah=new Audit_history();
		ah.setExpense_id(id1);
		ah.setAudit_desc(ea.getExpense_desc());
		ah.setUser_id(id);
		ah.setAudit_time(ea.getExpense_time());
		if(rid==1){
			es.jltjls(ah);
		}else if(rid==2){
			es.cwtjls(ah);
		}
		
		for(int a=0;a<costId.length;a++){
			es.insertex(ea.getExpense_id(), costId[a], detailsAmount[a]);
		}
		model.addAttribute("errorinfo", "报销单提交成功，请耐心等候审核！");
		return "expense/expense_add";
	
}
	
	/**
	 * 经理审核单查
	 * */
	@RequestMapping("mansh")
	public String mansh(Expense_account ea,HttpServletRequest request){
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		int expense_id=ea.getExpense_id();
		List jblist=es.findid(expense_id);
		List bxlist=es.bxmx(expense_id);
		request.setAttribute("jblist", jblist);
		request.setAttribute("bxlist", bxlist);
		return "expense/expense_manager";
		
	}
	/**
	 * 财务审核 
	 * */
	@RequestMapping("finsh")
	public String findsh(Expense_account ea,HttpServletRequest request){
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		int expense_id=ea.getExpense_id();
		List jblist=es.findid(expense_id);
		List bxlist=es.bxmx(expense_id);
	
		request.setAttribute("jblist", jblist);
		request.setAttribute("bxlist", bxlist);

		
		return "expense/expense_manager2";
		
	}
	/**
	 * 经理审核更新
	 * */
	@RequestMapping("jlshenhe")
	public String jlshenhe(Audit_history ah,Expense_account ea,HttpServletRequest request){
		ea.setExpense_id(ah.getExpense_id());
		ea.setExpense_state(ah.getAudit_state());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		ah.setAudit_time(df.format(new Date()));
		HttpSession session=request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		ah.setUser_id(ui.getRole_id());
		es.update(ah);
		es.update2(ea);
		return manager(request,ea);	
	}
	/**
	 * 财务更新
	 * */
	@RequestMapping("cwupdate")
	public String cwupdate(Audit_history ah,Expense_account ea,HttpServletRequest request){
		ea.setExpense_id(ah.getExpense_id());
		ea.setExpense_state(ah.getAudit_state());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		ah.setAudit_time(df.format(new Date()));
		HttpSession session=request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		ah.setUser_id(ui.getRole_id());
		es.update(ah);
		es.update2(ea);
		return finance(request,ea);	
	}

	/**
	 * 我的查看明细
	 * */
	@RequestMapping("myckmx")
	public String myckmx(HttpServletRequest request,Expense_account ea){
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		int expense_id=ea.getExpense_id();
		List jblist=es.findid(expense_id);
		List bxlist=es.bxmx(expense_id);
		List lslist=es.lsxx(expense_id);
		request.setAttribute("c", jblist.get(0));
		request.setAttribute("bxlist", bxlist);
		request.setAttribute("lslist", lslist);
		return "expense/expense_myshow";
	}
	
	/**
	 * 修改单查
	 * */
	@RequestMapping("mydancha")
	public String mydancha(int expense_id,HttpServletRequest request,Expense_account ea){
		String User_name=ea.getUser_name();
		String Expense_time=ea.getExpense_time();
		request.setAttribute("User_name", User_name);
		request.setAttribute("Expense_time", Expense_time);
		
		List jblist=es.findid(expense_id);
		List bxlist=es.bxmx(expense_id);
		List list =es.findcost();
		
		request.setAttribute("costlist", list);
		request.setAttribute("c", jblist.get(0));
		request.setAttribute("bxlist", bxlist);
		
		return "expense/expense_update";
		
	}
	
	/***
	 * 修改
	 * */
	@RequestMapping("updatezh")
	
	public String updatezh(Expense_account ea,double[] detailsAmount,HttpServletRequest request,int[]costId){
		
		es.delete(ea.getExpense_id());
		System.out.println(ea.toString()+"!!!!!!");
		HttpSession session=request.getSession();
		User_Info us=(User_Info) session.getAttribute("User_Info");
		if(us.getRole_id()==1){//如果等于1  就是经理  等于2就是财务
			ea.setExpense_state("1");
		}else if(us.getRole_id()==2){
			ea.setExpense_state("2");
		}else{
			ea.setExpense_state("0");
		}
		es.updatxg(ea);
		System.out.println(ea.getExpense_time()+"这是co");
		for(int a=0;a<costId.length;a++){
			es.insertex(ea.getExpense_id(), costId[a], detailsAmount[a]);
		}
		ea.setExpense_time(null);
		return mybxd(request,ea);
}
	//时间编辑器
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	
}
