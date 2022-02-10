import java.util.*;

public class compareTriiplets {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    String array = sc.nextLine();
	    String array1 = sc.nextLine();
	    String[] arr = array.split(" ");
	    String[] arr1 = array1.split(" ");
	    
	    int alice = 0, bob = 0; 
		int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
	    
	    int[] a = new int[arr.length];
	    int[] b = new int[arr1.length];
	    int[] c = new int[2];
	    
	    for(int i = 0; i < 3; i++) {
	    	a[i] = Integer.parseInt(arr[i]);
	    	b[i] = Integer.parseInt(arr1[i]);
	    	
	    	if(a[i] > b[i]) {
				alice = 1;
				sum1 += alice;
				
			}else if(a[i] < b[i]) {
				bob = 1;
				sum2 += bob;
				
			}else if(a[i] == b[i]) {
				alice = 0;
				bob = 0;
				sum3 += alice;
				sum4 += bob;
			}
	    }
	    int finalSumA = sum1 + sum3;
		int finalSumB = sum2 + sum4;
		
		c[0] = finalSumA;
		c[1] = finalSumB;
		
		System.out.println(c[0] + " " + c[1]);
	}
}
