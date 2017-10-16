package services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOUsuario;
import model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUsuario dao;
		Usuario usu = new Usuario();
		dao=new DAOUsuario();
		
		//recogemos los parametros
		String id = request.getParameter("nombre");
		String contra= request.getParameter("contra");
		
		//para el html
		ServletOutputStream out;
		out=response.getOutputStream();
		response.setContentType("text/html");
		
		
		usu=(Usuario)dao.findById(id);
		HttpSession sesion=request.getSession(true);
		
		if(usu !=null && usu.getPsswd().equals(contra)){
			
			//TENEMOS QUE AÑADIR A LA SESION COSAS DE USUARIO
			
			out.println("<html>");
			out.println("<body>");
			out.println("usuario validado correctamente");
			out.println("</body>");
			out.println("</html>");
			RequestDispatcher dispatcher;
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("usuario o contraseña incorrectos Prueba otra vez caxo lokoh!!!");
			out.println("</body>");
			out.println("</html>");
			
			RequestDispatcher dispatcher;
			dispatcher=request.getRequestDispatcher("Interface_registrar.html");
			dispatcher.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
