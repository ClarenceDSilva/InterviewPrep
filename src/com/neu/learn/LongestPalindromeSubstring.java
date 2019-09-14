package com.neu.learn;

/*Leetcode #5: Longest Palindromic Substring
 * Question: Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000. */
public class LongestPalindromeSubstring {
	
	public static String longestPalindrome(String s) {
		int length = s.length();
		
		if(s == null || length < 2) {
			return s;
		}
		
		boolean[][] isPalindrome = new boolean[length][length];
		int left = 0;
		int right = 0;
		
		for(int j = 1; j < length; j++) {
			for(int i = 0; i < j; i++) {
				//Condition to check if inner word(b/w i and j) is a palindrome
				boolean isInnerWordPalindrome = isPalindrome[i+1][j-1] || j - i <= 2;
				
				if(s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {
					isPalindrome[i][j] = true;
					// We have now found a word which is palindrome. Now check
					// if we have found the longest palindrome or not
					if(j - i > right - left) {
						left = i;
						right = j;
					}
				}
			}
		}
		return s.substring(left, right + 1);
	}
	public static void main(String[] args) {
		String s = "babad";
		String output = longestPalindrome(s);
		System.out.println(output);
	}

}
