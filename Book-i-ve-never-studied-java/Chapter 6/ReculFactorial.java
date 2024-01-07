class ReculFactorial
{	
	public static void main(String[] args)
	{
		System.out.println("7 factorial: " + factorial(7));		
		System.out.println("12 factorial: " + factorial(12));
	}
	
	public static int factorial(int n)
	{
		if(n==1)
			return 1;
		else
			return n*factorial(n-1);
	}
}
