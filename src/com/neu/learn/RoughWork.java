package com.neu.learn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoughWork {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("ab");
		set.add("ba");
		
		Iterator<String> it = set.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next());
	     }
		
	}

}
