package com.prashant.AtmInterface;

import java.util.Scanner;

public class Atm_Interface {
	public static void main(String[] args) {
		double balance = 0.0;
		String transaction_history = "";
		Create_Account account = new Create_Account();
		Deposit deposit = new Deposit();
		Withdraw withdraw = new Withdraw();
		Transfer transfer = new Transfer();
		Scanner sc = new Scanner(System.in);

		System.out.println("*************************** WELCOME TO GLOBAL BANK ***************************");
		System.out.println();
		System.out.println("You need to create an Account to proceed");

		System.out.println("Create your username: ");
		String username = sc.next();

		System.out.println("Create a strong password: ");
		String pass = sc.next();
		account.createAccount(username, pass);

		System.out.println("*************************** CONGRATS FOR BEING THE PART OF GLOBAL BANK'S FAMILY ***************************");
		System.out.println();
		System.out.println("------------------Please verify your credentials------------------");
		System.out.println("Enter username: ");
		username = sc.next();

		System.out.println("Enter the password: ");
		pass = sc.next();

		if (account.login(username, pass) == false) {
			System.out.println("---------------------SORRY! BAD CREDENTIALS---------------------");
		} else {
			System.out.println("---------------------CONGRATS YOU ARE IN---------------------");
			System.out.println();
			System.out.println("---------------------THIS IS A NEW ACCOUNT PLEASE DEPOSIT SOME AMOUNT TO ACTIAVTE IT!---------------------");
			System.out.println();
			while (true) {
				System.out.println("Enter the amount: ");
				double amount = sc.nextDouble();
				if (deposit.deposit_money(amount) == true) {
					balance += amount;
					System.out.println("---------------------AMOUNT DEPOSIT SUCCESSFUL---------------------");
					transaction_history = transaction_history.concat("Deposit of Rs." + amount + "\n");
					System.out.println();
					System.out.println("DO YOU WANT TO DEPOSIT AGAIN [YES/NO]?: ");
					String response = sc.next();
					if (response.equalsIgnoreCase("yes")) {
						continue;
					} else {
						break;
					}
				}
			}
		}
		System.out.println();
		System.out.println("DO YOU WANT TO PERFORM ANY TRANSACTION [YES/NO]?: ");
		String response = sc.next();
		if (response.equalsIgnoreCase("yes")) {
			while (true) {
				System.out.println();
				System.out.println("---------------------PLEASE SELECT AN OPTION---------------------");
				System.out.println("1.DEPOSIT");
				System.out.println("2.WITHDRAW");
				System.out.println("3.TRANSFER");
				System.out.println("4.BALANCE ENQUIRY");
				System.out.println("5.TRANSACTION HISTORY");
				System.out.println();

				System.out.println("Enter your choice: ");
				System.out.println();
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter the amount: ");
					double dep_amount = sc.nextDouble();
					if (deposit.deposit_money(dep_amount) == true) {
						balance += dep_amount;
						System.out.println("---------------------AMOUNT DEPOSIT SUCCESSFUL---------------------");
						transaction_history = transaction_history.concat("Deposit of Rs." + dep_amount + "\n");
						System.out.println();
					}
					System.out.println("---------------------TRANSACTION COMPLETED---------------------");
					break;

				case 2:
					System.out.println("Enter the amount: ");
					double with_amount = sc.nextDouble();
					if (withdraw.withdraw(with_amount, balance) == true) {
						balance -= with_amount;
						System.out.println("---------------------AMOUNT WITHDRAWN SUCCESSFULLY---------------------");
						transaction_history = transaction_history.concat("Withdrawl of Rs." + with_amount + "\n");
						System.out.println();
					}
					System.out.println("---------------------TRANSACTION COMPLETED---------------------");
					break;

				case 3:
					System.out.println("Enter the beneficiary name: ");
					String bName = sc.next();
					System.out.println("Enter the amount: ");
					double trans_amount = sc.nextDouble();
					if (transfer.transfer(trans_amount, balance, bName) == true) {
						balance -= trans_amount;
						System.out.println(trans_amount + " TRANSFERRED TO "+ bName);
						System.out.println();
						System.out.println("---------------------AMOUNT TRANSFERED SUCCESSFULLY---------------------");
						transaction_history = transaction_history
								.concat("Transfer of Rs. " + trans_amount + " to " + bName + "\n");
						System.out.println();
			
					}
					System.out.println("---------------------TRANSACTION COMPLETED---------------------");
					break;

				case 4:
					System.out.println("The balance is" + balance);

					System.out.println("---------------------TRANSACTION COMPLETED---------------------");
					break;

				case 5:
					System.out
							.println("THE TRANSACTION HISTORY ARE \n" + transaction_history);

					System.out.println("---------------------TRANSACTION COMPLETED---------------------");
					break;


				default:
					System.out.println("--------------ENTER A VALID OPTION!--------------");
					System.out.println();
					continue;
				}
				System.out.println();
				System.out.println("DO YOU WANT TO PERFORM MORE TRANSACTIONS[YES/NO]?: ");
				String res = sc.next();
				if (res.equalsIgnoreCase("yes")) {
					continue;
				} else {
					System.out.println();
					System.out.println("*************************** THANK YOU FOR CHOOSING GLOBAL BANK ***************************");
					break;
				}
			}

		} else {
			System.out.println();
			System.out.println("*************************** THANK YOU FOR CHOOSING GLOBAL BANK ***************************");
			sc.close();
		}
	}
}
