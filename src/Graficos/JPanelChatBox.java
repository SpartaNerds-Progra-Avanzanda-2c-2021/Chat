package Graficos;

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

import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;

public class JPanelChatBox extends JPanel{

    public static JTextArea jAreaTexto = new JTextArea();
    public static JScrollPane jPanelDeslizable = new JScrollPane(jAreaTexto);
    private JButton btnEnviarTexto;
    private JButton btnDescargarTexto;
    
	
	public JPanelChatBox() {
		super();
		addTextArea();
		//Estos 2 deberian estar en su propio jPanel chikito al costado
		addBotonEnviar();
		addBotonDescargar();
	}
	
	public void addTextArea() {
		jPanelDeslizable.setPreferredSize(new Dimension((Constantes.chatMinWidth-Constantes.salaWidth)*7/10, Constantes.chatMinHeight*2/9));
        this.add(jPanelDeslizable);
	}

	public void addBotonEnviar() {
		btnEnviarTexto = new JButton("Enviar");
		btnEnviarTexto.setBounds(50, 50, 90, 20);

		btnEnviarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_SEND_ROOM_SMG,
						jAreaTexto.getText());
				try {
					new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(btnEnviarTexto);
	}
	public void addBotonDescargar() {
		btnDescargarTexto = new JButton("Descargar");
		btnDescargarTexto.setBounds(50, 50, 90, 20);

		btnDescargarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_DOWNLOAD_ROOM_TEXT,
						null);
				try {
					new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(btnDescargarTexto);
	}
}
