package com.banque.model;

public class Money {
	private int id;
	private int userid;
	private double amount;
	private String at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	
}
