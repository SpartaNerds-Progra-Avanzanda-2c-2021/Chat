package Graficos;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import App.Mensaje;
import GraficosViejos.VentanaABMCliente;

public class JPanelComunication extends JPanel{
	private static JPanelChatBox jPanelChatBox;
	private static JPanelMensajeBox jPanelMensajeBox; //cambiar a NO static
	private static JLabel jLabel;

	public JPanelComunication() {
		super();
		jLabel = new JLabel();
		jLabel.setBounds( (Constantes.chatMinWidth-Constantes.salaWidth)*8/10, 0,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.salaHeight);
		addChatBox();
		addMensajesBox();
		add(jLabel);
	}

	private void addChatBox() {
		jPanelChatBox = new JPanelChatBox();
		jPanelChatBox.setBounds(0,Constantes.chatMinHeight*3/5,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.chatMinHeight);
		jPanelChatBox.setBackground(Constantes.jPanelChatBoxColor);
		this.add(jPanelChatBox);
	}
	public void addMensajesBox() {
		jPanelMensajeBox = new JPanelMensajeBox();
		jPanelMensajeBox.setBounds(0,Constantes.salaHeight,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.chatMinHeight*3/5);
		jPanelMensajeBox.setBackground(Constantes.jPanelMessagesColor);
		this.add(jPanelMensajeBox);
	}
	
	public static void addPanelMensaje(Mensaje info){
		jPanelMensajeBox.addMensaje(info);
	}
	
	public void setNombreSala(String nombre) {
		jLabel.setText(nombre);
	}
}
