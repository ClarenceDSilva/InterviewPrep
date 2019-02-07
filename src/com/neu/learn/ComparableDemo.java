package com.neu.learn;

//Demonstrating Comparable interface for comparing movies based on their year.
import java.util.*;
public class ComparableDemo implements Comparable<ComparableDemo> {
	
	private double rating;
	private String name;
	private int year;
	
	// Used to sort movies by year 
	@Override
	public int compareTo(ComparableDemo m) {
		return this.year - m.year;
	}
	
	//Constructor
	public ComparableDemo(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}
	

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
		public static void main(String[] args) {
			ArrayList<ComparableDemo> movieList = new ArrayList<ComparableDemo>();
			movieList.add(new ComparableDemo("Star Wars:The Force Awakens", 8.3, 2015));
			movieList.add(new ComparableDemo("Andaaz apna apna", 9.4, 1994));
			movieList.add(new ComparableDemo("Inception", 9.8, 2010));
			movieList.add(new ComparableDemo("When Harry met Sally", 8.2, 1989));
			
			Collections.sort(movieList);
			System.out.println("Movies after sorting according to year:"); 
			for (ComparableDemo movie : movieList) {
				System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
			}
			
		}
	}



