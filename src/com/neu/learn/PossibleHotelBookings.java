package com.neu.learn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*Question: A hotel manager has to process N bookings of rooms for the next season.
 *His hotel has K rooms. Bookings contain an arrival date and a departure date. 
 *He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
 *
 *Inputs:
	- First list for arrival time of booking
	- Second list for departure time of booking
	- Third is K which denotes the count of rooms
 *Output:
	- A boolean which tells whether its possible to make a booking
	false means there are not enough rooms for N booking
	true means there are enough rooms for N booking
 *
 *Source: InterviewBit
 */
public class PossibleHotelBookings {
	
	public static boolean hotelBookings(int[] arrivals, int[] departures, int k) {
		
		//Collection of the events
		Map<Integer, Integer> events = new HashMap<>();
		
		//Number of rooms
		int n = arrivals.length;
		
		for(int i = 0; i < n; i++) {
			int arrival = arrivals[i];
			int departure = departures[i];
			
			//Add to the events 1 during arrival
			events.put(arrival, events.getOrDefault(arrival, 0) + 1);
			
			//Remove 1 from the events for departure
			events.put(departure, events.getOrDefault(departure, 0) - 1);
		}
		
		//Sort the map to have all the events in ascending order
		Map<Integer, Integer> sortedEvents = new TreeMap<>(events);
		
		int count = 0;
		
		for(Map.Entry<Integer, Integer> entry : sortedEvents.entrySet()) {
			count += entry.getValue();
			
			//If the count exceeds k, return false
			if(count > k) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] arrivals = {1, 2, 5};
		int [] departures = {2, 6, 10};
		int k = 1;
		
		boolean result = hotelBookings(arrivals, departures, k);
		System.out.println(result);
	}
}
