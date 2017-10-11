package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import data.ConnectionDB;
import model.Producto;
import model.Usuario;

public class DAOUsuario implements DAOInterface<Usuario,String> {

	public int insert(Usuario u) {
		Connection con = null;
		int i = 0;
		try {
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			con = datasource.getConnection();
			Statement s = con.createStatement();

			String query = "INSERT INTO usuario(nombre, apellidos, DNI, email, nick, password, isadmin) VALUES ('"
					+ u.getNombre() + "','" + u.getApellidos() + "','" + u.getDni() + "','" + u.getEmail() + "','"
					+ u.getNick() + "','" + u.getPsswd() + "','" + u.isIsadmin() + "')";

			i = s.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return i;
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Usuario findById(String key) {
		Connection conexion = null;
		Usuario u = null;
		try
		{
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			conexion = datasource.getConnection();
			
				
			String query = "select * from usuario where nick = ?" ;
			
			PreparedStatement s = conexion.prepareStatement(query);
	    
			s.setString(1,key);
	    
			ResultSet result = s.executeQuery ();
	    
			if (result.next())
			{
				u = new Usuario();
				u.setId(result.getInt(1));
				u.setNombre(result.getString(2));
				u.setApellidos(result.getString(3));
				u.setDni(result.getString(4));
				u.setEmail(result.getString(5));
				u.setNick(result.getString(6));
				u.setPsswd(result.getString(7));
				u.setIsadmin(result.getBoolean(8));
			}
	        conexion.close();
		}
		catch (Exception ex)
    	{
    		System.out.println ("Error"+ex.getMessage());
    	}

		return u;
	}

	@Override
	public int delete(Usuario ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario ov) {
		// TODO Auto-generated method stub
		return 0;
	}
}
