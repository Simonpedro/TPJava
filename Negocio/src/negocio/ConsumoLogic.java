package negocio;

import java.util.ArrayList;

import datos.ConsumoAdapter;
import entidades.Consumo;

public class ConsumoLogic extends NegocioLogic {
	private ConsumoAdapter daoConsumo;
	
	public ConsumoLogic() {
		this.daoConsumo = new ConsumoAdapter();
	}
	
	public ArrayList<Consumo> getAll(){
		return daoConsumo.getAll();
	}
	
	public Consumo getOne(char letra) {
		ArrayList<Consumo> consumos = this.getAll();
		Consumo c = null;
		for (Consumo consumo : consumos) {
			if (consumo.getLetraConsumo() == letra) {
				c = consumo;
			}
		}
		return c;
	}

	
}
