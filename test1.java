import java.util.*;
import java.io.*;

public class test1 {
	public static void main(String[] args) throws Exception {
		// Check command-line argument length
		if (args.length != 1) {
			System.out.println("Usage: java Exercise_21_08 textFileName");
			System.exit(1);
		}

		// Check if the file exists
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("The file " + args[0] + " does not exists.");
			System.exit(1);
		}

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		
		try ( // Create an input stream
			Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				String[] words = input.nextLine().split("[ \n\t\r\"\'.,;:!?()]");
				store(map, words);
			}
		}	

		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

		// Get key and value from each entry
		for (Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getValue() + "\t" + entry.getKey());
	}

	/** Method Sotres occurrence of words */
	private static void store(Map<String, Integer> map, String[] words) {
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0 && Character.isLetter(key.charAt(0))) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
	}
}