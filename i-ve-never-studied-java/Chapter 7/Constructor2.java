class Number
{
	int num;
	
	public Number(int n)
	{
		num=n;
		System.out.println("인자 전달: "+n);
	}
	public int getNumber()
	{
		return num;
	}
}

class Constructor2
{
	public static void main(String[] args)
	{
		Number num1=new Number(10);
		System.out.println("메소드 반환 값: "+num1.getNumber());
		
		Number num2=new Number(20);
		System.out.println("메소드 반환 값: "+num2.getNumber());
	}	
}