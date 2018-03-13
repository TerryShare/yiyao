package com.lyh.Controlly;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lyh.Service.SalaryService;
import com.lyh.entity.Cost_Info;
import com.lyh.entity.Salary_Payment;
import com.lyh.util.Page;

@Controller
@RequestMapping("/salary/")
public class SalaryControlly  extends Page{
	@Autowired
	private SalaryService ss;
	
	/**
	 * 查全
	 * */
	@RequestMapping("findAll")
	public String findAll(HttpServletRequest request,Salary_Payment sp){
		if(sp==null){
			sp=new Salary_Payment();
		}
		String mhcx=sp.getMhcx();
		this.setCurrentPage(0);
		request.setAttribute("mhcx", mhcx);
		
		this.initPage(request);
		sp.setCurrentPage(this.getCurrentPage());
		sp.setLineSize(this.getLineSize());

		List list=ss.findAll(sp);
		
		request.setAttribute("total", this.ss.count(sp));

		request.setAttribute("Salarylist", list);

		return "salary/salary_list";
	}
	/**
	 * 查找
	 * */
	@RequestMapping("findname")
	public String findname(String User_name,String Payment_time,HttpServletRequest request,Salary_Payment sp){
		System.out.println(User_name+"******"+Payment_time);
		List list =ss.findname(User_name, Payment_time);
	
		request.setAttribute("Salarylist", list);
		System.out.println(list+"!!!!!!!");
		return "salary/salary_list";
	}
	
	/**
	 * 发放跳转
	 * */
	@RequestMapping("fftz")
	public String fftz(HttpServletRequest request){
		List list=ss.findusername();
		request.setAttribute("namelist", list);
		return "salary/salary_add";
	}
	
	/**
	 * 添加发放金额
	 * */
	@RequestMapping("insert")
	public String insert(Salary_Payment sp,HttpServletRequest request){
		
		ss.insert(sp);
		return fftz(request);
		
	}
	
