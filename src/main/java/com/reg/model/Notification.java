package com.reg.model;

public class Notification {
	private String date;
	private String text;
	
	
	public Notification() {
	}
	public Notification(String date, String text) {
		super();
		this.date = date;
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Notification [date=" + date + ", text=" + text + "]";
	}
	
	
}
