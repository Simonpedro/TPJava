package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Color;


public class ColorAdapter extends Adapter {

	public ArrayList<Color> getAll() {
		ArrayList<Color> cols = new ArrayList<Color>();
		
		String sql = "select * from colores col";
		Statement sentencia = null;
		ResultSet rs = null;
		
		
		try {
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			
			while (rs.next()) {
				Color col = new Color(rs.getInt("id_color"), rs.getString("nombre_color"));
				cols.add(col);
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
		return cols;
	}
	
}
