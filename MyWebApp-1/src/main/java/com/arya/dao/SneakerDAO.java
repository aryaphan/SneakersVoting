package com.arya.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@Service
public class SneakerDAO implements GetSneakers {
	//private Connection conn;
	private JdbcTemplate jdbcTemp;
	
//	public SneakerDAO() {
//		conn = ConnectionProvider.getConnection();
//	}
	
	public SneakerDAO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		jdbcTemp = new JdbcTemplate(dataSource);
		System.out.println("database connected");
	}
	
	public List<Sneaker> getAllSneakers(){ //throws IOException {
		System.out.println("Retrieving data");
		
		List<Sneaker> sneakers = jdbcTemp.query("select * from sneakers", new RowMapper<Sneaker>() {
			@Override
			public Sneaker mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sneaker sneaker = new Sneaker();
				sneaker.setId(rs.getInt("image_id"));
				sneaker.setName(rs.getString("name"));
				sneaker.setScore(rs.getInt("score"));
				
				return sneaker;
			}
		});
		return sneakers;

	}
	
	@Override
	public Blob getPhotoById(int id) {
		String query = "select image from sneakers where image_id=?";
		Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);
		System.out.println("image retrieved");
		return photo;
	}
	
}
