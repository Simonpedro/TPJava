package entidades;

public class Peso_Precio {
	private int idPesoPrecio;
	private float pesoDesde;
	private float pesoHasta;
	private double precio;
	public int getIdPesoPrecio() {
		return idPesoPrecio;
	}
	public void setIdPesoPrecio(int idPesoPrecio) {
		this.idPesoPrecio = idPesoPrecio;
	}
	public float getPesoDesde() {
		return pesoDesde;
	}
	public void setPesoDesde(float pesoDesde) {
		this.pesoDesde = pesoDesde;
	}
	public float getPesoHasta() {
		return pesoHasta;
	}
	public void setPesoHasta(float pesoHasta) {
		this.pesoHasta = pesoHasta;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
