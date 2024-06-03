package com.reg.dao;

import java.util.List;

import com.reg.model.Staff;
import com.reg.model.StaffMarks;

public interface StaffDAO {
	
	public Staff getStaffWithSid(int staffid);
	
	public Staff getStaffWithEmail(String email);
	
	public boolean checkStaffPasswordWithEmail(String email, String password);
	
	public boolean checkStaffPasswordWithStaffid(int staffid, String password);
	
	public void updateStaffDetails(Staff st);
	
	public void changePassword(int staffid, String password);
	
	public List<StaffMarks> GetStaffMarks(Staff staff, String sp);
	
	
}
