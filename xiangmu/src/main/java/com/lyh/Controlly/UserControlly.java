package com.lyh.Controlly;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.UserService;

import com.lyh.entity.User_Info;
import com.lyh.entity.Youjian;
import com.lyh.util.Page;

@Controller
@RequestMapping("/user/")
public class UserControlly extends Page{
@Autowired
private UserService userservice;

/**
 * 登录  如果失败 返回页面 并且 弹出框
 * */
@RequestMapping("login")
	public String login(User_Info user,HttpSession session,HttpServletRequest request){	
		User_Info ui=userservice.login(user);
	
		if(ui!=null){
			session.setAttribute("User_Info", ui);
			request.removeAttribute("dlsb");
			request.setAttribute("dlsb", "0");
			request.setAttribute("mhcx", "请输入用户姓名");
			int roleid=ui.getRole_id();
			List qxlist=userservice.findqx(roleid);
			request.setAttribute("qxlist", qxlist);
			request.setAttribute("qxlist1", qxlist);
			return "main/index";
		}
		request.setAttribute("dlsb", "1");
		return "../../login";
	}

/**
 * 退出
 * */
@RequestMapping("tuichu")
	public String tuichu(HttpSession session){
		session.removeAttribute("User_Info");
		return "../../login";
}



/**
 * 显示页面
 * */
@RequestMapping("bootm")
	public String bootm(){
		return "main/bootm";
	}

/**
 * 查询全部
 * */
@RequestMapping("findAll")
	public String findAll(String mhcx,HttpServletRequest request,User_Info ui){
		if(ui==null){
			ui=new User_Info();
		}
		this.setCurrentPage(0);
		this.initPage(request);
		ui.setCurrentPage(this.getCurrentPage());
		ui.setLineSize(this.getLineSize());
		
		request.setAttribute("mhcx", mhcx);
		ui.setMhcx(mhcx);
		List list=userservice.findAll(ui);
		request.setAttribute("User_Infolist", list);
		request.setAttribute("total", this.userservice.count(mhcx));
		return "user/user_list";
	}
	
	/**
	 * 单查
	 * */
@RequestMapping("dancha")
	public String dancha(int User_id,HttpServletRequest requst,String mhcx,int pd){
		requst.setAttribute("mhcx", mhcx);
		requst.setAttribute("pd", pd);
		
		User_Info us=userservice.findId(User_id);
		requst.setAttribute("dcUser_Info", us);
		return "user/user_update";
	}

/**
 * 修改
 * */
@RequestMapping("update")
	public String update(User_Info us,HttpServletRequest request,String mhcx,int pd){
		us.setMhcx(mhcx);
		int i=userservice.update(us);
		if(pd==1){
			return chakan(us.getUser_id(),request,mhcx);
		}
		return findAll(mhcx,request,us);
	
}

/**
 * 查看
 * */
@RequestMapping("chakan")
	public String chakan(int User_id ,HttpServletRequest requst,String mhcx){
	requst.setAttribute("mhcx", mhcx);
	
	User_Info us=userservice.findId(User_id);
	requst.setAttribute("dcUser_Info", us);
	return "user/user_show";
}
/**
 * 删除
 * */
@RequestMapping("delete")
	public String delete(String User_id[],String mhcx,HttpServletRequest requst){
	if(User_id!=null){
	for(int i=0;i<User_id.length;i++){
		userservice.dxg(Integer.parseInt(User_id[i]));
	}
	}
		return findAll(mhcx,requst,null);
}


/**
 * 增加
 * */
@RequestMapping("insert")
	public String insert(User_Info us,HttpServletRequest requst,String mhcx,User_Info ui){
	
	
	userservice.insert(us);

	return  findAll(mhcx,requst,ui);
}
/**
 * 添加的跳转
 * */
@RequestMapping("tjtz")
	public String tjtz(String mhcx,HttpServletRequest request){
	List list=userservice.findrole();
	request.setAttribute("Rolelist", list);
	request.setAttribute("mhcx", mhcx);
	return "user/user_add";
}
//查看我的收件箱
	@RequestMapping("sjx")
	public String sjx(HttpServletRequest request,Youjian yj){
		if(yj==null){
			yj=new Youjian();
		}
		
		HttpSession session=request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		yj.setShoujianrenid(ui.getUser_id());
		List sjxlist=userservice.findxj(yj);
		request.setAttribute("sjxlist", sjxlist);
		return "user/sjx";	
	}

	//查看邮件
@RequestMapping("chakanyj")
	public String chakanyj(HttpServletRequest request,int id){
		Youjian yj=userservice.xjid(id);
		request.setAttribute("youjian",yj);
		return "user/yjck";
	
}
@RequestMapping("fasong")
	public String fasong(Youjian yj,HttpServletRequest request){
		HttpSession session=request.getSession();
		User_Info ui=(User_Info) session.getAttribute("User_Info");
		int id=ui.getUser_id();
		yj.setFajianrenid(id);
		userservice.gxzt(yj.getId());
		String name=ui.getUser_name();
		yj.setFjrxm(name);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		yj.setShijian(df.format(new Date()));
		userservice.fsyj(yj);
		return sjx(request,null);
	
}
//准备发邮件
@RequestMapping("fyj")
	public String fyj(HttpServletRequest request){
		List userlist=userservice.findxma();
		request.setAttribute("userlist",userlist );
		return "user/fsyj";
	
}

//发送邮件
@RequestMapping("inyj")
	public String inyj(Youjian yj,HttpServletRequest request){
	HttpSession session=request.getSession();
	User_Info ui=(User_Info) session.getAttribute("User_Info");
	yj.setFajianrenid(ui.getUser_id());
	yj.setFjrxm(ui.getUser_name());

	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	yj.setShijian(df.format(new Date()));
	userservice.fsyj(yj);
		return sjx(request,null);
	
}

//删除邮件

@RequestMapping("deleteyj")
	public String deleteyj(String []id,HttpServletRequest request){
	if(id!=null){
		for(int a=0;a<id.length;a++){
			int i=Integer.parseInt(id[a]);
			userservice.deleteyj(i);
		}
	}
		return sjx(request,null);
	
}



	
}
