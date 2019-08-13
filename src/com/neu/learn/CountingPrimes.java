package com.neu.learn;

public class CountingPrimes {
	 static int countPrimes(int n) {
	        boolean[] primes = new boolean[n];
	        // Since Java by default initializes boolean array to false
	        for(int i = 0; i<primes.length; i++){
	            //Setting all the primes initially to true
	            primes[i] = true;
	        }
	        //Assuming 1 as neither prime nor composite
	        for(int i = 2; i*i < primes.length; i++){
	            if(primes[i]){
	                //Setting all its multiples as false
	                for(int j = i; j*i < primes.length; j++){
	                    primes[i * j] = false;
	                }
	            }                 
	        }
	        int primeCount = 0;
	        for(int i = 2; i < primes.length; i++){
	            if(primes[i]){
	                primeCount++;
	            }
	        }
	        return primeCount;
	    }
	 
	public static void main(String[] args) {
		int n = 10;
		System.out.println(countPrimes(n));
	}

}
