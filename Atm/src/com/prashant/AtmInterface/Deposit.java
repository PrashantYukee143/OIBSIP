package com.prashant.AtmInterface;

public class Deposit {

	public boolean deposit_money(double amount)
	{
		if(amount>10000.00)
		{
			System.out.println("AMOUNT IS HIGHER THAN THE DEPOSIT LIMIT!.PLEASE, TRY LESSER AMOUNT THAN RS.10000.");
			return false;
		}
		else if(amount <0.00)
		{
			System.out.println("AMOUNT CANNOT BE NULL!");
			return false;
		}
		else
		{
			return true;
		}
	}
}
