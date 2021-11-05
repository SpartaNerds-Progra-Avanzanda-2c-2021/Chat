package Graficos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JPanelMensajes extends JPanel{
	private ArrayList<JPanelMensaje> mensajes;
	
	public JPanelMensajes() {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.chatMinHeight);
		panel.setBackground(new Color(0,0,0));
		this.add(panel);
	}
}
