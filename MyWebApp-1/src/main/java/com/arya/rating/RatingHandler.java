package com.arya.rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arya.dbconnection.ConnectionProvider;

public class RatingHandler {
	public static int getOldRating(int id) {
		Connection con = ConnectionProvider.getConnection();
		int votes = 0;
		
		try {
			PreparedStatement statement = con.prepareStatement("select score from sneakers where image_id=?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				votes = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return votes;
		
	}
	
	public static void updateRating(int id, int newRating) {
		Connection con = ConnectionProvider.getConnection();
		
		try {
			PreparedStatement statement = con.prepareStatement("update score set score=? where image_id=?");
			statement.setInt(1, newRating);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getNewRating(int id1, int id2, boolean result) {
		//result = true if sneaker 1 wins, otherwise, false
		int prevRatingA = getOldRating(id1);
		int prevRatingB = getOldRating(id2);
		
		int newRatings[] = EloRating.getNewRating(prevRatingA, prevRatingB, result);
		int newRatingA = newRatings[0];
		int newRatingB = newRatings[1];
		
		updateRating(id1, newRatingA);
		updateRating(id2, newRatingB);
	}
}




