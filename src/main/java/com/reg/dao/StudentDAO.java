package com.reg.dao;

import java.util.List;

import com.reg.model.Marks;
import com.reg.model.Notification;
import com.reg.model.Student;

public interface StudentDAO {
	public int save(Student st);
	
	public Student selectWithId(int sid);
	
	public boolean cheackPasswordWithSid(int sid, String Password);
	
	public void updatePassword(int sid, String newPassword);
	
	public boolean checkMail(int sid, String email);
	
	public List<Student> allStudents();
	
	public void delete_With_sid(int sid);
	
	public void editStudent(Student st);
	
	public List<Notification> getNotification();
	
	public Student selectWithEmail(String email);
	
	public boolean checkPasswordWithEmail(String email, String password);
	
	public Marks getMarksWithIdForSem1(int sid);
	
	public Marks getMarksWithIdForSem2(int sid);
	
	public Marks getMarksWithIdForSem3(int sid);
}
