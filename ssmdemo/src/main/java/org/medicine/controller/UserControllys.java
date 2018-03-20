package org.medicine.controller;

import java.util.*;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.medicine.entity.doctor;
import org.medicine.entity.merdrug;
import org.medicine.entity.panel;
import org.medicine.service.DoctorService;
import org.medicine.service.MerdrugService;
import org.medicine.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.catalina.User;

/**
 * 
 * @author pengfei.liu 管理员的controller
 *
 */
@Controller
@RequestMapping("/user/")
public class UserControllys {
	@Autowired
	private UserServices us;

	@Autowired
	private MerdrugService ms;
	
	@Autowired
	private DoctorService ds;
	/**
	 * 登录 如果失败 返回页面 并且 弹出框
	 * 
	 */
	@ResponseBody
	@RequestMapping("login")
	public String login(String requestDate, HttpServletRequest request, HttpSession sessions) {
		//
		Map map = new HashMap();
		//
		JSONObject requestJson = JSONObject.fromObject(requestDate);
		System.out.println(requestJson);
		map.put("name", requestJson.getString("name"));
		map.put("password", requestJson.getString("password"));
		panel pa = us.login(map);
		sessions.setAttribute("pa", pa);
		HttpSession session = request.getSession();
		if (pa != null) {
			Map reMap = new HashMap();
			String sf = pa.getShenfen();
			reMap.put("succ", "user/logJump.do");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(reMap);
			return jsonObject.toString();

		} else {
			Map reMap = new HashMap();
			reMap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(reMap);
			return jsonObject.toString();
		}
	}

	/**
	 * 注册
	 */
	@ResponseBody
	@RequestMapping("zhuce")
	public String zhuce(String requestDate, HttpServletRequest request) {
		Map map = new HashMap();
		JSONObject requestJson = JSONObject.fromObject(requestDate);
		System.out.println(requestJson);
		map.put("name", requestJson.getString("name"));
		map.put("password", requestJson.getString("password"));
		map.put("shenfen", requestJson.getString("code"));

		String cod = requestJson.getString("code");
		if (cod.equals("2")) {
			map.put("t1", requestJson.getString("t1"));
			map.put("t2", requestJson.getString("t2"));
			map.put("t3", requestJson.getString("t3"));
			int b = us.yszhuece(map);
			if (b == 1) {
				Map reMap = new HashMap();
				reMap.put("succ", "true");
				JSONObject jsonObject = JSONObject.fromObject(reMap);
				return jsonObject.toString();
			} else {
				Map reMap = new HashMap();
				reMap.put("succ", "注册失败!");
				JSONObject jsonObject = JSONObject.fromObject(reMap);
				return jsonObject.toString();
			}
		} else {
			// 如果不是2直接 插入
			int a = us.ptzhuce(map);
			System.out.println(a);
			if (a == 1) {
				Map reMap = new HashMap();
				reMap.put("succ", "true");
				JSONObject jsonObject = JSONObject.fromObject(reMap);
				return jsonObject.toString();
			} else {
				Map reMap = new HashMap();
				reMap.put("succ", "注册失败!");
				JSONObject jsonObject = JSONObject.fromObject(reMap);
				return jsonObject.toString();
			}
		}
	}
	
	/**
	 * 登录跳转 分等级  这里只跳转  
	 * 
	 */
	@RequestMapping("logJump")
	public String logJump(HttpServletRequest request, HttpSession session) {
		panel pa = new panel();
		pa = (panel) session.getAttribute("pa");
		String sf = pa.getShenfen();
		System.out.println(sf);
		if (sf.equals("0")) {
			// 模块管理
			return "guanli/yhgl";
		} else if (sf.equals("1")) {
			//
			return "shangjia/index";
		} else if (sf.equals("2")) {
			return "redirect:ckly.do";
		} else if (sf.equals("3")) {
			return "redirect:tzyw.do";
		}
		return "index";
	}

	// 返回登录页面
	@RequestMapping("tc")
	public String tc(HttpSession session) {
		session.removeAttribute("pa");
		return "login";
	}

	// 跳转模块管理
	@RequestMapping("tzmk")
	public String tzmk() {
		return "guanli/index";
	}

	// 跳转角色管理
	@RequestMapping("tzjs")
	public String tzjs() {
		return "guanli/juese";
	}

