package prueba;

import java.util.ArrayList;

import entidades.Consumo;

import negocio.ConsumoLogic;









public class Test {

	public static void main(String[] args) {
				ConsumoLogic consLogic = new ConsumoLogic();
				
				ArrayList<Consumo> cons = consLogic.getAll();
				
				for (Consumo con : cons) {
					System.out.println(con);
				}
	}

}
