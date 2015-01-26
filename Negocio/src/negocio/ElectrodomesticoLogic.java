package negocio;

import java.util.ArrayList;

import datos.ElectrodomesticoAdapter;
import entidades.Electrodomestico;
import entidades.Peso_Precio;

public class ElectrodomesticoLogic extends NegocioLogic{
	private ElectrodomesticoAdapter daoElectrodometico;
	
	public ElectrodomesticoLogic() {
		daoElectrodometico = new ElectrodomesticoAdapter();
	}
	
	public ArrayList<Electrodomestico> getAll() {
		return this.daoElectrodometico.getAll();
	}
	
	public void save(Electrodomestico elec) {
		this.daoElectrodometico.save(elec);
	}
	
	public void delete(int idElec){
		this.daoElectrodometico.delete(idElec);
	}
	
	public void update(int idElec, Electrodomestico elec) { // Le paso los datos a modificar en un objeto electrodomestico
		this.daoElectrodometico.update(idElec, elec);
	}

	public ArrayList<Electrodomestico> getAll(String letraConsumo,
			double precioDesde, double precioHasta) {
		ArrayList<Electrodomestico> auxElecs = this.getAll();
		ArrayList<Electrodomestico> elecs = new ArrayList<Electrodomestico>();
		
		Peso_PrecioLogic ppl = new Peso_PrecioLogic();
		for (Electrodomestico elec : auxElecs) {
			Peso_Precio pp = ppl.encuentraPesoPrecio(elec.getPeso());
			if (this.cumpleCondiciones(elec, pp, letraConsumo, precioDesde, precioHasta)) {
				elecs.add(elec);
			}
		}
		return elecs;
	}

	private boolean cumpleCondiciones(Electrodomestico elec, Peso_Precio pp, String letraConsumo, double precioDesde, double precioHasta) {
		if ( (letraConsumo.equalsIgnoreCase("All") || letraConsumo.equalsIgnoreCase(Character.toString(elec.getConsumo().getLetraConsumo()))) && (elec.precioFinal(pp) >= precioDesde && elec.precioFinal(pp) <= precioHasta ) ) 
		{
			return true;
		}
		else return false;
	}

	public Electrodomestico getOne(int idElec) {

		ArrayList<Electrodomestico> elecs = this.getAll();
		Electrodomestico electrodomestico= null;
		for (Electrodomestico elec : elecs) {
			if (elec.getIdElectrodomestico() == idElec) {
				electrodomestico = elec;
				break;
			}
		}
		return electrodomestico;
	}
}
