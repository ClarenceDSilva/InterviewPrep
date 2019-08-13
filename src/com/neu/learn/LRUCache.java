package com.neu.learn;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/*Uses Double ended queue and HashSet for determining page faults
 * of a cache
 * Not a LeetCode Question
 * HashSet is used for quick access
 * Deque is used as mu cache*/
public class LRUCache {
	//Initializing variables
    private Deque<Integer> deque;
    private HashSet<Integer> map;
    private int cacheSize;
    
    public LRUCache(int capacity) {
        deque = new LinkedList<Integer>();
        map = new HashSet<Integer>();
        cacheSize = capacity;
    }
    
    public int get(int key) {
        int index = 0, i = 0;
        // Iterate over the deque, find the key and return it.
        
        Iterator<Integer> itr = deque.iterator();
        
        while(itr.hasNext()){
            if(itr.next() == key){
                // Since this is now the most freq used data,remove it
                //from the deque and push to the front
                
                deque.removeLast();
                deque.push(key);
                return 1;
            }
            index++;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Data is not present in the hashSet
        if(!map.contains(key)){
            // If the cache is full, remove from the end of the deque and the map
            if(deque.size() == cacheSize){
                int lastElement = deque.removeLast();
                map.remove(lastElement);
            }else{
                // The data is found in the cache, but it could be anywhere
                // So iterate the queue and push it forward
                int index = 0, i = 0;
                Iterator<Integer> itr = deque.iterator();
                while(itr.hasNext()){
                    if(itr.next() == key){
                        index = i;
                        break;
                    }
                    i++;
                }
                // Now index position locates the key in the deque. Remove it and add it
                // to the front of the queue
                deque.remove(index);
            }
            deque.push(key);
            // Add also the key to the map
            map.add(key);
        }    
    }
}
