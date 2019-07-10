package account;

public class myAccount {
	public double balance;
	protected myAccount(double init)
	{
		balance = init;
	}
	protected double getBalance(){
		
		return balance;

	}
	protected void deposit(double amt)
	{
		balance += amt;
	}
	protected void withdraw(double amt)throws OverdraftException
	{
		balance -= amt;
	}
	
}
