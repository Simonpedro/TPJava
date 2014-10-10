package negocio;

import java.util.ArrayList;

import datos.ElectrodomesticoAdapter;
import entidades.Electrodomestico;

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
}
