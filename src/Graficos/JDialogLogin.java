package Graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Cliente.Cliente;
import Utils.Acciones;
import Utils.Peticion;

public class JDialogLogin extends JDialog{
	private JTextField txtIp;
	private JTextField txtPuerto;
	private JButton btnSalir;
	
	public JDialogLogin() {
		addLabelNombre();
		addJTextFieldTxtIp();
		addJTextFieldTxtPuerto();
		addJbuttonSalir();
	}
	
	public void addLabelNombre() {
		JLabel lblIp = new JLabel("Ip");
		lblIp.setBounds(25, 18, 50, 20);
		getContentPane().add(lblIp);
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(25, 48, 50, 20);
		getContentPane().add(lblPuerto);
	}
	public void addJTextFieldTxtIp() {
		txtIp = new JTextField();
		txtIp.setBounds(95, 20, 350, 20);
		getContentPane().add(txtIp);
		txtIp.setColumns(10);
	}
	public void addJTextFieldTxtPuerto() {
		txtPuerto = new JTextField();
		txtPuerto.setBounds(95, 50, 350, 20);
		getContentPane().add(txtPuerto);
		txtPuerto.setColumns(10);
	}
	public void addJbuttonSalir() {
		btnSalir = new JButton("Aceptar");
		btnSalir.setBounds(465, 20, 90, 40);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Peticion<String> serverMessage = new Peticion<String>(Acciones.USER_CREATE_ROOM, txtNombre.getText());
//				try {
//					new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
				dispose();
			}
		});
		
		getContentPane().add(btnSalir);
	}
}
