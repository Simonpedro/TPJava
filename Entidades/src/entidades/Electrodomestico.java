package entidades;

public class Electrodomestico {
	
	protected int idElectrodomestico;
	protected double precioBase;
	protected float peso;
	protected String descripcion;
	protected Color color;
	protected Consumo consumo;
	
	public int getIdElectrodomestico() {
		return idElectrodomestico;
	}
	public void setIdElectrodomestico(int idElectrodomestico) {
		this.idElectrodomestico = idElectrodomestico;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	
	public double precioFinal(Peso_Precio pesoPrecio) {
		return this.precioBase+this.consumo.getPrecio()+pesoPrecio.getPrecio();
	}
	
}
