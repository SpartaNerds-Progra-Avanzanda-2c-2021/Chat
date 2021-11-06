package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cliente.Cliente;
import utils.Acciones;
import utils.Peticion;
import servidor.Constantes;

public class JDialogLogin extends JDialog {
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
		txtIp.setBounds(95, 20, 150, 20);
		getContentPane().add(txtIp);
		txtIp.setColumns(10);
	}

	public void addJTextFieldTxtPuerto() {
		txtPuerto = new JTextField();
		txtPuerto.setBounds(95, 50, 150, 20);
		getContentPane().add(txtPuerto);
		txtPuerto.setColumns(10);
	}

	public void addJbuttonSalir() {
		btnSalir = new JButton("Aceptar");
		btnSalir.setBounds(270, 20, 90, 40);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cliente(Integer.parseInt(txtPuerto.getText()), txtIp.getText());
				dispose();
			}
		});

		getContentPane().add(btnSalir);
	}
	
	public static void main(String[] args) {
		JDialogLogin login = new JDialogLogin();
		login.setBounds(0, 0, 400, 130);
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		login.setTitle("Login");
		login.setModal(true);
		login.getContentPane().setLayout(null);
		login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		login.setVisible(true);
	}
}