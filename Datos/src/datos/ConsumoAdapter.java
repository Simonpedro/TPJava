package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Consumo;


public class ConsumoAdapter extends Adapter{

	public ArrayList<Consumo> getAll() {
		
		ArrayList<Consumo> cons = new ArrayList<Consumo>();
		
		String sql = "select * from consumos con";
		Statement sentencia = null;
		ResultSet rs = null;
		
		
		try {
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			
			while (rs.next()) {
				Consumo con = new Consumo(rs.getInt("id_consumo"), rs.getString("letraConsumo").charAt(0), rs.getDouble("precio"));
				cons.add(con);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (sentencia!=null) {
					sentencia.close();
				}
				DataConnectionManager.getInstancia().closeConn();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return cons;
	}

}
