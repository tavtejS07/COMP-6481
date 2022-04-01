
import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int temp = 2*n-1;

		for(int i=0; i<temp; i++) {
			if(i%2 == 0) {
				for(int j=0; j<temp - i -1; j++) {
					System.out.print("-");
				}
				
				for(int j=temp-i-1; j<temp; j++) {
					System.out.print("* ");
				}
			}
			System.out.print("\n");
		}
		sc.close();

	}

}
