package com.reg.controller;

import java.io.IOException;
import java.util.List;

import com.reg.dao.StaffDAO;
import com.reg.dao.StaffDAOImpl;
import com.reg.dao.StudentDAO;
import com.reg.dao.StudentDAOImpl;
import com.reg.model.Marks;
import com.reg.model.Staff;
import com.reg.model.StaffMarks;
import com.reg.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "marks", urlPatterns = {"/semone", "/semtwo", "/semthree"})
public class MarksServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student stud = (Student)req.getSession().getAttribute("student");
		Staff staff = (Staff)req.getSession().getAttribute("staff");
		
		if(stud != null) {
			String url = req.getRequestURI();
			System.out.println(url);
			
			StudentDAO sdao = new StudentDAOImpl();

			int sid = stud.getSid();
			
			Marks marks = null;
			
			if(url.endsWith("one")) {
				req.setAttribute("sem", "2-1");
				marks = sdao.getMarksWithIdForSem1(sid);
			} else if (url.endsWith("two")) {
				req.setAttribute("sem", "2-2");
				marks = sdao.getMarksWithIdForSem2(sid);
			}
			else if (url.endsWith("three")) {
				req.setAttribute("sem", "3-1");
				marks = sdao.getMarksWithIdForSem3(sid);
			}
			
			req.setAttribute("marks", marks);
			
			
		}
		
		else if(staff != null)
			staffMarks(req, resp);
			
		req.getRequestDispatcher("Marks.jsp").forward(req, resp);
		
	}
	
	public void staffMarks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sp = req.getServletPath();
		System.out.println(sp);
		Staff staff = (Staff)req.getSession().getAttribute("staff");
		

		if(sp.endsWith("one"))
			req.setAttribute("sem", "2-1");
		else if (sp.endsWith("two"))
			req.setAttribute("sem", "2-2");
		else if (sp.endsWith("three"))
			req.setAttribute("sem", "3-1");
			
		
		StaffDAO st = new StaffDAOImpl();
		
		List<StaffMarks> list = st.GetStaffMarks(staff, sp);
		
		req.setAttribute("staffmarks",list);
		
		
		
	}

}
