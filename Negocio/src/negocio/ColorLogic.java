package negocio;

import java.util.ArrayList;

import datos.ColorAdapter;
import entidades.Color;

public class ColorLogic extends NegocioLogic {

	private ColorAdapter daoColor;
	
	public ColorLogic() {
		this.daoColor = new ColorAdapter();
	}
	
	public ArrayList<Color> getAll() {
		return this.daoColor.getAll();
	}

}
