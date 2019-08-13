package com.neu.learn;

import java.util.ArrayList;
import java.util.List;

/*LeetCode #293: Google Question: Flip Game
 * Runtime: O(n^2)*/

public class FlipGame {
	
	public static List<String> generatePossibleNextMoves(String s){
		List<String> possibleStates = new ArrayList<>();
		int i = 0;
		while(i < s.length()) {
			//If i is at the 1st iteration, give me the index of first 2 + signs
			// If i is at the 2nd iteration, give me the index of the next 2 + signs and so on
			int nextMove = i == 0 ? s.indexOf("++") : s.indexOf("++", i);
			if(nextMove == -1) {
				// No nextMove found
				return possibleStates;
			}
			String nextState = s.substring(0, nextMove)+ "--" + s.substring(nextMove+2);
			possibleStates.add(nextState);
			i = nextMove + 1;
		}
		return possibleStates;
		
	}
	public static void main(String[] args) {
		String s = "++++";
		System.out.println(generatePossibleNextMoves(s));
	}
}
