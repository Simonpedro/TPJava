package uiDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;










import entidades.Color;
import entidades.Consumo;
import entidades.Lavarropas;
import entidades.Televisor;
import negocio.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AltaElectrodomestico extends JDialog {

	private final JPanel pGeneral = new JPanel();
	private JComboBox<String> cbxElectrodomestico;
	private JTextField txtPeso;
	private JTextField txtPrecioBase;
	private JComboBox<Color> cbxColor;
	private JPanel pLavarropas;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private JPanel pTelevisor;
	private JCheckBox cbSintonizador;
	private JComboBox<Consumo> cbxConsumoEnergetico;
	private ColorLogic controladorColor;
	private ConsumoLogic controladorConsumo;
	private ElectrodomesticoLogic controladorElec;
	private boolean agregoAlgo;
	
	/*
	public static void main(String[] args) {
		try {
			AltaElectrodomestico dialog = new AltaElectrodomestico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	
	public AltaElectrodomestico(JFrame frame) {
		super(frame);
		this.setLocationRelativeTo(frame);
		this.setModal(true);
		this.setTitle("Alta Electrodomestico");
		setBounds(100, 100, 561, 362);
		getContentPane().setLayout(new BorderLayout());
		pGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pGeneral, BorderLayout.CENTER);
		
		JLabel lblSeleccion = new JLabel("Seleccionar Electrodomestico");
		lblSeleccion.setFont(new Font("Arial", Font.PLAIN, 14));
		
		pLavarropas = new JPanel();
		pLavarropas.setVisible(false);
		
		cbxElectrodomestico = new JComboBox<String>();
		cbxElectrodomestico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//Evento de cambio al seleccionar un item
				if(cbxElectrodomestico.getSelectedIndex()==0){
					this.cambiaEstadoPanel(0);
				}
				else{if(cbxElectrodomestico.getSelectedIndex()==1){
									this.cambiaEstadoPanel(1);
						}
					else{
							this.cambiaEstadoPanel(2);}
					    }
			}

			private void cambiaEstadoPanel(int num)
	{
		if(num==0){}		
		else{
			if (num==1){
					pLavarropas.setVisible(true);
					pTelevisor.setVisible(false);
				}
			else{
				pTelevisor.setVisible(true);
				pLavarropas.setVisible(false);
			}
		}
		
	}
		});
		
		cbxElectrodomestico.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		
		JLabel lblColor = new JLabel("Color");
		
		JLabel lblConsumo = new JLabel("Cons Energetico");
		
		JLabel lblPeso = new JLabel("Peso");
		
		txtPeso = new JTextField();
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
				{
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				 }
			}
		});
		txtPeso.setColumns(10);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') )
				{
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				 }
			}

			
		});
		txtPrecioBase.setColumns(10);
		
		cbxColor = new JComboBox<Color>();
		
		cbxConsumoEnergetico = new JComboBox<Consumo>();
		
		pTelevisor = new JPanel();
		pTelevisor.setVisible(false);
		pTelevisor.setDoubleBuffered(false);
		GroupLayout gl_pGeneral = new GroupLayout(pGeneral);
		gl_pGeneral.setHorizontalGroup(
			gl_pGeneral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pGeneral.createSequentialGroup()
					.addGroup(gl_pGeneral.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_pGeneral.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPeso)
								.addComponent(lblPrecioBase))
							.addGap(10)
							.addGroup(gl_pGeneral.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPrecioBase, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pGeneral.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblColor)
								.addComponent(lblConsumo))
							.addGap(18)
							.addGroup(gl_pGeneral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pGeneral.createSequentialGroup()
									.addComponent(cbxColor, 0, 125, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_pGeneral.createSequentialGroup()
									.addComponent(cbxConsumoEnergetico, 0, 121, Short.MAX_VALUE)
									.addGap(4))))
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(171)
							.addGroup(gl_pGeneral.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbxElectrodomestico, Alignment.LEADING, 0, 213, Short.MAX_VALUE)
								.addComponent(lblSeleccion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
					.addGap(146))
				.addGroup(gl_pGeneral.createSequentialGroup()
					.addContainerGap()
					.addComponent(pTelevisor, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_pGeneral.createSequentialGroup()
					.addContainerGap()
					.addComponent(pLavarropas, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pGeneral.setVerticalGroup(
			gl_pGeneral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pGeneral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSeleccion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbxElectrodomestico, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_pGeneral.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(6)
							.addComponent(lblColor))
						.addComponent(cbxColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrecioBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPrecioBase)))
					.addGap(53)
					.addGroup(gl_pGeneral.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(6)
							.addComponent(lblConsumo))
						.addComponent(cbxConsumoEnergetico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pGeneral.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPeso))
						.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(pLavarropas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pTelevisor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		
		JLabel lblResolucion = new JLabel("Resolucion");
		
		txtResolucion = new JTextField();
		txtResolucion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
				{
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				 }
			}
		});
		txtResolucion.setColumns(10);
		
		JLabel lblSintonizador = new JLabel("Sintonizador");
		
		cbSintonizador = new JCheckBox("");
		GroupLayout gl_pTelevisor = new GroupLayout(pTelevisor);
		gl_pTelevisor.setHorizontalGroup(
			gl_pTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTelevisor.createSequentialGroup()
					.addGap(2)
					.addComponent(lblResolucion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtResolucion, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(lblSintonizador)
					.addGap(18)
					.addComponent(cbSintonizador)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_pTelevisor.setVerticalGroup(
			gl_pTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTelevisor.createSequentialGroup()
					.addGroup(gl_pTelevisor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pTelevisor.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblResolucion)
							.addComponent(txtResolucion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSintonizador))
						.addComponent(cbSintonizador))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pTelevisor.setLayout(gl_pTelevisor);
		//table model
		
		
		JLabel lblCarga = new JLabel("Carga");
		
		txtCarga = new JTextField();
		txtCarga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
				{
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				 }
			}
		});
		txtCarga.setColumns(10);
		GroupLayout gl_pLavarropas = new GroupLayout(pLavarropas);
		gl_pLavarropas.setHorizontalGroup(
			gl_pLavarropas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pLavarropas.createSequentialGroup()
					.addGap(26)
					.addComponent(lblCarga)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCarga, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(383, Short.MAX_VALUE))
		);
		gl_pLavarropas.setVerticalGroup(
			gl_pLavarropas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pLavarropas.createSequentialGroup()
					.addGroup(gl_pLavarropas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarga)
						.addComponent(txtCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pLavarropas.setLayout(gl_pLavarropas);
		pGeneral.setLayout(gl_pGeneral);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Guardar");
				btnAceptar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						try {
							guardarElectrodomestico();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(pGeneral, "Verifique los datos ingresados, algo esta mal", "Ingreso invalido", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			this.controladorColor = new ColorLogic();
			this.controladorConsumo = new ConsumoLogic();
			this.controladorElec = new ElectrodomesticoLogic();
			this.agregoAlgo = false;
			this.iniciaCombos();
			
		}
	}
	


	protected void guardarElectrodomestico() throws Exception{
		
		
		double precioBase = Double.parseDouble(txtPrecioBase.getText());
		float peso = Float.parseFloat(txtPeso.getText());
		Consumo consumo =(Consumo) cbxConsumoEnergetico.getSelectedItem();
		Color color = (Color) cbxColor.getSelectedItem();
		if (cbxElectrodomestico.getSelectedIndex() == 1) {
			float carga = Float.parseFloat(txtCarga.getText());
			Lavarropas elec = new Lavarropas(precioBase, peso, color, consumo,carga);
			controladorElec.save(elec);
		}
		if (cbxElectrodomestico.getSelectedIndex() == 2) {
			float resolucion = Float.parseFloat(txtResolucion.getText());
			boolean tdt = cbSintonizador.isSelected();
			Televisor elec = new Televisor(precioBase, peso, color, consumo, resolucion, tdt);
			controladorElec.save(elec);
		}
		this.agregoAlgo = true;
		this.dispose();
	}

	public void iniciaCombos(){
		this.setLocationRelativeTo(this.getParent());
		this.cbxElectrodomestico.addItem("--");
		this.cbxElectrodomestico.addItem("Lavarropas");
		this.cbxElectrodomestico.addItem("Televisor");
		
		ArrayList<Color> colores = controladorColor.getAll();
		for (Color color : colores) {
			this.cbxColor.addItem(color);
		}
		
		ArrayList<Consumo> consumos = controladorConsumo.getAll();
		for (Consumo consumoEnergetico : consumos) {
			cbxConsumoEnergetico.addItem(consumoEnergetico);
		}	
	}

	public boolean agregoAlgo() {
		return this.agregoAlgo;
	}

	
	
}
