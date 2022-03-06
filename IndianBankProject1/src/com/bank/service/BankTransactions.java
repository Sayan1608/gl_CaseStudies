package com.bank.service;

import java.util.Scanner;

import com.bank.model.Customer;

public class BankTransactions {
	Scanner in = new Scanner(System.in);

	public void deposit(Customer customer, double Amount) {
		double final_bal = customer.getBalance() + Amount;
		customer.setBalance(final_bal);
//		System.out.println("Final Balance = "+customer.getBalance());
	}

	public boolean withdraw(Customer customer, double Amount) {
		double bal = customer.getBalance();
		if (bal >= Amount) {
			bal -= Amount;
			customer.setBalance(bal);
			return true;
		}
		return false;
	}

	public boolean transfer(Customer sender, Customer receiver, double Amount) {
		/*OTPGenerator gen = new OTPGenerator();
		System.out.println("Enter your OTP : ");
		int otp = in.nextInt();
		if (otp == gen.generateOTP()) {*/
			double bal = sender.getBalance();
			if (bal >= Amount) {
				bal -= Amount;
				sender.setBalance(bal);
				bal = receiver.getBalance() + Amount;
				receiver.setBalance(bal);
				return true;
			}
//		}
		return false;

	}
}
