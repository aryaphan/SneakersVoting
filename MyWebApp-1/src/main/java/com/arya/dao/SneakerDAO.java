package com.arya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arya.model.Sneaker;

public class SneakerDAO {
	private Connection conn;
	
	public SneakerDAO() {
		conn = ConnectionProvider.getConnection();
	}
	
	public List<Sneaker> getAllSneakers() {
		List<Sneaker> sneakers = new ArrayList<Sneaker>();
		try {
			String sql = "select * from sneakers";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Sneaker sneaker = new Sneaker();
				sneaker.setId(result.getInt("image_id"));
				sneaker.setName(result.getString("name"));
				sneaker.setScore(result.getInt("score"));
				sneakers.add(sneaker);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sneakers;
	}
}