	//导入表格
	@RequestMapping("Excel")
	public String Excel(){
		return "salary/excel";
	}
	@RequestMapping("addExcel")
	public String addExcel(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request,Salary_Payment salarypayment){
		try {
			this.ss.insertExcel(file.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return "salary/error";
		}
		return "salary/add";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@RequestMapping("baobiao")
	public String baobiao(HttpServletRequest request){
		Salary_Payment sp=new Salary_Payment();
		
		
		String yiyue="2017-01";
		sp.setPayment_time(yiyue);
		String y1=ss.jq(sp);
		
		 yiyue="2017-02";
		sp.setPayment_time(yiyue);
		String y2=ss.jq(sp);
		
		 yiyue="2017-03";
		sp.setPayment_time(yiyue);
		String y3=ss.jq(sp);
		
		 yiyue="2017-04";
		sp.setPayment_time(yiyue);
		String y4=ss.jq(sp);
		
		 yiyue="2017-05";
		sp.setPayment_time(yiyue);
		String y5=ss.jq(sp);
		
		 yiyue="2017-06";
		sp.setPayment_time(yiyue);
		String y6=ss.jq(sp);
		
		yiyue="2017-07";
		sp.setPayment_time(yiyue);
		String y7=ss.jq(sp);
		
		 yiyue="2017-08";
		sp.setPayment_time(yiyue);
		String y8=ss.jq(sp);
		
		 yiyue="2017-09";
		sp.setPayment_time(yiyue);
		String y9=ss.jq(sp);
		
		 yiyue="2017-10";
		sp.setPayment_time(yiyue);
		String y10=ss.jq(sp);
		
		 yiyue="2017-11";
		sp.setPayment_time(yiyue);
		String y11=ss.jq(sp);
		
		 yiyue="2017-12";
		sp.setPayment_time(yiyue);
		String y12=ss.jq(sp);
		String  yfjq=y1+","+y2+","+y3+","+y4+","+y5+","+y6+","+y7+","+y8+","+y9+","+y10+","+y11+","+y12;
		request.setAttribute("yfjq", yfjq);
		
		//计算每个级别的人的工资
		//role为1的 每个月份总工资
		String roley1=ss.rolejq("2017-01", 1);
		
		String roley2=ss.rolejq("2017-02", 1);
		String roley3=ss.rolejq("2017-03", 1);
		String roley4=ss.rolejq("2017-04", 1);
		String roley5=ss.rolejq("2017-05", 1);
		String roley6=ss.rolejq("2017-06", 1);
		String roley7=ss.rolejq("2017-07", 1);
		String roley8=ss.rolejq("2017-08", 1);
		String roley9=ss.rolejq("2017-09", 1);
		String roley10=ss.rolejq("2017-10", 1);
		String roley11=ss.rolejq("2017-11", 1);
		String roley12=ss.rolejq("2017-12", 1);
		String role1jq=roley1+","+roley2+","+roley3+","+roley4+","+roley5+","+roley6+","+roley7+","+roley8+","+roley9+","+roley10+","+roley11+","+roley12;
		request.setAttribute("role1jq", role1jq);
		
		 roley1=ss.rolejq("2017-01", 2);
		 roley2=ss.rolejq("2017-02", 2);
		 roley3=ss.rolejq("2017-03", 2);
		 roley4=ss.rolejq("2017-04", 2);
		 roley5=ss.rolejq("2017-05", 2);
		 roley6=ss.rolejq("2017-06", 2);
		 roley7=ss.rolejq("2017-07", 2);
		 roley8=ss.rolejq("2017-08", 2);
		 roley9=ss.rolejq("2017-09", 2);
		 roley10=ss.rolejq("2017-10", 2);
		 roley11=ss.rolejq("2017-11", 2);
		 roley12=ss.rolejq("2017-12", 2);
		 String role2jq=roley1+","+roley2+","+roley3+","+roley4+","+roley5+","+roley6+","+roley7+","+roley8+","+roley9+","+roley10+","+roley11+","+roley12;
		 request.setAttribute("role2jq", role2jq);
		
		 roley1=ss.rolejq("2017-01", 3);
		 roley2=ss.rolejq("2017-02", 3);
		 roley3=ss.rolejq("2017-03", 3);
		 roley4=ss.rolejq("2017-04", 3);
		 roley5=ss.rolejq("2017-05", 3);
		 roley6=ss.rolejq("2017-06", 3);
		 roley7=ss.rolejq("2017-07", 3);
		 roley8=ss.rolejq("2017-08", 3);
		 roley9=ss.rolejq("2017-09", 3);
		 roley10=ss.rolejq("2017-10", 3);
		 roley11=ss.rolejq("2017-11", 3);
		 roley12=ss.rolejq("2017-12", 3);
		String role3jq=roley1+","+roley2+","+roley3+","+roley4+","+roley5+","+roley6+","+roley7+","+roley8+","+roley9+","+roley10+","+roley11+","+roley12;
		request.setAttribute("role3jq", role3jq);
		
		 roley1=ss.rolejq("2017-01", 4);
		 roley2=ss.rolejq("2017-02", 4);
		 roley3=ss.rolejq("2017-03", 4);
		 roley4=ss.rolejq("2017-04", 4);
		 roley5=ss.rolejq("2017-05", 4);
		 roley6=ss.rolejq("2017-06", 4);
		 roley7=ss.rolejq("2017-07", 4);
		 roley8=ss.rolejq("2017-08", 4);
		 roley9=ss.rolejq("2017-09", 4);
		 roley10=ss.rolejq("2017-10", 4);
		 roley11=ss.rolejq("2017-11", 4);
		 roley12=ss.rolejq("2017-12", 4);
		String role4jq=roley1+","+roley2+","+roley3+","+roley4+","+roley5+","+roley6+","+roley7+","+roley8+","+roley9+","+roley10+","+roley11+","+roley12;
		request.setAttribute("role4jq", role4jq);
	//动态
		List list= ss.findida();
		String str="";
		for( int b=1;b<list.size()+1;b++){//循环列
			
			for(int c=1;c<13;c++){//循环月份
				Cost_Info ci=(Cost_Info) list.get(b-1);
				int id=ci.getCost_id();
				String time="2017-";
				if(c<10){
					time=time+"0"+c;
				}else{
					time=time+c;
				}
				String hh=ss.costjq(time, id);//获取钱数
				
			
				str=str+"["+c+","+hh+","+id+"],";
			}
		}
		str=str.substring(0, str.length()-1);
		System.out.println(str);
		request.setAttribute("zb", str);
		List ctlist =ss.findcosta();
		request.setAttribute("ctlist", ctlist);
		return "main/bootm";
	}
	
	
	
	
	
}
