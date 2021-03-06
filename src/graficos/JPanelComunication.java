package graficos;

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

import cliente.Cliente;
import app.Mensaje;
import utils.Acciones;
import utils.Peticion;

public class JPanelComunication extends JPanel{
	private JPanelChatBox jPanelChatBox;
	public JPanelMensajeBox jPanelMensajeBox;
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
		jLabelNombreSala.setFont(new Font("BOLD", Font.PLAIN, 22));
		jLabelNombreSala.setForeground(Color.white);
		jLabelNombreSala.setLayout(null);
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
		jPanelChatBox.setBounds(0,Constantes.chatMinHeight-170,Constantes.chatMinWidth-Constantes.salaWidth,
				Constantes.chatMinHeight-200);
		jPanelChatBox.setBackground(Constantes.jPanelChatBoxColor);
		this.add(jPanelChatBox);
	}
	public void addMensajesBox() {
		jPanelMensajeBox = new JPanelMensajeBox();
		jPanelMensajeBox.setBounds(0,Constantes.salaHeight,Constantes.chatMinWidth-Constantes.salaWidth,
				Constantes.chatMinHeight-Constantes.ChatBoxHeight+75);
		jPanelMensajeBox.setLayout(null);
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
