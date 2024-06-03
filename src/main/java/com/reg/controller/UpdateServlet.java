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


@WebServlet(name = "us", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ses = req.getSession();
		Student stud = (Student) ses.getAttribute("student");
		
		Staff staff = (Staff) ses.getAttribute("staff");
		
		String password = req.getParameter("password");
		
		if(stud != null) {
			
			StudentDAO sdao = new StudentDAOImpl();
			
			ses = req.getSession();
			Student st = (Student)ses.getAttribute("studentUpdate");
			System.out.println(st);
			
			
			if(sdao.cheackPasswordWithSid(st.getSid(), password)) {
				st.setPassword(password);
				sdao.editStudent(st);
				ses.removeAttribute("studentUpdate");
				
				ses.removeAttribute("student");
				Student newst = sdao.selectWithId(st.getSid());
				ses.setAttribute("student", newst);
				
				req.getRequestDispatcher("updateDetails.jsp").forward(req, resp);
			}
			
			else {
				req.setAttribute("pwderror", true);
				req.getRequestDispatcher("CheckPasswordtoUpdate.jsp").forward(req, resp);

			}
		}
		
		
		if(staff != null) {
			
			
			StaffDAO staffdao = new StaffDAOImpl();
			
			ses = req.getSession();
			Staff staffUp = (Staff)ses.getAttribute("staffUpdate");
			System.out.println(staffUp);
			
			
			if(staffdao.checkStaffPasswordWithStaffid(staffUp.getStaffid(), password)) {
				staffUp.setPassword(password);
				staffdao.updateStaffDetails(staffUp);
				
				ses.removeAttribute("staffUpdate");
				ses.removeAttribute("staffUp");
				
				Staff newstaff = staffdao.getStaffWithSid(staffUp.getStaffid());
				ses.setAttribute("staff", newstaff);
				
				req.getRequestDispatcher("updateDetails.jsp").forward(req, resp);
			}
			
			else {
				req.setAttribute("pwderror", true);
				req.getRequestDispatcher("CheckPasswordtoUpdate.jsp").forward(req, resp);

			}
		}
		
		
	
				
		
		
	}

}
