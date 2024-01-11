class LocalVariable
{	
	public static void main(String[] args)
	{
		boolean scope=true;
		if(scope)
		{
			int num=1;
			num++;
			System.out.println(num);
		}
		else
		{
			int num=2;
			System.out.println(num);
		}
		
		simple();
	}
	
	public static void simple()
	{
		int num=3;
		System.out.println(num);
	}
}
