package com.neu.learn;

/*Hackerrank Question: University Career Fair
 * 
 *Problem Desc:A team organizing a university career fair has a list of companies
 *along with their respective arrival times and their duration of stay. 
 *Only one company can present at any time. Given each company's arrival time 
 *and the duration they will stay, determine the maximum number of presentations 
 *that can be hosted during the career fair.
 *
 *	Example
	n = 5
	arrival = [1, 3, 3, 5, 7]
	duration = [2, 2, 1, 2, 1] 
 *	The first company arrives at time 1 and stays for 2 hours. At time 3, two companies 
 *  arrive, but only 1 can stay for either 1 or 2 hours. The next companies arrive at 
 *  times 5 and 7 and do not conflict with any others. In total, there can be a maximum 
 *  of 4 promotional events. 
 * 
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class UniversityCareerFair {
	public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int[][] events = new int[arrival.size()][2];
        for(int i = 0; i < arrival.size(); i++){
            events[i] = new int[]{arrival.get(i), arrival.get(i) + duration.get(i)};
        }
        //Sorting the events in ascending order of their duration time
        Arrays.sort(events, (a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int[] first = events[0];
        for(int i = 1; i < events.length; i++){
            int[] curr = events[i];
            if(curr[0] < first[1]){
                minHeap.offer(curr);
            }else{
                first[1] = events[i][1];
            }
        }
        return arrival.size() - minHeap.size();
    }

	public static void main(String[] args) {
		List<Integer> arrival = new ArrayList<>();
		arrival.add(1);
		arrival.add(1);
		arrival.add(1);
		arrival.add(1);
		arrival.add(4);
		
		List<Integer> duration = new ArrayList<>();
		duration.add(10);
		duration.add(3);
		duration.add(6);
		duration.add(4);
		duration.add(2);
		
		int result = maxEvents(arrival, duration);
		System.out.println(result);
	}
}
