import java.util.Scanner;
import java.util.*;

public class Lab1B {
	
	static int doubleSum(String card) {
		
		int sum = 0;
		int doubled = 0;
		String[] arr = card.split(""); 
		
		for(int i = arr.length-2; i>=0; i = i-2) {
			
			doubled = Integer.parseInt(arr[i]);
			doubled = doubled * 2;
			
			if(doubled>9) {
				doubled = doubled % 10 + 1;
			}
			arr[i] = String.valueOf(doubled);
		}
		
		for(int j = 0; j < arr.length ; j++) {
			sum += Integer.parseInt(arr[j]);
			//System.out.println(sum);
		}
		
		return sum;
	}
	


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input_cc = sc.nextLine();
		String[] cc_num = input_cc.split("");
		
		int finalSum = Lab1B.doubleSum(input_cc);
		
		int validity = finalSum % 10;
		
		int check = Integer.parseInt(cc_num[cc_num.length-1]);
		int correctCheckNum = (10 - (finalSum % 10)) + check;
		
		if (correctCheckNum > 9) correctCheckNum = correctCheckNum % 10;
		
		
		if(validity == 0 && input_cc.length()<20) {
			System.out.println("VALID");
		}else if(validity != 0 && input_cc.length()<20){
			System.out.println("INVALID" + " " + correctCheckNum);
		}
		
		sc.close();

	}

}

//if (correctCheckNum > 9) correctCheckNum = correctCheckNum % 10;
//int checkDigit = check - validity;
		//System.out.println(checkDigit);
//System.out.println(check);
//System.out.println(finalSum);