
//Programmer: Kiet Quan
//Program Description: The program tests the methods of MyLinkedList class that manipulates 10 names as elements.
import java.util.*;

 interface MyList<E> extends Iterable<E> {
	  
	  public void add(int index, E e);

	  public void clear();

	  public boolean contains(E e);

	  public E get(int index);

	  public int indexOf(E e);

	  public int lastIndexOf(E e);
	  
	  public E remove(int index);

	  public int size();

	  public E set(int index, E e);
	
	}


	 public class MyLinkedList<E> implements MyList<E> {
		 private Node<E> head, tail;
		 private int size = 0; 

		
		 public MyLinkedList() {
			 head = tail = null;
			 size = 0;
		 }

		 
		 public MyLinkedList(E[] objects) {
		 for (int i = 0; i < objects.length; i++)
		 this.add(i,objects[i]);
		 }

		 
		 public E getFirst() {
		 if (size == 0) {
		 return null;
		 }
		 else {
		 return head.element;
		 }
		 }

		 
		 public E getLast() {
		 if (size == 0) {
		 return null;
		 }
		 else {
		 return tail.element;
		 }
		 }

		 
		 public void addFirst(E e) {
			 Node<E> newNode = new Node<>(e); 
			 newNode.next = head; 
			 head = newNode; 
			 size++; 

			 if (tail == null) 
			 tail = head;
		 
		 }

		 
		 public void addLast(E e) {
			 Node<E> newNode = new Node<>(e); 

			 if (tail == null) {
			 head = tail = newNode;
			 }
			 else {
			 tail.next = newNode; 
			 tail = newNode; 
			 }

			 size++;

		 
		 }

		 @Override 
		 public void add(int index, E e) {
			 if (index == 0) addFirst(e); 
			 else if (index >= size) addLast(e); 
			 else { 
			 Node<E> current = head;
			for (int i = 1; i < index; i++)
			 current = current.next;
			 Node<E> temp = current.next;
			 current.next = new Node<>(e);
			 (current.next).next = temp;
			 size++;
			 }
		
		 }

		 
		 public E removeFirst() {
			 if (size == 0) return null; 
			 else {
			 Node<E> temp = head; 
			 head = head.next; 
			 size--; 
			 if (head == null) tail = null; 

			return temp.element; 
			 }
		 
		 }

		
		 public E removeLast() {
			 if (size == 0) return null; 
			 else if (size == 1) { 
			 Node<E> temp = head;
			 head = tail = null; 
			 size = 0;
			 return temp.element;
			 }
			 else {
			 Node<E> current = head;

			 for (int i = 0; i < size - 2; i++)
			 current = current.next;

			 Node<E> temp = tail;
			 tail = current;
			 tail.next = null;
			 size--;
			 return temp.element;
			 }
		 
		 }

		 @Override 
		 public E remove(int index) {
			 if (index < 0 || index >= size) return null; 
			 else if (index == 0) return removeFirst(); 
			 else if (index == size - 1) return removeLast(); 
			 else {
			 Node<E> previous = head;

			 for (int i = 1; i < index; i++) {
			 previous = previous.next;
			 }

			 Node<E> current = previous.next;
			 previous.next = current.next;
			 size--;
			 return current.element;
			 }
		 
		 }

		 @Override 
		 public String toString() {
		 StringBuilder result = new StringBuilder("[");

		 Node<E> current = head;
		 for (int i = 0; i < size; i++) {
		 result.append(current.element);
		 current = current.next;
		 if (current != null) {
		 result.append(", "); 
		 }
		 else {
		 result.append("]"); 
		 }
		 }

		 return result.toString();
		 }

		 @Override 
		 public void clear() {
		 size = 0;
		 head = tail = null;
		 }

		 @Override 
		 public boolean contains(Object e) {
		 Node<E> Current = head;
		 while(Current != null) {
			 if(Current.element == e) {
				 return true;
			 }
			 Current = Current.next;
		 }
		 return false;
		 }

		 @Override 
		 public E get(int index) {
			 Node<E> current = head;
			 if (index < size) {
		 for (int i = 0; i < index; i++) {
			 current = current.next;
		 }
		 	return current.element;
		 }
			 return null;
		 }

		 @Override 
		 public int indexOf(Object e) {
			 Node<E> Current = head;
			 int index = 0;
			 
			 while(Current != null) {
				 if(Current.element == e) {
					 return index;
				 }
				 Current = Current.next;
				 index++;
			 }
			 return -1;
		 }

		 @Override 
		 public int lastIndexOf(E e) {
			 Node<E> Current = head;
			 int index = 0;
			 int last_index = -1;
			 while(Current != null) {
				 if(Current.element == e) {
					last_index = index;
				 }
				 Current = Current.next;
				 index++;
			 }
			 return last_index;
		 }

		 @Override 
		 public E set(int index, E e) {
			 if (index < size) {
				 Node<E> current = head;
				 for (int i = 0; i < index; i++) {
					 current = current.next;
				 }
				 current.element = e;
				 }
			 return null;
		 }

		 @Override 
		 public java.util.Iterator<E> iterator() {
		 return new LinkedListIterator();
		 }

		 private class LinkedListIterator
		 implements java.util.Iterator<E> {
		 private Node<E> current = head; 

		 @Override
		 public boolean hasNext() {
		 return (current != null);
		 }

		 @Override
		 public E next() {
		 E e = current.element;
		 current = current.next;
		 return e;
		 }

		 @Override
		 public void remove() {
			 throw new UnsupportedOperationException("Remove not implemented.");
		 }
		 }

		 private static class Node<E> {
		 E element;
		 Node<E> next;

		 public Node(E element) {
		 this.element = element;
		 }
		 }

		 @Override 
		 public int size() {
		 return size;
		 }
		 
		 public static void main(String[] args) {
			MyLinkedList<Object> list = new MyLinkedList<Object>();
			list.addLast("Alan");
			list.addLast("Michael");
			list.addLast("Dan");
			list.addLast("Mikey");
			list.addLast("Kiet");
			list.addLast("Ben");
			list.addLast("Mikey");
			list.addLast("Riley");
			list.addLast("Ann");
			list.addLast("Pharah");
			System.out.println(list.toString());
			
			System.out.println("getFirst test: " + list.getFirst());
			System.out.println("getLast test: " + list.getLast());
			
			list.addFirst("Daniel");
			System.out.println("addFirst test: " + list.toString());
			
			list.addLast("Wang");
			System.out.println("addLast test: " + list.toString());
			
			list.add(5, "Byron");
			System.out.println("add test: " + list.toString());
			
			list.removeFirst();
			System.out.println("removeFirst test: " + list.toString());
			
			list.removeLast();
			System.out.println("removeLast test: " + list.toString());
			
			list.remove(4);
			System.out.println("remove test: " + list.toString());
			
			System.out.println("contains Kiet test: " + list.contains("Kiet"));
			
			System.out.println("get 3 test: " + list.get(3));
			
			System.out.println("index of Mikey test: " + list.indexOf("Mikey"));
			
			System.out.println("last index of Mikey test: " + list.lastIndexOf("Mikey"));
			
			list.set(0, "Felix");
			System.out.println("set 0 to Felix test: " + list.toString());
			
			System.out.println("size test: " + list.size());
			
			list.clear();
			System.out.println("clear test: " + list.toString());
			
			
		}
		 }
	 
	 
	  

