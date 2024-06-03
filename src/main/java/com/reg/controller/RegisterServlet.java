package com.reg.controller;

import java.io.IOException;

import com.reg.dao.StudentDAO;
import com.reg.dao.StudentDAOImpl;
import com.reg.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "rs", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p1 = req.getParameter("password");
		String p2 = req.getParameter("repassword");
		String email = req.getParameter("email");
		
		if(!(p1.equals(p2)) || (p1.equals(""))){
			req.setAttribute("pwderror", true);
			req.getRequestDispatcher("/RegisterPage.jsp").forward(req, resp);
			
			
		}	
		else if(!(email.endsWith("@gmail.com"))) {
			req.setAttribute("emailerror", true);
			req.getRequestDispatcher("/RegisterPage.jsp").forward(req, resp);
		}
		else 
			register(req, resp);
	}
	
	public void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		
		Student st = new Student(fname, lname, email, password, gender, dob, mobile);
		
		StudentDAO sdao = new StudentDAOImpl();
		int sid = sdao.save(st);
		
		req.setAttribute("loginId", sid);
		req.setAttribute("from", "Your Registeration is Sucessfull.");
		req.getRequestDispatcher("/afterRegister.jsp").forward(req, res);
		
	}
}
