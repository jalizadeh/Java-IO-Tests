package Examples;

public class SqrtException {
	public static void main(String[] args) /* #1 throws SqrExecption */ {
		
		double x = -5;
		
		//here we have 2 options:
		//	#1. Add throws declaration 
		//	#2. Surround with try/catch
		// double y = sqr(x);
		
		//#2
		try {
			//nominal case
			double y = sqr(x);
			System.out.println(y);
			
		} catch (SqrException e) {
			//error handling code
			//System.err.println("Sqr of negative number is not possible!!!");
			
			//print the exception msg
			System.out.println( e.getMessage() );
		} finally {
			//this section will be run in any case
			//even after exception raised
			System.out.println("I`m finally :)");
		}
		
		System.out.println("..rest of program ...");
		
	} 
	
	
	
	/**
	 * Computes the squared root of a given number
	 * 
	 * @param x (double)
	 * @return squared root of x
	 * @throws SqrException throws if the x is negative
	 */
	public static double sqr(double x) throws SqrException {
		
		//String s = null;
		//s.toLowerCase(); //throw new NullPointerException()
		
		if(x < 0)
			//throw new SqrException();
			throw new SqrException(x);
		
		return Math.sqrt(x);
	}
}
