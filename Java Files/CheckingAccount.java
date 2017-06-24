public class CheckingAccount

	private double balance;
	
	public CheckingAccount(double bal)
	{
		balance = bal;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount)
	(
		balance += amount;
	}
	
	public boolean withdraw(double amount)
	{
		if (amount > balance)
			System.out.print("Cannot complete withdrawal; insufficient funds");
		else
			balance -= amount;
	}
	
}