package com.lyh.Service;

import java.util.List;

import com.lyh.entity.Role_Info;
import com.lyh.entity.User_Info;
import com.lyh.entity.Youjian;

public interface UserService {
	public User_Info login(User_Info us);
	public int insert(User_Info us);
	public int delete (int id);
	public int update(User_Info us);
	public User_Info findId(int id);
	public List findAll(User_Info user);
	public int dxg(int User_id);
	public List findrole();
	public Role_Info findname(String name);
	public int count(String mhcx);
	public List<User_Info> findqx(int Menu_id);
	public List findxj(Youjian yj);
	public Youjian xjid(int id);
	public int fsyj(Youjian yj);
	public List findxma();
	public int gxzt(int id);
	public int deleteyj(int id);
}
