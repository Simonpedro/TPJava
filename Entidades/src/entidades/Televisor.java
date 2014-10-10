package entidades;

public class Televisor extends Electrodomestico{
	private float resolucion;
	private boolean tdt;
	
	public Televisor(double precioBase, float peso, Color color,
			Consumo consumo, float resolucion2, boolean tdt2) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = color;
		this.consumo = consumo;
		this.resolucion = resolucion2;
		this.tdt = tdt2;
	}
	public Televisor() {}
	public float getResolucion() {
		return resolucion;
	}
	public void setResolucion(float resolucion) {
		this.resolucion = resolucion;
	}
	public boolean isTdt() {
		return tdt;
	}
	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	
	public String toString() {
		return "Televisor";
	}
	
	public double precioFinal(Peso_Precio pesoPrecio) {
		double precioFinal = super.precioFinal(pesoPrecio);
		return precioFinal + (this.resolucion>40?(precioFinal/100*30):0) + (this.tdt==true?50:0);
	}
	
}
