package Chapter20;

import java.util.Random;
import java.util.Scanner;

public class Que20_3 {

	public static void main(String[] args) {
		int a, b, max, min;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력 : ");
		a = sc.nextInt();
		b = sc.nextInt();
		sc.nextLine();
		max = Math.max(a, b);
		min = Math.min(a, b);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			int result = ran.nextInt(max-min+1);
		result+=min;
			System.out.println(result);
	}
//		for (int i = 0; i < 5; i++) 
//			System.out.println((int)(Math.random()*10));
		}

	}

