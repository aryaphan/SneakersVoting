package com.arya.dbconnection;

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
				String password = "////";
				
				Class.forName(driver);
				con = DriverManager.getConnection(databaseURL, user, password);	
				System.out.println("connected");
			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (SQLException sqe) {
				System.out.println(sqe);
			}
			return con;
		}
	}
}


