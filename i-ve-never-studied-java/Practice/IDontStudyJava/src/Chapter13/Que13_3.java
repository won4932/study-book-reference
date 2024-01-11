package Chapter13;

import java.util.Scanner;

public class Que13_3 {
	//max, min을 e로 바꾸고 Que13_1 동일
	static int max, min;
	public static int maxValue(int arr) {
			if(max<arr)
				max=arr;
		return max;
			
	}
	public static int minValue(int arr) {
		if(min>arr)
			min=arr;
	return min;
		
}
	public static void main(String[] args) {
		int arr[]=new int[5];
		Scanner sc = new Scanner(System.in);
		for (int e : arr) {
			System.out.print("배열의 요소를 입력해주세요.");
			e =  sc.nextInt();
			sc.nextLine();
			min=arr[0];
			maxValue(e);
			minValue(e);
		}
		System.out.println("최대값 : " + max + " 최소값 : " + min);
	}

}