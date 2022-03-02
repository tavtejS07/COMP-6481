package practice6481.udemy;
import java.util.*;

public class ArraysPractice2 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int[] readIntegers(int count) {
		//count = sc.nextInt();
		int[] array = new int[count];
		
		for(int i = 0; i<array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		return array;
	}
	
	public static int findMin(int[] array) {
		int min = array[0];
		for(int i = 1; i<array.length; i++) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int count = sc.nextInt();
		int[] array = readIntegers(count);
		
		int minimum = findMin(array);
		
		System.out.println(minimum);
	}

}
