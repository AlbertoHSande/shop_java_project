package model;

public class LineaCompra {
	
	private String id;
	private String idcompra;
	private int cantidad;
	private float subtotal;
	
	public LineaCompra(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdcompra() {
		return idcompra;
	}

	public void setIdcompra(String idcompra) {
		this.idcompra = idcompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
