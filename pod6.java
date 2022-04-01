import java.util.*;

public class pod6 {
	static char[] a= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
	         'T','U','V','W','X','Y','Z'};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String length = sc.nextLine();
		String[] input_length = length.split(" ");
		
		int N = Integer.parseInt(input_length[0]);
		int M = Integer.parseInt(input_length[1]);
		
		String[] input = new String[N];
		String value = "";
		int count = 0;
		
		
		for(int i = 0; i < N ; i++) {
			input[i] = sc.nextLine();
			
		}
		
		for (int i = 0; i < M; i++) {
			int alphabet[] = new int[26];
			int max = -1;
			int total = 0;
			
			for (int j = 0; j < N; j++) {
				alphabet[input[j].charAt(i) - 'A']++;
			}

			int index = -1;
			for (int k = 0; k < 26; k++) {
				total+= alphabet[k];
				if (max < alphabet[k]) {
					max = alphabet[k];
					index = k;
				}
			}
			
			count += (total - max);
			value += a[index];
			
		}
		System.out.println(value);
		System.out.println(count);
		
		
	}

}
