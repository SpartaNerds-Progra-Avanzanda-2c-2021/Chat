package Graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;

import App.Mensaje;
import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;

import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class JDialogCrearSala extends JDialog {

	private JTextField txtNombre;
	private JButton btnSalir;

	/**
	 * Create the dialog.
	 */
	public JDialogCrearSala() {
		addLabelNombre();
		addJTextFieldTxtNombre();
		addJbuttonSalir();
	}

	private void addJbuttonSalir() {
		btnSalir = new JButton("Aceptar");
		btnSalir.setBounds(465, 20, 90, 20);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_CREATE_ROOM, txtNombre.getText());
				try {
					new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		getContentPane().add(btnSalir);
	}

	private void addJTextFieldTxtNombre() {
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 20, 350, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
	}
	
	public void addLabelNombre() {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 18, 50, 20);
		getContentPane().add(lblNombre);
	}
	
	public void cargaIconoVentana(String archivo) {
		ImageIcon ico = new ImageIcon(archivo);
		Image img = ico.getImage();
		Image imgRedimensionada = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		this.setIconImage(imgRedimensionada);
	}
}
