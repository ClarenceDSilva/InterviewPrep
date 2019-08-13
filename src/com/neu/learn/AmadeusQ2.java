package com.neu.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmadeusQ2 {

	public  static String weekDays(String day, int K){
        
        List<String> weekdays = new ArrayList<>(Arrays.asList("Mon","Tue","Wed","Thur","Fri","Sat","Sun"));
        
        int startIndex = weekdays.indexOf(day);
        
        int finalIntex = (startIndex + K) % weekdays.size();
        
        return weekdays.get(finalIntex);
        
    }
	public static void main(String[] args) {
		System.out.println(weekDays("Sat", 1));
		
	}

}
