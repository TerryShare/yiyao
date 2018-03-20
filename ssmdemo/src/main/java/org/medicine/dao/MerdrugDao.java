package org.medicine.dao;

import java.util.List;

import org.medicine.entity.merdrug;

public interface MerdrugDao {
	
	public List findmd(String  shenhe);
	public merdrug gmyw(int id);
	
	public List ypgl(merdrug  merdrug);
	
	public int sjyp(int id,String shenhe);
	
	public int  scyp(int id);
}
