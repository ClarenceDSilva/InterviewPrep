package com.neu.learn;

import java.util.HashSet;

public class NumUniqueEmails {
	public static int numUniqueEmails(String[] emails) {
        //Creating a hashset to store the unique addresses
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder address = new StringBuilder();
            for(int i = 0; i < email.length(); i++){
                char c = email.charAt(i);
                if(c == '.'){
                    continue;
                }else if(c == '+'){
                    // Move ahead till you reach an '@'
                    while(email.charAt(i) != '@'){
                        i++;
                    }
                    // Once you reach @ add all the remaining chars to your address string
                    address.append(email.substring(i));
                    break;
                }else if(c == '@'){
                    address.append(email.substring(i));
                    break;
                }else{
                    address.append(c);
                }      
            }
            set.add(address.toString());
            System.out.println(address.toString());
        }
        return set.size();
    }
	public static void main(String[] args) {
		String [] emails = new String[] {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
		System.out.println(numUniqueEmails(emails));

	}

}
