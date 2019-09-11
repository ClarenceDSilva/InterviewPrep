package com.neu.learn;

import java.util.Arrays;

/* Leetcode #252 Meeting Rooms
 * Problem Desc: Given an array of intervals bearing start and end
 * times, determine if a person could attend all meetings*/

/*Note: Interval Object definition is the same as MR2*/

public class MeetingRooms1 {
	
	public static boolean canAttend(Interval[] intervals) {
		//Sorting the intervals based on their start time
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		
		for(int i = 0; i < intervals.length; i++) {
			int endCurrentMeeting = intervals[i].end;
			int startNextMeeting = intervals[i + 1].start;
			
			//If the end current meeting exceeds that the start of next meeting
			if(endCurrentMeeting > startNextMeeting) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Interval arr[]=new Interval[5]; 
        arr[0]=new Interval(2,15); 
        arr[1]=new Interval(36,45); 
        arr[2]=new Interval(9,29); 
        arr[3]=new Interval(16,23);
        arr[4]=new Interval(4,9);
        
        boolean canAttend = canAttend(arr);
        System.out.println(canAttend);
	}

}
