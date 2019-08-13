package com.neu.learn;

public class LongestPallindromicSubstring {

	 public static String longestPalindrome(String s) {
         if(s == null || s.length() < 1){
             return "";
         }
     int maxLength = 0;
     String result = "";
     //StringBuilder result = new StringBuilder(s);
     if(s.length() % 2 != 0){
         // It means that the length of the string is ODD
         int center = s.length() / 2;
         expandAroundCenter(s, center - 1, center + 1, maxLength, result);
     }else{
         // It means that the length of the string is EVEN
         int center = s.length() / 2;
         expandAroundCenter(s, center - 1, center, maxLength, result);
     }
         return result;
 }
 
 public static void expandAroundCenter(String s, int left, int right, int max, String result){
     int newMax = 0;
     while(left >= 0 || right <= s.length() - 1){
         if(s.charAt(left) == s.charAt(right)){
             newMax = (right - left) + 1;
             left--;
             right++;   
         }
         
         if(newMax > max){
             max = newMax;
             if(max == s.length()){
                 result = s.substring(0);
                 break;
             }else{
                 result = s.substring(left + 1, right);
             }
         }
         expandAroundCenter(s, left - 1, left + 1, max, result);
         expandAroundCenter(s, right - 1, right + 1, max, result);
     }
 }

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

}
