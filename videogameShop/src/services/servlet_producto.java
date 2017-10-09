package services;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOInterface;

@WebServlet("/producto")

public class servlet_producto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6251665846157031729L;

	public void sProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String operation = request.getParameter("operation");
			DAOInterface dao = new DAOProducto();
			
			if(operation.equals("alta")) {
				dao.insert(request);
				response.sendRedirect("productos.html?listado");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}

	}

}
