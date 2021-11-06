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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import utils.Acciones;
import utils.Peticion;

import java.util.Date;

public class JPanelUsuarios extends JPanel{
	private ArrayList<JPanelUsuario> salas = new ArrayList<JPanelUsuario>();
	private JPanel jPanelTittle;
	
	public JPanelUsuarios() {
		super();
		addTitulo();
	}
	
	public ArrayList<JPanelUsuario> getUsuarios(){
		return this.salas;
	}
	
	private void addTitulo() {
		JLabel label=new JLabel("Usuarios");  
		label.setFont(new Font("BOLD", Font.PLAIN, 22));
		label.setBounds(Constantes.salaHeight,0,Constantes.salaWidth-Constantes.salaHeight,Constantes.salaHeight);
	    this.add(label);
	    
		jPanelTittle = new JPanel();
		jPanelTittle.setBounds(0,0,Constantes.salaWidth,Constantes.salaHeight);
		jPanelTittle.setBackground(Constantes.salaHoverColor);
		jPanelTittle.setLayout(null);
		jPanelTittle.setBackground(Constantes.jPanelSalasYChatTituloColor);
		jPanelTittle.add(label);
		this.add(jPanelTittle);
	}

	public void addJPanelUsuario(String nombre, Date conectadoDesde ) {
		JPanelUsuario panel = new JPanelUsuario(nombre, conectadoDesde);
		panel.setLayout(null);
		panel.setBounds(0, Constantes.salaHeight * (salas.size() + 1), Constantes.salaWidth, Constantes.salaHeight);
		panel.setBackground(Constantes.jPanelSalasYChatsColor);

		panel.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(!panel.clicked) {
					e.getComponent().setBackground(Constantes.jPanelSalasYChatsColor);	
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(!panel.clicked) {
					e.getComponent().setBackground(Constantes.salaHoverColor);	
				}
			}
			public void mouseClicked(MouseEvent e) {
				panel.clicked = !panel.clicked;
				if(panel.clicked) {
					e.getComponent().setBackground(Constantes.salaHoverColor);	
				}
				JPanelUsuariosClicked(nombre);
			}
		});
		
		salas.add(panel);
		this.add(panel);
		this.updateUI();
	}
	
	public void JPanelUsuariosClicked(String nombre) {
		Number id = Integer.valueOf(nombre);
		
		if(!Cliente.usuariosSeleccionadosIds.remove(id)) {
			Cliente.usuariosSeleccionadosIds.add(id);
		}
	}
}
