package com.projectone.models;

public class Reimbursement {
	String context;
	int money;
	String status;
	
	public Reimbursement() {}

	public Reimbursement(String context, int money, String status) {
		super();
		this.context = context;
		this.money = money;
		this.status = status;
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
	
	
}
