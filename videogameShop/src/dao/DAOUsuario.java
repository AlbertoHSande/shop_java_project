package dao;

import data.ConnectionDB;
import model.Usuario;

public class DAOUsuario implements DAOInterface {

	public int insert (Usuario u) {
		Connection con = null;
		int i=0;
		try {
			ConnectionDB pool = ConnectionDB.getInstancia();
			BasicDataSource datasource = pool.getPool();
			
		}
	}
}
