import java.util.*;
import java.util.Scanner;

public class Lab3B {
	
	void sortedArray(int points[]) {
		for (int i = 0; i < points.length-1; i++) {
			for(int j = 1; j < points.length-i; j++) {
				if(points[j-1] < points[j]) {
					int temp = points[j-1];
					points[j-1] = points[j];
					points[j] = temp;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Enter the number of players and rank required");
		
		String player_rank = sc.nextLine();
		String[] plr_rnk = player_rank.split(" ");
		
		int players = Integer.parseInt(plr_rnk[0]);
		int rank = Integer.parseInt(plr_rnk[1]);
		
		
		String[] player = new String[players];
		int[] points = new int[players];
		
		
		HashMap<Integer, String> playerScore = new HashMap<>();
		
		
		float total = 0;
		int ppm = 0;
		float result = 0;
		
		
		for(int i = 0; i < players; i++) {
			String playerName = sc.nextLine();
			int foulShots = Integer.parseInt(sc.nextLine());
			int twoPointers = Integer.parseInt(sc.nextLine());
			int threePointers = Integer.parseInt(sc.nextLine());
			int minutes = Integer.parseInt(sc.nextLine());
				
			
			foulShots = foulShots * 1;
			twoPointers = twoPointers * 2;
			threePointers = threePointers * 3;
				
			total = (foulShots + twoPointers + threePointers) * 1000;
			
			if(minutes > 0) {
				result = total/minutes;
				ppm = Math.round(result);
			}
			
			player[i] = playerName;
			points[i] = ppm;
				
			playerScore.put(ppm, playerName);
				
		}
		
		Lab3B sa = new Lab3B();
		sa.sortedArray(points);
		
		//if(players > 1 && players <= 50)
		
		System.out.println(playerScore.get(points[rank-1]) + " " + points[rank-1] + "\r\n");
		sc.close();		
	}
}