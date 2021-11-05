package Graficos;

import javax.swing.JPanel;

public class JPanelMensaje extends JPanel{
	private int propietario;
	private Long createdAt;
	private String info;
	
	public JPanelMensaje(int id, long date, String contenido) {
		super();
		this.propietario = id;
		this.createdAt = date;
		this.info = contenido;
	}
}
