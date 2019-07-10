package account;

public class CheckingAccount extends myAccount {
	private double overdraftProtection;
	protected CheckingAccount(double balance)
	{
		super(balance);
	}
	protected CheckingAccount(double balance,double protect)
	{
		this(balance);
		overdraftProtection = protect;
	}
	protected void withdraw(double amt)throws OverdraftException{
		this.balance -= amt;
		if (getBalance() < 0){
			overdraftProtection += getBalance();//透支
		}
		if(overdraftProtection < 0)
			throw new OverdraftException("虽然有透支额度，依然透支：",overdraftProtection);
		else 
		{
			if(getBalance() < 0)
				System.out.println("剩余透支额度："+overdraftProtection);
			else
				System.out.println("未透支,余额为："+getBalance());
		}
	}
	public static void main(String[] args) {
		CheckingAccount H = new CheckingAccount(1000,500);//剩余额度1000，透支额度500
		System.out.println("初始存款1000，透支额度500");
		H.deposit(1);
		try{
			H.withdraw(1600);
		}
		catch(OverdraftException e){
		System.out.println(e.getMessage()+ e.getDeficit());
		e.printStackTrace();
		}
		
	}
}
