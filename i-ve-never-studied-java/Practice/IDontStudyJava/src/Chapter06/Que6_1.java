package Chapter06;

import java.util.Scanner;

public class Que6_1 {
	public void add(int x, int y) {
		System.out.println("µ¡¼À : " + (x+y));
	}
	public void mul(int x, int y) {
		System.out.println("»¬¼À : " + (x-y));
	}
	public void cha(int x, int y) {
		if(x>y)
			System.out.println("µÑÀÇ Â÷ÀÌ : "+ (x-y));
		else
			System.out.println("µÑÀÇ Â÷ÀÌ : "+ (y-x));
	}
	
	public static int binary(int x) {
		if(x>0)
		{
			int bin;
			bin=x%2;
			x/=2;
			binary(x);
			System.out.print(bin);
		}
		return 0;
	}

	public static void main(String[] args) {
//		Que6_1 q6 = new Que6_1();
//		Scanner s = new Scanner(System.in);
//		System.out.print("µÎ¼ö ÀÔ·Â : ");
//		int n1 = s.nextInt();
//		int n2 = s.nextInt();
//		q6.add(n1,n2);
//		q6.mul(n1,n2);
//		q6.cha(n1, n2);
		binary(128); // =1000
	}

}
