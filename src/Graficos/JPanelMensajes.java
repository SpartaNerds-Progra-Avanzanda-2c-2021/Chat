package Graficos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JPanelMensajes extends JPanel{
	private ArrayList<JPanelMensaje> mensajes;
	
	public JPanelMensajes() {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,300,Constantes.chatMinHeight);
		panel.setBackground(new Color(255,255,0)); //amarillo
		this.add(panel);
	}
	
	public void addPanelMensaje(int id, long date, String contenido){
	JPanelMensaje panel = new JPanelMensaje(id, date, contenido);
	//panel.setLayout(null);
	panel.setBounds(0, 0, 80, 50);
	panel.setBackground(new Color(0,255,255));
	mensajes.add(panel);
	this.updateUI();
	}
}
