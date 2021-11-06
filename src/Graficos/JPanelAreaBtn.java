package Graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import App.Mensaje;
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
				
				Mensaje msj = new Mensaje((int) Cliente.clienteId, new Date(), JPanelChatBox.jAreaTexto.getText(), Cliente.salaActual);
				Peticion<Mensaje> serverMessage = new Peticion<Mensaje>(Acciones.USER_SEND_ROOM_SMG,msj);
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
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");

                fileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt", "txt");
                fileChooser.addChoosableFileFilter(restrict);

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    PrintWriter escritor;
                    try {
                        escritor = new PrintWriter(new FileWriter(fileToSave.getAbsolutePath() + ".txt"));
                        escritor.print(JPanelMensajeBox.getChatLog());
                        escritor.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }
        });
        this.add(btnDescargarTexto);
    }
}
