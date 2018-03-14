package org.medicine.controller;

import java.util.*;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.medicine.entity.panel;
import org.medicine.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.catalina.User;

@Controller
@RequestMapping("/user/")
public class UserControllys {
	@Autowired
	private UserServices us;

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
	 * 登录跳转 分等级
	 * 
	 */
	@RequestMapping("logJump")
	public String logJump(HttpServletRequest request, HttpSession session) {
		panel pa = new panel();
		pa = (panel) session.getAttribute("pa");
		String sf=pa.getShenfen();
		System.out.println(sf);
		if(sf.equals("0")) {
			return "guanli/index";
		}else if (sf.equals("1")) {
			return "shangjia/index";
		}else if (sf.equals("2")) {
			return  "yishi/index";
		}else if (sf.equals("3")) {
			return  "jumin/index";
		}
		return "index";
	}
	
	//返回登录页面
	@RequestMapping("tc")
	public String tc(HttpSession session) {
	session.removeAttribute("pa");
		return "login";
	}

}
