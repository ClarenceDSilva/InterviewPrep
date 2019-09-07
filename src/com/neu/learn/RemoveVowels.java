package com.neu.learn;

/*Leetcode #1119: Remove vowels from String*/
public class RemoveVowels {
	public static String removeVowels(String s) {
		String result = s.replaceAll("[AEIOUaeiou]", "");
		return result;
	}
	public static void main(String[] args) {
		String statement = "leetcodeisacommunityforcoders";
		String result = removeVowels(statement);
		System.out.println();
	}

}
