package com.prashant.AtmInterface;

public class Transfer {

	public boolean transfer(double amount,double balance,String id)
	{
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
