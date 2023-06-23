//Programmer: Kiet Quan
//Program Description: Program randomly generate input of size 50,000, 100,000, 200,000, 250,000, 300,000. It then calculates the execution time needed to sort
//the input using selection, merge, quick, heap and radix sort. It then outputs a table with these information.
import java.util.Arrays;

public class SortingTime {
	public static void SelectionSort(int[] arr) {
			int n = arr.length;
		
		for (int i = 0; i < n-1; i++) {
			int min_index = i;
			int min_val = arr[i];
			
			
			for (int j = i + 1; j < n;  j++) {
			if (arr[j] < min_val) {
				min_index = j;
				min_val = arr[j];
				
			}
			}
			if (min_index != i) {
			arr[min_index] = arr[i];
			arr[i] = min_val;
			}
		}
	}
	
	public static void merge (int[] arr, int l, int m, int r) {
		int size_l = (m-l)+1;
		int size_r = r - m;
		
		
		int[] L = new int[size_l];
		int[] R = new int[size_r];
		
		
		for (int i = 0; i < size_l; i++) {
			L[i] = arr[l+i];
		}
		for (int i = 0; i < size_r; i++) {
			R[i] = arr[m + 1 +i];
		}
		int i = 0, j = 0;
		  
        
        int k = l;
        while (i < size_l && j < size_r) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        
        while (i < size_l) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        
        while (j < size_r) {
            arr[k] = R[j];
            j++;
            k++;
        }
		
	}
	
	public static int partition (int[] arr, int l, int r) {
		int i = l -1;
		
		int pivot = arr[r];
		
		for (int j = l; j <= r-1; j++) {
			if  (arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		
		return i+1;
	}
	
	public static void quickSort (int[] arr, int l, int r) {
		if (l < r) {
			int pi = partition (arr, l, r);
			
			quickSort(arr, l, pi-1);
			quickSort(arr, pi+1, r);
		}
	}
	
	public static void heapify (int[] arr, int n, int i) {
		int root = i;
		int left = i*2+1;
		int right = i*2+2;
		
		if (left < n && arr[left] > arr[root]) {
			root = left;
		}
		
		if (right < n && arr[right] > arr[root]) {
			root = right;
		}
		
		if (root != i) {
			int temp = arr[root];
			arr[root] = arr[i];
			arr[i] = temp;
			
			heapify(arr,n,root);
		}
		
	}
	
	public static void heapSort(int[] arr) {
		for (int i = arr.length/2 -1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		for (int i = arr.length-1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify (arr, i, 0);
		}
	}

	public static void MergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			
			MergeSort(arr, l, m);
			MergeSort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	public static void RadixSort (int arr[], int n) {
		int max = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (int i = 1; max >= i; i *= 10) {
			sort(arr,n,i);
		}
	}
	
	public static void sort (int[] arr, int n, int div) {
		int[] count = new int[10];
		int[] result = new int[n];
		Arrays.fill(count, 0);
		
		for (int i = 0; i <n; i++) {
			count[(arr[i]/div)%10]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		
		for (int i = n-1; i >= 0; i--) {
			result[count[(arr[i]/div)%10]-1] = arr[i];
			count[(arr[i]/div)%10]--;
		}
		for (int i = 0; i < n;i++) {
			arr[i] = result[i];
		}
	}
	
	public static void main(String[] args) {
		System.out.println("  Array Size|   Selection       Merge       Quick        Heap       Radix");
		System.out.print  ("------------+--------------------------------------------------------------");
		int strWidth = 12;
		
		
		for (int i = 50000; i <= 300000; i += 50000) {
			int[] arr = new int[i];
			for(int j = 0; j < i; j++) {
				arr[j] = (int) (Math.random()*500000);
			}
			System.out.printf("\n%" + strWidth + "d|",i);
			
			int[] arr2 = Arrays.copyOf(arr, i);
			long startTime = System.currentTimeMillis();
			SelectionSort(arr2);
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.printf("%" + strWidth + "d", duration);
			
			arr2 = Arrays.copyOf(arr, i);
			startTime = System.currentTimeMillis();
			MergeSort(arr2, 0, arr2.length-1);
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.printf("%" + strWidth + "d", duration);
			
			arr2 = Arrays.copyOf(arr, i);
			startTime = System.currentTimeMillis();
			quickSort(arr2, 0, arr2.length-1);
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.printf("%" + strWidth + "d", duration);
			
			arr2 = Arrays.copyOf(arr, i);
			startTime = System.currentTimeMillis();
			heapSort(arr2);
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.printf("%" + strWidth + "d", duration);
			
			arr2 = Arrays.copyOf(arr, i);
			startTime = System.currentTimeMillis();
			RadixSort(arr2, arr2.length);
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.printf("%" + strWidth + "d", duration);
		}
		

	
}
}

	

 