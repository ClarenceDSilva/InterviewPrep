package com.neu.learn;

import java.util.Arrays;

/* Sort an array according to its Modulo 4 values
 * Constraints: Algorithm should have O(1) space and O(N) time
 * 
 * Asked at VMware*/
public class Mod4Sort {

	public static int[] modFourSort(int[] inputArr) {
		int index = 0;
		int beginIndex = 0;
		while(index < 4) {
			beginIndex = swap(inputArr, beginIndex, index);
			index++;
		}		
		return inputArr;
	}
	
	public static int swap(int[] inputArr, int beginIndex, int index) {
		for(int i = beginIndex; i < inputArr.length; i++) {
			if(inputArr[i] % 4 == index) {
				int temp = inputArr[beginIndex];
				inputArr[beginIndex] = inputArr[i];
				inputArr[i] = temp;
				beginIndex++;
			}
		}
		return beginIndex;
	}
	
	public static void main(String[] args) {
		int[] inputArr = {7,4,3,2,8};
		System.out.println(Arrays.toString(modFourSort(inputArr)));
	}

}
