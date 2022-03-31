import java.util.*;
public class pod7A {
	
	static int convert(int m, int n)
    {
        if (m == n) {
        	return 0;
        }
        if (n > m) {
        	return n - m;
        }
        if (n <= 0 && m > 0) {
        	 return -1;
        }
        
        if (m % 2 == 1) {
        	 return 1 + convert(m + 1, n);
        }
        else
            return 1 + convert(m / 2, n);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = Integer.parseInt(sc.next()); 
		int B = Integer.parseInt(sc.next());
		
		System.out.println(convert(A,B));
		
		//System.out.println(A + " " + count);
		
		sc.close();

	}

}
