package com.arya.rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arya.dbconnection.ConnectionProvider;
import com.arya.model.Sneaker;

import java.util.ArrayList;
import java.util.List;

/*
 * Handles and updates ratings of two pair of sneakers after one round of voting
 * 
 * */
public class RatingHandler {
	
	/*
	 * Gets new ratings of two pair of sneakers and updates their ratings in the database
	 * 
	 * @param id1 the identifier of sneakers A, is not null. id1 >= 1 and id1 != id2
	 * @param id2 the identifier of sneakers B, is not null. id2 >= 1 and id2 != id1
	 * @param result true if sneakers A win, otherwise false
	 * 
	 * */
	public static void getNewRating(int id1, int id2, boolean result) {
		int prevRatingA = getOldRating(id1);
		int prevRatingB = getOldRating(id2);
		
		int newRatings[] = EloRating.getNewRating(prevRatingA, prevRatingB, result);
		int newRatingA = newRatings[0];
		int newRatingB = newRatings[1];
		
		updateRating(id1, newRatingA);
		updateRating(id2, newRatingB);
		System.out.println("getting new rating");
	}
	
	/*
	 * Returns a list of all sneakers that are sorted based on their scores in descending order in the database
	 * 
	 * @return: a list of all sneakers that are sorted based on scores in descending order
	 * */
	public static List<Sneaker> getRanking() {
		ArrayList<Sneaker> sneakerList = new ArrayList<Sneaker>();
		
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("select * from sneakers order by score desc");
			ResultSet result = statement.executeQuery();
			Sneaker sneaker = null;
			
			
			while(result.next()) {
				sneaker = new Sneaker();
				sneaker.setId(result.getInt("image_id"));
				sneaker.setName(result.getString("name"));
				sneaker.setScore(result.getInt("score"));
				sneakerList.add(sneaker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sneakerList;
		
	}
	
	/*
	 * Gets the current rating (before voting) in MySQL database of a pair of sneakers
	 * 
	 * @param: id the identifier of the sneakers, is not null. id >= 1
	 * @return: the current rating (before voting) of the sneakers
	 * 
	 * */
	private static int getOldRating(int id) {
		Connection con = ConnectionProvider.getConnection();
		int score = 0;
		
		try {
			
			PreparedStatement statement = con.prepareStatement("select score from sneakers where image_id=?");
			System.out.println("getting old rating");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				score = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return score;
		
	}
	
	/*
	 * Updates the rating of a pair of sneakers in the database
	 * 
	 * @param: id the identifier of the sneakers, is not null. id >= 1
	 * @param newRating the new rating of the sneakers, is not null. newRating >= 0
	 * 
	 * */
	private static void updateRating(int id, int newRating) {
		Connection con = ConnectionProvider.getConnection();
		
		try {
			
			PreparedStatement statement = con.prepareStatement("update sneakers set score=? where image_id=?");
			System.out.println("updating rating");
			statement.setInt(1, newRating);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}




