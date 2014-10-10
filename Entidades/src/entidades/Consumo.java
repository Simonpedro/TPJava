package entidades;

public class Consumo {
	private int idConsumo;
	private char letraConsumo;
	private double precio;
	public int getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}
	public char getLetraConsumo() {
		return letraConsumo;
	}
	public void setLetraConsumo(char letraConsumo) {
		this.letraConsumo = letraConsumo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Consumo(int id, char letra, double precio) {
		this.idConsumo = id;
		this.letraConsumo = letra;
		this.precio = precio;
	}
	
	public String toString() {
		return Character.toString(this.getLetraConsumo());
	}
	
}
