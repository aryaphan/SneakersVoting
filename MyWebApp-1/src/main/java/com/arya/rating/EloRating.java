package com.arya.rating;


public class EloRating {
	
	/*
	 * Calculates new Elo ratings of two pair sneakers
	 * 
	 * @param: prevRatingA previous rating of sneaker A, is not null. prevRatingA >= 0
	 * @param: prevRatingB previous rating of sneaker B, is not null. prevRatingB >= 0
	 * @param: win true if sneaker A wins, otherwise false
	 * 
	 * @return: an array with length 2 whose elements represent the new ratings of sneakers A and B. The
	 * 			first element is sneaker A's rating, and the second element is sneaker B's rating
	 * 
	 * */
	public static int[] getNewRating(int prevRatingA, int prevRatingB, boolean win) {
		int result[] = new int[2];
		double expectedA = 0;
		double expectedB = 0;
		int outA, outB;
		
		//If A wins
		if(win) {
			outA = 1;
			outB = 0;
		}
		
		//if B wins
		else {  
			outA = 0;
			outB = 1;
		}
		
		//expected results. Formula is from https://en.wikipedia.org/wiki/Elo_rating_system
		expectedA = 1/(1+(Math.pow(10.0, (prevRatingB - prevRatingA) / 400.0)));
		expectedB = 1/(1+(Math.pow(10.0, (prevRatingA - prevRatingB) / 400.0)));
		
		result[0] = (int) Math.round((prevRatingA + 15 * (outA - expectedA)));
		result[1] = (int) Math.round((prevRatingA + 15 * (outB - expectedB)));
		
		return result;
	}
}
