package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import data.ConnectionDB;
import model.LineaCompra;
import model.Producto;

public class DAOLineaCompra implements DAOInterface<LineaCompra,String> {

	@Override
	public LineaCompra findById(String id) {
		
		LineaCompra l = null;
		
		try
		{
			BasicDataSource basicDataSource = ConnectionDB.getInstancia().getPool();
			Connection conexion = basicDataSource.getConnection();
			
			
			String query = "select * from lineacompra where login = ?" ;
			
			PreparedStatement s = conexion.prepareStatement(query);
	    
			s.setString(1,id);
	    
			ResultSet rs = s.executeQuery ();
	    
			if (rs.next())
			{
				l = new LineaCompra();
				l.setId(rs.getString(1));
				l.setIdcompra(rs.getString(2));
				l.setCantidad(rs.getInt(3));
				l.setSubtotal(rs.getFloat(4));

			}
	        conexion.close();
			
		}catch (Exception ex)
		{
			System.out.println ("Error"+ex.getMessage());
		}


		return l;
	}
	
	public int insert(LineaCompra l){
		Connection connection = null;
		int i=0;
		try
		{
			
			BasicDataSource basicDataSource = ConnectionDB.getInstancia().getPool();
			Connection conexion = basicDataSource.getConnection();
			
			PreparedStatement s = connection.prepareStatement("INSERT INTO lineacompra VALUES (?,?,?,?)");

			s.setString(1, l.getId());
			s.setString(2, l.getIdcompra());
			s.setInt(3, l.getCantidad());
			s.setFloat(4, l.getSubtotal());
			
			i=s.executeUpdate();

		}  
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (connection != null) {

				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return i;
	}

	@Override
	public List<LineaCompra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(LineaCompra ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LineaCompra ov) {
		// TODO Auto-generated method stub
		return 0;
	}




}
