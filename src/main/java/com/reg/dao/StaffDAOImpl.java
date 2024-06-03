package com.reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reg.model.Staff;
import com.reg.model.StaffMarks;


public class StaffDAOImpl implements StaffDAO {
	
	static String SELECT_WITH_STAFFID = " select * from staff inner join subjects on staff.staffid = subjects.staffid where staff.staffid = ?";
	static String SELECT_STAFF_WITH_EMAIL= " select * from staff inner join subjects on staff.staffid = subjects.staffid where email = ?";
	
	static String CHECK_PASSWORD_WITH_STAFFID = "select password from staff where staffid = ?";
	static String CHECK_PASSWORD_WITH_EMAIL = "select password from staff where email = ?";
	
	static String Update_Staff = "update staff set fname = ?, lname = ?, email = ?, mobile = ?, gender = ?, password = ? where staffid = ?";
	static String Update_Password = "update staff set password = ? where staffid = ?";
	

	public static void main(String[] args) {
		StaffDAO sd = new StaffDAOImpl();
		
		Staff st = new Staff(3001, "dinesh", "neelam", "dinesh@gmail.com", "85284", "grnder", "dinesh", 1, "subjectone");
		
		List<StaffMarks> getStaffMarks = sd.GetStaffMarks(st, "/semone");
		
		System.out.println(getStaffMarks);
	}
//	
	
	
	@Override
	public Staff getStaffWithSid(int staffid) {
		Staff st = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(SELECT_WITH_STAFFID);

			ps.setInt(1, staffid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			int staffiddb = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String mobile = rs.getString(5);
			String gender = rs.getString(6);
			String password = rs.getString(7);
			int subid = rs.getInt(8);
			String subject = rs.getString(9);
		
			st = new Staff(staffiddb, fname, lname, email, mobile, gender, password, subid, subject);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	@Override
	public Staff getStaffWithEmail(String email) {
		Staff st = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(SELECT_STAFF_WITH_EMAIL);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			rs.next();
			int staffiddb = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String emaildb = rs.getString(4);
			String mobile = rs.getString(5);
			String gender = rs.getString(6);
			String password = rs.getString(7);
			int subid = rs.getInt(8);
			String subject = rs.getString(9);
		
			st = new Staff(staffiddb, fname, lname, emaildb, mobile, gender, password, subid, subject);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	@Override
	public boolean checkStaffPasswordWithEmail(String email, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(CHECK_PASSWORD_WITH_EMAIL);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String password_Org = rs.getString(1);

//			System.out.println(password_Org);
			
			if(password_Org.equals(password))
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean checkStaffPasswordWithStaffid(int staffid, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(CHECK_PASSWORD_WITH_STAFFID);

			ps.setInt(1, staffid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String password_Org = rs.getString(1);

//			System.out.println(password_Org);
			
			if(password_Org.equals(password))
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void updateStaffDetails(Staff staff) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Update_Staff);
			
			ps.setString(1, staff.getFname());
			ps.setString(2, staff.getLname());
			ps.setString(3, staff.getEmail());
			ps.setString(4, staff.getMobile());
			ps.setString(5, staff.getGender());
			ps.setString(6, staff.getPassword());
			
			ps.setInt(7, staff.getStaffid());
		
			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void changePassword(int staffid, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Update_Password);
			
			ps.setString(1, password);
			
			ps.setInt(7, staffid);
		
			ps.executeUpdate();
			
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StaffMarks> GetStaffMarks(Staff staff, String sp) {
		
		List<StaffMarks> sm = new ArrayList<StaffMarks>();
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			String subject = staff.getSubject();
			
			String sub = subject.equals("subjectone") ? "sub1":
				subject.equals("subjecttwo") ? "sub2":
					subject.equals("subjectthree") ? "sub3":
						subject.equals("subjectfour") ? "sub4":
							subject.equals("subjectfive") ? "sub5": null;
			
			String table = sp.contains("semone") ? "sem1" :
				sp.contains("semtwo") ? "sem2" :
					sp.contains("semthree") ? "sem3" : null;

			PreparedStatement ps = conn.prepareStatement("select students.sid, firstname, lastname,"+ sub +" from students inner join "+ table +" on students.sid = "+table+".sid;");
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int sid = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				int marks = rs.getInt(4);
				
				StaffMarks sf = new StaffMarks(sid, fname, lname, marks);
				
				sm.add(sf);
			}
			
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sm;
	}

}
