import java.util.*;
import java.io.*;
//Programmer: Kiet Quan
/*Program Description: The program takes in command line argument as path to a designated file. 
It then count the occurrence of words in the file and display the output of words in alphabetical
order, preceded by their number of occurrence.
*/ 
public class CountOccurrenceOfWords {
	public static void main(String[] args) throws FileNotFoundException{
		//Create File object, para: file path
		  if (args.length != 1) {
		      System.out.println(
		        "Usage: java CountOccurrenceOfWords fullfilename");
		      System.exit(1);
		  }
		File file = new File(args[0]);
		//Create Scanner object, para: File Object
		Scanner scanner = new Scanner(file);
		//create a Tree Map object, generic: String, Int
		Map<String, Integer> map = new TreeMap<>();
		//Loop that while scanner.hasNextLine == true, add nextLine as delimited by punctuation (stored in a string) to map.
		System.out.println("Display words and their counts in ascending order of the words: ");
		while (scanner.hasNextLine() == true) {
			String[] entries = scanner.nextLine().split("[ \n\r\t,;.:?'\"()]");
			addToMap(map, entries);
		}
		//Display output
		map.forEach((k,v) -> System.out.println(v + "\t" + k));
	}
	
	public static void addToMap(Map<String, Integer> map, String[] entries) {
		for (int i = 0; i < entries.length; i++) {
			//consider upper case the same as lower case
			String key = entries[i].toLowerCase();
			//if map contains key, put value 1 with key variable into map
			if (key.length()>0 && Character.isLetter(key.charAt(0))) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				//else increase value associated with key variable by 1
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
	}
}
