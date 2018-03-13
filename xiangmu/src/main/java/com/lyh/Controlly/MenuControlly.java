package com.lyh.Controlly;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.Service.MenuService;
import com.lyh.entity.Menu_Info;

@Controller
@RequestMapping("/menu/")
public class MenuControlly {
	@Autowired
	private MenuService ms;
	/**
	 * 刚进去的时候
	 * */
	@RequestMapping("index")
	public String index(){
		return "menu/menu_index";
	}
	/**
	 * 头部
	 * */
	@RequestMapping("menutop")
	public String menutop(){
		return "menu/menu_top";
	}
	
	/**
	 * 左边
	 * */
	@RequestMapping("menuleft")
	public String menuleft(HttpServletRequest request){
		List list=ms.findAll();
		request.setAttribute("list", list);
		return "menu/menu_left";
	}
	/**
	 * main
	 * */
	@RequestMapping("main")
	public String main(HttpServletRequest request){
		return "menu/menu_main";
	}
	/**
	 * 单查
	 * */
	@RequestMapping("dancha")
	public String dancha(int Menu_id,HttpServletRequest request,int pd){
		
		Menu_Info mi=ms.findId(Menu_id);
		
		request.setAttribute("Menu_Info", mi);
		Menu_Info msj =ms.findId(mi.getPrent_menu_id());
		request.setAttribute("shangji", msj);
		request.setAttribute("Menu_id", mi.getMenu_id());
		if(pd==1){//如果pd等于1是更新
			List<Menu_Info> flist=ms.findAll();
			for(int a=0;a<flist.size();a++){
				if(flist.get(a).getMenu_id()==Menu_id){
					flist.remove(a);
				}
			}
			if(mi.getPrent_menu_id()==-1){
				request.setAttribute("msg", "跟节点不能删除");
				return "menu/menu_load";
			}
			request.setAttribute("flist", flist);
			return "menu/menu_update";
		}
		return main(request);
	}
	/**
	 * 更新
	 * */
	
	@RequestMapping("update")
	public String update(Menu_Info mi,HttpServletRequest request){
		
		if(mi.getPrent_menu_id()==-1){
			request.setAttribute("msg", "跟节点不能更新");
			return "menu/menu_load";
		}else{
			ms.update(mi);
		}
		return "menu/menu_load";
		
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping("delete")
	public String delete(int Menu_id,HttpServletRequest request){
		if(ms.getson(Menu_id).size()!=0){
			
			request.setAttribute("msg", "请先删除下级菜单");
			return "menu/menu_load";
		}
		ms.delete(Menu_id);
		return "menu/menu_load";
		
	}
	
	
	/**
	 * 添加的跳转页面
	 * */
	@RequestMapping("tjtz")
	public String tjtz(HttpServletRequest request){
		List<Menu_Info> flist=ms.findAll();
		request.setAttribute("list", flist);
		return "menu/menu_add";
	}
	
	/**
	 * 添加
	 * */
	@RequestMapping("insert")
	public String insert(Menu_Info mi){
		ms.insert(mi);
		return "menu/menu_load";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
