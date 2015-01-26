package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Consumo;
import entidades.Electrodomestico;

import entidades.Peso_Precio;


public class MyTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;

	private String[] columnNames = {"ID Electrodomestico","Precio Base","Precio Final","Peso","Color","Consumo","Detalle","Descripcion"};
	private ArrayList<Electrodomestico> elecsAll;
	private ArrayList<Electrodomestico> elecsTemporal;
	private ArrayList<Peso_Precio> pesosPrecios;
	
	
	
	public MyTableModel(ArrayList<Electrodomestico> all, ArrayList<Peso_Precio> pesosPrecios) {
		this.elecsAll = all;
		this.elecsTemporal = this.elecsAll;
		this.pesosPrecios = pesosPrecios;
	}
	
	public String getColumnName(int col) {
	    return columnNames[col];
	}
	
	public Class<?> getColumnClass(int c) {
		   return getValueAt(0, c).getClass();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return elecsTemporal.size();
	}
	
	public boolean isCellEditable(int row, int col) {
	    return false;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Electrodomestico elec = elecsTemporal.get(arg0);
		switch (arg1) {
		case 0: return elec.getIdElectrodomestico(); 
		case 1: return elec.getPrecioBase();
		case 2: {
			Peso_Precio ppCorrespondiente = this.encuentraPesoPrecio(elec.getPeso());
			return elec.precioFinal(ppCorrespondiente);
		}
		case 3: return elec.getPeso();
		case 4: return elec.getColor();
		case 5: return elec.getConsumo();
		case 6: return elec.getDetalle();
		case 7: return elec.getDescripcion();
		default: return "Columna no usada todavia";
			
		}
		
	}

	private Peso_Precio encuentraPesoPrecio(float peso) {
		Peso_Precio ppCorrespondiente = null;
		for (Peso_Precio pp : pesosPrecios) {
			if (peso>=pp.getPesoDesde() && peso<pp.getPesoHasta()) {
				ppCorrespondiente = pp;
			}
		}
		return ppCorrespondiente;
	}

	public Electrodomestico getElecAt(int row) {
		return elecsTemporal.get(row);
	}
	

	public void actualizar(ArrayList<Electrodomestico> all) {
		this.elecsTemporal = all;
		fireTableDataChanged();
	}

	public void filtrar(double precioDesde, double precioHasta, Object consumo) {
		elecsTemporal = new ArrayList<Electrodomestico>();
		for (Electrodomestico elec : elecsAll) {
			Peso_Precio ppCorrespondiente = this.encuentraPesoPrecio(elec.getPeso());
			double precioFinal=elec.precioFinal(ppCorrespondiente);
			boolean isAll = false;
			if (consumo instanceof String) {
				isAll = true;
			}
			if ((precioFinal>=precioDesde && precioFinal<=precioHasta) && (isAll || ((Consumo)consumo).getIdConsumo() == elec.getConsumo().getIdConsumo())) {
				elecsTemporal.add(elec);
			}
		}
		fireTableDataChanged();
	}

}
