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

@WebServlet(name = "forget", urlPatterns = {"/forget", "/newpassword"})
public class ForgetServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();	
		
		HttpSession sess = req.getSession();
		
		Student st = (Student) sess.getAttribute("student");
		Staff staff = (Staff) sess.getAttribute("staff");
		
		if(st != null) {
			if(uri.endsWith("forget"))
				forgetStudentPassword(req, resp);
			else if(uri.endsWith("newpassword"))
				newPassword(req, resp);
		}else if(staff != null) {
			if(uri.endsWith("newpassword"))
				staffNewPassword(req, resp);
		}
		
		
	}

	private void forgetStudentPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int loginid = Integer.parseInt(req.getParameter("loginid"));
		String email = req.getParameter("email");
		
		StudentDAO sdao = new StudentDAOImpl();
		
		boolean details = sdao.checkMail(loginid, email);
		
		if(details)
			req.setAttribute("loginid", loginid);
		else {
			req.setAttribute("varified", true);
			req.setAttribute("details", details);
		}
			
		
		
		req.getRequestDispatcher("forgetPage.jsp").forward(req, resp);;
		
	}
	
	public void newPassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int loginid = Integer.parseInt(req.getParameter("loginid"));
		String newp = req.getParameter("newpassword");
		String renewp = req.getParameter("renewpassword");
		
		StudentDAO sdao = new StudentDAOImpl();
		
		if(newp.equals(renewp)) {
			sdao.updatePassword(loginid, newp);
			req.setAttribute("from", "Your Password Changed Sucessfully");
			req.getSession().removeAttribute("student");
			req.getRequestDispatcher("afterRegister.jsp").forward(req, res);
		}
			
	}
	
	
	public void staffNewPassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int loginid = Integer.parseInt(req.getParameter("loginid"));
		String newp = req.getParameter("newpassword");
		String renewp = req.getParameter("renewpassword");
		
		StaffDAO staffdao = new StaffDAOImpl();
		
		if(newp.equals(renewp)) {
			staffdao.changePassword(loginid, newp);
			req.setAttribute("from", "Your Password Changed Sucessfully");
			req.getSession().removeAttribute("staff");
			req.getRequestDispatcher("afterRegister.jsp").forward(req, res);
		}
			
	}
	
	
}
