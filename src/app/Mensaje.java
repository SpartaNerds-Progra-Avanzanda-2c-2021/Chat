package app;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable{
	private int propietario;
	private Date createdAt;
	private String info;
	public String sala;
	
	public Mensaje(int propietario, Date createdAt, String info, String sala) {
		super();
		this.propietario = propietario;
		this.createdAt = createdAt;
		this.info = info;
		this.sala = sala;
	}
	
	public int getPropietario() {
		return propietario;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return propietario + "Se envio a las: " + createdAt + " " + info + "]\n";
	}
	
}