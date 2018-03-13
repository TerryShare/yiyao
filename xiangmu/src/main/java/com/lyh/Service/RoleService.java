package com.lyh.Service;

import java.util.List;

import com.lyh.entity.Role_Info;

public interface RoleService {
	public List findAll(Role_Info ri);
	public Role_Info findid(int id);
	public int update(Role_Info ri);
	public int insert(Role_Info ri);
	public int delete(int id);
	public int count(String mhcx);
}
