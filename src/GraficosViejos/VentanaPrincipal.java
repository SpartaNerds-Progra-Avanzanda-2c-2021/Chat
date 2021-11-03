package GraficosViejos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {

	private JButton btnAlta;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnVer;
	public JTable tblClientes;
	public VentanaPrincipalEventos ventanaPrincipalEventos = new VentanaPrincipalEventos();

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		super("Clientes");
		this.configurePrincipalPanel();
	
		this.addAltaIcon();
		this.addVerIcon();
		this.addEliminarIcon();
		this.addEditarIcon();
		this.addScrollPane();
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void configurePrincipalPanel() {
		this.setBounds(50, 50, 1024, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		ImageIcon icoPrincipal = new ImageIcon(".\\clientes.png");
		this.setIconImage(icoPrincipal.getImage());	
	}
	
	private void addScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 50, 1005, 516);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.addColumn("Documento");
		modelo.addColumn("Tipo Doc.");
		modelo.addColumn("Apellido/s");
		modelo.addColumn("Nombre/s");

		scrollPane.setViewportView(tblClientes);
	}
	
	private void addVerIcon() {
		ImageIcon icoVer = new ImageIcon(".\\ver.png");
		Image imgVer = icoVer.getImage();
		Image imgVerRed = imgVer.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoVerRed = new ImageIcon(imgVerRed);
		
		JButton btnVer = new JButton(icoVerRed);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoVisualizarCliente();
			}
		});
		btnVer.setToolTipText("Mostrar datos del Cliente seleccionado");
		btnVer.setBounds(140, 5, 40, 40);
		getContentPane().add(btnVer);
	}
	
	private void addEliminarIcon() {
		ImageIcon icoEliminar = new ImageIcon(".\\eliminar.png");
		Image imgEliminar = icoEliminar.getImage();
		Image imagEliminarRed = imgEliminar.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoEliminarRed = new ImageIcon(imagEliminarRed);
		
		JButton btnEliminar = new JButton(icoEliminarRed);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoBajaDeCliente();
			}
		});
		btnEliminar.setToolTipText("Eliminar datos del Cliente seleccionado");
		btnEliminar.setBounds(95, 5, 40, 40);
		getContentPane().add(btnEliminar);
	}
	private void addEditarIcon() {
		ImageIcon icoEditar = new ImageIcon(".\\editar.png");
		Image imgEditar = icoEditar.getImage();
		Image imagEditarRed = imgEditar.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoEditarRed = new ImageIcon(imagEditarRed);
		
		JButton btnEditar = new JButton(icoEditarRed);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoEdicionDeCliente();
			}
		});
		btnEditar.setToolTipText("Editar datos del Cliente");
		btnEditar.setBounds(50, 5, 40, 40);
		getContentPane().add(btnEditar);
	}
	
	private void addAltaIcon() {
		ImageIcon icoAlta = new ImageIcon(".\\agregar.png");
		Image imgAlta = icoAlta.getImage();
		Image imagAltaRed = imgAlta.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoAltaRed = new ImageIcon(imagAltaRed);
		
		btnAlta = new JButton(icoAltaRed);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoAltaDeCliente();
			}
		});
		btnAlta.setToolTipText("Alta de Nuevo Cliente");
		btnAlta.setBounds(5, 5, 40, 40);
		
		getContentPane().add(btnAlta);
	}
	
	public void abrirVentanaModoAltaDeCliente() {
		this.ventanaPrincipalEventos.abrirVentanaModoAltaDeCliente(this);
	}
	public void abrirVentanaModoEdicionDeCliente() {
		this.ventanaPrincipalEventos.abrirVentanaModoEdicionDeCliente(this, tblClientes);
	}
	public void abrirVentanaModoBajaDeCliente() {
		this.ventanaPrincipalEventos.abrirVentanaModoBajaDeCliente(this,tblClientes);
	}
	public void abrirVentanaModoVisualizarCliente() {
		this.ventanaPrincipalEventos.abrirVentanaModoVisualizarCliente(this, tblClientes);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new VentanaPrincipal().setVisible(true);
	}
}
