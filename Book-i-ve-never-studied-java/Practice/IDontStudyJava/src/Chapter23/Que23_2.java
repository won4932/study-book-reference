package Chapter23;

import java.util.Scanner;
class Cal {
	int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}

class Sun extends Thread{
	int num, result;
	public Sun(int n) {num=n;}
	public void run() {
		for (int i = 0; i < 5; i++) {
			result +=num;
			
			System.out.println("�Էµ� �� �� : " + result);
		}
	}
}
public class Que23_2 extends Thread{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 5�� �Է� : ");
		Cal cl = new Cal();
		for (int i = 0; i < 5; i++) {
			cl.setNum(sc.nextInt());			
		}
	}

}
