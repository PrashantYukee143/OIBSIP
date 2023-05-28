package com.prashant.AtmInterface;

public class Withdraw {

	public boolean withdraw(double amount, double balance) {
		if (amount > balance) {
			System.out.println("##### BALANCE INSUFFICIENT #####");
			return false;
		}
		else if(amount<0.00)
		{
			System.out.println("**** AMOUNT CANNOT BE NULL ****");
            return false;
		}
		else
		{
            return true;
		}
	}
}
