package graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cliente.Cliente;
import utils.Acciones;
import utils.Peticion;

public class JPanelChatBox extends JPanel{

    public static JTextArea jAreaTexto;
    public JScrollPane jPanelDeslizable;
    public JPanelAreaBtn jAreaBotones;
    
	
	public JPanelChatBox() {
		super();
		addTextArea();
		addBotones();
	}
	
	public void addTextArea() {
		jAreaTexto = new JTextArea();
		jPanelDeslizable = new JScrollPane(jAreaTexto);
		jPanelDeslizable.setPreferredSize(new Dimension((Constantes.chatMinWidth-Constantes.salaWidth)*6/10, 
				Constantes.chatMinHeight*1/8));
        this.add(jPanelDeslizable);
	}

	public void addBotones() {
		jAreaBotones = new JPanelAreaBtn();
		jAreaBotones.setBounds(0,0, (Constantes.chatMinWidth-Constantes.salaWidth)*4/10, Constantes.chatMinHeight*2/9 );
		this.add(jAreaBotones);
	}

	public void setJPanelMensajeBox(JPanelMensajeBox jPanelMensajeBox) {
		jAreaBotones.setJPanelMensajeBox(jPanelMensajeBox);
	}
}
