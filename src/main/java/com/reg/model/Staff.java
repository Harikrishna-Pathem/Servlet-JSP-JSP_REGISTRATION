package com.reg.model;

public class Staff {
	private int staffid;
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	private String gender;
	private String password;
	private int subid;
	private String subject;
	
	public Staff() {  }

	public Staff(int staffid, String fname, String lname, String email, String mobile, String gender,String passsword, int subid,
			String subject) {
		super();
		this.staffid = staffid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.password = passsword;
		this.subid = subid;
		this.subject = subject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", mobile="
				+ mobile + ", gender=" + gender + ", password=" + password + ", subid=" + subid + ", subject=" + subject
				+ "]";
	}
	
	
	
	
	
	
}
