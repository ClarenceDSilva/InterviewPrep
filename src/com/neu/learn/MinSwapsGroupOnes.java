package com.neu.learn;

public class MinSwapsGroupOnes {

	public static int minSwaps(int[] data) {
		// Calculate windowSize
		int windowSize = 0;
		for (int i : data) {
			if (i == 1)
				windowSize++;
		}

		if (windowSize <= 1) {
			return 0;
		}

		int i = 0;
		int j = i + (windowSize - 1);
		int minSwaps = computeInitialWindowZeros(data, i++, j++, 0);
		int countZeros = minSwaps;

		for (; j < data.length; j++) {
			// It means you lost a 0 when moving the window. Decrement the count
			countZeros -= data[i - 1] == 0 ? 1 : 0;
			// It means you gained a 0 when moving the window. Increment the count
			countZeros += data[j] == 0 ? 1 : 0;
			minSwaps = Math.min(minSwaps, countZeros);
			i++;
		}
		return minSwaps;
	}

	// Function to compute Zeroes for the initial Window
	private static int computeInitialWindowZeros(int[] data, int i, int j, int zeroes) {
		while (i <= j) {
			if (data[i++] == 0)
				zeroes++;
		}
		return zeroes;
	}

	public static void main(String[] args) {
		int[] data1 = { 1, 0, 1, 0, 1 };
		int swaps1 = minSwaps(data1);
		System.out.println(swaps1);
		
		int[] data2 = { 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1,
				1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0,
				0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0,
				1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1 };
		int swaps2 = minSwaps(data2);
		System.out.println(swaps2);
	}
}
