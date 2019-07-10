package account;

public class OverdraftException extends Exception{
	private double deficit;
	protected OverdraftException(String msg, double deficit)
	{
		super(msg);
		this.deficit = deficit;
	}
	protected double getDeficit()
	{
		return deficit;
	}
}
