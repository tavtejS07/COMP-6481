package practice6481.udemy;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysPractice3 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void reverseArray(int[] array) {
		int num = array.length-1;
		for(int i=0; i<num/2; i++) {
			int temp = array[i];
			array[i] = array[num-i];
			array[num-i] = temp;
		}
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] array = new int[n];
		//int[] array1 = new int[n];
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("input Array is: " + Arrays.toString(array));
		
		reverseArray(array);
		
		System.out.println("reversed Array is: " + Arrays.toString(array));

	}

}
