import java.util.*;
public class Exam2B {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		String[] input = s.split(" ");
		int[] input_int = new int[n];
		//int[] input_int1 = new int[n];
		int sum = 1;
		//int x = 0;
		
		for (int i = 0; i<input_int.length; i++) {	
		input_int[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(input_int);
		
		for(int i = 0; i < input_int.length; i++) {
			if(input_int[i] > sum) {
				//System.out.println(sum);
				break;
			}
			else {
				sum += input_int[i];
			}
		}
		System.out.println(sum);
		
//		for(int m = 0; m < input_int.length-1; m++) {
//			if(input_int[m] > sum) {
//				System.out.println(sum);
//				break;
//			}
//			sum += input_int[m];
//			input_int1[m] = sum;
//			x = input_int1[m] + 1;
//			if(x < input_int[m+1]) {
//				System.out.println(x);
//				break;
//			}
//		}
//		
//		System.out.println(sum+1+input_int[n-1]);
		sc.close();
			
}

}
