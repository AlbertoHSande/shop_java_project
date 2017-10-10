package model;

import java.util.Date;

public class Producto {

	private int id_producto;
	private String nombre;
	private String plataforma;
	private String categoria;
	private int stock;
	private float precio;
	private String fecha;
	private String descripcion;

	public Producto() {

	}

	public Producto(int id, String nom, String plat, String cat, int stock, float pre, String fe, String desc) {
		this.id_producto = id;
		this.nombre = nom;
		this.plataforma = plat;
		this.categoria = cat;
		this.stock = stock;
		this.precio = pre;
		this.fecha = fe;
		this.descripcion = desc;
	}

	public void setId_producto(int id) {
		this.id_producto = id;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setNombre(String nom) {
		this.nombre = nom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setPlataforma(String plat) {
		this.plataforma = plat;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setCategoria(String cat) {
		this.categoria = cat;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setPrecio(float pre) {
		this.precio = pre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setFecha(String fe) {
		this.fecha = fe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", plataforma=" + plataforma
				+ ", categoria=" + categoria + ", stock=" + stock + ", precio=" + precio + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id_producto;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_producto != other.id_producto)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

}
