package Graficos;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanelMensajeBox extends JPanel{
	private String nombre;
	private JScrollPane jScrollPane;
	private JPanelMensajes jPanelMensajes;
	
	public JPanelMensajeBox() {
		addMensajeArea();
	}
	
	public void addMensajeArea() {
		jPanelMensajes = new JPanelMensajes();
		jScrollPane = new JScrollPane(jPanelMensajes);
		jScrollPane.setPreferredSize(new Dimension((Constantes.chatMinWidth-Constantes.salaWidth)*6/10, Constantes.chatMinHeight*6/9));
        this.add(jScrollPane);
	}

	public void addPanelMensaje(int id, long date, String contenido) {
		JPanelMensaje panel = new JPanelMensaje(id, date, contenido);
		panel.setLayout(null);
		panel.setBounds(0, 0,Constantes.chatMinWidth-Constantes.salaWidth*6/10, Constantes.chatMinHeight*6/9);
		panel.setBackground(Constantes.jPanelSalasYChatsColor);
		jPanelMensajes.add(panel);
		this.updateUI();
	}
}
