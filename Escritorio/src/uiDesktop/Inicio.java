package uiDesktop;



import negocio.*; 
import entidades.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;







import util.MyTableModel;






import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;






import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;






import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

import entidades.Consumo;



public class Inicio {

	private JFrame frmTpJava;
	private ElectrodomesticoLogic controladorElec;
	private ConsumoLogic controladorConsumo;
	private JScrollPane scrollPane;
	private MyTableModel tableModel;
	private JSpinner spinnerPrecioDesde;
	private JSpinner spinnerPrecioHasta;
	private JButton btnActualizar;
	private JTable table;
	private JLabel lblIndice;
	private JComboBox<Object> comboBox;
	

	/**
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 */
	public Inicio() {
		
		controladorElec = new ElectrodomesticoLogic();
		controladorConsumo = new ConsumoLogic();
		
		tableModel = new MyTableModel(controladorElec.getAll(), new Peso_PrecioLogic().getAll());
		initialize();
		frmTpJava.setLocationRelativeTo(null);
		
	}
	
	public void show() {
		frmTpJava.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTpJava = new JFrame();
		frmTpJava.setTitle("TP1 Java");
		frmTpJava.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		frmTpJava.setResizable(false);
		frmTpJava.setBounds(100, 100, 755, 395);
		frmTpJava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTpJava.setJMenuBar(menuBar);
		
		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenuItem mntmAgregarElectrodomestico = new JMenuItem("Agregar Electrodomestico");
		mntmAgregarElectrodomestico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarElectrodomestico();
			}
		});
		mnAcciones.add(mntmAgregarElectrodomestico);
		
		JMenuItem mntmModificarElectrodomestico = new JMenuItem("Modificar Electrodomestico");
		mntmModificarElectrodomestico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarElectrodomestico();
			}
		});
		mnAcciones.add(mntmModificarElectrodomestico);
		
		JMenuItem mntmEliminarElectrodomestico = new JMenuItem("Eliminar Electrodomestico");
		mntmEliminarElectrodomestico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarElectrodomestico();
			}
		});
		mnAcciones.add(mntmEliminarElectrodomestico);	frmTpJava.getContentPane().setLayout(null);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregarElectrodomestico();
			}
		});
		btnAgregar.setBounds(25, 311, 89, 23);
		frmTpJava.getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarElectrodomestico();
				
			}

			
		});
		btnModificar.setBounds(124, 311, 89, 23);
		frmTpJava.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarElectrodomestico();
			}
		});
		btnEliminar.setBounds(271, 311, 89, 23);
		frmTpJava.getContentPane().add(btnEliminar);

		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Para evento de seleccionar una fila
		ListSelectionModel lsm = this.table.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				if (row!=-1) {
					lblIndice.setText("Fila seleccionada: "+Integer.toString(row+1));
				}
				else {
					lblIndice.setText("Ninguna seleccion");
				}
			}
		});
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 33, 729, 267);
		frmTpJava.getContentPane().add(scrollPane);
		
		JLabel lblPrecioDesde = new JLabel("Precio desde:");
		lblPrecioDesde.setBounds(232, 8, 65, 14);
		frmTpJava.getContentPane().add(lblPrecioDesde);
		
		JLabel lblPrecioHasta = new JLabel("Precio Hasta");
		lblPrecioHasta.setBounds(406, 8, 71, 14);
		frmTpJava.getContentPane().add(lblPrecioHasta);
		
		spinnerPrecioDesde = new JSpinner();
		spinnerPrecioDesde.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinnerPrecioDesde.setBounds(307, 5, 72, 20);
		frmTpJava.getContentPane().add(spinnerPrecioDesde);
		
	    spinnerPrecioHasta = new JSpinner();
		spinnerPrecioHasta.setModel(new SpinnerNumberModel(new Double(10000), null, null, new Double(1)));
		spinnerPrecioHasta.setBounds(487, 5, 72, 20);
		frmTpJava.getContentPane().add(spinnerPrecioHasta);
		
		btnActualizar = new JButton("Filtrar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double precioDesde = (double)spinnerPrecioDesde.getValue();
				double precioHasta = (double)spinnerPrecioHasta.getValue();
				Object consumo = comboBox.getSelectedItem();
				tableModel.filtrar(precioDesde,precioHasta,consumo);
			}
		});
		
		btnActualizar.setBounds(623, 4, 89, 23);
		frmTpJava.getContentPane().add(btnActualizar);
		
		lblIndice = new JLabel("Ninguna seleccion");
		lblIndice.setBounds(587, 303, 138, 14);
		frmTpJava.getContentPane().add(lblIndice);
		
		JLabel lblConsumo = new JLabel("Consumo: ");
		lblConsumo.setBounds(10, 8, 68, 14);
		frmTpJava.getContentPane().add(lblConsumo);
		
		comboBox = new JComboBox<Object>();
		iniCbxConsumo(comboBox);
		comboBox.setBounds(88, 5, 43, 20);
		frmTpJava.getContentPane().add(comboBox);
	}

	

	protected void modificarElectrodomestico() {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un electrodomestico para modificarlo");
		}
		else{
			Electrodomestico elec = tableModel.getElecAt(row);
			ModificarElectrodomestico frmModificar=new ModificarElectrodomestico(frmTpJava, elec);
			frmModificar.setVisible(true);
			if (frmModificar.modificoAlgo()) {
				tableModel.actualizar(controladorElec.getAll());
			}
		}
		
		table.clearSelection();
		
	}

	private void iniCbxConsumo(JComboBox<Object> cbx) {
		ArrayList<Consumo> consumos = controladorConsumo.getAll();
		comboBox.addItem("All");
		for (Consumo consumoEnergetico : consumos) {
			comboBox.addItem(consumoEnergetico);
		}
	}

	private void eliminarElectrodomestico() {
		int row= table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un electrodomestico para modificarlo");
		}
		else{
			int idElec =(int) tableModel.getValueAt(row, 0);
			controladorElec.delete(idElec);
			tableModel.actualizar(controladorElec.getAll());
		}
		
		table.clearSelection();
	}

	private void agregarElectrodomestico() {
		AltaElectrodomestico frmAlta = new AltaElectrodomestico(frmTpJava);
		frmAlta.setVisible(true);
		if (frmAlta.agregoAlgo()) {
			tableModel.actualizar(controladorElec.getAll());
		}
	}
}
