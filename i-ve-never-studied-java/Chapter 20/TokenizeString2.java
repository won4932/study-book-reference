import java.util.StringTokenizer;

class TokenizeString2
{	
	public static void main(String[] args)
	{
		String phoneNum="TEL 82-02-997-2059"; 	//국제 전화번호
		String javaCode="num+=1";
		
		System.out.println("First Result...........");
		StringTokenizer st1=new StringTokenizer(phoneNum);
		while(st1.hasMoreTokens())
			System.out.println(st1.nextToken());
		
		System.out.println("\nSecond Result...........");
		StringTokenizer st2=new StringTokenizer(phoneNum, " -");
		while(st2.hasMoreTokens())
			System.out.println(st2.nextToken());
		
		System.out.println("\nThird Result...........");
		StringTokenizer st3=new StringTokenizer(javaCode, "+=", true);
		while(st3.hasMoreTokens())
			System.out.println(st3.nextToken());
	}
}