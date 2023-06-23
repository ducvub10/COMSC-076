import java.util.*;

public class ReverseString {
	//Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in); 		
		System.out.print("Enter your string: ");
		String string = scanner.nextLine();				//Take a string as user input
		reverseDisplay(string);							//Pass string to reverseDisplay
		
		scanner.close();
	}
	
	public static void reverseDisplay(String value) {
		reverseDisplay(value, value.length()-1);		//Pass string and length to helper method
	}
	
	//Helper method
	public static void reverseDisplay(String value, int high) {
		if (high >= 0) {								//If high is larger than 0 
			System.out.print(value.charAt(high));		//Print character at index high
			reverseDisplay(value, high-1);				//Recursively call it again with high-1 to print preceding characters 
		}
		else return;									//If string runs out of value to print, return
	}
}
