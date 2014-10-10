package entidades;

public class Lavarropas extends Electrodomestico{
	private float carga;

	public Lavarropas(double precioBase, float peso, Color color,
			Consumo consumo, float carga2) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = color;
		this.consumo = consumo;
		this.carga = carga2;
	}

	public Lavarropas() {
		// TODO Auto-generated constructor stub
	}

	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}
	
	public String toString() {
		return "Lavarropas";
	}
	
	public double precioFinal(Peso_Precio pesoPrecio){
		return super.precioFinal(pesoPrecio) + (this.carga>30?50:0);
	}
		
}
