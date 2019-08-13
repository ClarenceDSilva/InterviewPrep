package com.neu.learn;
public class LongestCommonPrefix {

	 public static String longestCommonPrefix(String[] strs) {
		 if (strs.length == 0) return "";
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		        	System.out.println(strs[i].indexOf(prefix)); // -1 means that the substring is not found
		            prefix = prefix.substring(0, prefix.length() - 1);
		            System.out.println("Prefix: "+prefix);
		            if (prefix.isEmpty()) return "";
		        }        
		    return prefix;
	    }
	
	public static void main(String[] args) {
		String [] inputArr = new String[] {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(inputArr));
		
	}

}
