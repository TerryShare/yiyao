package org.medicine.service.impl;

import java.util.List;

import org.medicine.dao.DoctorDao;
import org.medicine.entity.doctor;
import org.medicine.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorImpl implements DoctorService{
	
	@Autowired
	private DoctorDao dd;
	
	public int lytj(doctor doctor) {
		// TODO Auto-generated method stub
		return dd.lytj(doctor);
	}

	public List ckly(int panel_id) {
		// TODO Auto-generated method stub
		return dd.ckly(panel_id);
	}

	public doctor tjyp(int id) {
		// TODO Auto-generated method stub
		return dd.tjyp(id);
	}

	public List ckss(doctor doctor) {
		// TODO Auto-generated method stub
		return dd.ckss(doctor);
	}

	public int scly(int id) {
		// TODO Auto-generated method stub
		return dd.scly(id);
	}

	

	

}
