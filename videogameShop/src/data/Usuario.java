package clases;
/**
*
* @author Ruben
*/
public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String nick;
	private String psswd;
	private boolean isadmin;
	
	
	public Usuario(){
		
		nombre="";
		apellidos="";
		dni="";
		email="";
		nick="";
		psswd="";
		isadmin=false;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPsswd() {
		return psswd;
	}

	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	
	public boolean isIsadmin() {
		return isadmin;
	}
	
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
}
