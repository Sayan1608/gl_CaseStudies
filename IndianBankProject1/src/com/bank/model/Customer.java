package com.bank.model;

public class Customer {

	private String bankAccNo;
	private String pword;
	private double balance;

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer(String bankAccNo, String pword, double balance) {
		super();
		this.bankAccNo = bankAccNo;
		this.pword = pword;
		this.balance = balance;
	}

}