	// 跳转审核管理
	@RequestMapping("tzsh")
	public String tzsh() {
		return "guanli/shenhe";
	}


	
	//根据商家信息 查全药品
	@ResponseBody
	@RequestMapping(value="hcqyp",produces = {"text/html;charset=UTF-8;"})
	public String hcqyp(HttpSession session){
		panel pa=(panel) session.getAttribute("pa");
		int id=pa.getId();
		List list=us.hypcq(id);
		List flcq=new ArrayList();
		flcq=us.hflcq();
		Map map=new HashMap();
		map.put("fenlei",flcq);
		map.put("yp",list);
		try{
			JSONObject jsonObject = JSONObject.fromObject(map);
//			JSONArray jsonArray =JSONArray.fromObject(map);
//			System.out.println(jsonArray.toString());
			System.out.println();
			return jsonObject.toString();
		}catch(Exception e){
			return null;
		}
		
	}
	//商品 修改
	@ResponseBody
	@RequestMapping("spxg")
	public String spxg(String requestDate){
		JSONObject requestJson = JSONObject.fromObject(requestDate);
		System.out.println(requestJson);
		Map map=new HashMap();
		map.put("flid", requestJson.get("flid"));
		map.put("name",requestJson.get("name"));
		map.put("price",requestJson.get("price"));
		map.put("number",requestJson.get("number"));
		map.put("shangjia",requestJson.get("shangjia"));
		map.put("id",requestJson.get("id"));
		int a=us.ypxg(map);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
		
	}
	//点击上架 医用品 跳转页面
	@RequestMapping("sjyyp")
	public String sjyyp(){
		return "shangjia/shangyy";
	}
	//点击添加商品
	@ResponseBody
	@RequestMapping("spzj")
	public String spzj(String requestDate,HttpSession session){
		panel pa=(panel) session.getAttribute("pa");
		int id=pa.getId();
		String name=pa.getName();
		JSONObject requestJson = JSONObject.fromObject(requestDate);
		System.out.println(requestJson);
		Map map=new HashMap();
		map.put("sjid", id);
		map.put("name", requestJson.get("name"));
		map.put("flid",requestJson.get("flid"));
		map.put("number",requestJson.get("number"));
		map.put("price",requestJson.get("price"));
		map.put("shangjia",requestJson.get("shangjia"));
		map.put("t1",name);
		map.put("t2",requestJson.get("t2"));
		int a=us.spzj(map);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
	
	}
	
	//h   用户 查全
	@ResponseBody
	@RequestMapping("hglycq")
	public String hglycq(String requestdata){
		List list=new ArrayList();
		list=us.hglycq();
		if(list!=null){
			JSONArray jsonArray =JSONArray.fromObject(list);
			return jsonArray.toString();
		}
		return null;
		
	}
	//gly  用户管理 跳转
	@RequestMapping("yhgltz")
	public String yhgltz(){
		return "guanli/yhgl";
	}
	//管理员身份 添加用户
	@ResponseBody
	@RequestMapping("hglyxg")
	public String hglyxg(String requestData){
		//
		Map map = new HashMap();
		//
		JSONObject requestJson = JSONObject.fromObject(requestData);
		map.put("id", requestJson.getString("id"));
		map.put("name", requestJson.getString("name"));
		map.put("password", requestJson.getString("password"));
		map.put("shenfen", requestJson.getString("shenfen"));
		int a=us.hglyxg(map);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
	}
	//管理员删除
	@ResponseBody
	@RequestMapping("yhglsc")
	public String yhglsc(int id){
		System.out.println(id);
		int a=us.yhglsc(id);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
	}
	//管理员添加
	@ResponseBody
	@RequestMapping("hglytj")
	public String hglytj(String requestData){
		//
		Map map = new HashMap();
		//
		JSONObject requestJson = JSONObject.fromObject(requestData);
		System.out.println(requestJson);
		map.put("name", requestJson.getString("name"));
		map.put("password", requestJson.getString("password"));
		map.put("shenfen", requestJson.getString("shenfen"));
		int a=us.hglytj(map);
		System.out.println(map);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");//
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
	}
	//管理员查全药品
	@ResponseBody
	@RequestMapping("glyypcq")
	public String glyypcq(){
		List list=new ArrayList();
		list=us.glyypcq();
		System.out.println(list);
		if(list!=null){
			JSONArray jsonObject = JSONArray.fromObject(list);
			return jsonObject.toString();
		}
		return null;
	}
	//审核页面跳转
	@RequestMapping("glyshtz")
	public String glyshtz(){
		return "guanli/shenhe";
	}
	//管理员审核药品审核 通过
	@ResponseBody
	@RequestMapping("glyyptg")
	public String glyyptg(int  id){
		System.out.println(id);
		int a=0;
		a=us.glyyptg(id);
		if(a==0){
			Map hmap=new HashMap();
			hmap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}else{
			Map hmap=new HashMap();
			hmap.put("succ", "true");// 这里写 跳转地址
			JSONObject jsonObject = JSONObject.fromObject(hmap);
			return jsonObject.toString();
		}
	}
	//管理员审核药品审核 作废
		@ResponseBody
		@RequestMapping("glyypzf")
		public String glyypzf(int  id){
			int a=0;
			a=us.glyypzf(id);
			if(a==0){
				Map hmap=new HashMap();
				hmap.put("succ", "false");
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}else{
				Map hmap=new HashMap();
				hmap.put("succ", "true");// 
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}
		}
		//医师 查全
		@ResponseBody
		@RequestMapping("glyyscq")
		public String glyypzf(){
			List list=new ArrayList();
			list=us.glyyscq();
			if(list!=null){
				JSONArray jsonObject = JSONArray.fromObject(list);
				return jsonObject.toString();
			}
			return null;		
		}
		//医师通过
		@ResponseBody
		@RequestMapping("glyytg")
		public String glyytg(int id){
			int a=us.glyystg(id);
			if(a==0){
				Map hmap=new HashMap();
				hmap.put("succ", "false");
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}else{
				Map hmap=new HashMap();
				hmap.put("succ", "true");// 
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}
		}
		//医师作废
		@ResponseBody
		@RequestMapping("glyyzf")
		public String glyyzf(int id){
			int a=us.glyyszf(id);
			if(a==0){
				Map hmap=new HashMap();
				hmap.put("succ", "false");
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}else{
				Map hmap=new HashMap();
				hmap.put("succ", "true");// 
				JSONObject jsonObject = JSONObject.fromObject(hmap);
				return jsonObject.toString();
			}
		}
		
