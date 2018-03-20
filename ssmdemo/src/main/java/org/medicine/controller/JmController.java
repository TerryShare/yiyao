package org.medicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author pengfei.liu jm的controller
 *
 */
@Controller
@RequestMapping("user/jm/")
public class JmController {

	// 跳转药物选购
	@RequestMapping("tzyw")
	public String tzyw() {
		return "jumin/index";
	}

	// 跳转咨询医师
	@RequestMapping("tzzx")
	public String tzzx() {
		return "jumin/zixun";
	}


}
