package ds.sort;

public class MergeSort {
	
	public static void sort(int inputArray[]) {
		sort(inputArray, 0, inputArray.length - 1);
	}
	
	public static void sort(int inputArray[], int start, int end) {
		if(end <= start) {
			return;
		}
		
		int mid = (start + end) / 2;
		sort(inputArray, start, mid); //Sort left half
		sort(inputArray, mid + 1, end); // Sort right half
		merge(inputArray, start, mid, end);// Merge sorted results into the inputArray
	}
	
	public static void merge(int inputArray[], int start, int mid, int end) {
		int tempArray[] = new int [end - start + 1];
		
		//index counter for the left side of the array
		int leftSlot = start;
		
		//index counter for the right side of the array
		int rightSlot = mid + 1;
		int k = 0;
		
		while(leftSlot <= mid && rightSlot <= end) {
			if(inputArray[leftSlot] < inputArray[rightSlot]) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
			}else {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
			}
			k++;
		}
		// Once done with the while loop, we are done sorting the right and left side of the Sub-Array
		
		// If there are still elements left to be sorted either at leftSlot or rightSlot; Just copy those elements
		if(leftSlot <= mid) {
			while(leftSlot <= mid) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
				k++;
			}
		}else if(rightSlot <= end) {
			while(rightSlot <= end) {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
				k++;
			}
		}
		
		// Copy the temp array into the appropriate slots of the input array
		for(int i = 0; i < tempArray.length; i++) {
			System.out.println("START INDEX: "+tempArray[i]);
			inputArray[start + i] = tempArray[i];
		}		
		//System.arraycopy(tempArray, 0, inputArray, 0, tempArray.length);
	} 
	
	public static void main(String[] args) {
		int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
		sort(inputArray);
		
		for(int i = 0; i < inputArray.length; i++) {
			System.out.println(inputArray[i]);
		}

	}

}
