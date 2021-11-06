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
import java.io.IOException;
import java.io.ObjectOutputStream;
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

import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;
import app.Mensaje;

public class JPanelComunication extends JPanel{
	private JPanelChatBox jPanelChatBox;
	public JPanelMensajeBox jPanelMensajeBox; //cambiar a NO static
	private JLabel jLabelNombreSala;
	
	public JPanelComunication() {
		super();
		addJLabelNombreSala();
		addChatBox();
		addMensajesBox();
		
		jPanelChatBox.setJPanelMensajeBox(jPanelMensajeBox);
	}

	private void addJLabelNombreSala() {
		jLabelNombreSala = new JLabel();
		jLabelNombreSala.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jLabelNombreSalaClicked((JLabel)e.getComponent());
			}
		});
		
		jLabelNombreSala.setBounds( (Constantes.chatMinWidth-Constantes.salaWidth)*8/10, 0,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.salaHeight);
		add(jLabelNombreSala);
	}
	
	private void jLabelNombreSalaClicked(JLabel jLabelTitulo) {
		try {
			Peticion<String> serverMessage = new Peticion<String>(Acciones.SEND_USERS_TO_USERS,jLabelTitulo.getText());
			new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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

	public void addPanelMensaje(Mensaje info){
		jPanelMensajeBox.addMensaje(info);
	}
	
	public void setNombreSala(String nombre) {
		jLabelNombreSala.setText(nombre);
	}

	public void setearMensaje(ArrayList<Mensaje> mensajes){
		jPanelMensajeBox.setearMensaje(mensajes);
	}
}
