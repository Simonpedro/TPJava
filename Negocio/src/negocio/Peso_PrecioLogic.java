package negocio;

import java.util.ArrayList;

import datos.PesoPorPrecioAdapter;
import entidades.Peso_Precio;

public class Peso_PrecioLogic {
	PesoPorPrecioAdapter pesoPrecioAdapter;
	
	public Peso_PrecioLogic() {
		this.pesoPrecioAdapter = new PesoPorPrecioAdapter();
	}
	
	public void save(Peso_Precio pesoPrecio) {
		this.pesoPrecioAdapter.save(pesoPrecio);
	}
	
	public ArrayList<Peso_Precio> getAll() {
		return this.pesoPrecioAdapter.getAll();
	}
}
