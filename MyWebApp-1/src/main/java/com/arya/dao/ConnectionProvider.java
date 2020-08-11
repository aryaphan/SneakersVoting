package com.arya.dao;

import java.beans.Statement;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

import org.omg.CORBA.portable.InputStream;

import com.arya.model.Sneaker;

public class ConnectionProvider {
	private static Connection con = null;
	
	public static Connection getConnection() {
		if(con != null)
			return con;
		else {
			try {
				String driver = "com.mysql.cj.jdbc.Driver";
				String databaseURL = "jdbc:mysql://localhost:3306/images";
				String user = "root";
				String password = "??";
				
				Class.forName(driver);
				con = DriverManager.getConnection(databaseURL, user, password);	
			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (SQLException sqe) {
				System.out.println(sqe);
			}
			return con;
		}
	}
}


//	String databaseURL = "jdbc:mysql://localhost:3306/images";
//	String user = "root";
//	String password = "??";
//	Integer image_id = ThreadLocalRandom.current().nextInt(1,15);
//	
//	public Sneaker get(int id) throws SQLException, IOException{
//		Sneaker sneaker = null;
//		String sql = "SELECT * FROM sneakers WHERE image_id=" + image_id;
//		
//		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)){
//			Statement statement = (Statement) connection.createStatement();
//			//statement.setInt(1, id);
//			ResultSet result = ((java.sql.Statement) statement).executeQuery(sql);
//			
//			if (result.next()) {
//				sneaker = new Sneaker();
//				String name = result.getString("name");
//				System.out.println(image_id);
//				Blob blob = result.getBlob("image");
				
//				InputStream inputStream = (InputStream) blob.getBinaryStream();
//				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//				byte[] buffer = new byte[4096];
//				int bytesRead = -1;
//				
//				while ((bytesRead = inputStream.read(buffer)) != -1) {
//					outputStream.write(buffer, 0, bytesRead);
//				}
//				
//				byte[] imageBytes = outputStream.toByteArray();
//				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//				
//				inputStream.close();
//				outputStream.close();
//				
//				sneaker.setName(name);
//				sneaker.setBase64Image(base64Image);
				
				
				
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw ex;
//		}
//		return sneaker;
//		
//	}
//}

