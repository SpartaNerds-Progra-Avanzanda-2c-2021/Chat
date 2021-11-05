package Graficos;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JPanelMensaje extends JPanel {
	private int propietario;
	private Long createdAt;
	private String info;

	public JPanelMensaje(int id, long date, String contenido) {
		super();
		this.propietario = id;
		this.createdAt = date;
		this.info = contenido;

		addPropietario();
		addContenido();
		addCreatedAt();
	}

	private void addPropietario() {
		JLabel label = new JLabel(String.valueOf(propietario));
		label.setBorder(new EmptyBorder(5, 20, 0, 0));
		label.setFont(new Font("BOLD", Font.PLAIN, 17));
		label.setBounds(0,0,Constantes.salaWidth/2,Constantes.salaHeight/2);
		//label.setBounds(0, 0, 0, 0);

		this.add(label);
	}

	private void addCreatedAt() {
		String mensaje = "Enviado a las : " + String.valueOf(this.createdAt);
		JLabel label = new JLabel(mensaje, SwingConstants.RIGHT);
		label.setBorder(new EmptyBorder(0, 0, 0, 15));
		label.setFont(new Font("BOLD", Font.PLAIN, 11));
		label.setBounds(Constantes.salaWidth / 2, 0, Constantes.salaWidth / 2, Constantes.salaHeight / 2);
		this.add(label);
	}

	private void addContenido() {
		String mensaje = this.info;
		JLabel contenido = new JLabel(mensaje);
		contenido.setBorder(new EmptyBorder(0, 25, 0, 0));
		contenido.setFont(new Font("BOLD", Font.PLAIN, 10));
		contenido.setBounds(0, Constantes.salaHeight / 2, Constantes.salaWidth, Constantes.salaHeight / 2);
		this.add(contenido);

	}
}
