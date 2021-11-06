package graficos;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.Mensaje;

public class JPanelMensajeBox extends JPanel {
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
		jTextAreaMensajes.setBounds(0,0,Constantes.chatMinWidth-Constantes.salaWidth,
				Constantes.chatMinHeight-Constantes.ChatBoxHeight);
		
		jScrollPane = new JScrollPane(jTextAreaMensajes);
		jScrollPane.setBounds(0,0,Constantes.chatMinWidth-Constantes.salaWidth,
				Constantes.chatMinHeight-Constantes.ChatBoxHeight);
		this.add(jScrollPane);
	}

	public void addMensaje(Mensaje msj) {
		String aux = msj.toString();
		jTextAreaMensajes.append(aux);
	}
	
	public void setearMensaje(ArrayList<Mensaje> msj) {
		jTextAreaMensajes.setText("");
		for (Mensaje mensaje : msj) {
			jTextAreaMensajes.append(mensaje.toString());
		}
	}
    public String getChatLog() {
        return jTextAreaMensajes.getText();
    }
}
