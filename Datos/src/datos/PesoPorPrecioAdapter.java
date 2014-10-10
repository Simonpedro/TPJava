package datos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;



import entidades.Peso_Precio;

public class PesoPorPrecioAdapter extends Adapter{
	public void save(Peso_Precio pesoPrecio) {
		String sql;
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		sql = "insert into precio_peso(id_precioPeso, peso_desde, peso_hasta, precio) values(?,?,?,?)";
		
		
		try {
			sentencia = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, pesoPrecio.getIdPesoPrecio());
			sentencia.setFloat(2, pesoPrecio.getPesoDesde());
			sentencia.setFloat(3, pesoPrecio.getPesoHasta());
			sentencia.setDouble(4, pesoPrecio.getPrecio());
			
			sentencia.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(sentencia!=null){sentencia.close();}
				DataConnectionManager.getInstancia().closeConn();
				}
				catch (SQLException sqle){
				sqle.printStackTrace();
				}
		}
	}

	public ArrayList<Peso_Precio> getAll() {
		ArrayList<Peso_Precio> pesosPrecios = new ArrayList<Peso_Precio>();
		
		String sql = "SELECT * FROM precio_peso";
		Statement sentencia = null;
		ResultSet rs = null;
		
		try {
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while (rs.next()) {
				Peso_Precio pesoPrecio = new Peso_Precio();
				pesoPrecio.setIdPesoPrecio(rs.getInt("id_precioPeso"));
				pesoPrecio.setPesoDesde(rs.getFloat("peso_desde"));
				pesoPrecio.setPesoHasta(rs.getFloat("peso_hasta"));
				pesoPrecio.setPrecio(rs.getDouble("precio"));
				
				pesosPrecios.add(pesoPrecio);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null){rs.close();}
				if(sentencia!= null){sentencia.close();}
				DataConnectionManager.getInstancia().closeConn();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pesosPrecios;
	}
}
