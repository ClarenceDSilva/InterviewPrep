package com.neu.learn;

import java.util.ArrayList;
import java.util.List;

public class WordLadderRecursion {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> transformedWords = new ArrayList<String>();
        int i = 0;
        int result = differByOne(beginWord, wordList.get(i), endWord, wordList, transformedWords, 0);
        return result;
        
    }
    
    public static int differByOne(String word1, String word2, String endWord, List<String> wordList, List<String> transformedWords, int size){
        int count = 0;
        while(size < wordList.size() || wordList.get(count).equals(endWord)){
            if(word1.length() != word2.length()){
            	return 0;
            }
	        for(int i = 0; i < word1.length(); i++){
	            int charCount = 0;
	            if(word1.charAt(i) != (word2.charAt(i))){
	                charCount ++;
	            }
	            if(charCount > 1){
	                break;
	            }
	        }
	        transformedWords.add(word1);
	        //size++;
	        count++;
	        System.out.println("COUNT" + count);
	        differByOne(word2, wordList.get(count), endWord, wordList, transformedWords, size + 1);
        }
        
        return size;
    }
    	public static void main(String[] args) {
    		String beginWord = "hit";
    		String endWord = "cog";
    		List<String> wordList = new ArrayList<String>();
    		wordList.add("hot");
    		wordList.add("dog");
    		wordList.add("dot");
    		wordList.add("lot");
    		wordList.add("log");
    		wordList.add("cog");
    		System.out.println(ladderLength(beginWord,endWord,wordList));
	}
}
