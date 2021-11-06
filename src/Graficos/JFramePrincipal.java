package Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Lobby;

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
	public JPanelSalas jPanelSalas;
	public JPanelUsuarios jPanelUsuarios;
	public JPanelComunication jPanelComunication;
	public boolean userShowed = false;
	
	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		this.addJPanelSalas();
		this.addJPanelChat();
		this.iniciarPantallaPrincipal();
		
		jPanelSalas.setJPanelComunication(jPanelComunication);
	}

	private void addJPanelChat() {
		int widthIfIsUserJpanelShowed = userShowed?Constantes.usersWidth:0;
		jPanelComunication = new JPanelComunication();
		jPanelComunication.setBounds(Constantes.salaWidth, 0, Constantes.chatMinWidth-Constantes.salaWidth-widthIfIsUserJpanelShowed, this.getHeight());
		jPanelComunication.setLayout(null);
		jPanelComunication.setBackground(Constantes.jPanelMessagesColor);
		getContentPane().add(jPanelComunication);
		jPanelComunication.setVisible(false);
	}
	
	public void switchJPanelUsuarios() {
		if(!userShowed) {
			jPanelUsuarios = new JPanelUsuarios();
			this.setSize(new Dimension(Constantes.chatMinWidth+Constantes.usersWidth,this.getHeight()));
			jPanelUsuarios.setBounds(this.getWidth()-Constantes.usersWidth, 0, Constantes.usersWidth, this.getHeight());
			jPanelUsuarios.setLayout(null);
			jPanelUsuarios.setBackground(Constantes.jPanelSalasYChatsColor);
			getContentPane().add(jPanelUsuarios);
			userShowed = true;
		}else {
			getContentPane().remove(jPanelUsuarios);
			this.setSize(new Dimension(Constantes.chatMinWidth,this.getHeight()));
			userShowed = false;
		}
	}

	private void addJPanelSalas() {
		jPanelSalas = new JPanelSalas();
		jPanelSalas.setBounds(0, 0, Constantes.salaWidth, this.getHeight());
		jPanelSalas.setLayout(null);
		jPanelSalas.setBackground(Constantes.jPanelSalasYChatsColor);
		getContentPane().add(jPanelSalas);
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
		    	pantallaPrincipalResized();
		    }
		});
	}
	
	private void pantallaPrincipalResized() {
		int widthIfIsUserJpanelShowed = userShowed?Constantes.usersWidth:0;
		
		jPanelSalas.setSize((int)jPanelSalas.getSize().getWidth(), this.getHeight());
		jPanelComunication.setSize(this.getWidth()-Constantes.salaWidth-widthIfIsUserJpanelShowed, this.getHeight());
		if(userShowed) {
			jPanelUsuarios.setBounds(this.getWidth()-Constantes.usersWidth, 0, Constantes.usersWidth, this.getHeight());	
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new JFramePrincipal().setVisible(true);
	}
}
