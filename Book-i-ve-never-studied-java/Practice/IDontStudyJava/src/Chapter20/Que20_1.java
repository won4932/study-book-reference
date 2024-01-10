package Chapter20;

import java.math.BigDecimal;
import java.util.Scanner;

public class Que20_1 {
	public static void Que20_2() {
		double d1, d2;
		Scanner sc = new Scanner(System.in);
		//오차없이 입력받으려면 String 형으로
		d1 = sc.nextDouble();
		d2 = sc.nextDouble();
		sc.nextLine();
		BigDecimal b1 = new BigDecimal(d1).abs();
		BigDecimal b2 = new BigDecimal(d2).abs();

		System.out.println(b1.subtract(b2).abs());
	}
	public static void main(String[] args) {
		//다른 인스턴스참조
//		Integer iValue1= new Integer(10);
//		Integer iValue2= new Integer(10);
		//동일 인스턴스 참조
		Integer iValue1= Integer.valueOf(10);
		Integer iValue2= Integer.valueOf(10);
		Que20_2();
		
		if(iValue1==iValue2)
			System.out.println("iValue1과 iValue2는 동일 인스턴스 참조");
		else
			System.out.println("iValue1과 iValue2는 다른 인스턴스 참조");
	}

}
