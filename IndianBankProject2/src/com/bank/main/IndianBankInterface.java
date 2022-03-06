package com.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.Customer;
import com.bank.model.CustomerList;
import com.bank.service.BankTransactions;

public class IndianBankInterface {
	static BankTransactions transaction = new BankTransactions();
//	static Customer customer1 = new Customer("HDFC1011", "Subho@123", 1000);
//	static Customer customer2 = new Customer("ICIC12101", "Bankim@142", 3000);

	static ArrayList<Customer> customerList = CustomerList.getCustomerList();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter your Account no");
		String accNo = in.nextLine();
		System.out.println("Enter your Password");
		String pword = in.nextLine();
		int option;
		String choice;

		Customer customer = validate(accNo, pword); // validating Customer

		if (customer != null) {

			do {

				showMenu();
				option = in.nextInt();
				double Amount;
				in.nextLine();

				switch (option) {
				case 1:
					System.out.println("Enter the amount to Deposit : ");
					Amount = in.nextDouble();
					transaction.deposit(customer, Amount);
					System.out.println("Your final balance ::" + customer.getBalance());
					break;
				case 2:
					System.out.println("Enter the amount to Withdraw : ");
					Amount = in.nextDouble();
					if (transaction.withdraw(customer, Amount)) {
						System.out.println("Remaining balance ::" + customer.getBalance());
					} else {
						System.out.println("Insufficient Account balance");
					}
					break;
				case 3:
					System.out.println("Enter the account no of receiver : ");
					String acc_no = in.nextLine();
					Customer receiver = validate(acc_no);
					System.out.println("Enter the amount to Transfer : ");
					Amount = in.nextDouble();
					if (receiver != null) {
						if (transaction.transfer(customer, receiver, Amount)) {
							System.out.println("Your Final Balance ::" + customer.getBalance());
							System.out.println("Receiver Balance ::" + receiver.getBalance());
						} else {
							System.out.println("Insufficient Account balance");
						}
					} else {
						System.out.println("Recipient Account does not exist.");
					}
					break;

				case 0:
					break;
				}

				in.nextLine();
				System.out.println("Do you want to have any other Transactions?");
				choice = in.nextLine();
			} while (choice.equalsIgnoreCase("yes"));

			System.out.println("You are now Logged out.Thank you for banking with us.");

		} else {
			System.out.println("Wrong Account no or Password.");
		}
		in.close();

	}

	private static Customer validate(String accNo) {
		for (Customer customer : customerList) {
			if (accNo.equals(customer.getBankAccNo())) {
				return customer;
			}
		}
		return null;
	}

	private static Customer validate(String accNo, String pword) {
		for (Customer customer : customerList) {
			if (accNo.equals(customer.getBankAccNo()) && pword.equals(customer.getPword())) {
				return customer;
			}
		}

		return null;
	}

	private static void showMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation you want to Perform.");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("0. Logout");
		System.out.println("-----------------------------------------------");
	}

}
