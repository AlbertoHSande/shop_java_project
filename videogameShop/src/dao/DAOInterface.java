package dao;

import java.util.List;
/**
*
* @author Ruben
*/
public interface DAOInterface <T,K>{

	/*interfaz con funciones basicas buscar,listar,borrar,insertar y modificar.*/

	public T findById(K key);

	public  List<T> findAll();

	public int delete(T ov);

	public int insert(T ov);

	public int update(T ov);
}
