package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import entidades.Color;
import entidades.Consumo;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Televisor;

public class ElectrodomesticoAdapter extends Adapter{

	public ArrayList<Electrodomestico> getAll() {
		ArrayList<Electrodomestico> elecs = new ArrayList<Electrodomestico>();
		
		String sql = "select * from `electrodomesticos` ele "
				+ "inner join `colores` col on ele.`id_color` = col.`id_color` "
				+ "inner join consumos con on ele.`id_consumo` = con.`id_consumo`";
		Statement sentencia = null;
		ResultSet rs = null;
		
		
		try {
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			
			while (rs.next()) {
				Color color = new Color(rs.getInt("id_color"), rs.getString("nombre_color"));
				Consumo consumo = new Consumo(rs.getInt("id_consumo"), rs.getString("letraConsumo").charAt(0), rs.getDouble("precio"));
				if (rs.getObject("carga") ==  null) { // me fijo si es lavarropas
					Televisor elec = new Televisor();
					elec.setIdElectrodomestico(rs.getInt("id_electrodomestico"));
					elec.setPrecioBase(rs.getDouble("precio_base"));
					elec.setPeso(rs.getFloat("peso"));
					elec.setColor(color);
					elec.setConsumo(consumo);
					elec.setDescripcion(rs.getString("descripcion"));
					elec.setResolucion(rs.getFloat("resolucion"));
					elec.setTdt(rs.getBoolean("tdt"));
					
					elecs.add(elec);
				}
				else {
					Lavarropas elec = new Lavarropas();
					elec.setIdElectrodomestico(rs.getInt("id_electrodomestico"));
					elec.setPrecioBase(rs.getDouble("precio_base"));
					elec.setPeso(rs.getFloat("peso"));
					elec.setColor(color);
					elec.setConsumo(consumo);
					elec.setDescripcion(rs.getString("descripcion"));
					elec.setCarga(rs.getFloat("carga"));
					
					elecs.add(elec);
				}
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
		return elecs;
	}

	public void save(Electrodomestico elec) {
		String sql;
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		boolean control = true;
		if (elec instanceof Lavarropas) {
			sql = "insert into electrodomesticos(precio_base, peso, id_color, id_consumo, descripcion, carga) values(?,?,?,?,?,?)";
		}
		else {
			sql = "insert into electrodomesticos(precio_base, peso, id_color, id_consumo, descripcion, resolucion, tdt) values(?,?,?,?,?,?,?)";
			control = false;
		}
		
		try {
			sentencia = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setDouble(1, elec.getPrecioBase());
			sentencia.setFloat(2, elec.getPeso());
			sentencia.setInt(3, elec.getColor().getIdColor());
			sentencia.setInt(4, elec.getConsumo().getIdConsumo());
			sentencia.setString(5, elec.getDescripcion());
			if (control) {
				sentencia.setFloat(6, ((Lavarropas)elec).getCarga());
			}
			else {
				sentencia.setFloat(6, ((Televisor)elec).getResolucion());
				sentencia.setBoolean(7, ((Televisor)elec).isTdt());
			}
			sentencia.executeUpdate();
			ResultSet clavesGeneradas = sentencia.getGeneratedKeys();
			if (clavesGeneradas.next()) {
				int id_elec = clavesGeneradas.getInt(1);
				elec.setIdElectrodomestico(id_elec);
			}
			
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

	public void delete(int idElec) {
		String sql = "DELETE FROM electrodomesticos WHERE id_electrodomestico=?";
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		try{
			sentencia = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, idElec);
			sentencia.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try{
				if (sentencia != null) {
					sentencia.close();
				}
				DataConnectionManager.getInstancia().closeConn();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public void update(int idElec, Electrodomestico elec) {
		String sql;
		if (elec instanceof Lavarropas) {
			sql = "UPDATE electrodomesticos set precio_base="+elec.getPrecioBase()+",peso="+elec.getPeso()+",id_color="+elec.getColor().getIdColor()
					+",id_consumo="+elec.getConsumo().getIdConsumo()+",descripcion="+(elec.getDescripcion()==null?null:("\""+elec.getDescripcion()+"\""))+",carga="+((Lavarropas)elec).getCarga()
					+" WHERE id_electrodomestico=?";
		}else {
			sql = "UPDATE electrodomesticos set precio_base="+elec.getPrecioBase()+",peso="+elec.getPeso()+",id_color="+elec.getColor().getIdColor()
					+",id_consumo="+elec.getConsumo().getIdConsumo()+",descripcion="+(elec.getDescripcion()==null?null:("\""+elec.getDescripcion()+"\""))+",resolucion="+((Televisor)elec).getResolucion()
					+",tdt="+((Televisor)elec).isTdt()+" WHERE id_electrodomestico=?";
		}
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		try{
			sentencia = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, idElec);
			sentencia.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if (sentencia!=null) {
					sentencia.close();
				}
				DataConnectionManager.getInstancia().closeConn();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
	}

}
