package uiDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.*;

import javax.swing.JCheckBox;

import negocio.ColorLogic;
import negocio.ConsumoLogic;
import negocio.ElectrodomesticoLogic;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ModificarElectrodomestico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPeso;
	private JTextField txtPrecioBase;
	private JComboBox<Color> cbxColor;
	private JComboBox<Consumo> cbxConsumoEnergetico;
	private JPanel pLavarropa;
	private JPanel pTelevisor;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private ColorLogic controladorColor;
	private ConsumoLogic controladorConsumo;
	private JCheckBox chkSintonizador;
	private Electrodomestico electrodo;
	private ElectrodomesticoLogic controladorElec;
	private boolean modificoAlgo;


	
	public ModificarElectrodomestico(JFrame frame, Electrodomestico elec) {
		super(frame);
		this.setLocationRelativeTo(frame);
		this.setModal(true);
		this.setTitle("Modificar Electrodomestico  ");
		setBounds(100, 100, 610, 308);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblPrecioBase = new JLabel("Precio Base:");
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		
		cbxColor = new JComboBox<Color>();
		
		JLabel lblPeso = new JLabel("Peso");
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		
		JLabel lblConsumoEnergetico = new JLabel("Cons Energetico");
		
		cbxConsumoEnergetico = new JComboBox<Consumo>();
		
		pLavarropa = new JPanel();
		pLavarropa.setVisible(false);
		
		pTelevisor = new JPanel();
		pTelevisor.setVisible(false);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pTelevisor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPeso)
								.addComponent(lblPrecioBase))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(txtPrecioBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblColor))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblConsumoEnergetico)))
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbxConsumoEnergetico, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbxColor, 0, 103, Short.MAX_VALUE))))
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addComponent(pLavarropa, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioBase)
						.addComponent(txtPrecioBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor))
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeso)
						.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConsumoEnergetico)
						.addComponent(cbxConsumoEnergetico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(pLavarropa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pTelevisor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JLabel lblResolucion = new JLabel("Resolucion");
		
		txtResolucion = new JTextField();
		txtResolucion.setColumns(10);
		
		chkSintonizador = new JCheckBox("");
		
		JLabel lblSintonizador = new JLabel("Sintonizador");
		GroupLayout gl_pTelevisor = new GroupLayout(pTelevisor);
		gl_pTelevisor.setHorizontalGroup(
			gl_pTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTelevisor.createSequentialGroup()
					.addGap(45)
					.addComponent(lblResolucion)
					.addGap(18)
					.addComponent(txtResolucion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblSintonizador)
					.addGap(18)
					.addComponent(chkSintonizador)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_pTelevisor.setVerticalGroup(
			gl_pTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTelevisor.createSequentialGroup()
					.addGroup(gl_pTelevisor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pTelevisor.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblResolucion)
							.addComponent(lblSintonizador)
							.addComponent(txtResolucion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(chkSintonizador))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pTelevisor.setLayout(gl_pTelevisor);
		
		JLabel lblCarga = new JLabel("Carga");
		
		txtCarga = new JTextField();
		txtCarga.setColumns(10);
		GroupLayout gl_pLavarropa = new GroupLayout(pLavarropa);
		gl_pLavarropa.setHorizontalGroup(
			gl_pLavarropa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pLavarropa.createSequentialGroup()
					.addGap(74)
					.addComponent(lblCarga)
					.addGap(18)
					.addComponent(txtCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(367, Short.MAX_VALUE))
		);
		gl_pLavarropa.setVerticalGroup(
			gl_pLavarropa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pLavarropa.createSequentialGroup()
					.addGroup(gl_pLavarropa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarga)
						.addComponent(txtCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pLavarropa.setLayout(gl_pLavarropa);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						try {
							modificarElectrodomestico(electrodo);
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(contentPanel, "Verifique los datos ingresados, algo esta mal", "Ingreso invalido", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				});
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		this.electrodo = elec;
		this.controladorColor = new ColorLogic();
		this.controladorConsumo = new ConsumoLogic();
		this.controladorElec = new ElectrodomesticoLogic();
		this.modificoAlgo = false;
		this.cargarVentana(elec);
		
	}
	
	protected void modificarElectrodomestico(Electrodomestico electrodo) throws Exception{
		double precioBase = Double.parseDouble(txtPrecioBase.getText());
		float peso = Float.parseFloat(txtPeso.getText());
		Color color =(Color) cbxColor.getSelectedItem();
		Consumo consumo =(Consumo) cbxConsumoEnergetico.getSelectedItem();
		float carga;
		float resolucion;
		boolean tdt;
		
		electrodo.setColor(color);
		electrodo.setConsumo(consumo);
		electrodo.setPrecioBase(precioBase);
		electrodo.setPeso(peso);
		if (electrodo instanceof Lavarropas) {
			carga= Float.parseFloat(txtCarga.getText());
			((Lavarropas) electrodo).setCarga(carga);
			
		}
		else {
			resolucion = Float.parseFloat(txtResolucion.getText());
			((Televisor) electrodo).setResolucion(resolucion);
			tdt= chkSintonizador.isSelected();
			((Televisor) electrodo).setTdt(tdt);
			}
		controladorElec.update(electrodo.getIdElectrodomestico(), electrodo);
		this.modificoAlgo = true;
	}

	
	public boolean modificoAlgo() {
		return this.modificoAlgo;
	}
	
	public void cargarVentana(Electrodomestico elec){
		this.setLocationRelativeTo(this.getParent());
		if(electrodo instanceof entidades.Lavarropas){
			this.pLavarropa.setVisible(true);
			this.cargaLavarropas(electrodo);
		}
		else{
			this.pTelevisor.setVisible(true);
			this.cargaTelevisor(electrodo);
		}
	}
	
	private void cargaComun(Electrodomestico electrodo){
		Double ayuda=electrodo.getPrecioBase();
		Float  ayuda1=electrodo.getPeso();
		this.txtPrecioBase.setText(ayuda.toString());
		this.txtPeso.setText(ayuda1.toString());
		this.setCombos(electrodo);		
	}

	private void cargaLavarropas(Electrodomestico electrodo) {
		
		Float ayuda=((Lavarropas)electrodo).getCarga();
		this.cargaComun(electrodo);
		this.txtCarga.setText(ayuda.toString());	
	}

	private void cargaTelevisor(Electrodomestico electrodo) {
		Float ayuda=((Televisor)electrodo).getResolucion();
		boolean sintoniza= ((Televisor)electrodo).isTdt();
		this.cargaComun(electrodo);
		this.txtResolucion.setText(ayuda.toString());
		this.chkSintonizador.setSelected(sintoniza);
	}
	
	private void setCombos(Electrodomestico electrodo) {
			int index=0; 
			ArrayList<Color> colores = controladorColor.getAll();
			for (Color color : colores) {
				this.cbxColor.addItem(color);
			}
			String color=electrodo.getColor().toString();
				for (int i = 0; i < colores.size(); i++) {
					if(color==colores.get(i).toString()){
						index=i;
					}
				}
			cbxColor.setSelectedIndex(index);	
						
			ArrayList<Consumo> consumos = controladorConsumo.getAll();
			for (Consumo consumoEnergetico : consumos) {
				cbxConsumoEnergetico.addItem(consumoEnergetico);
			}
			String consumo=electrodo.getConsumo().toString();
				for (int i = 0; i < consumos.size(); i++) {
					if(consumo==consumos.get(i).toString()){
						index=i;
					}
				}
			cbxConsumoEnergetico.setSelectedIndex(index);
		}
		
	}

