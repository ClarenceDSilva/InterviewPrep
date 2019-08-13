package com.neu.learn;

/* QUESTION: 
 * Given an array of integers and a target value, write a function 
 * that returns True if any two number in the array
 * and adds up to the target value*/

import java.util.*;
import java.util.stream.Collectors;
public class Adobe {
	static int count = 0;
	static boolean solution(int[]a, int k){
		
		boolean result = true;
	    //Converting the Array to a list
		//ArrayList<Integer> arrayList = new ArrayList<Integer>Arrays.asList(a)); // This can't be used as the array also needs to be of Integer type
		// Uses Java 8 Stream API
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
	    for(int i = 0; i < a.length; i++){
	      int value = a[i];
	      if(list.contains(k - value)){
	    	  count ++;
	        result = true;
	      }else
	    	  result = false;
	    }
	    return result;
	  }
	  public static void main(String[] args) {
	    int[] a = {4,1,10,15,2,7}; //1,2,4,7,10,15
	    int target_value = 17; 
	    System.out.println(solution(a, target_value));
	    System.out.println(count/2);

	  }
}
