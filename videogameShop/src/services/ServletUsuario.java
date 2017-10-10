package services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOInterface;
import dao.DAOProducto;
import model.Producto;
import model.Usuario;

/**
 * Servlet implementation class servlet_usuario
 */
@WebServlet("/usuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void sUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String operation = request.getParameter("operation");
			DAOInterface dao = new DAOUsuario();
			
			if(operation.equals("alta")) {
				dao.insert(request);
				response.sendRedirect("usuarios.html?listado");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}

	}
	public Usuario getDatos(HttpServletRequest request) throws ParseException {
		Usuario u = new Usuario();
		u.setNombre( request.getParameter("nombre"));
		u.setApellidos(request.getParameter("apellidos"));
		u.setDni(request.getParameter("DNI"));
		u.setEmail(request.getParameter("stock"));
		u.setNick(request.getParameter("username"));
		u.setPsswd(request.getParameter("descripcion"));
		return u;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sUsuario(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sUsuario(request, response);
	}

}
