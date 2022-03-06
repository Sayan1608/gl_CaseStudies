package com.bank.model;

import java.util.ArrayList;

public class CustomerList {

	public static ArrayList<Customer> list = new ArrayList<Customer>();

	static {
		list.add(new Customer("HDFC1011", "Subho@123", 5000));
		list.add(new Customer("ICIC12101", "Bankim@142", 3000));
		list.add(new Customer("AXIS1010", "Piyush@100", 2500));
		list.add(new Customer("YES1234", "Nupur@123", 4000));
	}

}
