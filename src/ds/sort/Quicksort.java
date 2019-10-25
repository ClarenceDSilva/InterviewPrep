package ds.sort;

import java.util.Arrays;

/*Quicksort algorithm for sorting
 * Steps:
 * 1. Select pivot
 * 2. Move smaller elements to the left and move bigger elements to the right of pivot
 * 3. Recursively sort the left and the right part
 * 
 * This program uses Pivot as the right most element of the array*/
public class Quicksort {
	
	public static void main(String[] args) {
		int[] arr = {5, 1, 25, 32, 104, 2, 10, 3};
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		int partition = partition(arr, start, end);
		
		if(partition - 1 > start) {
			//It means everything before the partition is less than the partition elemt
			quicksort(arr, start, partition - 1);
		}
		
		if(partition + 1 < end) {
			//It means everything after the partition is greater than the partition elemt
			quicksort(arr, partition + 1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		
		for(int i = start; i < end; i++) {
			if(arr[i] < pivot) {
				//Swap arr elmt with the start
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				
			}
		}
		// Swapping start and pivot
		int temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;
		
		return start;
	}
}
