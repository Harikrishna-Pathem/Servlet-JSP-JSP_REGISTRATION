package com.reg.model;

public class Marks {
	String fname;
	String lname;
	int sub1;
	int sub2;
	int sub3;
	int sub4;
	int sub5;
	
	
	
	public Marks() {
		
	}
	public Marks(String fname, String lname, int sub1, int sub2, int sub3, int sub4, int sub5) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
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
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public int getSub4() {
		return sub4;
	}
	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}
	public int getSub5() {
		return sub5;
	}
	public void setSub5(int sub5) {
		this.sub5 = sub5;
	}
	@Override
	public String toString() {
		return "Marks [fname=" + fname + ", lname=" + lname + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3
				+ ", sub4=" + sub4 + ", sub5=" + sub5 + "]";
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
