//Programmer: Kiet Quan
/*Program Description: The program sort values of 3 array lists of different types.
 * The sorted values are then printed out as formatted. 
 */
import java.util.*;

public class SortArrayList {
	public static <E extends Comparable<E>>
    void sort(ArrayList<E> list) {
		//Bubble sort
		for (int n = 0; n < list.size()-1; n++) {
			for (int i = 0; i < list.size() - n -1; i++) {
				if (list.get(i).compareTo(list.get(i+1)) > 0) {
					E temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
				}
			}
		}
		printList(list);
		System.out.println();
	}
	
	public static <E> void printList(ArrayList<E> list) {
		//Print sorted array
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " " );
		}
	}
	
	public static void main(String[] args) {
		 //Declare 3 array lists of 3 types
		ArrayList<Integer> intList = new ArrayList<Integer>();  
		ArrayList<Double> doubleList = new ArrayList<Double>();
		ArrayList<String> stringList = new ArrayList<String>();
		//Initialize array lists
		intList.add(2);
		intList.add(4);
		intList.add(3);
		doubleList.add(3.4);
		doubleList.add(1.2);
		doubleList.add(-12.3);
		stringList.add("Alice");
		stringList.add("Bob");
		stringList.add("Carol");
		stringList.add("Ted");
		
		//Print sorted results
		System.out.print("Sorted Integer Objects: ");
		sort(intList);
		System.out.print("Sorted Double Object: ");
		sort(doubleList);
		System.out.print("Sorted String Object: ");
		sort(stringList);
	}
}
