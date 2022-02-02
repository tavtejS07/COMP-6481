import java.util.*;
import java.util.Scanner;

public class pod2 {
	
	public int maxSum(int[] arr) {
		int sumMax = arr[0];
		int sum = 0;
		
		for(int i = 0; i< arr.length; i++) {
			sum += arr[i];
			
			if(sum < arr[i]) {
				sum = arr[i];
			}
			
			if(sumMax < sum) {
				sumMax = sum;
			}
		}
		
		return sumMax;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String newString = sc.nextLine();
		String[] input = newString.split("\\.");
		int[] arr = new int[input.length];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		pod2 sm = new pod2();
		int answer = sm.maxSum(arr);
		
		System.out.println(answer);

	}

}
