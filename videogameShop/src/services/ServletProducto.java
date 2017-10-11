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
		//String opera = request.getParameter("id");
		System.out.println("LLEGO AL Method");
		try {
			String operation = request.getParameter("operacion");
			DAOProducto dao = new DAOProducto();
			//Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				Producto p = getDatos(request);
				dao.insert(p);
				System.out.println("He introducido datos en la base " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("modificar")) {
				//dao.update(p);
			//	System.out.println("He modificado el producto " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("baja")) {
				dao.delete(Integer.parseInt(request.getParameter("id")));
				System.out.println("He eliminado el producto ");
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
		
		
		
		/*
		try {
			String operation = request.getParameter("operacion");
			DAOProducto dao = new DAOProducto();
			Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				dao.insert(p);
				System.out.println("He introducido datos en la base " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("modificar")) {
				dao.update(p);
				System.out.println("He modificado el producto " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("baja")) {
				System.out.println("Toi en baja");
				dao.delete(Integer.parseInt(request.getParameter("id")));
				System.out.println("He eliminado el producto " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
	*/
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
		sProducto(request,response);
		
		
		/*
		String opera = request.getParameter("id");
		System.out.println("LLEGO AL POST "+opera);
		try {
			String operation = request.getParameter("operacion");
			DAOProducto dao = new DAOProducto();
			//Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				
				Producto p = getDatos(request);
				dao.insert(p);
				System.out.println("He introducido datos en la base " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("modificar")) {
				//dao.update(p);
			//	System.out.println("He modificado el producto " + p.getNombre());
				//response.sendRedirect("productos.html?listado");
			}
			else if(operation.equals("baja")) {
				dao.delete(Integer.parseInt(request.getParameter("id")));
				System.out.println("He eliminado el producto ");
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}*/
		
		
		
	}
}
