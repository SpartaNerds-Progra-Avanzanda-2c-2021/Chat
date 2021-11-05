package App;

import java.io.Serializable;
import java.util.Date;

public class Conexion implements Serializable {
	private Usuario usuario;
	private Date createdAt;
	
	public Conexion(Usuario user, Date date) {
		this.usuario = user;
		this.createdAt = date;
	}
}
