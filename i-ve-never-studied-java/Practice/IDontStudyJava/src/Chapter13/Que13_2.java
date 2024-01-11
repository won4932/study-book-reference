package Chapter13;

import java.util.Arrays;

public class Que13_2 {
	public static void addTwoDArr(int[][] arr, int add) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] +=add;
			}
		}
	}
	public static void Que1322(int[][] arr) {
		
		int[] temp = arr[arr.length-1];
		for (int i = arr.length-1; i > 0; i--)
				arr[i] = arr[i-1]; 
		arr[0] = temp;
	}

	public static void main(String[] args) {
		int arr[][] = {{1 ,2 ,3, 4, 5}, {6, 7, 8, 9, 10}};
		int arr2[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		addTwoDArr(arr, 10);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.println(arr[i][j]);
		}
		Que1322(arr2);
		for (int i = 0; i < arr2.length; i++) {
				System.out.print(Arrays.toString(arr2[i]));
			System.out.println();
		}
		Que1322(arr2);
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++)
				System.out.print(arr2[i][j]+ " ");
			System.out.println();
		}
	}
}
