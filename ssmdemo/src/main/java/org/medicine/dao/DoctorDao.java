package org.medicine.dao;

import java.util.List;

import org.medicine.entity.doctor;

public interface DoctorDao {

	public int lytj(doctor doctor);
	
	public List ckly(int panel_id);
	
	public doctor tjyp(int id);
	
	public List ckss(doctor doctor);
	
	public int scly(int id);
	

	
	
}