		// 跳转留言管理
		@RequestMapping("ckss")
		public String ckss(HttpServletRequest request,doctor doctor) {
			List lylist=ds.ckss(doctor);
			System.out.println(lylist);
			request.setAttribute("lylist", lylist);
			return "guanli/liuyan";
		}
		
		//删除留言
		@RequestMapping("scly")
		public String scly(int id) {
			System.out.println(id);
			ds.scly(id);
			return "redirect:ckss.do";
		}
		
		//药品管理
		@RequestMapping("ypgl")
		public String ypgl(HttpServletRequest request,merdrug merdrug) {
			List   yplist=ms.ypgl(merdrug);
			request.setAttribute("yplist", yplist);
			return  "guanli/yaopin";
			
		}
		//上下架操作
		@RequestMapping("sjyp")
		public String sjyp(int id,HttpServletRequest request) {
			System.out.println(id);
			ms.scyp(id);
			merdrug merdrug=new merdrug();
			List   yplist=ms.ypgl(merdrug);
			request.setAttribute("yplist", yplist);
			return  "guanli/yaopin";

			
		}



		// 跳转信息管理
		@RequestMapping("tzxx")
		public String tzxx() {
			return "guanli/shenhe";
		}

		
		// 跳转药物选购
		@RequestMapping("tzyw")
		public String tzyw(HttpServletRequest request) {
			String shenhe="1";
			List ywlist=ms.findmd(shenhe);
			request.setAttribute("ywlist", ywlist);
			System.out.println(ywlist);
			return "jumin/index";
		}
		//跳转到购买页面
		@RequestMapping("gmyw")
		public String gmyw(HttpServletRequest request,int id) {
			merdrug gm=ms.gmyw(id);
			request.setAttribute("gm", gm);
			System.out.println(gm);
			return "jumin/gmyp";
		}
		// 跳转咨询医师
		@RequestMapping("tzzx")
		public String tzzx(HttpServletRequest request) {
			List yslist =us.cxys(2);
			request.setAttribute("yslist", yslist);
			System.out.println(yslist);
			return "jumin/zixun";
		}
		
		//医师留言界面
		@RequestMapping("ysly")
		public String  ysly(int id,HttpServletRequest request,HttpSession session) {
			//跳转之后获取当前登录的居民姓名,因为留言之后医师需要查看是哪位居民留言
			panel pa = new panel();
			pa = (panel) session.getAttribute("pa");
			String sf = pa.getName();
			System.out.println("当前提交人:++++++++"+sf);
			panel ysly=us.ysly(id);
			request.setAttribute("ysly",ysly );
			request.setAttribute("sf", sf);
			System.out.println(ysly);
			return "jumin/ysly";
		}
		
		//留言提交
		@RequestMapping("lytj")
		public String lytj(doctor doctor,HttpSession session,HttpServletRequest request) {
			System.out.println(doctor);
			doctor.toString();
			System.out.println(doctor.toString());
			ds.lytj(doctor);
			//tz咨询医师数据
			List yslist =us.cxys(2);
			request.setAttribute("yslist", yslist);
			return "jumin/zixun";
		}
		
		//跳转医师查看留言
		@RequestMapping("ckly")
		public String ckly(HttpServletRequest request,HttpSession session) {
			panel pa = new panel();
			pa = (panel) session.getAttribute("pa");
			int panel_id=pa.getId();
			System.out.println("取到当前登录医师编号"+panel_id);
			List lylist=ds.ckly(panel_id);
			System.out.println("根据id查到医师下的留言"+lylist);
			request.setAttribute("lylist", lylist);
			return "yishi/index";
			
		}	
		
		//跳转推荐药品
		@RequestMapping("tjyp")
		public String tjyp(int id,HttpServletRequest request) {
			//留言编号 查询 
			doctor dc=ds.tjyp(id);
			System.out.println(dc);
			request.setAttribute("dc", dc);
			//药品列表
			merdrug merdrug=new merdrug();
			String shenhe="1";
			List ywlist=ms.findmd(shenhe);
			System.out.println(ywlist);
			request.setAttribute("ywlist", ywlist);
			return "yishi/yptj";
		}
		
		
		
		
		
}
