package com.arya.rating;

public class EloRating {
	public static int[] getNewRating(int prevRatingA, int prevRatingB, boolean win) {
		int result[] = new int[2];
		double probA = 0;
		double probB = 0;
		int outA, outB;
		
		//If A wins
		if(win) {
			outA = 1;
			outB = 0;
		}
		
		else {   //if B wins
			outA = 0;
			outB = 1;
		}
		
		probA = 1/(1+(Math.pow(10.0, (prevRatingB - prevRatingA) / 400.0)));
		probB = 1/(1+(Math.pow(10.0, (prevRatingA - prevRatingB) / 400.0)));
		
		result[0] = (int) Math.round((prevRatingA + 15 * (outA - probA)));
		result[1] = (int) Math.round((prevRatingA + 15 * (outB - probB)));
		
		return result;
	}
}
