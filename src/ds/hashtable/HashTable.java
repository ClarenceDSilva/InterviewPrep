package ds.hashtable;

/*Implementation of a HashTable using Arrays
 * Uses the concept of Double Hashing*/
public class HashTable {
	
	String[] hashArray;
	int arraySize;
	int size = 0; // number of elements in the hash table
	
	public HashTable(int numOfSlots) {
		if(isPrime(numOfSlots)) {
			hashArray = new String[numOfSlots];
			arraySize = numOfSlots;
		}else {
			int primeCount = getNextPrime(numOfSlots);
			hashArray = new String[primeCount];
			arraySize = primeCount;
			
			System.out.println("Hash table size given"+ numOfSlots+ "is not a prime");
			System.out.println("Hash table size changed to: "+primeCount);
		}
	}
	
	private boolean isPrime(int num) {
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private int getNextPrime(int minNumber) {
		for(int i = minNumber; true; i++) {
			if(isPrime(i)) {
				return i;
			}
		}
	}
	// Now we define our  HashFunctions
	
	// Returns preferred index position
	private int hashFunction1(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		
		if(hashVal < 0) {// Since hashVal can be negative
			hashVal += arraySize;
		}
		return hashVal; //Ideal index position we'd like to insert or search in
	}
	//Returns the step size greater than 0
	private int hashFunction2(String word) {
		int hashVal = word.hashCode();
		hashVal %=arraySize;
		
		if(hashVal < 0) {
			hashVal += arraySize;
		}
		// Calculating step size(To calculate, use a prime number which is less that the arraySize; eg.3)
		return 3 - hashVal % 3;
	}
	
	public void insert(String word) {
		int prefIndexPos = hashFunction1(word);
		int stepSize = hashFunction2(word);
		
		while(hashArray[prefIndexPos] != null) { // Loop until you find a slot in the array
			prefIndexPos = prefIndexPos + stepSize;
			prefIndexPos = prefIndexPos % arraySize;
		}
		hashArray[prefIndexPos] = word;
		System.out.println("Inserted word: "+ word);
		size++;
	}
	
	public String find(String word) {
		int prefIndexPos = hashFunction1(word);
		int stepSize = hashFunction2(word);
		
		while(hashArray[prefIndexPos] != null) { // Loop until you find a slot in the array
			if(hashArray[prefIndexPos].equals(word)) {
				return hashArray[prefIndexPos];
			}
			prefIndexPos = prefIndexPos + stepSize;
			prefIndexPos = prefIndexPos % arraySize;
		}
		return hashArray[prefIndexPos]; // which would be null
	}
	
	public void displayTable() {
		System.out.println("\nTable: ");
		for(int i = 0; i < arraySize; i++) {
			if(hashArray[i] != null) {
				System.out.print(hashArray[i] + " ");
			}else {
				System.out.print("** ");
			}
			System.out.println("");
		}
	}
}
