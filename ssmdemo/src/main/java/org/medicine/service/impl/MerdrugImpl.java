package org.medicine.service.impl;

import java.util.List;

import org.medicine.dao.MerdrugDao;
import org.medicine.entity.merdrug;
import org.medicine.service.MerdrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MerdrugImpl implements MerdrugService{
	
	@Autowired
	private MerdrugDao mdao;

	public List findmd(String  shenhe) {
		// TODO Auto-generated method stub
		return mdao.findmd(shenhe);
	}

	public merdrug gmyw(int id) {
		// TODO Auto-generated method stub
		return mdao.gmyw(id);
	}

	public List ypgl(merdrug merdrug) {
		// TODO Auto-generated method stub
		return mdao.ypgl(merdrug);

	}

	public int sjyp(int id,String shenhe ) {
		// TODO Auto-generated method stub
		return mdao.sjyp(id,shenhe);
	}

	public int scyp(int id) {
		// TODO Auto-generated method stub
		return mdao.scyp(id);
	}

}
