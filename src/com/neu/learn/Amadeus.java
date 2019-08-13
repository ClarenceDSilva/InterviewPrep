package com.neu.learn;

/* Question:
 * Given a non-negative integer V; perform 2 actions:
 * 1. If V is odd, subtract 1 from it
 * 2. If V is even, divide it by 2
 * Do this until your final number is 0
 * return the count of the operations
 * */

public class Amadeus {

	/*public static boolean isBinary(int number) {
        int copyOfInput = number;

        while (copyOfInput != 0) {
            if (copyOfInput % 10 > 1) {
                return false;
            }
            copyOfInput = copyOfInput / 10;
        }
        return true;
    }*/
	
	static int logic(int n){
	    if(n < 1){
	      return 0;
	    }else if (n % 2 == 0) {  
	        // If number is even
	        return 1 + logic(n / 2);
	    }else{
	      // Number is odd
	      return 1 + logic(n - 1);
	    }

	  }
	
	static int solution(String s){
		int n = Integer.parseInt(s,2);
		    //Checking if the given string is Integer or Binary
		    //int numberBin=Integer.parseInt(s,2);
		    //boolean isBinary = false;
		     //int n = Integer.parseInt(s);
		    // try{
		     
		    // if(isBinary(n)){
		    //   n=Integer.parseInt(s,2);
		    // } 
		    
		    // }catch(NumberFormatException ex){
		    //   ex.getMessage();
		      
		    // }
		    
		    return logic(n);
		  }
	
	
	public static void main(String[] args) {
		String s = "11110100001001000000";
		System.out.println(solution(s));
	}

}
