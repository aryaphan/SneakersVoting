package com.arya.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.io.InputStream;

import com.arya.dbconnection.ConnectionProvider;
import com.arya.model.Sneaker;

/*
 * Connects to MySQL database once the app is launched
 * */
@Service
public class SneakerDAO implements GetSneakers {
	
//	private JdbcTemplate jdbcTemp;
	private Connection conn;
	
	/*
	 * Connects to MySQL database
	 * */
//	public SneakerDAO(DataSource dataSource) {
//		// TODO Auto-generated constructor stub
//
//		//dataSource comes from Config.java
//		jdbcTemp = new JdbcTemplate(dataSource);
//		System.out.println("database connected");
//	}
	public SneakerDAO() {
		conn = ConnectionProvider.getConnection();
	}
	
	/*
	 * Returns the list of all sneakers in the database
	 * */
	public List<Sneaker> getAllSneakers(){
		System.out.println("Retrieving data");

		List<Sneaker> sneakers = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("select * from sneakers");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Sneaker sneaker = new Sneaker();
				sneaker.setId(rs.getInt("image_id"));
				sneaker.setName(rs.getString("name"));
				sneaker.setScore((rs.getInt("score")));
				sneakers.add(sneaker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		List<Sneaker> sneakers = jdbcTemp.query("select * from sneakers", new RowMapper<Sneaker>() {
//			@Override
//			public Sneaker mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Sneaker sneaker = new Sneaker();
//				sneaker.setId(rs.getInt("image_id"));
//				sneaker.setName(rs.getString("name"));
//				sneaker.setScore(rs.getInt("score"));
//
//				return sneaker;
//			}
//		});
		return sneakers;

	}
	
	/*
	 * Returns an image that matches <code>id</code> in MySQL database
	 * 
	 * @param id: identifier of the image to be displayed
	 * @return: the image that matches <code>id</code> in MySQL database in type Blob
	 * */
	@Override
	public Blob getPhotoById(int id) {
		String query = String.format("select image from sneakers where image_id=%d", id);
		ResultSet rs = null;
		Blob photo = null;
		try {
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			rs.next();
			photo = rs.getBlob("image");

		} catch (SQLException e) {
			e.printStackTrace();
		}
//		Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);
		System.out.println("image retrieved");
		return photo;
	}
	
}
