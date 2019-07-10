package account;

public class myAccount {
	public double balance;
	protected myAccount(double init)
	{
		balance = init;
	}
	protected double getBalance() throws OverdraftException{
		if(balance < 0)
			throw new OverdraftException("͸֧",balance);
		else 
		{
			System.out.println(balance);
			return balance;
		}
	}
	protected void deposit(double amt)
	{
		balance += amt;
	}
	protected void withdraw(double amt)
	{
		balance -= amt;
	}
	public static void main(String[] args) {
		myAccount H = new myAccount(100);
		H.deposit(1.0);
		H.withdraw(1000.0);
		try{
		double mymoney = H.getBalance();
		}
		catch(OverdraftException e)
		{
			System.out.println(e.getMessage()+ e.getDeficit());
			e.printStackTrace();
		}
	}
	
}
