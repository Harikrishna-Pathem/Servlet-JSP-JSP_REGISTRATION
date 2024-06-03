package com.reg.controller;

import java.io.IOException;

import com.reg.dao.StaffDAO;
import com.reg.dao.StaffDAOImpl;
import com.reg.dao.StudentDAO;
import com.reg.dao.StudentDAOImpl;
import com.reg.model.Staff;
import com.reg.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginas = req.getParameter("loginas");
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		Student st = null;
		Staff staff = null;
		if(loginas.equals("student"))
			st = loginAsStudent(uname, password);
		else
			staff = loginAsStaff(uname, password);
		
		
		if(st != null) {
			HttpSession session = req.getSession();
			session.setAttribute("student", st);
			session.removeAttribute("staff");
			resp.sendRedirect("index.jsp");
		}
		
		
		if(staff != null) {
			HttpSession session = req.getSession();
			session.setAttribute("staff", staff);
			session.removeAttribute("student");
			
			resp.sendRedirect("index.jsp");
		}
	}
	
	public Student loginAsStudent(String uname, String password) {
		
		StudentDAO sdao = new StudentDAOImpl();
		
		Student st = null;
		
		if(uname.endsWith(".com")) {
			if(sdao.checkPasswordWithEmail(uname, password)) {
				st = sdao.selectWithEmail(uname);
			}
		}
		else {
			int sid = Integer.parseInt(uname);
			if(sdao.cheackPasswordWithSid(sid, password)) {
				st = sdao.selectWithId(sid);
			}
		}
		
		return st;
	}
	
public Staff loginAsStaff(String uname, String password) {
		
		StaffDAO staffdao = new StaffDAOImpl();
		
		Staff st = null;
		
		if(uname.endsWith(".com")) {
			if(staffdao.checkStaffPasswordWithEmail(uname, password)) {
				st = staffdao.getStaffWithEmail(uname);
			}
		}
		else {
			int staffid = Integer.parseInt(uname);
			if(staffdao.checkStaffPasswordWithStaffid(staffid, password)) {
				st = staffdao.getStaffWithSid(staffid);
			}
		}
		
		return st;
	}
	
	
}
