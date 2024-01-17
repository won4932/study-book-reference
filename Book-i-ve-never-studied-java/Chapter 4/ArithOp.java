class ArithOp
{
	public static void main(String[] args)
	{
		int n1 = 7;
		int n2 = 3;
		
		int result = n1 + n2;
		System.out.println("µ¡¼À °á°ú: "+result);
		
		result = n1 - n2;
		System.out.println("»¬¼À °á°ú: " + result);		
		System.out.println("°ö¼À °á°ú: " + n1*n2);
		System.out.println("³ª´°¼À °á°ú: " + n1/n2);
		System.out.println("³ª¸ÓÁö °á°ú: " + n1%n2);
	}
}