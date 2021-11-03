package Graficos;

import java.awt.BorderLayout;
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

import GraficosViejos.VentanaABMCliente;

public class JPanelSalasYChats extends JPanel{
	private ArrayList<JPanelSala> salas = new ArrayList<JPanelSala>();
	private JPanelSalasYChatTitulo jPanelSalasYChatTitulo;
	
	public JPanelSalasYChats() {
		super();
		addTituloAndAddButton();
	}
	
	private void addTituloAndAddButton() {
		jPanelSalasYChatTitulo = new JPanelSalasYChatTitulo();
		jPanelSalasYChatTitulo.setBounds(0,0,Constantes.salaWidth,Constantes.salaHeight);
		jPanelSalasYChatTitulo.setBackground(Constantes.salaHoverColor);
		jPanelSalasYChatTitulo.setLayout(null);
		jPanelSalasYChatTitulo.setBackground(Constantes.jPanelMessagesColor);
		this.add(jPanelSalasYChatTitulo);
	}

	public void addJPanelSala(String nombre, int cantConexiones, int cantMensajesNuevos ) {
		JPanelSala panel = new JPanelSala(nombre,cantConexiones,cantMensajesNuevos);
		panel.setLayout(null);
		panel.setBounds(0, Constantes.salaHeight*(salas.size()+1), Constantes.salaWidth, Constantes.salaHeight);
		panel.setBackground(Constantes.jPanelSalasYChatsColor);
		
		panel.addMouseListener(new MouseAdapter() {
		    public void mouseExited(MouseEvent e) {
		        e.getComponent().setBackground(Constantes.jPanelSalasYChatsColor);
		    }
		    public void mouseEntered(MouseEvent e) {
		        e.getComponent().setBackground(Constantes.salaHoverColor);
		    }
		});
		
		salas.add(panel);
		this.add(panel);
		this.updateUI();
	}
}
