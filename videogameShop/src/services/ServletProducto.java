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
import javafx.scene.control.Alert;
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
			//Producto p = getDatos(request);
			
			if(operation.equals("alta")) {
				Producto p = getDatos(request);
				dao.insert(p);
				System.out.println("He introducido datos en la base " + p.getNombre());
				response.sendRedirect("Interface_producto.html");
			}
			else if(operation.equals("modificar")) {
				System.out.println("EL ID ES: "+request.getParameter("id"));
				Producto p = getDatos(request);
				int idp = Integer.parseInt(request.getParameter("id"));
				p.setId_producto(idp);
				dao.update(p);
				response.sendRedirect("Crud_Producto.jsp");
			}
			else if(operation.equals("baja")) {
				Producto p = dao.findById(request.getParameter("id"));
				dao.delete(p);
				response.sendRedirect("index");
				//System.out.println("He eliminado el producto ");
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sProducto(request,response);	
		Producto p = new Producto();
		p.setNombre(request.getParameter("nombre"));
		System.out.println(p.getNombre());
		String operacion;

		        try {

		            // Comprobamos el tipo de accion que se solicita
		            operacion = request.getParameter("operacion");
		            DAOProducto op = new DAOProducto();
		            if (operacion.equals("alta")) {
		                //ALTA
		                op.insert(getDatos(request));
		               // op.insert(getDatos(request));

		               // response.sendRedirect("paises?operacion=listado");
		            }

		            else if (operacion.equals("listar")){
		                System.out.println("Entra detalles");
		                String id = request.getParameter("id");
		                request.setAttribute("producto", op.findById(id));
		                RequestDispatcher view = request.getRequestDispatcher("details.jsp");
		                view.forward(request, response);
		            }



		        }  catch (Exception e) {
		                System.out.println("--------------------  FALLO  -----------------------------");
		                e.printStackTrace();
		                System.out.println("----------------------------------------------------------");
		            }
		}
}
