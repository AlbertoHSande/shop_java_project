package services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOInterface;
import dao.DAOProducto;

import model.Producto;

//@WebServlet("/servlet_producto")
//ServletRecuperado

public class ServletProducto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void sProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String operation = request.getParameter("operacion");
			DAOProducto dao = new DAOProducto();
			Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				dao.insert(p);
				System.out.println("He introducido datos en la base");
				//response.sendRedirect("productos.html?listado");
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}

	}
	
	public Producto getDatos(HttpServletRequest request) throws ParseException {
		Producto p = new Producto();
		p.setNombre(request.getParameter("nombre"));
		p.setPlataforma(request.getParameter("plataforma"));
		p.setCategoria(request.getParameter("categoria"));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		p.setPrecio(Float.parseFloat(request.getParameter("precio")));
		// revisar formato con el que envía el form
		//String dateTarget = request.getParameter("fecha");
		//DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		p.setFecha(request.getParameter("fecha"));
		p.setDescripcion(request.getParameter("descripcion"));
		return p;
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sProducto(request, response);
	}
}
