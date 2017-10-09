package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
*
* @author Ruben
*/
public class DAOProducto implements DAOInterface{
	
	//falta clase producto
	
	//funcion para insertar productos en la tabla 
	public int insert(Producto p){
		Connection connection = null;
		int i=0;
		try
		{
			
			//faltaria crear el pool para poder conectar con la base de gatos
			PoolConexiones pool = PoolConexiones.getInstancia();
			BasicDataSource datasource = pool.getPool(); 
			connection = datasource.getConnection();
			Statement s = connection.createStatement();

			String query = "INSERT INTO PRODUCTO(idproducto, nombre, plataforma, categoria, stock, precio, fecha, descripcion) VALUES ('" + p.getIdProducto() + "',"+ "'"+ p.getNombre() + "'," + p.getPlataforma() + "'," + p.getCategoria()+ "'," + p.getPrecio()+ "'," + p.getFecha()+ "'," + p.getDescripcion()+")";
			

			i=s.executeUpdate(query);

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
	
	
}
