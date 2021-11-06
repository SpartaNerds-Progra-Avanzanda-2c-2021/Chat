package Graficos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import App.Mensaje;
import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;

public class JPanelSala extends JPanel{
	private String nombre;
	private int cantConexiones;
	private int cantMensajesNuevos;
	private JLabel cantConexionesLabel;
	private JButton salirButton;
	private boolean conectado = false;
	
	public JPanelSala(String nombre, int cantConexiones, int cantMensajesNuevos) {
		super();
		this.nombre = nombre;
		this.cantConexiones = cantConexiones;
		this.cantMensajesNuevos = cantMensajesNuevos;
		
		addNombre();
		addCantConexiones();
		addCantMensajesNuevos();
		addButtonDesconectar();
	}
	
	private void addButtonDesconectar() {
		salirButton = new JButton("Entrar");
		salirButton.setBounds(Constantes.salaWidth / 2 +20 , Constantes.salaHeight / 2, 70, 20);
		salirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaveRoom();
			}
		});
		this.add(salirButton);
	}
	
	private void leaveRoom() {
		if(!conectado) {
			
			Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_ENTERS_ROOM, nombre);
			try {
				new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Cliente.salaActual = nombre;
		}else {
			Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_LEAVE_ROOM,this.nombre);
			try {
				new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			switchConection();	
		}
	}
	
	private void addNombre() {
		JLabel label=new JLabel(this.nombre);  
		label.setBorder(new EmptyBorder(5,20,0,0));
		label.setFont(new Font("BOLD", Font.PLAIN, 17));
		label.setBounds(0,0,Constantes.salaWidth/2,Constantes.salaHeight/2);  
		
	    this.add(label);
	}
	
	private void addCantMensajesNuevos() {
		String mensaje = "Msj: "+String.valueOf(this.cantMensajesNuevos);
		JLabel label = new JLabel(mensaje,SwingConstants.RIGHT);  
		label.setBorder(new EmptyBorder(0,0,0,15));
		label.setFont(new Font("BOLD", Font.PLAIN, 11));
		label.setBounds(Constantes.salaWidth / 2, 0, Constantes.salaWidth / 2,
				Constantes.salaHeight / 2);
		this.add(label);
	}
	
	private void addCantConexiones() {
		String mensaje = "Conectados: "+String.valueOf(this.cantConexiones);
		this.cantConexionesLabel = new JLabel(mensaje);  
		cantConexionesLabel.setBorder(new EmptyBorder(0,25,0,0));
		cantConexionesLabel.setFont(new Font("BOLD", Font.PLAIN, 10));
		cantConexionesLabel.setBounds(0,Constantes.salaHeight/2,Constantes.salaWidth,Constantes.salaHeight/2);  
	    this.add(cantConexionesLabel);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void actualizarCantConexiones(int cantConexiones) {
		this.cantConexiones = cantConexiones;
		this.cantConexionesLabel.setText("Conectados: "+String.valueOf(this.cantConexiones));
	}

	public void updateJLabel() {
		this.cantConexionesLabel.updateUI();
	}

	public void switchConection() {
		this.conectado = !this.conectado;
		this.salirButton.setText(this.conectado?"Salir":"Entrar");
		updateJLabel();
	}

	public boolean isConectado() {
		return conectado;
	}
}
