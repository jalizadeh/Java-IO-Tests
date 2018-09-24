package Examples;

public class SqrException extends Exception {

	private double offendingArgument;
	
	
	public SqrException(String msg) {
		super(msg);
	} 
	
	public SqrException(double offending) {
		super("Can`t compute the square root of " + offending);
		offendingArgument = offending;
	}
	
}
