package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import data.ConnectionDB;
import model.Producto;

/**
 *
 * @author Ruben
 */
public class DAOProducto implements DAOInterface<Producto,String>{

	public int insert(Producto p) {
		Connection connection = null;
		int i = 0;
		try {

			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			connection = datasource.getConnection();
			Statement s = connection.createStatement();

			String query = "INSERT INTO PRODUCTO(nombre, plataforma, categoria, stock, precio, fecha, descripcion) VALUES ('"
					+ p.getNombre() + "','" + p.getPlataforma() + "','" + p.getCategoria() + "','" + p.getStock()
					+ "','" + p.getPrecio() + "','" + p.getFecha() + "','" + p.getDescripcion() + "')";

			i = s.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return i;
	}

	public Producto findById(String id)
	{
		Connection conexion = null;
		Producto p = null;
		try
		{
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			conexion = datasource.getConnection();
			
				
			String query = "select * from producto where idProducto = ?" ;
			
			PreparedStatement s = conexion.prepareStatement(query);
	    
			s.setString(1,id);
	    
			ResultSet result = s.executeQuery ();
	    
			if (result.next())
			{
				p = new Producto();
				p.setId_producto(result.getInt(1));
				p.setNombre(result.getString(2));
				p.setPlataforma(result.getString(3));
				p.setCategoria(result.getString(4));
				p.setStock(result.getInt(5));
				p.setPrecio(result.getFloat(6));
				p.setFecha(result.getString(7));
				p.setDescripcion(result.getString(8));
			}
	        conexion.close();
			
		}
		
		
		catch (Exception ex)
		{
			System.out.println ("Error"+ex.getMessage());
		}


		return p;
	}
	
	public Vector<Producto> findAll(){
		
		Connection connection=null;
		Vector <Producto>productos;
		productos=new Vector<Producto>();
		
		try{

			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			connection = datasource.getConnection();
			Statement s = connection.createStatement();

			String query="SELECT * FROM PRODUCTO";
			
			ResultSet result=s.executeQuery(query);

			Producto p;
			
			while(result.next()){
				p=new Producto();
				p.setId_producto(result.getInt(1));
				p.setNombre(result.getString(2));
				p.setPlataforma(result.getString(3));
				p.setCategoria(result.getString(4));
				p.setStock(result.getInt(5));
				p.setPrecio(result.getFloat(6));
				p.setFecha(result.getString(7));
				p.setDescripcion(result.getString(8));
				productos.addElement(p);
				
			}
		}catch(Exception e){
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
		return productos;
	}

	public int delete(Producto p){
		Connection connection=null;
		int i=-1;
		try{
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			connection = datasource.getConnection();
			Statement s = connection.createStatement();

			String query="DELETE FROM USUARIO WHERE ID = '" +p.getId_producto()+"'";
		

			i=s.executeUpdate(query);
			
		
		}catch(Exception e){
			System.out.println("error");
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
	public int update(Producto ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
