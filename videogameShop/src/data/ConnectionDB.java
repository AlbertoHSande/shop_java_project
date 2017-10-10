package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class ConnectionDB {
	
	/*Connection con = null;
	String DB = null;
	String driverURL = "jdbc:mysql:///" + DB;
	String user = "root";
	String pass = "root";*/
	
	private BasicDataSource pool;
	private static ConnectionDB instancia = null;

	private ConnectionDB ()
	{
		pool = new BasicDataSource();
		pool.setDriverClassName("com.mysql.jdbc.Driver");
		pool.setUsername("root");
		pool.setPassword("1111");
		pool.setUrl("jdbc:mysql://localhost/videogameshop");
		pool.setInitialSize(40); 

	}
	
	public static ConnectionDB getInstancia()
	{
		if (instancia == null)
			instancia = new ConnectionDB();

		return instancia;
	}

	public BasicDataSource getPool() {
		return pool;
	}
	
	/*public ConnectionDB(){
		
		con = null;
		DB = null;
		driverURL = "jdbc:mysql:///" + DB;
		user = "root";
		pass = "root";
	}
	
	public void Connection (String DB) {
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
	}*/
	
}
