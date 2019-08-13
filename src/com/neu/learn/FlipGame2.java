package com.neu.learn;

/*LeetCode #294: Google Question: Flip Game 2*/
public class FlipGame2 {
	public static boolean canWin(String s) {
		if(s == null || s.length() < 2) {
			return false;
		}
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == '+' || s.charAt(i + 1) == '+') {
				String nextState = s.substring(0,i) + "--" + s.substring(i + 2);
				if(!canWin(nextState)) {
					// If Player2 cannot win with the nextState given, it means Player1 wins
					return true;
				}
			}		
		}
		return false;
	}
	public static void main(String[] args) {
		String state = "++++";
		System.out.println(canWin(state));

	}

}
