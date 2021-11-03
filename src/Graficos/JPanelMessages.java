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

public class JPanelMessages extends JPanel{
	private JPanelChatBox jPanelChatBox;

	public JPanelMessages() {
		super();
		addChatBox();
	}

	private void addChatBox() {
		jPanelChatBox = new JPanelChatBox();
		jPanelChatBox.setBounds(0,Constantes.chatMinHeight*2/3,Constantes.chatMinWidth-Constantes.salaWidth,Constantes.chatMinHeight);
		jPanelChatBox.setBackground(Constantes.jPanelChatBoxColor);
		this.add(jPanelChatBox);
	}


}
