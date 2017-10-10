package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import data.ConnectionDB;
import model.Usuario;

public class DAOUsuario implements DAOInterface {

	public int insert(Usuario u) {
		Connection con = null;
		int i = 0;
		try {
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			con = datasource.getConnection();
			
			PreparedStatement s = con.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?,?,?)");

	        s.setString(1, u.getNombre());
	        s.setString(2, u.getApellidos());
	        s.setString(3, u.getDni());
	        s.setString(4, u.getEmail());
	        s.setString(5, u.getNick());
	        s.setString(6, u.getPsswd());
	        s.setBoolean(7, u.isIsadmin());

	        i=s.executeUpdate();

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
