package com.neu.learn;

/*Reverse a sentence*/
public class ReverseWordsInSentence {
	
	public static char[] correctOrder(char[] arr) {
		int index = 0;
		String strArr = new String(arr);
		String[] temp = strArr.split(" ");
		for(int i = temp.length - 1; i >= 0; i--) {
			for(char c : temp[i].toCharArray()) {
				arr[index++] = c;
			}
			if(index < arr.length) {
				arr[index++] = ' ';
			}
		}
		return arr;
	}
	//Alternative Approach
	public static char[] correctOrder2(char[] arr) {
		char[] result = new char[arr.length];
		int i = 0;
		int k = arr.length - 1;
		int j;
		while(i < arr.length) {
			j = i;
			while(arr[j] != ' ' && j < arr.length - 1) {
				j++;
			}
			int len = j;
			while(j >= i) {
				if(arr[j] == ' ') {
					j--;
				}
				result[k] = arr[j];
				k--;
				j--;
			}
			if(k >= 0) {
				result[k] = ' ';
				k--;
			}
			i = len + 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		char[] arr = new char[]{'d','e','v','e','l','o','p','e','r', ' ', 'a', ' ', 'a','m',' ','I'};
		char[] result = correctOrder(arr);
		System.out.println(result);

	}

}
