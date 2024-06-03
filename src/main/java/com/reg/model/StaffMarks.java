package com.reg.model;

public class StaffMarks {
	private int sid;
	private String fname;
	private String lname;
	private int marks;
	
	
	public StaffMarks() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StaffMarks(int sid, String fname, String lname, int marks) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.marks = marks;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "StaffMarks [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", marks=" + marks + "]";
	}
	
	public String getGrade(int marks) {
		if(marks >= 90)
			return "O";
		else if (marks >= 80)
			return "A+";
		else if (marks >= 70)
			return "A";
		else if (marks >= 60)
			return "B+";
		else if (marks >= 50)
			return "B";
		else if (marks >= 40)
			return "C";
		else 
			return "F";
		
	}
	
	
}
