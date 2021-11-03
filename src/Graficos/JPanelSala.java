package Graficos;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JPanelSala extends JPanel{
	private String nombre;
	private int cantConexiones;
	private int cantMensajesNuevos;
	
	public JPanelSala(String nombre, int cantConexiones, int cantMensajesNuevos) {
		super();
		this.nombre = nombre;
		this.cantConexiones = cantConexiones;
		this.cantMensajesNuevos = cantMensajesNuevos;
		
		addNombre();
		addCantConexiones();
		addCantMensajesNuevos();
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
		JLabel label=new JLabel(mensaje);  
		label.setBorder(new EmptyBorder(0,25,0,0));
		label.setFont(new Font("BOLD", Font.PLAIN, 10));
		label.setBounds(0,Constantes.salaHeight/2,Constantes.salaWidth,Constantes.salaHeight/2);  
	    this.add(label);
	}

}
