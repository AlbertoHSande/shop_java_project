package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import data.ConnectionDB;
import model.Producto;

/**
 *
 * @author Ruben
 */
public class DAOProducto implements DAOInterface {

	public int insert(Producto p) {
		Connection connection = null;
		int i = 0;
		try {

			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			connection = datasource.getConnection();
			Statement s = connection.createStatement();
			System.out.println(p.getDescripcion());
			String query = "INSERT INTO PRODUCTO(nombre, plataforma, categoria, stock, precio, fecha, descripcion) VALUES ('"
				+ p.getNombre() + "','" + p.getPlataforma() + "','" + p.getCategoria() + "','"+ p.getStock() + "','"  + p.getPrecio() + "','"
					+ p.getFecha() + "','" + p.getDescripcion() + "')";

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

	@Override
	public Object findById(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
