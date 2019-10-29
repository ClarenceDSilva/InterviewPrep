package com.neu.learn;

import java.util.ArrayList;
import java.util.List;

/*Question: Given a word of length n and n six-sided dice with a character in each side. 
 * Find out if this word can be constructed by the set of given dice.
 * 
 * Asked at Verily Onsite*/
public class ConstructWordUsingDice {

	public static List<List<Integer>> canConstruct(String word, List<List<Character>> dices) {
		List<List<Integer>> result = new ArrayList<>();
		if (word == null || word.length() == 0) {
			return result;
		}

		arrangeDices(0, word, new ArrayList<>(), result, dices);
		return result;
	}

	public static void arrangeDices(int index, String word, List<Integer> combination, List<List<Integer>> result, List<List<Character>> dices) {
		if (combination.size() == word.length()) {
			result.add(new ArrayList<>(combination));
		}

		for (int i = index; i < word.length(); i++) {
			for (int j = 0; j < dices.size(); j++) {
				if (!combination.contains(j)) {
					// Simulating 'Taking the dice' from the array
					if (dices.get(j).contains(word.charAt(i))) {
						combination.add(j);
						arrangeDices(i + 1, word, combination, result, dices);
						// Simulating not taking the dice
						combination.remove(combination.size() - 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String word = "hello";
		List<List<Character>> dices = new ArrayList<>();

		List<Character> dice1 = new ArrayList<>();
		dice1.add('a');
		dice1.add('l');
		dice1.add('c');
		dice1.add('d');
		dice1.add('e');
		dice1.add('f');

		List<Character> dice2 = new ArrayList<>();
		dice2.add('a');
		dice2.add('b');
		dice2.add('c');
		dice2.add('d');
		dice2.add('e');
		dice2.add('f');

		List<Character> dice3 = new ArrayList<>();
		dice3.add('a');
		dice3.add('b');
		dice3.add('c');
		dice3.add('h');
		dice3.add('e');
		dice3.add('f');

		List<Character> dice4 = new ArrayList<>();
		dice4.add('a');
		dice4.add('b');
		dice4.add('c');
		dice4.add('d');
		dice4.add('o');
		dice4.add('f');

		List<Character> dice5 = new ArrayList<>();
		dice5.add('a');
		dice5.add('b');
		dice5.add('c');
		dice5.add('l');
		dice5.add('e');
		dice5.add('f');

		dices.add(dice1);
		dices.add(dice2);
		dices.add(dice3);
		dices.add(dice4);
		dices.add(dice5);

		List<List<Integer>> result = canConstruct(word, dices);
		System.out.println(result);
	}

}
