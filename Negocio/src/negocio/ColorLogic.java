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
	
	public Color getOne(String nombreColor) {
		ArrayList<Color> colores = this.getAll();
		Color c = null;
		for (Color color : colores) {
			if (color.getNombreColor().equalsIgnoreCase(nombreColor)) {
				c = color;
				break;
			}
		}
		return c;
	}
}
