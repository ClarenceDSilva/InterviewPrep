package com.neu.learn;

/*Question: Given a string of instructions, you find out that there are certain sequence of instructions
 * that are repeated from the beginning. If you mark them as * find out how many steps are required to
 * represent those sets of instructions
 * Eg 1: Given the following instruction, 'A B C A B C D' == 8
 *  you can represent it as 'A B C * D'(Since the instruction ABC is being repeated again in the sequence,
 *  you can replace it with a *)
 * Eg 2: 'A B C D D A B C D D' ==  6 (It can be represented as A B C D D *)
 *  
 *  Asked at Goldman Sachs interview*/
public class RepeatedPatterns {
	
	public int countInstructions(String instructions ) {
		int numOfInstructions = 0;
		int instructionLen = instructions.length();
		if(instructionLen == 0) {
			return numOfInstructions;
		}
		StringBuilder pattern = new StringBuilder();
		int i = 0;
		while(i < instructionLen) {
			char current = instructions.charAt(i);
			
			//Case where the incoming instructions are present in the pattern
			if(pattern.toString().contains(Character.toString(current))){
				int patternLen = pattern.length();
				if((i + patternLen - 1) <= instructionLen && pattern.toString().equals(instructions.substring(i, i + patternLen))){
					numOfInstructions++;
					pattern.append(pattern.toString());
					i = i + patternLen;
				}else {
					numOfInstructions++;
					pattern.append(current);
					i++;
				}
			}else {
				//Case where the pattern is not present
				pattern.append(current);
				numOfInstructions++;
				i++;
			}
		}
		return numOfInstructions;
	}
	public static void main(String[] args) {
		String instruction1 = "ABABCDABC";
		String instruction2 = "ABCDDABCDD";
		RepeatedPatterns rp = new RepeatedPatterns();
		
		int numOfInstructions1 = rp.countInstructions(instruction1);
		int numOfInstructions2 = rp.countInstructions(instruction2);
		
		System.out.println(numOfInstructions1);
		System.out.println(numOfInstructions2);
	}

}
