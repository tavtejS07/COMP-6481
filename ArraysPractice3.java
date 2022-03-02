package practice6481.udemy;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysPractice3 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void reverseArray(int[] array) {
		int num = array.length;
		for(int i=0; i<num/2; i++) {
			int temp = array[i];
			array[i] = array[num-i-1];
			array[num-i-1] = temp;
		}
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] array = new int[n];
		//int[] array1 = new int[n];
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		reverseArray(array);
		
		System.out.println(Arrays.toString(array));

	}

}
