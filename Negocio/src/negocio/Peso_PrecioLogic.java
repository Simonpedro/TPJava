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
	
	public Peso_Precio encuentraPesoPrecio(float peso) {
		Peso_Precio ppCorrespondiente = null;
		ArrayList<Peso_Precio> pesosPrecios = this.getAll();
		for (Peso_Precio pp : pesosPrecios) {
			if (peso>=pp.getPesoDesde() && peso<pp.getPesoHasta()) {
				ppCorrespondiente = pp;
			}
		}
		return ppCorrespondiente;
	}
}
