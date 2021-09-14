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

/*import org.omg.CORBA.portable.InputStream;*/

import com.arya.model.Sneaker;

public class ConnectionProvider {
	private static Connection con = null;
	
	public static Connection getConnection() {
		if(con != null)
			return con;
		else {
			try {
				String driver = "com.mysql.cj.jdbc.Driver";
				String dbName = System.getProperty("RDS_DB_NAME");
				String user = System.getProperty("RDS_USERNAME");
				String password = System.getProperty("RDS_PASSWORD");
				String hostname = System.getProperty("RDS_HOSTNAME");
				String port = System.getProperty("RDS_PORT");
				String databaseURL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;

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


