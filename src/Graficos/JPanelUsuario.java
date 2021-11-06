package Graficos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
import Cliente.HiloEnrrutadorDeCliente;
import Utils.Acciones;
import Utils.Peticion;
import app.Mensaje;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JPanelUsuario extends JPanel{
	private String nombre;
	private Date conectadoDesde;
	private JLabel tiempoConectadoLabel;
	
	public JPanelUsuario(String nombre, Date conectadoDesde) {
		super();
		this.nombre = nombre;
		this.conectadoDesde = conectadoDesde;
		
		addNombre();
		addTiempoContectado();
		
		new HiloDeTiempoDeUsuario(tiempoConectadoLabel, conectadoDesde).start();
	}
	
	private void addNombre() {
		JLabel label=new JLabel(this.nombre);  
		label.setBorder(new EmptyBorder(5,20,0,0));
		label.setFont(new Font("BOLD", Font.PLAIN, 17));
		label.setBounds(0,0,Constantes.salaWidth/2,Constantes.salaHeight/2);  
	    this.add(label);
	}
	
	private void addTiempoContectado() {
	    long diffInMillies = Math.abs(this.conectadoDesde.getTime() - (new Date()).getTime());
	    long diff = TimeUnit.SECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		String mensaje = "Desde: "+String.valueOf(diff)+" sec";
		this.tiempoConectadoLabel = new JLabel(mensaje);  
		tiempoConectadoLabel.setBorder(new EmptyBorder(0,25,0,0));
		tiempoConectadoLabel.setFont(new Font("BOLD", Font.PLAIN, 10));
		tiempoConectadoLabel.setBounds(0,Constantes.salaHeight/2,Constantes.salaWidth,Constantes.salaHeight/2);  
	    this.add(tiempoConectadoLabel);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void updateJLabel() {
		this.tiempoConectadoLabel.updateUI();
	}
}
