package com.neu.learn;

/*0/1 Knapsack using bottom-up processing:DP*/

public class Knapsack_01 {
	public static int knapsack(int val[], int wt[], int limit) {
		int dp[][] = new int[val.length + 1][limit + 1];
		
		for(int i = 0; i <= val.length; i++) {
			for(int j = 0; j <= limit; j++) {
				//1st column will be all 0 since if there is no min. wt, nothing can be added into the knapsack
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if(j - wt[i - 1] >= 0) {
					//If the wt in contention is less than the wt just above the cell we are trying to process..
					//then calculate the max value as..
					dp[i][j] = Math.max( dp[i - 1][j - wt[i - 1]] + val[i - 1] , dp[i - 1][j]);
				}else {
					//Take the wt above directly above the cell in contention
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[val.length][limit];
	}
	public static void main(String[] args) {
		int val[] = {1, 4, 5, 7};
		int wt[] = {1, 3, 4, 5};
		int limit = 7;
		int result = knapsack(val, wt, limit);
		System.out.println("Total VALUE of items in the Knapsack close to the WT are: "+result);
	}

}
