package com.neu.learn;

import java.util.HashSet;

/*Leetcode Question# 681: Next Closest Time
 * Description: Given a time represented in the format HH:MM
 * form the next closest time by only reusing the digits
 * E.g. Input: "19:34"
 * 		Output:"19:39"(5 mins)
 * Since we have reused the digit 9 to form the next closest.
 * Note: Ans, i'snt 19:33 because the time would be 23:59 mins */

public class NextClosestTime {
	
	public static String nextClosestTime(String time) {
		// Converting the entire time into minutes
		int minutes = Integer.parseInt(time.substring(0,2)) * 60;
		minutes += Integer.parseInt(time.substring(3));
		
		//Create a HashSet of the time to check if it is a valid time
		HashSet<Integer> digits = new HashSet<>();
		for(char c : time.toCharArray()) {
			digits.add(c - '0');
		}
		
		//Generating the next time combination: Adding one to every minute and checking if it is the next closest time
		while(true) {
			minutes = (minutes + 1) % (24 * 60);
			int [] nextTime = {minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};
			
			boolean isValid = true;
			for(int digit : nextTime) {
				if(!digits.contains(digit)) {
					isValid = false;
				}
			}
			
			if(isValid) {
				return String.format("%02d:%02d", minutes / 60, minutes % 60);
			}
		}
	}
	public static void main(String[] args) {
		String time = "19:34";
		System.out.println(nextClosestTime(time));
	}

}
