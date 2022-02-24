import java.util.*;

public class POD3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input_a = sc.nextLine();
		String input_b = sc.nextLine();
		
		String[] a1 = input_a.split(" ");
		String[] b1 = input_b.split(" ");
		
		int[] a = new int[a1.length];
		int[] b = new int[b1.length];
		
		int length1 = 0;
		int breadth1 = 0;
		int diagonal1 = 0;
		int sum1 = 0;
		
		int length2 = 0;
		int breadth2 = 0;
		int diagonal2 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(a1[i]);
			b[i] = Integer.parseInt(b1[i]);
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		length1 = a[0]*a[0];
		breadth1 = a[1]*a[1];
		diagonal1 = a[2]*a[2];
		sum1 = length1 + breadth1;
		
		length2 = b[0]*b[0];
		breadth2 = b[1]*b[1];
		diagonal2 = b[2]*b[2];
		sum2 = length2 + breadth2;
		
//		System.out.println(length1+" " + breadth1 + " " + diagonal1);
//		System.out.println(length2+" " + breadth2 + " " + diagonal2);
		
		//System.out.println();
//		if(Arrays.equals(a, b) && sum1 != diagonal1 && sum2!=diagonal2)
		
		if(Arrays.equals(a, b) && sum1 == diagonal1 && sum2 == diagonal2) {
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
		sc.close();

	}

}
