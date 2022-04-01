import java.util.*;

public class pod5 {
	
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, HashMap<String, String>> dictionaries = new HashMap<>();
	static List<List<String>> textLines = new ArrayList<>();

	
	public static void checkLanguage() {
		for (List<String> line : textLines) {
			for (String word : line) {
				if (findLanguage(word))
					break;
	            }
	        }
	    }

	public static boolean findLanguage(String word) {
		for (String language : dictionaries.keySet()) {
			if (dictionaries.get(language).containsKey(word)) {
				System.out.println(language);
				return true;
				
			}
	        
		}
		
		return false;
	    
	}
	    
	    public static void main(String[] args) {
	    	int num = sc.nextInt();
	        sc.nextLine();
	        // Create dictionaries for all languages
	        for (int i = 0; i < num; i++) {
	            String line = sc.nextLine();
	            String[] words = line.split(" ");
	            HashMap<String, String> dict = new HashMap<>();
	            for (int j = 1; j < words.length; j++) {
	                dict.put(words[j], words[j]);
	            }
	            dictionaries.put(words[0], dict);
	        }
	        sc.nextLine();
	        // Take the sample text input
	        String line = null;
	        while (!(line = sc.nextLine()).isEmpty()) {
	            List<String> words = new ArrayList<String>(Arrays.asList(line.split("[ ,!.!;?()]+")));
	            textLines.add(words);
	        }
	        
	        checkLanguage();
	        
	        
	    }
	        

}
/*
Vulcan throks kilko-srashiv k’etwel
Romulan Tehca uckwazta Uhn Neemasta
Menk e’satta prah ra’sata
Russian sluchilos

Dif-tor heh, Spohkh. I’tah trai k’etwel
Uhn kan’aganna! Tehca zuhn ruga’noktan!
*/
//	    public static void takeInput() {
//	        
//
//}

//public static void main(String[] args) {
//Scanner sc = new Scanner(System.in);
//int n = Integer.parseInt(sc.nextLine());
//String input = "";
//String sample;
//String[] arr = new String[n];
//String[] arr1 = new String[1000];
//
//for(int i = 0; i<n; i++) {
//	input = sc.nextLine();
//	arr[i] = input;
//}
//
////System.out.println(Arrays.toString(arr));
//
//System.out.println();
//
//for(int j = 0; j < 1000; j++ ) {
//	sample = sc.nextLine();
//	arr1[j] = sample;
//	System.out.println(arr1[j]);
//	arr[j].compareToIgnoreCase(input);
////	if() {
////		
////	}
//	
//	System.out.println(arr[j].compareToIgnoreCase(input));
//}
//
//
//
//sc.close();
//
//
//}
