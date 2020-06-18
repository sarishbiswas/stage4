package com.cognizant;

public class Account {
	public String number;
	public String type;
	public long balance;
	public Account(String number, String type, long balance) {
		super();
		this.number = number;
		this.type = type;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
}
