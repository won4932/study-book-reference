package Chapter20;

import java.math.BigDecimal;
import java.util.Scanner;

public class Que20_1 {
	public static void Que20_2() {
		double d1, d2;
		Scanner sc = new Scanner(System.in);
		//�������� �Է¹������� String ������
		d1 = sc.nextDouble();
		d2 = sc.nextDouble();
		sc.nextLine();
		BigDecimal b1 = new BigDecimal(d1).abs();
		BigDecimal b2 = new BigDecimal(d2).abs();

		System.out.println(b1.subtract(b2).abs());
	}
	public static void main(String[] args) {
		//�ٸ� �ν��Ͻ�����
//		Integer iValue1= new Integer(10);
//		Integer iValue2= new Integer(10);
		//���� �ν��Ͻ� ����
		Integer iValue1= Integer.valueOf(10);
		Integer iValue2= Integer.valueOf(10);
		Que20_2();
		
		if(iValue1==iValue2)
			System.out.println("iValue1�� iValue2�� ���� �ν��Ͻ� ����");
		else
			System.out.println("iValue1�� iValue2�� �ٸ� �ν��Ͻ� ����");
	}

}
