package Graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JPanel;

import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;

public class JPanelAreaBtn extends JPanel {
    private JButton btnEnviarTexto;
    private JButton btnDescargarTexto;

	public JPanelAreaBtn() {
		addBotonEnviar();
		addBotonDescargar();
	}
	
	public void addBotonEnviar() {
		btnEnviarTexto = new JButton("Enviar");
		btnEnviarTexto.setBounds(50, 50, 90, 20);

		btnEnviarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_SEND_ROOM_SMG,
						JPanelChatBox.jAreaTexto.getText());
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
