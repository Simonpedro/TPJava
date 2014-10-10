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

	
}
