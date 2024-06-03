package com.reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reg.model.Marks;
import com.reg.model.Notification;
import com.reg.model.Student;

public class StudentDAOImpl implements StudentDAO { 

	static String sql = "insert into students(firstname, lastname, email, password, gender, dob, mobile) value (?, ?, ?, ?, ?, ?, ?)";
	static String Select_With_Sid = "select * from students where sid = ?";
	static String CHECK_PASSWORD = "select password from students where sid = ?";
	static String UPDATE_PASSWORD = "update students set password = ? where sid = ?";
	static String CHECK_EMAIL = "select email from students where sid = ?";
	static String SELECT_ALL_STUDENTS = "select * From students";  
	static String DELETE_WITH_SID = "DELETE FROM students WHERE sid = ?"; 
	static String UPDATE_STUDENT = "update students set firstname = ?, lastname = ?, email = ?, gender = ?, dob = ?, mobile = ? where sid = ?";
	static String Select_With_Email = "select * from students where email = ?";
	static String CHECK_PASSWORD_Using_Email = "select password from students where email = ?";
	
	static String Get_Marks_With_Sid_for_Sem1 = "select firstname, lastname, sub1, sub2, sub3, sub4, sub5 from students inner join sem1 on students.sid = sem1.sid where students.sid = ?";
	static String Get_Marks_With_Sid_for_Sem2 = "select firstname, lastname, sub1, sub2, sub3, sub4, sub5 from students inner join sem2 on students.sid = sem2.sid where students.sid = ?";
	static String Get_Marks_With_Sid_for_Sem3 = "select firstname, lastname, sub1, sub2, sub3, sub4, sub5 from students inner join sem3 on students.sid = sem3.sid where students.sid = ?";
	
	static String GET_NOTIFICATIONS = "select * from notifications";
	
	public static void main(String[] args) {
		StudentDAOImpl ss = new StudentDAOImpl();
//		boolean ps = ss.cheackPassword(1001, "hk@123");
//		System.out.println("pass ->" + ps);
		boolean pss = ss.checkMail(1001, "hari@gmail.com");
		System.out.println("mail -> "+ pss);
		
		ss.updatePassword(1001, "hari@rejectedpeace");
	}

	@Override
	public int save(Student st) {
		int sid = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			System.out.println("Save Called");

//			Statement stmt = conn.createStatement();
//			
//			String sql2 = "insert into students values (1001, 'hk', 'darling', 'hari@gmail.com', 'hk@123', 'male', '02/04/2002')";
//			int rows = stmt.executeUpdate(sql2);

			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, st.getFname());
			ps.setString(2, st.getLname());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getPassword());
			ps.setString(5, st.getGender());
			ps.setString(6, st.getDob());
			ps.setString(7, st.getMobile());

			int rows = ps.executeUpdate();
			System.out.println(rows + " Rows Affected");

			ResultSet res = ps.getGeneratedKeys();
			res.next();
			sid = res.getInt(1);
			System.out.println(sid);
//			String sname = res.getString(2);
//			String lname = res.getString(3);
//			String email = res.getString(4);
//			String pswd = res.getString(5);
//			String gen = res.getString(6);
//			String dob = res.getString(7);

//			System.out.println(sname + "\t" + lname + "\t" + email);

//			
//			System.out.println(rows +" rows Affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sid;
	}

	@Override
	public Student selectWithId(int sid) {
		Student st = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Select_With_Sid);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			int siddb = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String passord = rs.getString(5);
			String gender = rs.getString(6);
			String dob = rs.getString(7);
			String mobile = rs.getString(7);
		
			st = new Student(siddb, fname, lname, email, passord, gender, dob, mobile);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	@Override
	public boolean cheackPasswordWithSid(int sid, String Password) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(CHECK_PASSWORD);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String password_Org = rs.getString(1);

//			System.out.println(password_Org);
			
			if(password_Org.equals(Password))
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	@Override
	public boolean checkMail(int sid, String email) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(CHECK_EMAIL);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String email_Org = rs.getString(1);

			System.out.println(email_Org);
			
			if(email_Org.equals(email))
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public void updatePassword(int sid, String newPassword) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(UPDATE_PASSWORD);

			ps.setString(1, newPassword);
			ps.setInt(2, sid);

			int rows = ps.executeUpdate();

			System.out.println(rows + "rows affected");

		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

	@Override
	public List<Student> allStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_STUDENTS);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int sid = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String email = rs.getString(4);
				String passord = rs.getString(5);
				String gender = rs.getString(6);
				String dob = rs.getString(7);
				String mobile = rs.getString(8);
				System.out.println(gender);
				Student st = new Student(sid, fname, lname, email, passord, gender, dob, mobile);
				
				
				
				students.add(st);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students; 
	}

	@Override
	public void delete_With_sid(int sid) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(DELETE_WITH_SID);
			ps.setInt(1, sid);
			int rows = ps.executeUpdate();
			System.out.println(rows + "rows affected");

		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

	@Override
	public void editStudent(Student st) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			
			PreparedStatement ps = conn.prepareStatement(UPDATE_STUDENT);
			ps.setString(1, st.getFname());
			ps.setString(2, st.getLname());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getGender());
			ps.setString(5, st.getDob());
			ps.setString(6, st.getMobile());
			ps.setInt(7, st.getSid());
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "rows affected");

		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

	@Override
	public List<Notification> getNotification() {
		List<Notification> nots = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(GET_NOTIFICATIONS);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String date = rs.getString("rdate");
				String text = rs.getString("value");
				
				Notification not = new Notification(date, text);
				
				
				
				nots.add(not);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nots; 
	}

	@Override
	public Student selectWithEmail(String email) {
		Student st = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Select_With_Email);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			rs.next();
			int siddb = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String semail = rs.getString(4);
			String passord = rs.getString(5);
			String gender = rs.getString(6);
			String dob = rs.getString(7);
			String mobile = rs.getString(8);
		
			st = new Student(siddb, fname, lname, semail, passord, gender, dob, mobile);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	@Override
	public boolean checkPasswordWithEmail(String email, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(CHECK_PASSWORD_Using_Email);

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
	public Marks getMarksWithIdForSem1(int sid) {
		Marks marks = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Get_Marks_With_Sid_for_Sem1);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			int sub1 = rs.getInt(3);
			int sub2 = rs.getInt(4);
			int sub3 = rs.getInt(5);
			int sub4 = rs.getInt(6);
			int sub5 = rs.getInt(7);
		
			marks = new Marks(fname, lname, sub1, sub2, sub3, sub4, sub5);
			
		
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return marks;
	}
	
	public Marks getMarksWithIdForSem2(int sid) {
		Marks marks = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Get_Marks_With_Sid_for_Sem2);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			int sub1 = rs.getInt(3);
			int sub2 = rs.getInt(4);
			int sub3 = rs.getInt(5);
			int sub4 = rs.getInt(6);
			int sub5 = rs.getInt(7);
		
			marks = new Marks(fname, lname, sub1, sub2, sub3, sub4, sub5);
			
		
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return marks;
	}
	
	public Marks getMarksWithIdForSem3(int sid) {
		Marks marks = null;
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(Get_Marks_With_Sid_for_Sem3);

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			rs.next();
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			int sub1 = rs.getInt(3);
			int sub2 = rs.getInt(4);
			int sub3 = rs.getInt(5);
			int sub4 = rs.getInt(6);
			int sub5 = rs.getInt(7);
		
			marks = new Marks(fname, lname, sub1, sub2, sub3, sub4, sub5);
			
		
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return marks;
	}




	
}
