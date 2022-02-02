package practice6481;

import java.util.List;
import java.util.*;
import java.util.Scanner;

public class simpleSumArray {
	
	public static int simpleArraySum(List<Integer> ar) {
	    //Scanner sc = new Scanner(System.in);
	    //int n = sc.nextInt();
	    int sum = 0;
	    
	    for(int i = 0; i < ar.size(); i++) {
	    	//ar.add(i, Integer.parseInt(sc.nextLine()));
	    	sum += ar.get(i);
	    }
	    
	    return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    int n = Integer.parseInt(sc.nextLine());
	    String array = sc.nextLine();
	    String[] arr = array.split(" ");
	    
	    int[] ar1 = new int[n];
	    List<Integer> ar = new ArrayList<>();
	    
	    for(int i = 0; i < ar1.length; i++) {
	    	ar1[i] = Integer.parseInt(arr[i]);
	    	ar.add(i, ar1[i]);
	    }
	    
	    //simpleSumArray sa = new simpleSumArray();
	    int Sum = simpleSumArray.simpleArraySum(ar);
	    
	    System.out.println(Sum);

	}

}
