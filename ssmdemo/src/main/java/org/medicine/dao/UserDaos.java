package org.medicine.dao;

import java.util.Map;

import org.medicine.entity.panel;

public interface UserDaos {
	//登录 查询身份
	public panel login(Map map);
	public int ptzhuce(Map map);
	public int yszhuece(Map map);
}
