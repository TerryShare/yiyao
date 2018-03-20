package org.medicine.service;

import java.util.List;
import java.util.Map;

import org.medicine.entity.fenlei;
import org.medicine.entity.panel;

public interface UserServices {
	public panel login(Map map);
	public int ptzhuce(Map map);
	public int yszhuece(Map map);
	public List hypcq(int ym);
	//分类 查全
	public List hflcq();
	//分类单查
	public fenlei hfldc(int id);
	public int ypxg(Map map);
	//商品增加
	public int spzj(Map map);
	//查全 用户
		public List hglycq();
		//管理员 添加用户
		public int hglyxg(Map map);
		//管理员单个删除
		public int yhglsc(int id);
		//管理员 添加 用户
		public int hglytj(Map map);
		//管理员药品查全
		public List glyypcq();
		//管理员 药品 审核通过
		
		public int glyyptg(int id);
		public int glyypzf(int id);
		//注册医生查全
		public List glyyscq();
		//管理员医生 通过
		public int glyystg(int id);
		//管理员医生作废
		public int glyyszf(int id);
		//查询现有医师
		public  List cxys(int shenfen);
		//根据id查医师
		public panel ysly(int id);
}
