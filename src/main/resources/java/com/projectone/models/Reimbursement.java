package com.projectone.models;

public class Reimbursement {
	int id;
	String context;
	int money;
	String status;
	String username;
	Reimbursement() {
	}
	public Reimbursement(int id, String context, int money, String status, String username) {
		super();
		this.id = id;
		this.context = context;
		this.money = money;
		this.status = status;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", context=" + context + ", money=" + money + ", status=" + status
				+ ", username=" + username + "]";
	}

}
