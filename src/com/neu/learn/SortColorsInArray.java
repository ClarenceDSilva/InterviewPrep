package com.neu.learn;

/*Oracle Inteview Question:
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue or(RWB)
 * */

public class SortColorsInArray {
	public static char[] sortColor(char[] arr){
        if(arr == null || arr.length <= 2) {
            return arr;
        }
        String lookup = "RWB";
        int lookupIndex = 0;
        int index = 0;
        while(index < arr.length){
            for(int i = index; i < arr.length; i++){
                if(lookup.charAt(lookupIndex) == arr[i]){
                    char temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    index++;
                }
            }
            lookupIndex++;
        }
        return arr;
    }
	public static void main(String[] args) {
		char[] arr = {'B', 'W', 'B', 'R', 'R', 'B', 'W'};
		sortColor(arr);
		StringBuilder sb = new StringBuilder();
		
		//Iterating and printing array as String
		for(char c : arr){
		    sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
