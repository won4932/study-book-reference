package Chapter13;

import java.util.Scanner;

public class Que13_1 {
	static int max, min;
	public static int maxValue(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]<arr[i+1])
				max=arr[i+1];
		}
		return max;
			
	}
	public static int minValue(int[] arr) {
		min=arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1])
				min=arr[i+1];
		}
		return min;
	}
	public static void main(String[] args) {
		int arr[]=new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열의 요소를 입력해주세요.");
			arr[i] =  sc.nextInt();
			sc.nextLine();
		}
		maxValue(arr);
		minValue(arr);
		System.out.println("최대값 : " + max + " 최소값 : " + min);
	}

}
