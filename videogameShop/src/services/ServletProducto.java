package services;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOInterface;
import dao.DAOProducto;

@WebServlet("/producto")

public class ServletProducto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void sProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String operation = request.getParameter("operation");
			DAOInterface dao = new DAOProducto();
			Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				dao.insert(p);
				response.sendRedirect("productos.html?listado");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}

	}
	
	public Producto getDatos(HttpServletRequest request) {
		Producto p = new Producto();
		p.setNombre = request.getParameter("nombre");
		p.setPlataforma = request.getParameter("plataforma");
		p.setCategoria = request.getParameter("categoria");
		p.setStock = Integer.parseInt(request.getParameter("stock"));
		p.setPrecio = Integer.parseInt(request.getParameter("precio"));
		// revisar formato con el que envía el form
		String dateTarget = request.getParameter("fecha");
		DateFormat df = new SimpleDateFormat("");
		p.setFecha = df.parse(df);
		p.setDescripcion = request.getParameter("descripcion");
		return p;
	}

}
