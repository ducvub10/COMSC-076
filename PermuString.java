//Programmer: Kiet Quan
//Program Description: takes a string as input from user. As output, display all permutation of the string.
import java.util.*;

public class PermuString {
	//Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String string = scanner.next(); 					//Take string as user input
		displayPermutation(string);							//Pass string to displayPermutation method
		scanner.close();
	}
	
	public static void displayPermutation(String s) {		
		displayPermutation("", s); 							//Invoke helper method 
	}
	
	//Helper method 
	public static void displayPermutation (String s1, String s2) { //s1: empty, s2: s
		if (s2.length() == 0) {								//Base case: if s2 runs out of character, print s1
			System.out.println(s1);
		}
		else {
		for (int i = 0; i < s2.length(); i++) { 			//loop through string s2
			displayPermutation(s1 + s2.charAt(i), s2.substring(0,i) + s2.substring(i+1));//Pass character at index i from s2 to s1
		}
	}
}
}