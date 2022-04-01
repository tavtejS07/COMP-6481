import java.util.Scanner;

public class practice1 {
	
	static void fun1(int n)
	{
	   int i = 0;  
	   if (n > 1)
	     fun1(n - 1);
	   for (i = 0; i < n; i++)
	     System.out.print(" * ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		fun1(n);
		
		sc.close();

	}

}
