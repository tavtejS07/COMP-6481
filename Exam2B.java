import java.util.*;
public class Exam2B {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		String[] input = s.split(" ");
		int[] input_int = new int[n];
		int sum = 1;
		
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
		sc.close();			
}
}
