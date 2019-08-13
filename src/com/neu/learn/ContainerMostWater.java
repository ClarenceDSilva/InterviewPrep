package com.neu.learn;

public class ContainerMostWater {
	 public static int maxArea(int[] height) {
	        int max = Integer.MIN_VALUE;
	        int i =0;
	        int j = height.length -1;
	        
	        while(i < j){
	            int min = Math.min(height[i], height[j]);
	            max = Math.max(max, min *(j -i));
	            if(height[i] < height[j]){
	                i++;
	            }else{
	                j--;
	            }
	        }
	        return max;
	    }
	 
	 public static void main(String args[]) {
		 int[] height = new int []{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
		 System.out.println(maxArea(height));
	 }
}
