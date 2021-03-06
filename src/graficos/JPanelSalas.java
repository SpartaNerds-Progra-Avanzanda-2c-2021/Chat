package graficos;

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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import utils.Acciones;
import utils.Peticion;


public class JPanelSalas extends JPanel{
	private ArrayList<JPanelSala> salas = new ArrayList<JPanelSala>();
	private JPanelSalasYChatTitulo jPanelSalasYChatTitulo;
	private JPanelComunication jPanelComunication;
	private JPanelMensajeBox jPanelMensajeBox;
	
	public JPanelSalas() {
		super();
		addTituloAndAddButton();
	}

	public ArrayList<JPanelSala> getSalas() {
		return this.salas;
	}
	
	private void addTituloAndAddButton() {
		jPanelSalasYChatTitulo = new JPanelSalasYChatTitulo();
		jPanelSalasYChatTitulo.setBounds(0, 0, Constantes.salaWidth, Constantes.salaHeight);
		jPanelSalasYChatTitulo.setBackground(Constantes.salaHoverColor);
		jPanelSalasYChatTitulo.setLayout(null);
		jPanelSalasYChatTitulo.setBackground(Constantes.jPanelSalasYChatTituloColor);
		this.add(jPanelSalasYChatTitulo);
	}

	public void addJPanelSala(String nombre, int cantConexiones, int cantMensajesNuevos) {
		JPanelSala panel = new JPanelSala(nombre, cantConexiones, cantMensajesNuevos);
		panel.setLayout(null);
		panel.setBounds(0, Constantes.salaHeight * (salas.size() + 1), Constantes.salaWidth, Constantes.salaHeight);
		panel.setBackground(Constantes.jPanelSalasYChatsColor);

		panel.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(Constantes.jPanelSalasYChatsColor);
			}
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(Constantes.salaHoverColor);
			}
			public void mouseClicked(MouseEvent e) {
				JPanelSalaClicked(nombre, panel);
			}
		});

		salas.add(panel);
		this.add(panel);
		this.updateUI();
	}
	
	public void JPanelSalaClicked(String nombre, JPanelSala panel) {
		if (panel.isConectado()) {
			jPanelComunication.setVisible(true);
			jPanelComunication.setNombreSala(nombre);
		}
		if (Cliente.salasPosibles.containsKey(nombre)) {
			Cliente.salaActual = nombre;
			jPanelMensajeBox.setearMensaje(Cliente.salasPosibles.get(Cliente.salaActual));
		}
		try {
			Peticion<String> serverMessage = new Peticion<String>(Acciones.SEND_USERS_TO_USERS_WITHOUTH_OPENCLOSE_GUI,nombre);
			new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setJPanelComunication(JPanelComunication jPanelComunication) {
		this.jPanelComunication=jPanelComunication;
		this.jPanelMensajeBox = jPanelComunication.jPanelMensajeBox;
	}
}
