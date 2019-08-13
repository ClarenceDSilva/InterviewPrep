package com.neu.learn;
/* Hubspot question:
 * To check whether the given Strings are Anagrams of each other
 * T.C: O(n + m + n) Since the map is being iterated thrice 
 * SC: O(n) Since only 1 Hashmap is being used*/
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean checkIfAnagram(String a, String b) {
		Map<Character, Integer> mapStringA = new HashMap<Character, Integer>();
		int count = 0;
		boolean isAnagram = true;
		
		if (a == null && b == null)
			return true;
		
		// Iterate mapStringA and add all the character counts
		for(char c : a.toCharArray()) {
			if(!mapStringA.containsKey(c))
				mapStringA.put(c, count);
			else
				mapStringA.put(c, mapStringA.get(c) + 1);
		}
		// Iterate over b character array to check if the characters are present in mapStringA
		for(char c : b.toCharArray()) {
			if(mapStringA.containsKey(c))
				mapStringA.put(c, mapStringA.get(c) - 1);
			else {
				//Strings a and b are a mismatch
				isAnagram = false;
				break;
			}
		}
		// Now iterate mapStringA values to see if any character counts are > 0
		for(int i : mapStringA.values()) {
			if(i > 0) {
				isAnagram = false;
				break;
			}
		}
		return isAnagram;
	}
	
	public static void main(String[] args) {
		String a = "anagram";
		String b = "nagaram";
		
		System.out.println(checkIfAnagram(a, b));
	}

}
