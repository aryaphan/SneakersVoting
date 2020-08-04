package com.arya.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.omg.CORBA.portable.InputStream;

import com.arya.model.Sneaker;

public class SneakerDAO {
	String databaseURL = "jdbc:mysql://localhost:3306/images";
	String user = "root";
	String password = "??";
	
	public Sneaker get(int id) throws SQLException, IOException{
		Sneaker sneaker = null;
		String sql = "SELECT * FROM sneakers WHERE image_id = ?";
		
		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)){
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				sneaker = new Sneaker();
				String name = result.getString("name");
				Blob blob = result.getBlob("image");
				
				InputStream inputStream = (InputStream) blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				inputStream.close();
				outputStream.close();
				
				sneaker.setName(name);
				sneaker.setBase64Image(base64Image);
				
				
				
			}
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return sneaker;
		
	}
}

