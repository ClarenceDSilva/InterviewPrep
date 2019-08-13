package com.neu.learn;

import java.util.ArrayList;
import java.util.Collections;
//Demonstrating Comparator interface for comparing the ratings of movies.
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		ArrayList<ComparableDemo> movieList = new ArrayList<ComparableDemo>();
		movieList.add(new ComparableDemo("Star Wars:The Force Awakens", 8.3, 2015));
		movieList.add(new ComparableDemo("Andaaz apna apna", 9.4, 1994));
		movieList.add(new ComparableDemo("Inception", 9.8, 2010));
		movieList.add(new ComparableDemo("When Harry met Sally", 8.2, 1989));

		// Sort by rating : (1) Create an object of ratingCompare
		// (2) Call Collections.sort
		// (3) Print Sorted list
		System.out.println("Sort by rating");
		RatingCompare rating = new RatingCompare();
		Collections.sort(movieList, rating);
		for(ComparableDemo movie: movieList) {
			 System.out.println(movie.getRating() + " " + 
                     movie.getName() + " " + 
                     movie.getYear());
		}
	}
	 }
	class RatingCompare implements Comparator<ComparableDemo> {
		// Class to compare Movies by ratings
		public int compare(ComparableDemo m1, ComparableDemo m2) {
			if (m1.getRating() < m2.getRating())
				return -1;
			if (m1.getRating() > m2.getRating())
				return 1;
			else
				return 0;
		}
	}

	// Class to compare movies by name
	class NameCompare implements Comparator<ComparableDemo> {
		public int compare(ComparableDemo m1, ComparableDemo m2) {
			return m1.getName().compareTo(m2.getName());
		}
	}
