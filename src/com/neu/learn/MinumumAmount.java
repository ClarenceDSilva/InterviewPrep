package com.neu.learn;

import java.util.ArrayList;
import java.util.List;

/*Hackerrank Question Toast Inc.*/
public class MinumumAmount {
	public static int calculateAmount(List<Integer> prices) {
		int dp[] = new int[prices.size()];
		dp[0] = prices.get(0);
		int totalPrice = dp[0];
		for (int i = 1; i < prices.size(); i++) {
			dp[i] = Math.min(prices.get(i), dp[i - 1]);
			if (prices.get(i) <= dp[i]) {
				totalPrice += 0;
			} else {
				totalPrice += (prices.get(i) - dp[i]);
			}
		}

		return totalPrice;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(9);
		list.add(2);
		list.add(3);
		System.out.println(calculateAmount(list));
	}
}
