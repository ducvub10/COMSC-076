import java.util.*;
//Programmer: Kiet Quan
/*Program Description: Take a character as user input. Print number of occurrences of character 
 * in array.
 */

public class CharacterCounter {
	public static int charCount(char[ ] array, int start, char ch) {
		if (start > array.length-1) {
			return 0;
		}
		
		else if (array[start] == ch) {
			return 1 + charCount(array,start+1,ch);
		}
		else {
			return charCount(array,start+1,ch);
		}
	
	}
	public static void main(String[] args) {
		char[] test = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ' , 'o', 'n', 'e', ' ', 'e', 'x', 'a', 'm', 'p', 'l', 'e'};
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter character: ");
		char character = scanner.next().charAt(0);
		System.out.println("Occurrences: " + charCount(test, 0, character));
		scanner.close();
	}
}
