package Graficos;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import App.Mensaje;

public class JPanelMensajeBox extends JPanel{
	private String nombre;
	private JScrollPane jScrollPane;
	private static JTextArea jTextAreaMensajes;
	
	public JPanelMensajeBox() {
		addMensajeArea();
	}
	
	public void addMensajeArea() {
		jTextAreaMensajes = new JTextArea();
		jTextAreaMensajes.setEditable(false);
		jTextAreaMensajes.setLineWrap(true);
		jTextAreaMensajes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jScrollPane = new JScrollPane(jTextAreaMensajes);
		jScrollPane.setPreferredSize(new Dimension((Constantes.chatMinWidth-Constantes.salaWidth)*8/10, Constantes.chatMinHeight*5/9));
        this.add(jScrollPane);
	}

	public void addMensaje(Mensaje msj) {
		String aux = msj.toString();
		jTextAreaMensajes.append(aux);
	}
}
