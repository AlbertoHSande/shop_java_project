package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	Connection con = null;
	String DB = null;
	String driverURL = "jdbc:mysql:///" + DB;
	String user = "root";
	String pass = "root";
	
	public ConnectionDB(String DB) {
		try {
			con = DriverManager.getConnection(driverURL, user, DB);
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Codigo del error: " + e.getErrorCode());
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
}
