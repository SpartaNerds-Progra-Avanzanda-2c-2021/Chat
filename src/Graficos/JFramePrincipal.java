package Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import App.Lobby;
import Utils.SalaCallback;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.Socket;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFramePrincipal extends JFrame {
	public JTable tblClientes;
	public JPanelSalasYChats jPanelSalasYChats;
	public static JPanelComunication jPanelComunication;

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		
		this.addJPanelSalas();
		this.addJPanelChat();
		
		this.iniciarPantallaPrincipal();
	}

	private void addJPanelChat() {
		jPanelComunication = new JPanelComunication();
		jPanelComunication.setBounds(Constantes.salaWidth, 0, Constantes.chatMinWidth-Constantes.salaWidth, this.getHeight());
		jPanelComunication.setLayout(null);
		jPanelComunication.setBackground(Constantes.jPanelMessagesColor);
		getContentPane().add(jPanelComunication);
		jPanelComunication.setVisible(false);
	}
	
	private void addJPanelSalas() {
		jPanelSalasYChats = new JPanelSalasYChats();
		jPanelSalasYChats.setBounds(0, 0, Constantes.salaWidth, this.getHeight());
		jPanelSalasYChats.setLayout(null);
		jPanelSalasYChats.setBackground(Constantes.jPanelSalasYChatsColor);
		jPanelSalasYChats.setSalaCallback(new SalaCallback() {
			@Override
			public void onClickSala(String nombreSala) {
				jPanelComunication.setVisible(true);
				jPanelComunication.setNombreSala(nombreSala);
			}			
		});
		getContentPane().add(jPanelSalasYChats);
	}

	private void iniciarPantallaPrincipal() {
		getContentPane().setLayout(null);

		this.setResizable(true);
		this.setBounds(0,0, Constantes.chatMinWidth, Constantes.chatMinHeight);
		this.setMinimumSize(new Dimension(Constantes.chatMinWidth, Constantes.chatMinHeight));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	pantallaPrincipalResized(componentEvent.getComponent().getWidth(), componentEvent.getComponent().getHeight());
		    }
		});
	}
	
	private void pantallaPrincipalResized(int width ,int height) {
		jPanelSalasYChats.setSize((int)jPanelSalasYChats.getSize().getWidth(), height);
		jPanelComunication.setSize(width-(int)jPanelSalasYChats.getSize().getWidth(), height);
		//TODO
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new JFramePrincipal().setVisible(true);
	}
}
