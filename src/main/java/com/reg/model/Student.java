
package com.reg.model;

public class Student {

	private int sid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String gender;
	private String dob;
	private String mobile;
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Student() {
		
	}
	
	public Student(int sid, String fname, String lname, String email, String password, String gender, String dob, String mobile) {
		
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
	}

	public Student( String fname, String lname, String email, String password, String gender, String dob, String mobile) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", dob=" + dob + ", gender=" + gender + ", mobile=" + mobile + "]";
	}
	
	
	
	
	
	
	
	

}

