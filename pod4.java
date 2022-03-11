//import java.lang.reflect.Array;
import java.util.*;

public class pod4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		
		while(n != -1){
			n = Integer.parseInt(sc.nextLine());
			int[] entry = new int[1000000];
			int x = 1;
			int y;
			int sum = 0;
			
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<String> arr1 = new ArrayList<>();

			
			if(n > 2 && n < 1000000) {
				for(int i = 0; i < entry.length; i++) {
					if(x < n) {
						y = n%x;
						if(y == 0) {
							entry[i] = x;
							x++;
						}else if(y!= 0) {
							x++;
						}
					}
					sum += entry[i];
					arr.add(entry[i]);
					
					if(arr.get(i) > 0) {
						arr1.add(String.valueOf(entry[i]));
					}
				}
			}
			
			if(sum == n && n>2 && n < 1000000) {
				System.out.println(n + " = " + String.join(" + ", arr1) );
			}else if(sum != n && n>2 && n < 1000000) {
				System.out.println(n + " is NOT perfect.");
			}
//			else if(n == -1) {
//				System.exit(0);
//			}
		}
		
		
		
		sc.close();
	}
}
