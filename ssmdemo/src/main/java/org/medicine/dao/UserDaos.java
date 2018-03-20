package org.medicine.dao;

import java.util.List;
import java.util.Map;

import org.medicine.entity.fenlei;
import org.medicine.entity.panel;
import org.medicine.entity.register;

public interface UserDaos {
	//登录 查询身份
	public panel login(Map map);
	public int ptzhuce(Map map);
	public int yszhuece(Map map);
	//查询现有医师
		public  List cxys(int shenfen);
		//根据id查医师
		public panel ysly(int id);
	//h  根据商家id查全  商家  商品
	public List hypcq(int ym);
	//分类 查全
	public List hflcq();
	//分类单查
	public fenlei hfldc(int id);
	//药品修改 
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
	
	//管理员 药品 作废
	public int glyypzf(int id);
	//注册医生查全
	public List glyyscq();
	//管理员医生 通过
	public int glyystg(int id);
	//管理员医生作废
	public int glyyszf(int id);
	//管理员单查 医师
	public register glyysdc(int id);
}
