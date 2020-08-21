package com.neu.learn;

/*Asked at Venmo*/
import java.util.HashMap;
import java.util.Map;

public class ArrayWordsToString {
	public static boolean Solution(String word, String[] subWords) {
		Map<Character, Integer> map = new HashMap<>();
		// Iterating over the word
		for(char c: word.toLowerCase().replace(" " , "").toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		//Iterating over the sub-words
		for(String s : subWords) {
			for(char c : s.toCharArray()) {
				if(map.containsKey(c) && map.get(c) > 0) {
					map.put(c, map.get(c) - 1);
					if(map.get(c) == 0) {
						map.remove(c);
					}
				}else{
					return false;
				}
			}
		}
		
		return map.size() == 0;
	}
	public static void main(String[] args) {
		String word = "Justin Bieber";
		String[] subWords = {"suj", "tin", "bie", "ber"};
		boolean result = Solution(word, subWords);
		System.out.println(result);
	}
}
