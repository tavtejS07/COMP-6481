package practice6481.udemy;
import java.util.*;

public class ArraysPractice1 {
	private static Scanner sc = new Scanner(System.in);
	
	public static int[] getIntegers(int n) {
		System.out.println("Enter " + n + " Integers");
		int[] array = new int[n];
		
		for(int i = 0; i< array.length; i++) {
			array[i] = sc.nextInt();
			//System.out.println(array[i]);
		}
		
		return array;
	}
	
	public static void sortedArray(int[] arr) {
		for(int i = 0; i <arr.length-1 ; i++) {
			for(int j = i+1 ; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			//System.out.println(arr[i]);
		}
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		
		int n = sc.nextInt();
		int[] array = getIntegers(n);//new int[n];
		
		ArraysPractice1.sortedArray(array);
		
		System.out.println("Final Output:\n");
		printArray(array);
		
	}

}
